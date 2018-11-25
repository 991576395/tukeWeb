package com.xuzy.hotel.deliverygoods.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.deliverygoods.dao.CvcDeliveryGoodsDao;
import com.xuzy.hotel.deliverygoods.entity.CvcDeliveryGoodsEntity;
import com.xuzy.hotel.deliverygoods.service.CvcDeliveryGoodsService;

/**
 * 描述：发货商品表
 * @author: www.jeecg.org
 * @since：2018年11月25日 17时11分43秒 星期日 
 * @version:1.0
 */

@Service("cvcDeliveryGoodsService")
public class CvcDeliveryGoodsServiceImpl implements CvcDeliveryGoodsService {
	@Resource
	private CvcDeliveryGoodsDao cvcDeliveryGoodsDao;

	@Override
	public CvcDeliveryGoodsEntity get(String id) {
		return cvcDeliveryGoodsDao.get(id);
	}

	@Override
	public int update(CvcDeliveryGoodsEntity cvcDeliveryGoods) {
		return cvcDeliveryGoodsDao.update(cvcDeliveryGoods);
	}

	@Override
	public void insert(CvcDeliveryGoodsEntity cvcDeliveryGoods) {
		cvcDeliveryGoodsDao.insert(cvcDeliveryGoods);
		
	}

	@Override
	public MiniDaoPage<CvcDeliveryGoodsEntity> getAll(CvcDeliveryGoodsEntity cvcDeliveryGoods, int page, int rows) {
		return cvcDeliveryGoodsDao.getAll(cvcDeliveryGoods, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcDeliveryGoodsDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcDeliveryGoodsDao.deleteById(id);
		}
	}
}
