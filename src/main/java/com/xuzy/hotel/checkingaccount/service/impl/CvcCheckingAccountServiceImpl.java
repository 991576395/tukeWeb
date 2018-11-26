package com.xuzy.hotel.checkingaccount.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xuzy.hotel.checkingaccount.dao.CvcCheckingAccountDao;
import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;
import com.xuzy.hotel.checkingaccount.service.CvcCheckingAccountService;
import com.xuzy.hotel.checkingaccountorder.dao.CvcCheckingAccountOrderDao;
import com.xuzy.hotel.checkingaccountorder.entity.CvcCheckingAccountOrderEntity;
import com.xuzy.hotel.order.dao.CvcOrderInfoDao;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.ordergoods.dao.CvcOrderGoodsDao;
import com.xuzy.hotel.ordergoods.entity.CvcOrderGoodsEntity;

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
	
	@Resource
	private CvcOrderInfoDao cvcOrderInfoDao;
	
	@Resource
	private CvcCheckingAccountOrderDao cvcCheckingAccountOrderDao;
	
	@Resource
	private CvcOrderGoodsDao cvcOrderGoodsDao;

	@Override
	public CvcCheckingAccountEntity get(String id) {
		return cvcCheckingAccountDao.get(id);
	}

	@Override
	public int update(CvcCheckingAccountEntity cvcCheckingAccount) {
		return cvcCheckingAccountDao.update(cvcCheckingAccount);
	}

	@Override
	@Transactional
	public void insert(CvcCheckingAccountEntity cvcCheckingAccount,int CheckAccountInfoID, List<CvcOrderInfoEntity> cvcOrderInfoEntities) {
		cvcCheckingAccountDao.insert(cvcCheckingAccount);
		for(CvcOrderInfoEntity cvcOrderInfoEntity:cvcOrderInfoEntities) {
			CvcOrderGoodsEntity cvcOrderGoodsEntity = cvcOrderGoodsDao.getOrderGood(cvcOrderInfoEntity.getId()+"");
			CvcCheckingAccountOrderEntity cvcCheckingAccountOrder = new CvcCheckingAccountOrderEntity();
			cvcCheckingAccountOrder.setCheckingAccountId(CheckAccountInfoID);
			cvcCheckingAccountOrder.setOrderId(cvcOrderInfoEntity.getId());
			cvcCheckingAccountOrder.setInvoiceNo(cvcOrderInfoEntity.getInvoiceNo());
			cvcCheckingAccountOrder.setShippingName(cvcOrderInfoEntity.getShippingName());
			if(cvcOrderGoodsEntity != null) {
				cvcCheckingAccountOrder.setGoodsSn(cvcOrderGoodsEntity.getGoodsSn());
				cvcCheckingAccountOrder.setGoodsNumber(cvcOrderGoodsEntity.getGoodsNumber());
			}
			cvcCheckingAccountOrder.setIsAddCheckingAccount(0);
			cvcCheckingAccountOrder.setAddress(cvcOrderInfoEntity.getAddress());
			cvcCheckingAccountOrder.setConsignee(cvcOrderInfoEntity.getConsignee());
			cvcCheckingAccountOrder.setMobile(cvcOrderInfoEntity.getMobile());
			cvcCheckingAccountOrder.setSigninDate(cvcOrderInfoEntity.getSigninDate());
			cvcCheckingAccountOrderDao.insert(cvcCheckingAccountOrder);
		}
	}

	@Override
	public MiniDaoPage<CvcCheckingAccountEntity> getAll(CvcCheckingAccountEntity cvcCheckingAccount, int page, int rows) {
		return cvcCheckingAccountDao.getAll(cvcCheckingAccount, page, rows);
	}

	@Override
	@Transactional
	public void delete(String id) {
		//删除对账表头
		cvcCheckingAccountDao.delete(id);
		//删除所属订单
		cvcCheckingAccountOrderDao.deleteByCheckingAccountId(id);
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

	@Override
	public void update(CvcCheckingAccountEntity cvcCheckingAccount, Integer checkAccountInfoID,
			List<CvcOrderInfoEntity> cvcOrderInfoEntities) {
		for(CvcOrderInfoEntity cvcOrderInfoEntity:cvcOrderInfoEntities) {
			CvcCheckingAccountOrderEntity cvcCheckingAccountOrderEntity = cvcCheckingAccountOrderDao.get(checkAccountInfoID,cvcOrderInfoEntity.getId());
			if(cvcCheckingAccountOrderEntity != null) {
				continue;
			}
			CvcOrderGoodsEntity cvcOrderGoodsEntity = cvcOrderGoodsDao.getOrderGood(cvcOrderInfoEntity.getId()+"");
			CvcCheckingAccountOrderEntity cvcCheckingAccountOrder = new CvcCheckingAccountOrderEntity();
			cvcCheckingAccountOrder.setCheckingAccountId(checkAccountInfoID);
			cvcCheckingAccountOrder.setOrderId(cvcOrderInfoEntity.getId());
			cvcCheckingAccountOrder.setInvoiceNo(cvcOrderInfoEntity.getInvoiceNo());
			cvcCheckingAccountOrder.setShippingName(cvcOrderInfoEntity.getShippingName());
			if(cvcOrderGoodsEntity != null) {
				cvcCheckingAccountOrder.setGoodsSn(cvcOrderGoodsEntity.getGoodsSn());
				cvcCheckingAccountOrder.setGoodsNumber(cvcOrderGoodsEntity.getGoodsNumber());
			}
			cvcCheckingAccountOrder.setIsAddCheckingAccount(0);
			cvcCheckingAccountOrder.setAddress(cvcOrderInfoEntity.getAddress());
			cvcCheckingAccountOrder.setConsignee(cvcOrderInfoEntity.getConsignee());
			cvcCheckingAccountOrder.setMobile(cvcOrderInfoEntity.getMobile());
			cvcCheckingAccountOrder.setSigninDate(cvcOrderInfoEntity.getSigninDate());
			cvcCheckingAccountOrderDao.insert(cvcCheckingAccountOrder);
		}
	}

	@Override
	@Transactional
	public int makeBalance(CvcCheckingAccountEntity cvcCheckingAccount) {
		int count = 0;
		List<CvcCheckingAccountOrderEntity> cvcCheckingAccountOrderEntities = cvcCheckingAccountOrderDao.getOrders(cvcCheckingAccount.getCheckingAccountId());
		if(CollectionUtils.isNotEmpty(cvcCheckingAccountOrderEntities)) {
			for (CvcCheckingAccountOrderEntity cvcCheckingAccountOrderEntity : cvcCheckingAccountOrderEntities) {
				int res = cvcOrderInfoDao.updateIsBalance(cvcCheckingAccountOrderEntity.getOrderId());
				if(res > 0) {
					count++;
				}
			}
			cvcCheckingAccount.setIsBalance(1);
			cvcCheckingAccountDao.update(cvcCheckingAccount);
		}
		return count;
	}
}
