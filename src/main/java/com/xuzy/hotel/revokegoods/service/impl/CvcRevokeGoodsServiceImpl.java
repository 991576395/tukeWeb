package com.xuzy.hotel.revokegoods.service.impl;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.revokegoods.dao.CvcRevokeGoodsDao;
import com.xuzy.hotel.revokegoods.entity.CvcRevokeGoodsEntity;
import com.xuzy.hotel.revokegoods.service.CvcRevokeGoodsService;

/**
 * 描述：撤销商品表
 * @author: www.jeecg.org
 * @since：2018年11月03日 22时15分53秒 星期六 
 * @version:1.0
 */

@Service("cvcRevokeGoodsService")
public class CvcRevokeGoodsServiceImpl implements CvcRevokeGoodsService {
	@Resource
	private CvcRevokeGoodsDao cvcRevokeGoodsDao;

	@Override
	public CvcRevokeGoodsEntity get(String id) {
		return cvcRevokeGoodsDao.get(id);
	}

	@Override
	public int update(CvcRevokeGoodsEntity cvcRevokeGoods) {
		return cvcRevokeGoodsDao.update(cvcRevokeGoods);
	}

	@Override
	public void insert(CvcRevokeGoodsEntity cvcRevokeGoods) {
		cvcRevokeGoodsDao.insert(cvcRevokeGoods);
		
	}

	@Override
	public MiniDaoPage<CvcRevokeGoodsEntity> getAll(CvcRevokeGoodsEntity cvcRevokeGoods, int page, int rows) {
		return cvcRevokeGoodsDao.getAll(cvcRevokeGoods, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcRevokeGoodsDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcRevokeGoodsDao.deleteById(id);
		}
	}

	@Override
	public List<CvcRevokeGoodsEntity> getByOrderId(int orderId) {
		List<CvcRevokeGoodsEntity> cvcRevokeGoodsEntities = cvcRevokeGoodsDao.getByOrderId(orderId);
		if(CollectionUtils.isNotEmpty(cvcRevokeGoodsEntities)) {
			for (CvcRevokeGoodsEntity cvcRevokeGoodsEntity : cvcRevokeGoodsEntities) {
				cvcRevokeGoodsEntity.setTotal(cvcRevokeGoodsEntity.getGoodsPrice().multiply(new BigDecimal(cvcRevokeGoodsEntity.getNumber())));
			}
		}
		return cvcRevokeGoodsEntities;
	}
}
