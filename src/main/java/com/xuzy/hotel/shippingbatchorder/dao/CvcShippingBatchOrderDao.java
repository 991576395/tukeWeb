package com.xuzy.hotel.shippingbatchorder.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.shippingbatchorder.entity.CvcShippingBatchOrderEntity;

/**
 * 描述：批量发货订单表
 * @author：www.jeecg.org
 * @since：2018年11月21日 20时52分03秒 星期三 
 * @version:1.0
 */
@Repository
public interface CvcShippingBatchOrderDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_shipping_batch_order WHERE ID = :id")
	CvcShippingBatchOrderEntity get(@Param("id") String id);
	
	
	@Sql("SELECT * FROM cvc_shipping_batch_order WHERE invoice_no = :invoiceNo and is_postorder=1 LIMIT 1 ")
	CvcShippingBatchOrderEntity getEntityByInvoiceNo(@Param("invoiceNo") String invoiceNo);
	
	@ResultType(CvcShippingBatchOrderEntity.class)
	@Sql("SELECT order_id FROM cvc_shipping_batch_order WHERE batch_no=:batchNo ")
	List<CvcShippingBatchOrderEntity> getEntitysByBatchNo(@Param("batchNo") String batchNo);
	
	/**
	 * 修改数据
	 * @param cvcShippingBatchOrder
	 * @return
	 */
	int update(@Param("cvcShippingBatchOrder") CvcShippingBatchOrderEntity cvcShippingBatchOrder);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcShippingBatchOrder") CvcShippingBatchOrderEntity cvcShippingBatchOrder);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcShippingBatchOrder
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcShippingBatchOrderEntity.class)
	public MiniDaoPage<CvcShippingBatchOrderEntity> getAll(@Param("cvcShippingBatchOrder") CvcShippingBatchOrderEntity cvcShippingBatchOrder,@Param("page")  int page,@Param("rows") int rows);
	
	int getCount(@Param("cvcShippingBatchOrder") CvcShippingBatchOrderEntity cvcShippingBatchOrder);
	
	@Sql("DELETE from cvc_shipping_batch_order WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	@Sql("DELETE from cvc_shipping_batch_order WHERE batch_no = :batchNo")
	public void deleteBybatchNo(@Param("batchNo") String batchNo);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_shipping_batch_order WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
	 
	@Sql("UPDATE cvc_shipping_batch_order SET is_offharbour=1,is_postorder=:status,status=:status,shipping_time=:shippingTime WHERE batch_no = :batchNo and order_id=:orderId")
	public void updateBatchOrderStatus(@Param("status") int status,@Param("shippingTime") long shippingTime,@Param("orderId") int orderId,@Param("batchNo") String batchNo);
		
}

