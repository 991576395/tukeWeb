package com.xuzy.hotel.orderaction.service;

import java.util.List;

import org.jeecgframework.minidao.pojo.MiniDaoPage;

import com.xuzy.hotel.orderaction.entity.CvcOrderActionEntity;

/**
 * 描述：操作表
 * @author: www.jeecg.org
 * @since：2018年11月03日 22时39分29秒 星期六 
 * @version:1.0
 */
public interface CvcOrderActionService {
	public CvcOrderActionEntity get(String id);

	public int update(CvcOrderActionEntity cvcOrderAction);

	public void insert(CvcOrderActionEntity cvcOrderAction);

	public MiniDaoPage<CvcOrderActionEntity> getAll(CvcOrderActionEntity cvcOrderAction,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
	public List<CvcOrderActionEntity> getNewByOrderId(int orderId);
}
