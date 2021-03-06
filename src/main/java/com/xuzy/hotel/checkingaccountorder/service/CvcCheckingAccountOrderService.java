package com.xuzy.hotel.checkingaccountorder.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.checkingaccountorder.entity.CvcCheckingAccountOrderEntity;

/**
 * 描述：对账订单表
 * @author: www.jeecg.org
 * @since：2018年11月15日 21时28分02秒 星期四 
 * @version:1.0
 */
public interface CvcCheckingAccountOrderService {
	
	CvcCheckingAccountOrderEntity get(int checkingAccountId,int orderId);
	CvcCheckingAccountOrderEntity getById(int id);

	public int update(CvcCheckingAccountOrderEntity cvcCheckingAccountOrder);

	public void insert(CvcCheckingAccountOrderEntity cvcCheckingAccountOrder);

	public MiniDaoPage<CvcCheckingAccountOrderEntity> getAll(CvcCheckingAccountOrderEntity cvcCheckingAccountOrder,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);

	public int getCount(CvcCheckingAccountOrderEntity query);
	
	public void updateAddCheckingAccount( int checkingAccountId
			,int orderId,long time);
	
	public List<CvcCheckingAccountOrderEntity> getOrders(int checkingAccountId);
	
	public void deleteByCheckingAccountId(String id);
}
