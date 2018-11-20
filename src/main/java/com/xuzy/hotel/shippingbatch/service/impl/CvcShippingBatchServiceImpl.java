package com.xuzy.hotel.shippingbatch.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.shippingbatch.dao.CvcShippingBatchDao;
import com.xuzy.hotel.shippingbatch.entity.CvcShippingBatchEntity;
import com.xuzy.hotel.shippingbatch.service.CvcShippingBatchService;

/**
 * 描述：批量发货表
 * @author: www.jeecg.org
 * @since：2018年11月20日 20时41分17秒 星期二 
 * @version:1.0
 */

@Service("cvcShippingBatchService")
public class CvcShippingBatchServiceImpl implements CvcShippingBatchService {
	@Resource
	private CvcShippingBatchDao cvcShippingBatchDao;

	@Override
	public CvcShippingBatchEntity get(String id) {
		return cvcShippingBatchDao.get(id);
	}

	@Override
	public int update(CvcShippingBatchEntity cvcShippingBatch) {
		return cvcShippingBatchDao.update(cvcShippingBatch);
	}

	@Override
	public void insert(CvcShippingBatchEntity cvcShippingBatch) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		cvcShippingBatch.setId(randomSeed);
		cvcShippingBatchDao.insert(cvcShippingBatch);
		
	}

	@Override
	public MiniDaoPage<CvcShippingBatchEntity> getAll(CvcShippingBatchEntity cvcShippingBatch, int page, int rows) {
		return cvcShippingBatchDao.getAll(cvcShippingBatch, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcShippingBatchDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcShippingBatchDao.deleteById(id);
		}
	}
}
