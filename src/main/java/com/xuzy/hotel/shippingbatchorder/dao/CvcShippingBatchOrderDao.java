package com.xuzy.hotel.shippingbatchorder.dao;

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
	
	@Sql("DELETE from cvc_shipping_batch_order WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_shipping_batch_order WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

