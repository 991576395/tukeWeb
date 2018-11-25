package com.xuzy.hotel.shipping.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.shipping.dao.CvcShippingDao;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;
import com.xuzy.hotel.shipping.service.CvcShippingService;

/**
 * 描述：物流表
 * @author: www.jeecg.org
 * @since：2018年10月28日 14时36分19秒 星期日 
 * @version:1.0
 */

@Service("cvcShippingService")
public class CvcShippingServiceImpl implements CvcShippingService {
	@Resource
	private CvcShippingDao cvcShippingDao;

	@Override
	public CvcShippingEntity get(String id) {
		return cvcShippingDao.get(id);
	}

	@Override
	public int update(CvcShippingEntity cvcShipping) {
		return cvcShippingDao.update(cvcShipping);
	}

	@Override
	public void insert(CvcShippingEntity cvcShipping) {
//		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
//		cvcShipping.setId(randomSeed);
		cvcShippingDao.insert(cvcShipping);
	}

	@Override
	public MiniDaoPage<CvcShippingEntity> getAll(CvcShippingEntity cvcShipping, int page, int rows) {
		return cvcShippingDao.getAll(cvcShipping, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcShippingDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcShippingDao.deleteById(id);
		}
	}
}
