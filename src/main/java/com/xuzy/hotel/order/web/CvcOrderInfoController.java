package com.xuzy.hotel.order.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.appinterface.app.base.exception.XuException;
import com.util.PHPAndJavaSerialize;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.deliveryorder.service.CvcDeliveryOrderService;
import com.xuzy.hotel.getorderstatistics.service.CvcGetOrderStatisticsService;
import com.xuzy.hotel.order.entity.CvcDeliveryGoodsEntity;
import com.xuzy.hotel.order.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.order.entity.CvcOrderGoodsEntity;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.module.DelivetyJson;
import com.xuzy.hotel.order.service.CvcOrderGoodsService;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.orderaction.entity.CvcOrderActionEntity;
import com.xuzy.hotel.orderaction.service.CvcOrderActionService;
import com.xuzy.hotel.revokegoods.entity.CvcRevokeGoodsEntity;
import com.xuzy.hotel.revokegoods.service.CvcRevokeGoodsService;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;
import com.xuzy.hotel.shipping.service.CvcShippingService;
import com.xuzy.hotel.ylrequest.ConmentHttp;
import com.xuzy.hotel.ylrequest.ResponseHead;
import com.xuzy.hotel.ylrequest.TukeRequestBody;
import com.xuzy.hotel.ylrequest.module.RequestDeliveryExchangeOrderJson;
import com.xuzy.hotel.ylrequest.module.RequestOFFHarbourExchangeOrderJson;
import com.xuzy.hotel.ylrequest.module.RequestSignInExchangeOrderJson;

/**
 * 描述：订单表
 * 
 * @author: www.jeecg.org
 * @since：2018年10月28日 18时23分43秒 星期日
 * @version:1.0
 */
@Controller
@RequestMapping("/cvcOrderInfo")
public class CvcOrderInfoController extends BaseController {
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	@Autowired
	private CvcOrderGoodsService cvcOrderGoodsService;
	
	@Autowired
	private CvcDeliveryOrderService cvcDeliveryOrderService;
	
	@Autowired
	private CvcRevokeGoodsService cvcRevokeGoodsService;
	
	@Autowired
	private CvcOrderActionService cvcOrderActionService;
	
	@Autowired
	private CvcShippingService cvcShippingService;
	
	@Autowired
	private CvcGetOrderStatisticsService cvcGetOrderStatisticsService;
	  
	
	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "exceptionOrderList")
	public ModelAndView exceptionOrderList(HttpServletRequest request) {
		return new ModelAndView("com/xuzy/hotel/order/tExceptionOrderTableList");
	}
	
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "exceptionOrderListDatagrid")
	public void exceptionOrderListDatagrid(CvcOrderInfoEntity query,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		MiniDaoPage<CvcOrderInfoEntity> list = cvcOrderInfoService.getExceptionOrderListAll(query, dataGrid.getPage(), dataGrid.getRows());
		if(CollectionUtils.isNotEmpty(list.getResults())) {
			for (CvcOrderInfoEntity entity : list.getResults()) {
				entity.setAddTime(DateFormatUtils.format(Long.parseLong(entity.getAddTime()+"000"), "yyyy-MM-dd HH:mm:ss"));
				entity.setGetTime(DateFormatUtils.format(Long.parseLong(entity.getGetTime()+"000"), "yyyy-MM-dd HH:mm:ss"));
				if(entity.getHandleTime() != null && entity.getHandleTime() > 0) {
					entity.setHandleTimeFormat(DateFormatUtils.format(Long.parseLong(entity.getHandleTime()+"000"), "yyyy-MM-dd HH:mm:ss"));
				}else {
					entity.setHandleTimeFormat("");
				}
			}
		}
		dataGrid.setResults(SystemTools.convertPaginatedList(list));
		dataGrid.setTotal(cvcOrderInfoService.getExceptionOrderCount(query));
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String orderStatus = request.getParameter("orderStatus")==null?"":request.getParameter("orderStatus");
		request.setAttribute("orderStatus", orderStatus);
		String batchNo = request.getParameter("batchNo")==null?"":request.getParameter("batchNo");
		request.setAttribute("batchNo", batchNo);
		return new ModelAndView("com/xuzy/hotel/order/tOrderTableList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(CvcOrderInfoEntity query,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		if(StringUtils.isNotEmpty(query.getAddTime_begin1())) {
			try {
				Date date1 = DateUtils.parseDate(query.getAddTime_begin1(),new String[] {"yyyy-MM-dd HH:mm:ss"}) ;
				query.setAddTimeBegin(Integer.parseInt(String.valueOf(date1.getTime()).substring(0, 10)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if(StringUtils.isNotEmpty(query.getAddTime_end2())) {
			try {
				Date date1 = DateUtils.parseDate(query.getAddTime_end2(),new String[] {"yyyy-MM-dd HH:mm:ss"}) ;
				query.setAddTimeEnd(Integer.parseInt(String.valueOf(date1.getTime()).substring(0, 10)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		MiniDaoPage<CvcOrderInfoEntity> list = cvcOrderInfoService.getAll(query, dataGrid.getPage(), dataGrid.getRows());
		if(CollectionUtils.isNotEmpty(list.getResults())) {
			for (CvcOrderInfoEntity entity : list.getResults()) {
				entity.setAddTime(DateFormatUtils.format(Long.parseLong(entity.getAddTime()+"000"), "yyyy-MM-dd HH:mm:ss"));
				entity.setGetTime(DateFormatUtils.format(Long.parseLong(entity.getGetTime()+"000"), "yyyy-MM-dd HH:mm:ss"));
			}
		}
		dataGrid.setResults(SystemTools.convertPaginatedList(list));
		dataGrid.setTotal(cvcOrderInfoService.getCount(query, dataGrid.getPage(), dataGrid.getRows()));
		TagUtil.datagrid(response, dataGrid);
	}
	


	/**
	 * 查看详情
	 * 
	 * @return
	 */
	@RequestMapping(params = "toDetail", method = RequestMethod.GET)
	public ModelAndView cvcOrderInfoDetail(@RequestParam(required = true, value = "id") int id, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		CvcOrderInfoEntity cvcOrderInfoEntity = new CvcOrderInfoEntity();
		cvcOrderInfoEntity.setId(id);
		cvcOrderInfoEntity = cvcOrderInfoService.getOrder(cvcOrderInfoEntity);
		if(cvcOrderInfoEntity == null) {
			throw new XuException("订单查询失败！");
		}
		CvcDeliveryOrderEntity deliveryOrder = cvcOrderInfoService.getDeliveryOrderByOrderId(id);
		List<DelivetyJson> deliveryInfos = new ArrayList<>();
		if(deliveryOrder != null) {
			CvcDeliveryInfoEntity entity = cvcOrderInfoService.getDeliveryInfosByInvoiceNo(deliveryOrder.getInvoiceNo());
			if(entity != null && StringUtils.isNotEmpty(entity.getData())) {
				deliveryInfos = PHPAndJavaSerialize.unserializePHParray(entity.getData(),DelivetyJson.class);
			}
		}
		///*异常订单类型*/
//		1); // 疑难
//		2); // 退签
//		3); // 退回
//		4); // 快递单号异常
//		5); // 超时关闭
		boolean is_show_exception = new ArrayList<String>() {
			{
				add("1");
				add("2");
				add("3");
			}
		}.contains(cvcOrderInfoEntity.getExceptionStatus());
		//是否展示异常区域	
		request.setAttribute("is_show_exception", is_show_exception);
		//订单状态
		request.setAttribute("exception_status",cvcOrderInfoEntity.getExceptionStatus());
		//是否已签收
		request.setAttribute("is_show_shipping_info", 5 == cvcOrderInfoEntity.getOrderStatus()); // 已签收订单
		request.setAttribute("delivery_order", deliveryOrder);
		request.setAttribute("delivery_info", deliveryInfos);
		
		//传递订单信息
		request.setAttribute("cvcOrderInfoEntity", cvcOrderInfoEntity);
		
		
		 /* 根据订单是否完成检查权限 */
		// getOrderStatus  define('OS_CONFIRMED',              1); // 已确认
		//getShippingStatus define('SS_SHIPPED',1); // 已发货
		//define('SS_RECEIVED',2); // 已收货
		//getPayStatus 
		//define('PS_PAYING',                 1); // 付款中
		//define('PS_PAYED',                  2); // 已付款
	    if ( 1== cvcOrderInfoEntity.getOrderStatus() && (cvcOrderInfoEntity.getShippingStatus() == 1 || cvcOrderInfoEntity.getShippingStatus() == 2 )
	    		&& (cvcOrderInfoEntity.getPayStatus()==2 || cvcOrderInfoEntity.getPayStatus()==1)) {
	    	//检查权限
	    	throw new XuException("订单状态异常！");
	    }
	    //获取商品
	    List<CvcOrderGoodsEntity> cvcOrderGoodsEntities = cvcOrderGoodsService.getAll(id);
		request.setAttribute("goods_list", cvcOrderGoodsEntities);
		
		//发货情况 
		List<CvcDeliveryOrderEntity> deliveryGoods = cvcDeliveryOrderService.getDeliveryCondition(id);
		request.setAttribute("delivery_goods", deliveryGoods);
		if(CollectionUtils.isNotEmpty(deliveryGoods)) {
			CvcShippingEntity cvcShipping = new CvcShippingEntity();
			cvcShipping.setEnabled(1);
			//查询快递公司
			MiniDaoPage<CvcShippingEntity> daoPage = cvcShippingService.getAll(cvcShipping, 1, 20);
			request.setAttribute("shippingEntitys", daoPage.getResults());
		}
		
		// 撤销商品情况 
		List<CvcRevokeGoodsEntity> cvcRevokeGoodsEntities = cvcRevokeGoodsService.getByOrderId(id);
		request.setAttribute("revoke_goods", cvcRevokeGoodsEntities);
		
		//取得订单操作记录
		List<CvcOrderActionEntity> actionEntities = cvcOrderActionService.getNewByOrderId(id);
		request.setAttribute("action_list", actionEntities);
		return new ModelAndView("com/xuzy/hotel/order/tOrderDetail");
	}
	
	/**
	 * 更新签收时间
	 * 
	 * @return
	 */
	@RequestMapping(params = "updateSigndate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson updateSigndate(@RequestParam(required = true, value = "orderId") int orderId,@RequestParam(required = true, value = "signdate")String signdate) {
		AjaxJson j = new AjaxJson();
		if(orderId <= 0) {
			j.setSuccess(false);
			j.setMsg("该订单号不存在！");
			return j;
		}
		
		if(StringUtils.isEmpty(signdate)) {
			j.setSuccess(false);
			j.setMsg("请选择时间！");
			return j;
		}
		
		try {
			CvcOrderInfoEntity cvcOrderInfo = new CvcOrderInfoEntity();
			cvcOrderInfo.setId(orderId);
			CvcOrderInfoEntity cvcOrderInfo1 = cvcOrderInfoService.getOrder(cvcOrderInfo);
			if(cvcOrderInfo1 != null) {
				//TODO 请求伊利接口  CRMIF.ReNewExchangeSignDateJson
				
				//TODO 请求伊利接口成功
				
				cvcDeliveryOrderService.updateSigndate(orderId, signdate);
			}else {
				j.setSuccess(false);
				j.setMsg("该订单号不存在！");
				return j;
			}
			j.setMsg("更新成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("更新失败");
		}
		return j;
	}
	
	
	
	/**
	 * 更新快递订单号
	 * 
	 * @return
	 */
	@RequestMapping(params = "updateNu", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson updateNu(@RequestParam(required = true, value = "orderId") int orderId
			,@RequestParam(required = true, value = "invoiceNo")String invoiceNo,@RequestParam(required = true, value = "shippingName")String shippingName) {
		AjaxJson j = new AjaxJson();
		if(orderId <= 0) {
			j.setSuccess(false);
			j.setMsg("该订单号不存在！");
			return j;
		}
		
		if(StringUtils.isEmpty(shippingName) || StringUtils.isEmpty(invoiceNo)) {
			j.setSuccess(false);
			j.setMsg("请填写快递公司或快递单号！");
			return j;
		}
		
		try {
			//获取快递公司
			CvcShippingEntity cvcShipping = new CvcShippingEntity();
			cvcShipping.setEnabled(1);
			cvcShipping.setShippingName(shippingName);
			//查询快递公司
			MiniDaoPage<CvcShippingEntity> daoPage = cvcShippingService.getAll(cvcShipping, 1, 1);
			CvcShippingEntity cvcShippingEntity = null;
			if(CollectionUtils.isEmpty(daoPage.getResults())) {
				j.setSuccess(false);
				j.setMsg("该快递公司不存在！");
				return j;
			}else {
				cvcShippingEntity = daoPage.getResults().get(0);
			}
			CvcOrderInfoEntity cvcOrderInfo = new CvcOrderInfoEntity();
			cvcOrderInfo.setId(orderId);
			CvcOrderInfoEntity cvcOrderInfo1 = cvcOrderInfoService.getOrder(cvcOrderInfo);
			if(cvcOrderInfo1 != null) {
				//TODO 请求伊利接口  CRMIF.ReNewExchangeEMSJson
				
				//TODO 请求伊利接口成功
				cvcDeliveryOrderService.updateNu(orderId, cvcShippingEntity.getShippingId(),cvcShippingEntity.getShippingName(),invoiceNo);
				if(cvcOrderInfo1.getExceptionStatus() != null &&
						"4".equals(cvcOrderInfo1.getExceptionStatus()) || "5".equals(cvcOrderInfo1.getExceptionStatus())) {
					//更新异常订单
					cvcOrderInfoService.updateHandle(cvcOrderInfo1.getId(),1,Integer.parseInt(String.valueOf(Calendar.getInstance().getTimeInMillis()).substring(0, 10)),ResourceUtil.getSessionUser().getUserName());
				}
			}else {
				j.setSuccess(false);
				j.setMsg("该订单号不存在！");
				return j;
			}
			j.setMsg("更新成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("更新失败");
		}
		return j;
	}
	
	
	/**
	 * 更新快递订单号
	 * 
	 * @return
	 */
	@RequestMapping(params = "ship", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson ship(@RequestParam(required = true, value = "orderId") int orderId
			,@RequestParam(required = false, value = "country") String country
			,@RequestParam(required = false, value = "province") String province
			,@RequestParam(required = false, value = "city") String city
			,@RequestParam(required = false, value = "district") String district
			,@RequestParam(required = false, value = "agency_id") String agency_id
			,@RequestParam(required = false, value = "insure_fee") String insure_fee
			,@RequestParam(required = false, value = "shipping_fee") String shipping_fee
			,@RequestParam(required = true, value = "shippingId") int shippingId
			,@RequestParam(required = true, value = "shippingName") String shippingName) {
		AjaxJson j = new AjaxJson();
		if(orderId <= 0) {
			j.setSuccess(false);
			j.setMsg("该订单号不存在！");
			return j;
		}
		CvcOrderInfoEntity cvcOrderInfoEntity = new CvcOrderInfoEntity();
		cvcOrderInfoEntity.setId(orderId);
		cvcOrderInfoEntity = cvcOrderInfoService.getOrder(cvcOrderInfoEntity);
		if(cvcOrderInfoEntity == null) {
			j.setSuccess(false);
			j.setMsg("订单查询失败！");
			return j;
		}

		if (1 == cvcOrderInfoEntity.getOrderStatus()
				&& (cvcOrderInfoEntity.getShippingStatus() == 1 || cvcOrderInfoEntity.getShippingStatus() == 2)
				&& (cvcOrderInfoEntity.getPayStatus() == 2 || cvcOrderInfoEntity.getPayStatus() == 1)) {
			// 检查权限
			j.setSuccess(false);
			j.setMsg("订单状态异常！");
			return j;
		}
		
		if (5 == cvcOrderInfoEntity.getOrderStatus()) {
			// 检查权限
			j.setSuccess(false);
			j.setMsg("订单已发货！");
			return j;
		}
		
		//获取商品
	    List<CvcOrderGoodsEntity> cvcOrderGoodsEntities = cvcOrderGoodsService.getAll(orderId);
	    int goodNumber = 0;
	    for(CvcOrderGoodsEntity cvcOrderGoodsEntity:cvcOrderGoodsEntities) {
	    	goodNumber += cvcOrderGoodsEntity.getGoodsNumber();
	    }
	    if(CollectionUtils.isEmpty(cvcOrderGoodsEntities) || goodNumber <= 0) {
	    	j.setSuccess(false);
			j.setMsg("商品不能为空！");
			return j;
	    }
	    
		try {
			 /* 生成发货单 */
	        /* 获取发货单号和流水号 */
			String delivery_sn = DateFormatUtils.format(Calendar.getInstance(), "yyyyMMddHHmmssSSS");
			
			//保存发货订单
			CvcDeliveryOrderEntity cvcDeliveryOrderEntity = new CvcDeliveryOrderEntity();
			cvcDeliveryOrderEntity.setDeliverySn(delivery_sn);
			cvcDeliveryOrderEntity.setOrderId(orderId);
			//设置更新时间
			cvcDeliveryOrderEntity.setUpdateTime(Calendar.getInstance().getTimeInMillis());
			//修改人
			cvcDeliveryOrderEntity.setActionUser(ResourceUtil.getSessionUser().getUserName());
			cvcDeliveryOrderEntity.setAddTime(Integer.parseInt(cvcOrderInfoEntity.getOldAddTime()));
			cvcDeliveryOrderEntity.setStatus(2);
				
			
			CvcShippingEntity cvcShipping = null;
			//快递公司处理
			if(shippingId == 0 && StringUtils.isNotEmpty(shippingName)) {
				cvcShipping = new CvcShippingEntity();
				cvcShipping.setShippingName(shippingName);
				cvcShipping.setEnabled(1);
				//其他 添加快递公司
				cvcShippingService.insert(cvcShipping);
				//获取
				List<CvcShippingEntity> cvcShippingEntities = cvcShippingService.getAll(cvcShipping, 1, 1).getResults();
				if(CollectionUtils.isNotEmpty(cvcShippingEntities)) {
					cvcShipping = cvcShippingEntities.get(0);
				}
			}else {
				cvcShipping = cvcShippingService.get(shippingId+"");
			}
			
			//订单离港
			ResponseHead head = ConmentHttp.sendHttp(new TukeRequestBody.Builder().builder(), null);
			if(head.getReturn() >= 0) {
				//发送发货订单 同步到物流表中
				ConmentHttp.postorder();
				/* 发货单入库 */
				//成功
				int id = cvcDeliveryOrderService.insert(cvcDeliveryOrderEntity);
				if(StringUtils.isNotEmpty(cvcOrderInfoEntity.getBatchNo())) {
					//更新批量发货记录
					cvcGetOrderStatisticsService.addOffharbourCount(cvcOrderInfoEntity.getBatchNo());
				}
				if(id > 0 && CollectionUtils.isNotEmpty(cvcOrderGoodsEntities)) {
					//发货单商品入库
					for(CvcOrderGoodsEntity cvcOrderGoodsEntity:cvcOrderGoodsEntities) {
						CvcDeliveryGoodsEntity cvcDeliveryGoods = new CvcDeliveryGoodsEntity();
						cvcDeliveryGoods.setDeliveryId(id);
						cvcDeliveryGoods.setGoodsId(cvcOrderGoodsEntity.getGoodsId());
						cvcDeliveryGoods.setProductId(cvcOrderGoodsEntity.getProductId());
						cvcDeliveryGoods.setProductSn(cvcOrderGoodsEntity.getProductSn());
						cvcDeliveryGoods.setGoodsName(cvcOrderGoodsEntity.getGoodsName());
						cvcDeliveryGoods.setBrandName(cvcOrderGoodsEntity.getBrandName());
						cvcDeliveryGoods.setGoodsSn(cvcOrderGoodsEntity.getGoodsSn());
//						cvcDeliveryGoods.setSendNumber(sendNumber);
						cvcDeliveryGoods.setParentId(0);
						cvcDeliveryGoods.setIsReal(0);
						cvcDeliveryGoods.setGoodsAttr(cvcOrderGoodsEntity.getGoodsAttr());
						cvcDeliveryGoods.setSystemSku(cvcOrderGoodsEntity.getSystemSku());
						cvcDeliveryGoods.setGoodsPrice(cvcOrderGoodsEntity.getGoodsPrice());
						cvcDeliveryGoods.setUpcId(cvcOrderGoodsEntity.getUpcId());
						cvcOrderInfoService.insert(cvcDeliveryGoods);
					}
				}else {
					j.setSuccess(false);
					j.setMsg("发货失败,商品入库失败！");
					return j;
				}
				
				
				
				j.setMsg("发货成功");
			}else {
				j.setSuccess(false);
				j.setMsg("伊利接口调用失败！ msg:"+head.getReturnInfo());
				return j;
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("发货失败");
		}
		return j;
	}
	
	
	/**
	 * 跳转到发货页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "toShip", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView toShip(@RequestParam(required = true, value = "orderId") int orderId,HttpServletRequest request) throws Exception {
		CvcOrderInfoEntity cvcOrderInfoEntity = new CvcOrderInfoEntity();
		cvcOrderInfoEntity.setId(orderId);
		cvcOrderInfoEntity = cvcOrderInfoService.getOrder(cvcOrderInfoEntity);
		if(cvcOrderInfoEntity == null) {
			throw new XuException("订单查询失败！");
		}
		
		cvcOrderInfoEntity.setInvoiceNo((cvcOrderInfoEntity.getShippingStatus() != null  && cvcOrderInfoEntity.getShippingStatus() == 0 )
				|| (cvcOrderInfoEntity.getShippingStatus() != null && cvcOrderInfoEntity.getShippingStatus() == 0) ? ResourceUtil.searchAllTypesByCode("0","sstatus"):
					cvcOrderInfoEntity.getInvoiceNo());
		 /* 查询：是否保价 */
		
		 /* 根据订单是否完成检查权限 */
		// getOrderStatus  define('OS_CONFIRMED',              1); // 已确认
		//getShippingStatus define('SS_SHIPPED',1); // 已发货
		//define('SS_RECEIVED',2); // 已收货
		//getPayStatus 
		//define('PS_PAYING',                 1); // 付款中
		//define('PS_PAYED',                  2); // 已付款
	    if ( 1== cvcOrderInfoEntity.getOrderStatus() && (cvcOrderInfoEntity.getShippingStatus() == 1 || cvcOrderInfoEntity.getShippingStatus() == 2 )
	    		&& (cvcOrderInfoEntity.getPayStatus()==2 || cvcOrderInfoEntity.getPayStatus()==1)) {
	    	//检查权限
	    	throw new XuException("订单状态异常！");
	    }
		
	    //获取商品
	    List<CvcOrderGoodsEntity> cvcOrderGoodsEntities = cvcOrderGoodsService.getAll(orderId);
		request.setAttribute("goods_list", cvcOrderGoodsEntities);
	    
		
		CvcShippingEntity cvcShipping = new CvcShippingEntity();
		cvcShipping.setEnabled(1);
		//查询快递公司
		MiniDaoPage<CvcShippingEntity> daoPage = cvcShippingService.getAll(cvcShipping, 1, 20);
		request.setAttribute("shippingEntitys", daoPage.getResults());
		
		//传递订单信息
		request.setAttribute("cvcOrderInfoEntity", cvcOrderInfoEntity);
		return new ModelAndView("com/xuzy/hotel/order/tOrderShip");
	}
	
	/**
	 * 修改状态
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "orderStatusUpdate", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson orderStatusUpdate(@RequestParam(required = true, value = "id") int id,
			@RequestParam(required = true, value = "tkOrderStatus") String tkOrderStatus) {
		AjaxJson j = new AjaxJson();
		try {
			if(StringUtils.isEmpty(tkOrderStatus)) {
				j.setSuccess(false);
				j.setMsg("参数异常");
				return j;
			}
			CvcOrderInfoEntity cvcOrderInfoEntity = cvcOrderInfoService.get(id);
			if(cvcOrderInfoEntity == null) {
				j.setSuccess(false);
				j.setMsg("操作订单不存在");
				return j;
			}
			if("offharbour".equals(tkOrderStatus)) {
				//推送至离港 
				RequestOFFHarbourExchangeOrderJson  requestBody = new RequestOFFHarbourExchangeOrderJson();
				requestBody.setOrderID(id);
				requestBody.setEMSCompany(cvcOrderInfoEntity.getShippingName());
				requestBody.setEMSOdd(cvcOrderInfoEntity.getInvoiceNo());
				requestBody.setPreArrivalDate(cvcOrderInfoEntity.getPreferDeliverdate());
				ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
						.setSequence(2)
						.setServiceCode("CRMIF.OFFHarbourExchangeOrderJson")
						.setParams(requestBody).builder(), null);
				if(responseHead.getReturn() >= 0) {
					cvcOrderInfoService.updateStatusByOrderId(id, 3);
					j.setMsg("订单离港成功");
				}else {
					j.setSuccess(false);
					j.setMsg("订单离港失败 原因:"+responseHead.getReturnInfo());
				}
			} else if("send".equals(tkOrderStatus)) {
				//推送至配送中 
				RequestDeliveryExchangeOrderJson  requestBody = new RequestDeliveryExchangeOrderJson();
				requestBody.setOrderID(id);
				requestBody.setDeliveryingDate(DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
				ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
						.setSequence(2)
						.setServiceCode("CRMIF.DeliveryExchangeOrderJson")
						.setParams(requestBody).builder(), null);
				if(responseHead.getReturn() >= 0) {
					cvcOrderInfoService.updateStatusByOrderId(id, 4);
					j.setMsg("订单配送成功");
				}else {
					j.setSuccess(false);
					j.setMsg("订单配送失败 原因:"+responseHead.getReturnInfo());
				}
			}else if("signin".equals(tkOrderStatus)) {
				CvcDeliveryInfoEntity cvcDeliveryInfoEntity = cvcOrderInfoService.getDeliveryInfosByInvoiceNo(cvcOrderInfoEntity.getInvoiceNo());
				if(cvcDeliveryInfoEntity == null) {
					j.setSuccess(false);
					j.setMsg("暂未查询到物流信息");
					return j;
				}
				List<DelivetyJson> datas = PHPAndJavaSerialize.unserializePHParray(cvcDeliveryInfoEntity.getData(),DelivetyJson.class);
				if(CollectionUtils.isEmpty(datas)) {
					j.setSuccess(false);
					j.setMsg("暂未查询到物流信息");
					return j;
				}
				//推送至签收 
				RequestSignInExchangeOrderJson  requestBody = new RequestSignInExchangeOrderJson();
				requestBody.setOrderID(id);
				requestBody.setSignInMan(datas.get(0).getContext());
				requestBody.setSignInDate(datas.get(0).getFtime() );
				ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
						.setSequence(2)
						.setServiceCode("CRMIF.SignInExchangeOrderJson")
						.setParams(requestBody).builder(), null);
				if(responseHead.getReturn() >= 0) {
					cvcOrderInfoService.updateStatusByOrderId(id, 5);
					j.setMsg("订单签收成功");
				}else {
					j.setSuccess(false);
					j.setMsg("订单签收失败 原因:"+responseHead.getReturnInfo());
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("推送失败");
		}
		return j;
	}

	
	
	/**
	 * 保存信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute CvcOrderInfoEntity cvcOrderInfo) {
		AjaxJson j = new AjaxJson();
		try {
			cvcOrderInfoService.insert(cvcOrderInfo);
			j.setMsg("保存成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}


	/**
	 * 编辑
	 * 
	 * @return
	 */
	@RequestMapping(params = "doEdit", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute CvcOrderInfoEntity cvcOrderInfo) {
		AjaxJson j = new AjaxJson();
		try {
			cvcOrderInfoService.update(cvcOrderInfo);
			j.setMsg("编辑成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}
		return j;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDelete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id") String id) {
		AjaxJson j = new AjaxJson();
		try {
			cvcOrderInfoService.delete(id);
			j.setMsg("删除成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("删除失败");
		}
		return j;
	}

	/**
	 * 批量删除数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "batchDelete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(required = true, value = "ids") String[] ids) {
		AjaxJson j = new AjaxJson();
		try {
			cvcOrderInfoService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch (Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("批量删除失败");
		}
		return j;
	}

}
