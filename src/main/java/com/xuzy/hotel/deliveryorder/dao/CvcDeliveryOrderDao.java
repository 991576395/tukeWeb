package com.xuzy.hotel.deliveryorder.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;

/**
 * 描述：物流信息表
 * @author：www.jeecg.org
 * @since：2018年11月04日 09时59分48秒 星期日 
 * @version:1.0
 */
@Repository
public interface CvcDeliveryOrderDao{
	
    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_delivery_order WHERE ID = :id")
	CvcDeliveryOrderEntity get(@Param("id") String id);
	
	@Sql("SELECT LAST_INSERT_ID();")
	public int getInserId();
	
	@Sql("SELECT order_id FROM cvc_delivery_order WHERE invoice_no = :invoiceNo  group by order_id")
	@ResultType(CvcDeliveryOrderEntity.class)
	List<CvcDeliveryOrderEntity> getEntityByinvoiceNo(@Param("invoiceNo") String invoiceNo);
	
	/**
	 * 修改数据
	 * @param cvcDeliveryOrder
	 * @return
	 */
	int update(@Param("cvcDeliveryOrder") CvcDeliveryOrderEntity cvcDeliveryOrder);
	
	@Sql("UPDATE cvc_delivery_order SET  signin_date=:signDate WHERE invoice_no = :invoiceNo")
	int updateSignDate(@Param("signDate") String signDate,@Param("invoiceNo") String invoiceNo);
	
	/**
	 * 插入数据
	 * @param act
	 */
	int insert(@Param("cvcDeliveryOrder") CvcDeliveryOrderEntity cvcDeliveryOrder);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcDeliveryOrder
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcDeliveryOrderEntity.class)
	public MiniDaoPage<CvcDeliveryOrderEntity> getAll(@Param("cvcDeliveryOrder") CvcDeliveryOrderEntity cvcDeliveryOrder,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_delivery_order WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_delivery_order WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	 
	 @ResultType(CvcDeliveryOrderEntity.class)
	 public List<CvcDeliveryOrderEntity> getDeliveryCondition(@Param("orderId") int orderId);
	 
	 @Sql("UPDATE cvc_delivery_order SET signin_date= :signdate WHERE order_id= :orderId LIMIT 1")
	 public void updateSigndate(@Param("orderId") int orderId,@Param("signdate") String signdate);
	 
	 @Sql("UPDATE cvc_delivery_order SET invoice_no=:invoiceNo,shipping_id=:shippingId,shipping_name=:shippingName  WHERE order_id= :orderId LIMIT 1 ")
	 public void updateNu(@Param("orderId") int orderId,@Param("shippingId") int shippingId,@Param("shippingName") String shippingName,@Param("invoiceNo") String invoiceNo);
	 
	 @Sql("UPDATE cvc_delivery_order SET shipping_code=:shippingCode WHERE invoice_no= :invoiceNo LIMIT 1 ")
	 public void updateErrorCode(@Param("shippingCode") String shippingCode,@Param("invoiceNo") String invoiceNo);
	 
	 /**
	  * 通过订单号查询快递信息
	  * @return
	  */
	 @ResultType(CvcDeliveryOrderEntity.class)
	 @Sql("SELECT invoice_no,delivery_id,shipping_name, pre_arrival_date,add_time FROM cvc_delivery_order WHERE  " + 
	 		"order_id = :orderId and " + 
	 		"delivery_id in (" + 
	 		"select MAX(delivery_id) from cvc_delivery_order where order_id = :orderId GROUP BY invoice_no " + 
	 		") ")
	 public List<CvcDeliveryOrderEntity> getDeliveryOrderByOrderId(@Param("orderId") int orderId);
}

