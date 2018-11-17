package com.xuzy.hotel.order.service.impl;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.order.dao.CvcOrderInfoDao;
import com.xuzy.hotel.order.entity.CvcOrderGoodsEntity;
import com.xuzy.hotel.order.service.CvcOrderGoodsService;

/**
 * @author: www.jeecg.org
 * @since：2018年11月03日 12时14分09秒 星期六 
 * @version:1.0
 */

@Service("cvcOrderGoodsService")
public class CvcOrderGoodsServiceImpl implements CvcOrderGoodsService {
	@Resource
	private CvcOrderInfoDao cvcOrderInfoDao;
	
	@Override
	public CvcOrderGoodsEntity get(String orderId) {
		return cvcOrderInfoDao.getOrderGood(orderId);
	}

	@Override
	public int update(CvcOrderGoodsEntity cvcOrderGoods) {
		return 0;
	}

	@Override
	public void insert(CvcOrderGoodsEntity cvcOrderGoods) {
		cvcOrderInfoDao.insert(cvcOrderGoods);
	}

	@Override
	public List<CvcOrderGoodsEntity> getAll(int orderId) {
		List<CvcOrderGoodsEntity> cvcOrderGoodsEntities = cvcOrderInfoDao.getGoods(orderId);
		if(CollectionUtils.isNotEmpty(cvcOrderGoodsEntities)) {
			for(CvcOrderGoodsEntity entity:cvcOrderGoodsEntities) {
				entity.setFormatedSubtotal(entity.getGoodsPrice().multiply(new BigDecimal(entity.getGoodsNumber())));
			}
		}
		return cvcOrderGoodsEntities;
	}

}
