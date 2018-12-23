package com.xuzy.hotel.shippingbatch.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xuzy.hotel.shippingbatch.dao.CvcShippingBatchDao;
import com.xuzy.hotel.shippingbatch.entity.CvcShippingBatchEntity;
import com.xuzy.hotel.shippingbatch.service.CvcShippingBatchService;
import com.xuzy.hotel.shippingbatchorder.dao.CvcShippingBatchOrderDao;

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
	
	@Resource
	private CvcShippingBatchOrderDao cvcShippingBatchOrderDao;

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
		cvcShippingBatchDao.insert(cvcShippingBatch);
		
	}

	@Override
	public MiniDaoPage<CvcShippingBatchEntity> getAll(CvcShippingBatchEntity cvcShippingBatch, int page, int rows) {
		return cvcShippingBatchDao.getAll(cvcShippingBatch, page, rows);
	}

	@Override
	@Transactional
	public void delete(String batchNo) {
		cvcShippingBatchDao.delete(batchNo);
		cvcShippingBatchOrderDao.deleteBybatchNo(batchNo);
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcShippingBatchDao.deleteById(id);
		}
	}

	@Override
	public int getCount(CvcShippingBatchEntity cvcShippingBatch) {
		return cvcShippingBatchDao.getCount(cvcShippingBatch);
	}

	@Override
	public void addSucSizeCount(String batchNo, int sucSize) {
		cvcShippingBatchDao.addSucSizeCount(batchNo, sucSize);
	}
}
