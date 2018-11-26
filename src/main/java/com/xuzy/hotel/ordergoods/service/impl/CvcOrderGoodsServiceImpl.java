package com.xuzy.hotel.ordergoods.service.impl;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.ordergoods.dao.CvcOrderGoodsDao;
import com.xuzy.hotel.ordergoods.entity.CvcOrderGoodsEntity;
import com.xuzy.hotel.ordergoods.service.CvcOrderGoodsService;

/**
 * 描述：订单商品表
 * @author: www.jeecg.org
 * @since：2018年11月25日 17时10分02秒 星期日 
 * @version:1.0
 */

@Service("cvcOrderGoodsService")
public class CvcOrderGoodsServiceImpl implements CvcOrderGoodsService {
	@Resource
	private CvcOrderGoodsDao cvcOrderGoodsDao;

	@Override
	public CvcOrderGoodsEntity get(String id) {
		return cvcOrderGoodsDao.getOrderGood(id);
	}

	@Override
	public int update(CvcOrderGoodsEntity cvcOrderGoods) {
		return cvcOrderGoodsDao.update(cvcOrderGoods);
	}

	@Override
	public void insert(CvcOrderGoodsEntity cvcOrderGoods) {
		cvcOrderGoodsDao.insert(cvcOrderGoods);
		
	}

	@Override
	public MiniDaoPage<CvcOrderGoodsEntity> getAll(CvcOrderGoodsEntity cvcOrderGoods, int page, int rows) {
		return cvcOrderGoodsDao.getAll(cvcOrderGoods, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcOrderGoodsDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcOrderGoodsDao.deleteById(id);
		}
	}
	
	@Override
	public List<CvcOrderGoodsEntity> getAll(int orderId) {
		List<CvcOrderGoodsEntity> cvcOrderGoodsEntities = cvcOrderGoodsDao.getGoods(orderId);
		if(CollectionUtils.isNotEmpty(cvcOrderGoodsEntities)) {
			for(CvcOrderGoodsEntity entity:cvcOrderGoodsEntities) {
				entity.setFormatedSubtotal(entity.getGoodsPrice().multiply(new BigDecimal(entity.getGoodsNumber())));
			}
		}
		return cvcOrderGoodsEntities;
	}
}
