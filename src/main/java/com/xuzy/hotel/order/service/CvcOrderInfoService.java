package com.xuzy.hotel.order.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;

import com.xuzy.hotel.deliverygoods.entity.CvcDeliveryGoodsEntity;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;

/**
 * 描述：订单表
 * @author: www.jeecg.org
 * @since：2018年10月28日 18时23分43秒 星期日 
 * @version:1.0
 */
public interface CvcOrderInfoService {
	CvcOrderInfoEntity getOnlyEntity(int id);
	
	public CvcOrderInfoEntity get(int id);

	public int update(CvcOrderInfoEntity cvcOrderInfo);

	public void insert(CvcOrderInfoEntity cvcOrderInfo);

	public MiniDaoPage<CvcOrderInfoEntity> getAll(CvcOrderInfoEntity cvcOrderInfo,int page,int rows);
	
	public List<CvcOrderInfoEntity> getExcelAll(CvcOrderInfoEntity cvcOrderInfo);
	
	public List<CvcOrderInfoEntity> getExceptionExcelAll(CvcOrderInfoEntity cvcOrderInfo);
	
	public int getCount(CvcOrderInfoEntity cvcOrderInfo,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	/**
	 * 修改指定订单的状态
	 * @param orderId
	 * @param status
	 */
	public void updateStatusByOrderId(@Param("orderId")  int orderId,int status);
	
	/**
	 * 获取订订单信息
	 * @param cvcOrderInfo
	 * @return
	 */
	public CvcOrderInfoEntity getOrder(CvcOrderInfoEntity cvcOrderInfo);
	
	/**
	 * 通过订单号获取物流信息
	 * @param orderId
	 * @return
	 */
	public CvcDeliveryOrderEntity getDeliveryOrderByOrderId(int orderId);
	
	
	/**
	 * 修改操作人
	 * @param orderId
	 * @param handleStatus
	 * @param handleTime
	 * @param handleUser
	 */
	 public void updateHandle(int orderId,int handleStatus,int handleTime, String handleUser);
	 
	 public void insert(CvcDeliveryGoodsEntity cvcDeliveryGoods);
	 
	 /**
	  * 获取待确认的订单
	  * @param batchNo
	  * @return
	  */
	 public List<CvcOrderInfoEntity> getCanReadOrders(String batchNo);
	 
	 /**
	  * 获取指定状态订单
	  * @param status
	  * @return
	  */
	 public List<CvcOrderInfoEntity> getAllocateOrders(CvcOrderInfoEntity entity);
	 
	 /**
	  * 获取异常订单列表
	  * @param cvcOrderInfo
	  * @param page
	  * @param rows
	  * @return
	  */
	 public MiniDaoPage<CvcOrderInfoEntity> getExceptionOrderListAll(CvcOrderInfoEntity cvcOrderInfo, int page,int rows);

	public int getExceptionOrderCount(CvcOrderInfoEntity query);
	
	/**
	 * 获取账单列表订单
	 * @param userName
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<CvcOrderInfoEntity> getAccountOrderList(String userName,
			 String startTime,String endTime);
		
	public void updateErrorStatusByOrderId( int orderId,int errorStatus);
	
	
	CvcOrderInfoEntity getEntity(int id,String batchNo);
	
	
	public AjaxJson sendOrder(CvcOrderInfoEntity cvcOrderInfoEntity, String shippingName, String batchSendNo,String invoiceNo,String preArrivalDate);

	public void updateAllocateOrder();
	
	public List<CvcOrderInfoEntity> getCanCangKu();
}
