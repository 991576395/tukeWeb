package com.xuzy.hotel.shippingbatchorder.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.shippingbatchorder.dao.CvcShippingBatchOrderDao;
import com.xuzy.hotel.shippingbatchorder.entity.CvcShippingBatchOrderEntity;
import com.xuzy.hotel.shippingbatchorder.service.CvcShippingBatchOrderService;

/**
 * 描述：批量发货订单表
 * @author: www.jeecg.org
 * @since：2018年11月21日 20时52分03秒 星期三 
 * @version:1.0
 */

@Service("cvcShippingBatchOrderService")
public class CvcShippingBatchOrderServiceImpl implements CvcShippingBatchOrderService {
	@Resource
	private CvcShippingBatchOrderDao cvcShippingBatchOrderDao;

	@Override
	public CvcShippingBatchOrderEntity get(String id) {
		return cvcShippingBatchOrderDao.get(id);
	}

	@Override
	public int update(CvcShippingBatchOrderEntity cvcShippingBatchOrder) {
		return cvcShippingBatchOrderDao.update(cvcShippingBatchOrder);
	}

	@Override
	public void insert(CvcShippingBatchOrderEntity cvcShippingBatchOrder) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		cvcShippingBatchOrder.setId(randomSeed);
		cvcShippingBatchOrderDao.insert(cvcShippingBatchOrder);
		
	}

	@Override
	public MiniDaoPage<CvcShippingBatchOrderEntity> getAll(CvcShippingBatchOrderEntity cvcShippingBatchOrder, int page, int rows) {
		return cvcShippingBatchOrderDao.getAll(cvcShippingBatchOrder, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcShippingBatchOrderDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcShippingBatchOrderDao.deleteById(id);
		}
	}
}
