package com.xuzy.hotel.shippingbatch.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.shippingbatch.entity.CvcShippingBatchEntity;

/**
 * 描述：批量发货表
 * @author：www.jeecg.org
 * @since：2018年11月20日 20时41分17秒 星期二 
 * @version:1.0
 */
@Repository
public interface CvcShippingBatchDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_shipping_batch WHERE ID = :id")
	CvcShippingBatchEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cvcShippingBatch
	 * @return
	 */
	int update(@Param("cvcShippingBatch") CvcShippingBatchEntity cvcShippingBatch);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcShippingBatch") CvcShippingBatchEntity cvcShippingBatch);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcShippingBatch
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcShippingBatchEntity.class)
	public MiniDaoPage<CvcShippingBatchEntity> getAll(@Param("cvcShippingBatch") CvcShippingBatchEntity cvcShippingBatch,@Param("page")  int page,@Param("rows") int rows);
	
	int getCount(@Param("cvcShippingBatch") CvcShippingBatchEntity cvcShippingBatch);
	
	
	@Sql("DELETE from cvc_shipping_batch WHERE batch_no = :batchNo limit 1")
	public void delete(@Param("batchNo") String batchNo);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_shipping_batch WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	 
	 
	@Sql("UPDATE cvc_shipping_batch SET shipping_count_ok=shipping_count_ok + :sucSize WHERE batch_no=:batchNo")
	void addSucSizeCount(@Param("batchNo")String batchNo,@Param("sucSize")int sucSize);
	
}

