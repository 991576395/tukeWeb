package com.xuzy.hotel.checkingaccountorder.service.impl;

import javax.annotation.Resource;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
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
		MiniDaoPage<CvcCheckingAccountOrderEntity>  entitys = cvcCheckingAccountOrderDao.getAll(cvcCheckingAccountOrder, page, rows);
		if(CollectionUtils.isNotEmpty(entitys.getResults())) {
			for(CvcCheckingAccountOrderEntity accountOrderEntity:entitys.getResults()) {
				if(accountOrderEntity.getIsAddCheckingAccount() != null && accountOrderEntity.getIsAddCheckingAccount() == 1) {
					accountOrderEntity.setStatueName("上传成功");
				}else if(accountOrderEntity.getAddCheckingAccountTime() != 0) {
					accountOrderEntity.setStatueName("上传失败");
				}else {
					accountOrderEntity.setStatueName("未上传");
				}
				
				accountOrderEntity.setAddCheckingAccountTimeFormat(DateFormatUtils.format(Long.parseLong(accountOrderEntity.getAddCheckingAccountTime()+"000"), "yyyy-MM-dd HH:mm:ss"));
			}
		}
		return entitys;
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

	@Override
	public int getCount(CvcCheckingAccountOrderEntity query) {
		return cvcCheckingAccountOrderDao.getCount(query);
	}
}