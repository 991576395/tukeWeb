package com.xuzy.hotel.checkingaccount.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.checkingaccount.dao.CvcCheckingAccountDao;
import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;
import com.xuzy.hotel.checkingaccount.service.CvcCheckingAccountService;

/**
 * 描述：对账表
 * @author: www.jeecg.org
 * @since：2018年11月14日 19时44分59秒 星期三 
 * @version:1.0
 */

@Service("cvcCheckingAccountService")
public class CvcCheckingAccountServiceImpl implements CvcCheckingAccountService {
	@Resource
	private CvcCheckingAccountDao cvcCheckingAccountDao;

	@Override
	public CvcCheckingAccountEntity get(String id) {
		return cvcCheckingAccountDao.get(id);
	}

	@Override
	public int update(CvcCheckingAccountEntity cvcCheckingAccount) {
		return cvcCheckingAccountDao.update(cvcCheckingAccount);
	}

	@Override
	public void insert(CvcCheckingAccountEntity cvcCheckingAccount) {
		cvcCheckingAccountDao.insert(cvcCheckingAccount);
	}

	@Override
	public MiniDaoPage<CvcCheckingAccountEntity> getAll(CvcCheckingAccountEntity cvcCheckingAccount, int page, int rows) {
		return cvcCheckingAccountDao.getAll(cvcCheckingAccount, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcCheckingAccountDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcCheckingAccountDao.deleteById(id);
		}
	}

	@Override
	public int getCount(CvcCheckingAccountEntity cvcCheckingAccount) {
		return cvcCheckingAccountDao.getCount(cvcCheckingAccount);
	}
}
