package com.xuzy.hotel.order.web;

import java.util.Calendar;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.util.PHPAndJavaSerialize;
import com.util.PhpDateUtils;
import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.deliveryorder.service.CvcDeliveryOrderService;
import com.xuzy.hotel.getorderstatistics.service.CvcGetOrderStatisticsService;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.module.CallBackResponse;
import com.xuzy.hotel.order.module.CallBaseRequest;
import com.xuzy.hotel.order.module.Data;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.order.service.impl.CvcOrderInfoServiceImpl;
import com.xuzy.hotel.yldeliveryinfo.entity.CvcYlDeliveryInfoEntity;
import com.xuzy.hotel.yldeliveryinfo.service.CvcYlDeliveryInfoService;
import com.xuzy.hotel.ylrequest.ConmentHttp;
import com.xuzy.hotel.ylrequest.ResponseHead;
import com.xuzy.hotel.ylrequest.TukeRequestBody;
import com.xuzy.hotel.ylrequest.module.RequestDeliveryExchangeOrderJson;
import com.xuzy.hotel.ylrequest.module.RequestExchangeProcessHistoryAddJson;
import com.xuzy.hotel.ylrequest.module.RequestSignInExchangeOrderJson;

/**
 * 描述：订单表
 * 
 * @author: www.jeecg.org
 * @since：2018年10月28日 18时23分43秒 星期日
 * @version:1.0
 */
@Controller
@RequestMapping("/callBack")
public class OrderCallBack extends BaseController {
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	@Autowired
	private CvcDeliveryOrderService cvcDeliveryOrderService;
	
	@Autowired
	private CvcGetOrderStatisticsService cvcGetOrderStatisticsService;
	
	@Autowired
	private CvcDeliveryInfoService cvcDeliveryInfoService;
	
	@Autowired
	  private CvcYlDeliveryInfoService cvcYlDeliveryInfoService;
	
	
	
	 /**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderCallBack.class);
	
	/**
	 * 更新签收时间
	 * 
	 * @return
	 */
	@RequestMapping(params = "result", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public CallBackResponse result(@RequestParam(required = true, value = "param") String param) {
		CallBackResponse callBackResponse = new CallBackResponse();
		callBackResponse.setMessage("成功");
		callBackResponse.setResult("true");
		callBackResponse.setReturnCode("200");
		logger.info("param:"+param);
		try {
			CallBaseRequest callbaseRequest = ConmentHttp.gson.fromJson(param, CallBaseRequest.class);
			if(StringUtils.isNotEmpty(callbaseRequest.getLastResult().getMessage())
					&& "ok".equals(callbaseRequest.getLastResult().getMessage())) {
				String nu = callbaseRequest.getLastResult().getNu().trim();
				
				CvcDeliveryInfoEntity  cvcDeliveryInfo = new CvcDeliveryInfoEntity();
				cvcDeliveryInfo.setNumber(nu);
				cvcDeliveryInfo.setMessage(callbaseRequest.getMessage());
				cvcDeliveryInfo.setData(PHPAndJavaSerialize.serialize(callbaseRequest.getLastResult().getData()));
				cvcDeliveryInfo.setState(callbaseRequest.getLastResult().getState());
				//快递信息
				cvcDeliveryInfoService.insert(cvcDeliveryInfo);
				
				CvcDeliveryOrderEntity entity = cvcDeliveryOrderService.getEntityByinvoiceNo(nu);
				if(entity != null) {
					//查询订单状态
					CvcOrderInfoEntity cvcOrderInfoEntity = cvcOrderInfoService.get(entity.getOrderId());
					
					if(cvcOrderInfoEntity.getOrderStatus() == 5) {
						//已签收
						return callBackResponse;
					}
					
					if(CollectionUtils.isNotEmpty(callbaseRequest.getLastResult().getData())) {
						for(Data data:callbaseRequest.getLastResult().getData()) {
							CvcYlDeliveryInfoEntity ylDeliveryInfoEntity =cvcYlDeliveryInfoService.get(entity.getOrderId(),nu,data.getContext());
							if(ylDeliveryInfoEntity == null) {
								//未发送过
								RequestExchangeProcessHistoryAddJson request = new RequestExchangeProcessHistoryAddJson();
								request.setOrderID(entity.getOrderId());
								request.setSwitNumber(PhpDateUtils.getOrderSn());
								request.setDescription(data.getContext());
								request.setProcessTime(data.getFtime());
								ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setSequence(2)
										.setServiceCode("CRMIF.ExchangeProcessHistoryAddJson")
										.setParams(request).builder(), null); 
								if(responseHead.getReturn() >= 0) {
									//记录推送成功
									ylDeliveryInfoEntity = new CvcYlDeliveryInfoEntity();
									ylDeliveryInfoEntity.setOrderId(entity.getOrderId());
									ylDeliveryInfoEntity.setNumber(nu);
									ylDeliveryInfoEntity.setContext(data.getContext());
									ylDeliveryInfoEntity.setFtime(data.getFtime());
									cvcYlDeliveryInfoService.insert(ylDeliveryInfoEntity);
								}
							}
						}
					}
					
					//推送yl
					if(cvcDeliveryInfo.getState() == 0 || cvcDeliveryInfo.getState() == 5
							|| (cvcDeliveryInfo.getState() == 3 && cvcOrderInfoEntity.getOrderStatus() == 3)) {
						//推送至配送中 
						RequestDeliveryExchangeOrderJson  requestBody = new RequestDeliveryExchangeOrderJson();
						requestBody.setOrderID(entity.getOrderId());
						requestBody.setDeliveryingDate(DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
						ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
								.setSequence(2)
								.setServiceCode("CRMIF.DeliveryExchangeOrderJson")
								.setParams(requestBody).builder(), null);
						if(responseHead.getReturn() >= 0) {
							cvcOrderInfoService.updateStatusByOrderId(entity.getOrderId(), 4);
						}
						return callBackResponse;
					}else if(cvcDeliveryInfo.getState() == 3){
						//推送至签收 
						RequestSignInExchangeOrderJson  requestBody = new RequestSignInExchangeOrderJson();
						requestBody.setOrderID(entity.getOrderId());
						requestBody.setSignInMan(callbaseRequest.getLastResult().getData().get(0).getContext());
						requestBody.setSignInDate(callbaseRequest.getLastResult().getData().get(0).getFtime() );
						ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
								.setSequence(2)
								.setServiceCode("CRMIF.SignInExchangeOrderJson")
								.setParams(requestBody).builder(), null);
						if(responseHead.getReturn() >= 0) {
							cvcOrderInfoService.updateStatusByOrderId(entity.getOrderId(), 5);
						}
						return callBackResponse;
					}else if(cvcDeliveryInfo.getState() == 2){
						//设置疑难
						cvcOrderInfoService.updateErrorStatusByOrderId(entity.getOrderId(), 1);
						return callBackResponse;
					}else if(cvcDeliveryInfo.getState() == 4) {
						//退签
						cvcOrderInfoService.updateErrorStatusByOrderId(entity.getOrderId(), 2);
						return callBackResponse;
					}else if(cvcDeliveryInfo.getState() == 6) {
						//退回
						cvcOrderInfoService.updateErrorStatusByOrderId(entity.getOrderId(), 3);
						return callBackResponse;
					}
				}
			}else {
				if("abort".equals(callbaseRequest.getStatus())) {
					//快递信息录入错误
					if(callbaseRequest.getMessage().contains("3天")) {
						if(!StringUtils.isEmpty(callbaseRequest.getLastResult().getComNew())) {
							cvcDeliveryOrderService.updateErrorCode(callbaseRequest.getLastResult().getComNew(), callbaseRequest.getLastResult().getNu());
						}else {
							//快递单号异常
							CvcDeliveryOrderEntity entity = cvcDeliveryOrderService.getEntityByinvoiceNo(callbaseRequest.getLastResult().getNu());
							if(entity != null) {
								cvcOrderInfoService.updateErrorStatusByOrderId(entity.getOrderId(), 4);
								CvcOrderInfoEntity orderInfoEntity = cvcOrderInfoService.get(entity.getOrderId());
								if(orderInfoEntity != null) {
									cvcGetOrderStatisticsService.addExceptionCount(orderInfoEntity.getBatchNo());
								}
							}
						}
					}else if(callBackResponse.getMessage().contains("60天")) {
						//超时关闭
						CvcDeliveryOrderEntity entity = cvcDeliveryOrderService.getEntityByinvoiceNo(callbaseRequest.getLastResult().getNu());
						if(entity != null) {
							cvcOrderInfoService.updateErrorStatusByOrderId(entity.getOrderId(), 5);
							CvcOrderInfoEntity orderInfoEntity = cvcOrderInfoService.get(entity.getOrderId());
							if(orderInfoEntity != null) {
								cvcGetOrderStatisticsService.addExceptionCount(orderInfoEntity.getBatchNo());
							}
						}
					}
					
				}
			}
		} catch (Exception e) {
			callBackResponse.setMessage("失败");
			callBackResponse.setResult("false");
			callBackResponse.setReturnCode("500");
			logger.error("推送信息异常", e);
		}
		return callBackResponse;
	}
	
	public static void main(String[] args) {
		
		
		
		String param = "{\"status\":\"polling\",\"billstatus\":\"got\",\"message\":\"寄件\",\"lastResult\":{\"message\":\"ok\",\"nu\":\"884382620117795613\",\"ischeck\":\"0\",\"condition\":\"00\",\"com\":\"yuantong\",\"status\":\"200\",\"state\":\"0\",\"data\":[{\"time\":\"2017-03-06 21:46:36\",\"ftime\":\"2017-03-06 21:46:36\",\"context\":\"福建省泉州市晋江市二部公司 已打包\"},{\"time\":\"2017-03-06 21:43:39\",\"ftime\":\"2017-03-06 21:43:39\",\"context\":\"福建省泉州市晋江市二部公司(点击查询电话) 已揽收\"}]}}";
		Data callbaseRequest = ConmentHttp.gson.fromJson(param, Data.class);
		System.out.println(callbaseRequest.toString());
	
	}

}
