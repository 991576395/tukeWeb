package com.xuzy.hotel.order.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.order.entity.CvcDeliveryGoodsEntity;
import com.xuzy.hotel.order.entity.CvcOrderGoodsEntity;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;

/**
 * 描述：订单表
 * @author：www.jeecg.org
 * @since：2018年10月28日 18时23分43秒 星期日 
 * @version:1.0
 */
@Repository
public interface CvcOrderInfoDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT d_o.shipping_name as shippingName,d_o.invoice_no as invoiceNo,d_o.pre_arrival_date as preArrivalDate FROM  cvc_order_info AS o LEFT JOIN cvc_delivery_order AS d_o  ON o.order_id=d_o.order_id WHERE o.order_id = :id")
	CvcOrderInfoEntity get(@Param("id") int id);
	
	@Sql("SELECT order_id as id,tk_order_status FROM  cvc_order_info  WHERE order_id = :id")
	CvcOrderInfoEntity getOnlyEntity(@Param("id") int id);
	
	@Sql("SELECT order_id as id,tk_order_status FROM  cvc_order_info  WHERE order_id = :id and batch_no=:batchNo")
	CvcOrderInfoEntity getEntity(@Param("id") int id,@Param("batchNo") String batchNo);
	
	@Sql("UPDATE cvc_order_info SET handle_status=:handleStatus,handle_time=:handleTime,handle_user=:handleUser  WHERE order_id= :orderId LIMIT 1 ")
	public void updateHandle(@Param("orderId") int orderId,@Param("handleStatus") int handleStatus,@Param("handleTime") int handleTime,@Param("handleUser") String handleUser);
	
	/**
	 * 修改数据
	 * @param cvcOrderInfo
	 * @return
	 */
	int update(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo);
	
	/**
	 * 插入数据
	 * @param act
	 */
	@Sql("INSERT INTO	cvc_order_info (order_id,order_sn,user_id,user_name,consignee,address,tel,add_time,confirm_time,batch_no,remark,get_time) "
			+ "values (:cvcOrderInfo.id,:cvcOrderInfo.orderSn,:cvcOrderInfo.userId,:cvcOrderInfo.userName,:cvcOrderInfo.consignee,:cvcOrderInfo.address,:cvcOrderInfo.tel,:cvcOrderInfo.addTime,:cvcOrderInfo.confirmTime,:cvcOrderInfo.batchNo,:cvcOrderInfo.remark,:cvcOrderInfo.getTime)")
	void insertOrder(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcOrderInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcOrderInfoEntity.class)
	public MiniDaoPage<CvcOrderInfoEntity> getAll(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("SELECT order_id as id FROM  cvc_order_info batch_no = :batchNo AND tk_order_status='0'")
	public List<CvcOrderInfoEntity> getCanReadOrders(@Param("batchNo")  String batchNo);
	
	@Sql("UPDATE cvc_order_info SET yl_order_status= '1',tk_order_status='1' WHERE batch_no=:batchNo and tk_order_status='0'")
	public void updateOrderRead(@Param("batchNo")  String batchNo);
	
	@Sql("UPDATE cvc_order_info SET yl_order_status= :status,tk_order_status=:status WHERE order_id=:orderId limit 1")
	public void updateStatusByOrderId(@Param("orderId")  int orderId,@Param("status")int status);
	
	@Sql("UPDATE cvc_order_info SET is_balance=1 WHERE order_id= :orderId limit 1")
	public int updateIsBalance(@Param("orderId")  Integer orderId);
	
	@Sql("UPDATE cvc_order_info SET exception_status=:errorStatus,exception_time=:exceptionTime WHERE order_id=:orderId limit 1")
	public void updateErrorStatusByOrderId(@Param("orderId")  int orderId,@Param("errorStatus")int errorStatus,@Param("exceptionTime")long exceptionTime);
	
	@Sql("UPDATE cvc_order_info SET order_status=:orderStatus,confirm_time=:confirmTime,yl_order_status= :status,tk_order_status=:status,shipping_status= :shippingStatus WHERE order_id= :orderId limit 1")
	public int updateOrder(@Param("orderId")  Integer orderId,@Param("orderStatus")int orderStatus,@Param("status")int status,@Param("shippingStatus")int shippingStatus,@Param("confirmTime")String confirmTime);
	
	@ResultType(CvcOrderInfoEntity.class)
	public MiniDaoPage<CvcOrderInfoEntity> getExceptionOrderListAll(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo,@Param("page")  int page,@Param("rows") int rows);
	
	public int getExceptionOrderCount(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo);
	
	/**
	 * 条件查询订单
	 * @param cvcOrderInfo
	 * @return
	 */
	public CvcOrderInfoEntity getOrder(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo);
	
	
	public int getCount(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo);
	
	
	@Sql("DELETE from cvc_order_info WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_order_info WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
	 /**
	  * 通过订单号查询快递信息
	  * @return
	  */
	 @ResultType(CvcDeliveryOrderEntity.class)
	 @Sql("SELECT shipping_name, invoice_no, pre_arrival_date,add_time FROM cvc_delivery_order WHERE order_id = :orderId")
	 public CvcDeliveryOrderEntity getDeliveryOrderByOrderId(@Param("orderId") int orderId);
	 
	 /**
	  * 通过订单号查询操作人
	  * @return
	  */
	 @Sql("SELECT action_user FROM cvc_order_action WHERE order_id = :orderId group by action_user")
	 public String getActionUserByOrderId(@Param("orderId") int orderId);
	
		
	 
	 
	 /**
	  * 获取物流流程
	  * @param invoice_no
	  * @return
	  */
	 @ResultType(CvcOrderGoodsEntity.class)
	 public List<CvcOrderGoodsEntity> getGoods(@Param("orderId") int orderId);
	 
	 
	/**
	 * 插入数据
	 * 
	 * @param act
	 */
	void insertGoods(@Param("cvcDeliveryGoods") CvcDeliveryGoodsEntity cvcDeliveryGoods);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcOrderGoods") CvcOrderGoodsEntity cvcOrderGoods);
	
	@ResultType(CvcOrderInfoEntity.class)
	List<CvcOrderInfoEntity> getAccountOrders(@Param("userName")  String userName,
			@Param("startTime") String startTime,@Param("endTime") String endTime);

	
	@ResultType(CvcOrderGoodsEntity.class)
	@Sql("SELECT goods_sn, goods_number FROM  cvc_order_goods WHERE order_id= :orderId")
	CvcOrderGoodsEntity getOrderGood(@Param("orderId")String orderId);
	
	@Sql("SELECT COUNT(rec_id) FROM  cvc_order_goods WHERE order_id = :orderId AND goods_number > send_number")
	int getOrderFinish(@Param("orderId")int orderId);
	
}

