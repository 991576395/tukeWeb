package com.xuzy.hotel.checkingaccount.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;

/**
 * 描述：对账表
 * @author: www.jeecg.org
 * @since：2018年11月14日 19时44分59秒 星期三 
 * @version:1.0
 */
public interface CvcCheckingAccountService {
	public CvcCheckingAccountEntity get(String id);

	public int update(CvcCheckingAccountEntity cvcCheckingAccount);

	public void insert(CvcCheckingAccountEntity cvcCheckingAccount);

	public MiniDaoPage<CvcCheckingAccountEntity> getAll(CvcCheckingAccountEntity cvcCheckingAccount,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
	int getCount(CvcCheckingAccountEntity cvcCheckingAccount);
	
}
