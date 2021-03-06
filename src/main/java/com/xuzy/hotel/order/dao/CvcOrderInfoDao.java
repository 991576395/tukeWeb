package com.xuzy.hotel.order.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.deliverygoods.entity.CvcDeliveryGoodsEntity;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.ordergoods.entity.CvcOrderGoodsEntity;

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
	@Sql("SELECT o.order_id id,o.tk_order_status orderStatus,d_o.shipping_name as shippingName,d_o.invoice_no as invoiceNo,d_o.pre_arrival_date as preArrivalDate FROM  cvc_order_info AS o LEFT JOIN cvc_delivery_order AS d_o  ON o.order_id=d_o.order_id WHERE o.order_id = :id order by d_o.update_time desc limit 1")
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
	@Sql("INSERT INTO	cvc_order_info (order_id,order_sn,user_id,user_name,consignee,address,tel,add_time,confirm_time,batch_no,remark,get_time,order_source_name) "
			+ "values (:cvcOrderInfo.id,:cvcOrderInfo.orderSn,:cvcOrderInfo.userId,:cvcOrderInfo.userName,:cvcOrderInfo.consignee,:cvcOrderInfo.address,:cvcOrderInfo.tel,:cvcOrderInfo.addTime,:cvcOrderInfo.confirmTime,:cvcOrderInfo.batchNo,:cvcOrderInfo.remark,:cvcOrderInfo.getTime,:cvcOrderInfo.orderSourceName)")
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
	
	@Sql("SELECT order_id as id FROM  cvc_order_info where batch_no = :batchNo AND tk_order_status='0'")
	public List<CvcOrderInfoEntity> getCanReadOrders(@Param("batchNo")  String batchNo);
	
	@Sql("SELECT order_id as id FROM  cvc_order_info where tk_order_status='0'")
	public List<CvcOrderInfoEntity> getCanReadOrders();
	
	@Sql("SELECT order_id as id FROM  cvc_order_info where tk_order_status='1'")
	public List<CvcOrderInfoEntity> getCanCangKu();
	
	@Sql("UPDATE cvc_order_info SET yl_order_status= '1',tk_order_status='1' WHERE batch_no=:batchNo and tk_order_status='0'")
	public void updateOrderRead(@Param("batchNo")  String batchNo);
	
	@Sql("UPDATE cvc_order_info SET yl_order_status= '1',tk_order_status='1' WHERE tk_order_status='0'")
	public void updateOrderRead();
	
	@Sql("UPDATE cvc_order_info SET yl_order_status= '2',tk_order_status='2' WHERE tk_order_status='1'")
	public void updateAllocateOrder();
	
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
	  * 通过订单号查询操作人
	  * @return
	  */
	 @Sql("SELECT action_user FROM cvc_order_action WHERE order_id = :orderId group by action_user limit 1")
	 public String getActionUserByOrderId(@Param("orderId") int orderId);
	
	/**
	 * 
	 * d_o.shipping_name,
 d_o.invoice_no,
 coi.address,
 coi.consignee,
 coi.mobile,
 d_o.signin_date,
	 * @param userName
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@ResultType(CvcOrderInfoEntity.class)
	List<CvcOrderInfoEntity> getAccountOrders(@Param("userName")  String userName,
			@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	
	@ResultType(CvcOrderInfoEntity.class)
	public List<CvcOrderInfoEntity> getExcelAll(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo);
	
	@ResultType(CvcOrderInfoEntity.class)
	public List<CvcOrderInfoEntity> getExceptionExcelAll(@Param("cvcOrderInfo") CvcOrderInfoEntity cvcOrderInfo);
	
	@Sql("SELECT distinct o.order_id as id, d_o.shipping_name, d_o.invoice_no,o.address,o.consignee,o.mobile,d_o.signin_date FROM  cvc_order_info AS o LEFT JOIN \r\n" + 
			"	cvc_delivery_order AS d_o ON o.order_id=d_o.order_id \r\n" + 
			"	where \r\n" + 
			"	d_o.signin_date ='' and \r\n" + 
			"	d_o.invoice_no is not null and \r\n" + 
			"	tk_order_status=5 order by id desc")
	@ResultType(CvcOrderInfoEntity.class)
	List<CvcOrderInfoEntity> getErrorList();
	
	
	@Sql("SELECT distinct o.order_id as id FROM  cvc_order_info AS o \r\n" + 
			"	LEFT JOIN cvc_delivery_order AS d_o ON o.order_id=d_o.order_id \r\n" + 
			"	LEFT JOIN cvc_delivery_info AS d_i ON d_o.invoice_no=d_i.number\r\n" + 
			"where (tk_order_status=4 or tk_order_status=3) and (yl_order_status = 3 or yl_order_status = 4) and (d_i.state = 3 or d_i.state = 5)")
	@ResultType(CvcOrderInfoEntity.class)
	List<CvcOrderInfoEntity> getWillSignList();
	
	
	@Sql("UPDATE cvc_order_info SET is_show=2 WHERE order_id=:orderId limit 1")
	public void updateEpStatus(@Param("orderId")  int orderId);
	
	
	
	@Sql("select coi.order_id as id,cdo.invoice_no,cdo.shipping_name from cvc_order_info coi " + 
			"left join cvc_delivery_order cdo on coi.order_id = cdo.order_id  " + 
			"where (coi.yl_order_status = 3 or coi.yl_order_status = 4) and (coi.tk_order_status = 3 or coi.tk_order_status = 4) and cdo.delivery_sn > :startTime and cdo.delivery_sn < :endTime order by cdo.delivery_sn  limit 3000")
	@ResultType(CvcOrderInfoEntity.class)
	List<CvcOrderInfoEntity> getTogezelWuliuList(@Param("startTime")  String startTime,@Param("endTime")String endTime);
	
	
	@Sql("select distinct coi.order_id as id,cdo.invoice_no,cdo.shipping_name from cvc_order_info coi " + 
			"left join cvc_delivery_order cdo on coi.order_id = cdo.order_id  " + 
			"where (coi.yl_order_status = 3 or coi.yl_order_status = 4) and cdo.shipping_name='申通快递' and coi.add_time > :startTime and coi.add_time < :endTime")
	@ResultType(CvcOrderInfoEntity.class)
	List<CvcOrderInfoEntity> getShentongList(@Param("startTime")  long startTime,@Param("endTime")long endTime);
	
	
	@Sql("select distinct coi.order_id as id,coi.tk_order_status orderStatus,cdo.invoice_no,cdo.shipping_id shippingId,cdo.shipping_name,cdo.delivery_sn from cvc_order_info coi " + 
			"left join cvc_delivery_order cdo on coi.order_id = cdo.order_id  " + 
			"where (coi.yl_order_status = 3 or coi.yl_order_status = 4) and (coi.tk_order_status = 3 or coi.tk_order_status = 4)  order by cdo.delivery_sn")
	@ResultType(CvcOrderInfoEntity.class)
	public MiniDaoPage<CvcOrderInfoEntity> getTimeOutOrderList(@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("select count(*) from cvc_order_info coi " + 
			"left join cvc_delivery_order cdo on coi.order_id = cdo.order_id  " + 
			"where (coi.yl_order_status = 3 or coi.yl_order_status = 4) and (coi.tk_order_status = 3 or coi.tk_order_status = 4) ")
	public int getTimeOutOrderCount();
	
	
	
	@Sql("select distinct coi.order_id as id,cdo.invoice_no,cdo.shipping_name from cvc_order_info coi " + 
			"left join cvc_delivery_order cdo on coi.order_id = cdo.order_id  " + 
			"where (coi.yl_order_status = 3 or coi.yl_order_status = 4 or coi.yl_order_status = 23 or coi.yl_order_status = 24) "
			+ "and (coi.tk_order_status = 3 or coi.tk_order_status = 4 or coi.tk_order_status = 23 or coi.tk_order_status = 24) and cdo.shipping_id = 39 and "
			+ "cdo.delivery_sn > :startTime and cdo.delivery_sn < :endTime")
	@ResultType(CvcOrderInfoEntity.class)
	List<CvcOrderInfoEntity> getShenTongList(@Param("startTime")  String startTime,@Param("endTime")String endTime);


	@Sql("select distinct coi.order_id as id,cdo.invoice_no,cdo.shipping_name from cvc_order_info coi " + 
			"left join cvc_delivery_order cdo on coi.order_id = cdo.order_id  "
			+ "left join cvc_delivery_info_new cdin on cdo.invoice_no = cdin.invoice_no " + 
			"where coi.tk_order_status = 5 and cdo.shipping_id = 39 and cdin.shentong_status != 3 and "
			+ "cdo.delivery_sn > :startTime and cdo.delivery_sn < :endTime")
	@ResultType(CvcOrderInfoEntity.class)
	List<CvcOrderInfoEntity> getShenTongTwoList(@Param("startTime")  String startTime,@Param("endTime")String endTime);
}

