package com.xuzy.hotel.checkingaccountorder.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.checkingaccountorder.dao.CvcCheckingAccountOrderDao;
import com.xuzy.hotel.checkingaccountorder.entity.CvcCheckingAccountOrderEntity;
import com.xuzy.hotel.checkingaccountorder.service.CvcCheckingAccountOrderService;

/**
 * 描述：对账订单表
 * @author: www.jeecg.org
 * @since：2018年11月15日 21时28分02秒 星期四 
 * @version:1.0
 */

@Service("cvcCheckingAccountOrderService")
public class CvcCheckingAccountOrderServiceImpl implements CvcCheckingAccountOrderService {
	@Resource
	private CvcCheckingAccountOrderDao cvcCheckingAccountOrderDao;

	@Override
	public CvcCheckingAccountOrderEntity get(String id) {
		return cvcCheckingAccountOrderDao.get(id);
	}

	@Override
	public int update(CvcCheckingAccountOrderEntity cvcCheckingAccountOrder) {
		return cvcCheckingAccountOrderDao.update(cvcCheckingAccountOrder);
	}

	@Override
	public void insert(CvcCheckingAccountOrderEntity cvcCheckingAccountOrder) {
		cvcCheckingAccountOrderDao.insert(cvcCheckingAccountOrder);
	}

	@Override
	public MiniDaoPage<CvcCheckingAccountOrderEntity> getAll(CvcCheckingAccountOrderEntity cvcCheckingAccountOrder, int page, int rows) {
		return cvcCheckingAccountOrderDao.getAll(cvcCheckingAccountOrder, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcCheckingAccountOrderDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcCheckingAccountOrderDao.deleteById(id);
		}
	}
}
