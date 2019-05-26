package com.xuzy.hotel.order.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appinterface.app.base.exception.XuException;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.PHPAndJavaSerialize;
import com.util.PhpDateUtils;
import com.xuzy.hotel.deliverygoods.dao.CvcDeliveryGoodsDao;
import com.xuzy.hotel.deliverygoods.entity.CvcDeliveryGoodsEntity;
import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;
import com.xuzy.hotel.deliveryorder.dao.CvcDeliveryOrderDao;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.deliveryorder.service.CvcDeliveryOrderService;
import com.xuzy.hotel.order.dao.CvcOrderInfoDao;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.module.CallBaseRequest;
import com.xuzy.hotel.order.module.Data;
import com.xuzy.hotel.order.module.DelivetyJson;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.order.web.OrderCallBack;
import com.xuzy.hotel.orderaction.dao.CvcOrderActionDao;
import com.xuzy.hotel.orderaction.entity.CvcOrderActionEntity;
import com.xuzy.hotel.shipping.dao.CvcShippingDao;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;
import com.xuzy.hotel.shippingbatchorder.dao.CvcShippingBatchOrderDao;
import com.xuzy.hotel.shippingbatchorder.entity.CvcShippingBatchOrderEntity;
import com.xuzy.hotel.ylrequest.ConmentHttp;
import com.xuzy.hotel.ylrequest.ResponseHead;
import com.xuzy.hotel.ylrequest.TukeRequestBody;
import com.xuzy.hotel.ylrequest.module.Kuaidi100Response;
import com.xuzy.hotel.ylrequest.module.RequestOFFHarbourExchangeOrderJson;

/**
 * 描述：订单表
 * @author: www.jeecg.org
 * @since：2018年10月28日 18时23分43秒 星期日 
 * @version:1.0
 */

@Service("cvcOrderInfoService")
public class CvcOrderInfoServiceImpl implements CvcOrderInfoService {
	@Resource
	private CvcOrderInfoDao cvcOrderInfoDao;
	
	@Resource
	private CvcDeliveryOrderDao cvcDeliveryOrderDao;
	
	@Autowired
	private CvcDeliveryOrderService cvcDeliveryOrderService;
	
	@Resource
	private CvcShippingBatchOrderDao cvcShippingBatchOrderDao;
	
	@Resource
	private CvcDeliveryGoodsDao cvcDeliveryGoodsDao;
	
	@Resource
	private CvcShippingDao cvcShippingDao;
	
	@Resource
	private CvcOrderActionDao cvcOrderActionDao;
	
	@Resource
	private OrderCallBack orderCallBack;
	

	 /**
		 * Logger for this class
		 */
		private static final Logger logger = Logger.getLogger(CvcOrderInfoServiceImpl.class);
	
	@Override
	public CvcOrderInfoEntity get(int id) {
		return cvcOrderInfoDao.get(id);
	}

	@Override
	public int update(CvcOrderInfoEntity cvcOrderInfo) {
		return cvcOrderInfoDao.update(cvcOrderInfo);
	}

	@Override
	public void insert(CvcOrderInfoEntity cvcOrderInfo) {
		cvcOrderInfoDao.insertOrder(cvcOrderInfo);
		
	}

	@Override
	public MiniDaoPage<CvcOrderInfoEntity> getAll(CvcOrderInfoEntity cvcOrderInfo, int page, int rows) {
		return cvcOrderInfoDao.getAll(cvcOrderInfo, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcOrderInfoDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcOrderInfoDao.deleteById(id);
		}
	}

	@Override
	public int getCount(CvcOrderInfoEntity cvcOrderInfo, int page, int rows) {
		return cvcOrderInfoDao.getCount(cvcOrderInfo);
	}

	@Override
	public CvcOrderInfoEntity getOrder(CvcOrderInfoEntity cvcOrderInfo) {
		CvcOrderInfoEntity cvcOrderInfoEntity = cvcOrderInfoDao.getOrder(cvcOrderInfo);
		if (cvcOrderInfoEntity != null) {
			cvcOrderInfoEntity.setOldAddTime(cvcOrderInfoEntity.getAddTime());
			// 格式化时间
			cvcOrderInfoEntity.setAddTime(PhpDateUtils
					.parseDate(Long.parseLong(cvcOrderInfoEntity.getAddTime()), "yyyy-MM-dd HH:mm:ss"));
			cvcOrderInfoEntity.setGetTime(PhpDateUtils
					.parseDate(Long.parseLong(cvcOrderInfoEntity.getGetTime()), "yyyy-MM-dd HH:mm:ss"));
		}
		return cvcOrderInfoEntity;
	}

	@Override
	public List<CvcDeliveryOrderEntity> getDeliveryOrderByOrderId(int orderId) {
		List<CvcDeliveryOrderEntity> deliveryOrders = cvcDeliveryOrderDao.getDeliveryOrderByOrderId(orderId);
		for (CvcDeliveryOrderEntity deliveryOrder : deliveryOrders) {
			deliveryOrder.setActionUser(cvcOrderInfoDao.getActionUserByOrderId(orderId));
			
			deliveryOrder.setAddTimeString(PhpDateUtils.parseDate(deliveryOrder.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
		}
		return deliveryOrders;
	}


	@Override
	public void updateHandle(int orderId, int handleStatus, int handleTime, String handleUser) {
		cvcOrderInfoDao.updateHandle(orderId, handleStatus, handleTime, handleUser);
	}
	
	
	@Override
	public void insert(CvcDeliveryGoodsEntity cvcDeliveryGoods) {
		cvcDeliveryGoodsDao.insert(cvcDeliveryGoods);
	}

	@Override
	public List<CvcOrderInfoEntity> getCanReadOrders(String batchNo) {
		if(!StringUtils.isEmpty(batchNo)) {
			return cvcOrderInfoDao.getCanReadOrders(batchNo);
		}else {
			return cvcOrderInfoDao.getCanReadOrders();
		}
	}

	@Override
	public MiniDaoPage<CvcOrderInfoEntity> getExceptionOrderListAll(CvcOrderInfoEntity cvcOrderInfo, int page,
			int rows) {
		return cvcOrderInfoDao.getExceptionOrderListAll(cvcOrderInfo, page, rows);
	}

	@Override
	public int getExceptionOrderCount(CvcOrderInfoEntity query) {
		return cvcOrderInfoDao.getExceptionOrderCount(query);
	}

	@Override
	public List<CvcOrderInfoEntity> getAccountOrderList(String userName, String startTime, String endTime) {
		return cvcOrderInfoDao.getAccountOrders(userName, startTime, endTime);
	}

	@Override
	public void updateStatusByOrderId(int orderId, int status) {
		cvcOrderInfoDao.updateStatusByOrderId(orderId, status);
		
//		try {
//			//添加操作记录
//			CvcOrderActionEntity cvcOrderAction = new CvcOrderActionEntity();
//			cvcOrderAction.setOrderId(orderId);
//			cvcOrderAction.setActionUser(ResourceUtil.getSessionUser().getUserName());
//			cvcOrderAction.setLogTime((int)PhpDateUtils.getTime());
//			cvcOrderAction.setActionNote("推送订单状态为"+ResourceUtil.searchAllTypesByCode("OStatus",status+""));
//			cvcOrderActionDao.insert(cvcOrderAction );
//		} catch (Exception e) {
//			logger.info("添加操作日志失败=="+e.getMessage());
//		}
	}

	@Override
	public void updateErrorStatusByOrderId(int orderId, int errorStatus) {
		cvcOrderInfoDao.updateErrorStatusByOrderId(orderId, errorStatus, PhpDateUtils.getTime());
	}

	@Override
	public CvcOrderInfoEntity getOnlyEntity(int id) {
		return cvcOrderInfoDao.getOnlyEntity(id);
	}

	@Override
	public CvcOrderInfoEntity getEntity(int id, String batchNo) {
		return cvcOrderInfoDao.getEntity(id, batchNo);
	}
	
	/**
	 * 订单发货
	 * 
	 * 
	 */
	public AjaxJson sendOrder(CvcOrderInfoEntity cvcOrderInfoEntity, String shippingName,String batchSendNo,String invoiceNo
			,String preArrivalDate) {
		AjaxJson j = new AjaxJson();
		try {
			shippingName = shippingName.trim();
			if (cvcOrderInfoEntity == null) {
				j.setSuccess(false);
				j.setMsg("订单查询失败！");
				return j;
			}

			if (5 == cvcOrderInfoEntity.getOrderStatus()) {
				// 检查权限
				j.setSuccess(false);
				j.setMsg("订单已发货！");
				return j;
			}
			// 快递公司信息
			if (StringUtils.isEmpty(shippingName)) {
				// 快递信息异常
				j.setSuccess(false);
				j.setMsg("订单：" + cvcOrderInfoEntity.getId() + "快递名称：" + shippingName + "有误，请检查！");
				return j;
			}
			cvcOrderInfoEntity.setInvoiceNo(invoiceNo);
			cvcOrderInfoEntity.setPreArrivalDate(preArrivalDate);
			cvcOrderInfoEntity.setShippingName(shippingName);
			
			// 是否离港
			boolean isOffhabour = false;
			if (cvcOrderInfoEntity.getOrderStatus() == 2) {
				// 配货中订单 调用离港接口
				// 订单离港
				RequestOFFHarbourExchangeOrderJson exchangeOrderJson = new RequestOFFHarbourExchangeOrderJson();
				exchangeOrderJson.setOrderID(cvcOrderInfoEntity.getId());
				exchangeOrderJson.setEMSCompany(shippingName);
				exchangeOrderJson.setEMSOdd(invoiceNo);
				exchangeOrderJson.setPreArrivalDate(preArrivalDate);
				ResponseHead head = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setParams(exchangeOrderJson)
						.setSequence(4).setServiceCode("CRMIF.OFFHarbourExchangeOrderJson").builder(), null);
				if (head.getReturn() >= 0) {
					isOffhabour = true;
				} else {
					j.setSuccess(false);
					j.setMsg(head.getReturnInfo());
					return j;
				}
			}

			CvcShippingEntity cvcShippingEntity = cvcShippingDao.get(shippingName.trim());
			
			if (cvcOrderInfoEntity.getOrderStatus() == 3 || isOffhabour) {
				int isPostorder = 0;
//				 已经为离港订单 或者调用伊利接口成功
				if (StringUtils.isNotEmpty(batchSendNo)) {
					// 批量发货相关
					// 是否已经订阅快递信息
					CvcShippingBatchOrderEntity batchOrderEntity = cvcShippingBatchOrderDao
							.getEntityByInvoiceNo(invoiceNo);
					if (batchOrderEntity == null) {
						// 未订阅物流信息 开始订阅
						Kuaidi100Response kuaidi100Response = ConmentHttp.postorder(cvcShippingEntity.getShippingCode(),
								invoiceNo);
						isPostorder = (kuaidi100Response.getResult() || kuaidi100Response.getMessage().contains("重复订阅"))
								? 1: 0;
					} else {
						isPostorder = 1;
					}
				} else {
					// 非批量发货
					Kuaidi100Response kuaidi100Response =  ConmentHttp.postorder(cvcShippingEntity.getShippingCode(), invoiceNo);
					isPostorder = (kuaidi100Response.getResult() || kuaidi100Response.getMessage().contains("重复订阅"))
					? 1: 0;
				}
				// 添加发货订单
				cvcDeliveryOrderService.addDeliveryOrderByOrder(cvcOrderInfoEntity, shippingName, batchSendNo,
						isPostorder);
				j.setSuccess(true);
				j.setMsg("发货成功");
			}
		}catch (XuException e) {
			j.setSuccess(false);
			j.setMsg("调用异常:"+e.getMessage());
			logger.error("发货异常", e);
			return j;
		}catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("接口调用异常");
			logger.error("发货异常", e);
			return j;
		}
		return j;
	}

	@Override
	public List<CvcOrderInfoEntity> getExcelAll(CvcOrderInfoEntity cvcOrderInfo) {
		List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoDao.getExcelAll(cvcOrderInfo);
		for (CvcOrderInfoEntity cvcOrderInfoEntity : cvcOrderInfoEntities) {
			cvcOrderInfoEntity.setOldAddTime(cvcOrderInfoEntity.getAddTime());
			// 格式化时间
			cvcOrderInfoEntity.setAddTime(PhpDateUtils
					.parseDate(Long.parseLong(cvcOrderInfoEntity.getAddTime()), "yyyy-MM-dd HH:mm:ss"));
			cvcOrderInfoEntity.setGetTime(PhpDateUtils
					.parseDate(Long.parseLong(cvcOrderInfoEntity.getGetTime()), "yyyy-MM-dd HH:mm:ss"));
			cvcOrderInfoEntity.setTkOrderStatusString(ResourceUtil.searchAllTypesByCode(cvcOrderInfoEntity.getOrderStatus()+"","OStatus"));
			cvcOrderInfoEntity.setYlOrderStatusString(ResourceUtil.searchAllTypesByCode(cvcOrderInfoEntity.getYlOrderStatus()+"","OStatus"));
			cvcOrderInfoEntity.setIsBalanceString(ResourceUtil.searchAllTypesByCode(cvcOrderInfoEntity.getIsBalance()+"","is_balance"));
			cvcOrderInfoEntity.setExceptionStatusString(ResourceUtil.searchAllTypesByCode(cvcOrderInfoEntity.getExceptionStatus()+"" ,"isExp"));
		}
		return cvcOrderInfoEntities;
	}

	@Override
	public List<CvcOrderInfoEntity> getExceptionExcelAll(CvcOrderInfoEntity cvcOrderInfo) {
		List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoDao.getExceptionExcelAll(cvcOrderInfo);
		for (CvcOrderInfoEntity cvcOrderInfoEntity : cvcOrderInfoEntities) {
			cvcOrderInfoEntity.setOldAddTime(cvcOrderInfoEntity.getAddTime());
			// 格式化时间
			cvcOrderInfoEntity.setAddTime(PhpDateUtils
					.parseDate(Long.parseLong(cvcOrderInfoEntity.getAddTime()), "yyyy-MM-dd HH:mm:ss"));
			cvcOrderInfoEntity.setGetTime(PhpDateUtils
					.parseDate(Long.parseLong(cvcOrderInfoEntity.getGetTime()), "yyyy-MM-dd HH:mm:ss"));
			cvcOrderInfoEntity.setTkOrderStatusString(ResourceUtil.searchAllTypesByCode(cvcOrderInfoEntity.getOrderStatus()+"","OStatus"));
			cvcOrderInfoEntity.setYlOrderStatusString(ResourceUtil.searchAllTypesByCode(cvcOrderInfoEntity.getYlOrderStatus()+"","OStatus"));
			cvcOrderInfoEntity.setIsBalanceString(ResourceUtil.searchAllTypesByCode(cvcOrderInfoEntity.getIsBalance()+"","is_balance"));
			cvcOrderInfoEntity.setExceptionStatusString(ResourceUtil.searchAllTypesByCode(cvcOrderInfoEntity.getExceptionStatus()+"" ,"isExp"));
		}
		return cvcOrderInfoEntities;
	}

	@Override
	public List<CvcOrderInfoEntity> getAllocateOrders(CvcOrderInfoEntity entity) {
		return cvcOrderInfoDao.getExcelAll(entity);
	}

	@Override
	public void updateAllocateOrder() {
		cvcOrderInfoDao.updateAllocateOrder();
	}

	@Override
	public List<CvcOrderInfoEntity> getCanCangKu() {
		return cvcOrderInfoDao.getCanCangKu();
	}
	
	@Autowired
	private CvcDeliveryInfoService cvcDeliveryInfoService;

	@Override
	public void doErrorList() {
		List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoDao.getErrorList();
		if(!CollectionUtils.isEmpty(cvcOrderInfoEntities)){
			for (CvcOrderInfoEntity cvcOrderInfoEntity : cvcOrderInfoEntities) {
				if(StringUtils.isNotEmpty(cvcOrderInfoEntity.getInvoiceNo()) && !StringUtils.isNotEmpty(cvcOrderInfoEntity.getSigninDate())) {
//					CvcDeliveryOrderEntity cvcDeliveryOrderEntity = cvcDeliveryOrderService.getEntityByinvoiceNo(cvcOrderInfoEntity.getInvoiceNo());
					
					List<Data> deliveryInfos = new ArrayList<>();
					CvcDeliveryInfoEntity entity = cvcDeliveryInfoService.getDeliveryInfosByInvoiceNo(cvcOrderInfoEntity.getInvoiceNo());
					if(entity != null && StringUtils.isNotEmpty(entity.getData())) {
						deliveryInfos = PHPAndJavaSerialize.unserializePHParray(entity.getData(),Data.class);
					}
					if(CollectionUtils.isNotEmpty(deliveryInfos)) {
						int x = cvcDeliveryOrderService.updateSignDate(deliveryInfos.get(0).getFtime(),cvcOrderInfoEntity.getInvoiceNo());
						System.out.println(x);
					}
				}
			}
		}
		
	}

	@Override
	public List<CvcOrderInfoEntity> getWillSignList() {
		return cvcOrderInfoDao.getWillSignList();
	}

	@Override
	public void updateEpStatus(int orderId) {
		cvcOrderInfoDao.updateEpStatus(orderId);
	}

	@Override
	public List<CvcOrderInfoEntity> getTogezelWuliuList() {
		Calendar calendar = Calendar.getInstance();
		//3天前
		calendar.add(Calendar.DAY_OF_YEAR, -3);
		String startTime = DateFormatUtils.format(calendar, "yyyyMMddHHmmssSSS");
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		calendar.add(Calendar.HOUR_OF_DAY, 12);
		String endTime = DateFormatUtils.format(calendar, "yyyyMMddHHmmssSSS");
		return cvcOrderInfoDao.getTogezelWuliuList(startTime, endTime);
	}
	

	@Override
	public MiniDaoPage<CvcOrderInfoEntity> getTimeOutOrderList(int page, int rows) {
		return cvcOrderInfoDao.getTimeOutOrderList(page, rows);
	}

	@Override
	public int getTimeOutOrderCount() {
		return cvcOrderInfoDao.getTimeOutOrderCount();
	}
	
	
	@Override
	public void shengtongSearch() {
		Calendar calendar = Calendar.getInstance();
		//3天前
		calendar.add(Calendar.DAY_OF_YEAR, -3);
		String startTime = DateFormatUtils.format(calendar, "yyyyMMddHHmmssSSS");
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		calendar.add(Calendar.HOUR_OF_DAY, 12);
		String endTime = DateFormatUtils.format(calendar, "yyyyMMddHHmmssSSS");
		List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoDao.getShenTongList(startTime,endTime);
		if(CollectionUtils.isNotEmpty(cvcOrderInfoEntities)) {
			for (CvcOrderInfoEntity entity : cvcOrderInfoEntities) {
				try {
					CallBaseRequest baseRequest = ConmentHttp.postShentongValue(entity.getInvoiceNo());
					logger.info("申通接口:"+new Gson().toJson(baseRequest));
					orderCallBack.runByRequest(baseRequest);
				} catch (Exception e) {
					logger.error(entity.getInvoiceNo()+":处理物流返回异常", e);
				}
			}
		}
	}
}
