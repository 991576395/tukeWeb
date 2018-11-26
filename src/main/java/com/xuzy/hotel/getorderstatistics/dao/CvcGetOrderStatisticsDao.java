package com.xuzy.hotel.getorderstatistics.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.getorderstatistics.entity.CvcGetOrderStatisticsEntity;

/**
 * 描述：抓单表
 * @author：www.jeecg.org
 * @since：2018年11月10日 17时34分59秒 星期六 
 * @version:1.0
 */
@Repository
public interface CvcGetOrderStatisticsDao{
    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_get_order_statistics WHERE ID = :id")
	CvcGetOrderStatisticsEntity get(@Param("id") String id);
	
	/**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_get_order_statistics WHERE unified_batch_no = :BatchNo")
	CvcGetOrderStatisticsEntity getByBatchNo(@Param("BatchNo") String BatchNo);
	
	/**
	 * 修改数据
	 * @param cvcGetOrderStatistics
	 * @return
	 */
	int update(@Param("cvcGetOrderStatistics") CvcGetOrderStatisticsEntity cvcGetOrderStatistics);
	
	
	/**
	 * 添加一条发货记录
	 * @param cvcGetOrderStatistics
	 * @return
	 */
	@Sql("UPDATE cvc_get_order_statistics SET offharbour_count=offharbour_count+1 WHERE batch_no=:batchNo")
	void addOffharbourCount(@Param("batchNo")String batchNo);
	
	@Sql("UPDATE cvc_get_order_statistics SET exception_count=exception_count+1 WHERE batch_no=:batchNo")
	void addExceptionCount(@Param("batchNo")String batchNo);
	
	/**
	 * 添加一条发货记录
	 * @param cvcGetOrderStatistics
	 * @return
	 */
	@Sql("UPDATE cvc_get_order_statistics SET order_count=order_count+:orderCount,add_time=addTime WHERE unified_batch_no=:batchNo")
	void addOrderCount(@Param("orderCount")int  orderCount,@Param("batchNo")String batchNo,@Param("addTime")String addTime);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcGetOrderStatistics") CvcGetOrderStatisticsEntity cvcGetOrderStatistics);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcGetOrderStatistics
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcGetOrderStatisticsEntity.class)
	public MiniDaoPage<CvcGetOrderStatisticsEntity> getAll(@Param("cvcGetOrderStatistics") CvcGetOrderStatisticsEntity cvcGetOrderStatistics,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_get_order_statistics WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_get_order_statistics WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	 
	 public int getCount(@Param("cvcGetOrderStatistics") CvcGetOrderStatisticsEntity cvcGetOrderStatistics,@Param("page")   int page,@Param("rows")  int rows);
	
	 
	/**
	 * 添加抓单成功订单
	 * @param orderCount
	 * @param batchNo
	 * @param addTime
	 * @return
	 */
	@Sql("UPDATE cvc_get_order_statistics SET wait_delivery_count=wait_delivery_count+:orderCount WHERE unified_batch_no=:batchNo")
	int addwaitDeliveryCount(@Param("orderCount")int  orderCount,@Param("batchNo")String batchNo);
}

