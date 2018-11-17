package com.xuzy.hotel.getorderstatistics.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.xuzy.hotel.getorderstatistics.entity.CvcGetOrderStatisticsEntity;
import com.xuzy.hotel.ylrequest.module.order.ExchangeOrder;

/**
 * 描述：抓单表
 * @author: www.jeecg.org
 * @since：2018年11月10日 17时34分59秒 星期六 
 * @version:1.0
 */
public interface CvcGetOrderStatisticsService {
	public CvcGetOrderStatisticsEntity get(String id);

	public int update(CvcGetOrderStatisticsEntity cvcGetOrderStatistics);

	public void insert(CvcGetOrderStatisticsEntity cvcGetOrderStatistics);

	public MiniDaoPage<CvcGetOrderStatisticsEntity> getAll(CvcGetOrderStatisticsEntity cvcGetOrderStatistics,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
	public int addOffharbourCount(String batchNo);

	public int getCount(CvcGetOrderStatisticsEntity query, int page, int rows);
	
	/**
	 * 添加或者更新抓取订单
	 */
	public CvcGetOrderStatisticsEntity addOrUpdateOrder(List<ExchangeOrder> exchangeOrders);
	
	public int addwaitDeliveryCount(int  orderCount,String batchNo);
}
