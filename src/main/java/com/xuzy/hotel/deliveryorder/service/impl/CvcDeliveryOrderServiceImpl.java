package com.xuzy.hotel.deliveryorder.service.impl;

import javax.annotation.Resource;

import java.util.List;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.deliveryorder.dao.CvcDeliveryOrderDao;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.deliveryorder.service.CvcDeliveryOrderService;

/**
 * 描述：物流信息表
 * @author: www.jeecg.org
 * @since：2018年11月04日 09时59分48秒 星期日 
 * @version:1.0
 */

@Service("cvcDeliveryOrderService")
public class CvcDeliveryOrderServiceImpl implements CvcDeliveryOrderService {
	@Resource
	private CvcDeliveryOrderDao cvcDeliveryOrderDao;

	@Override
	public CvcDeliveryOrderEntity get(String id) {
		return cvcDeliveryOrderDao.get(id);
	}

	@Override
	public int update(CvcDeliveryOrderEntity cvcDeliveryOrder) {
		return cvcDeliveryOrderDao.update(cvcDeliveryOrder);
	}

	@Override
	public int insert(CvcDeliveryOrderEntity cvcDeliveryOrder) {
		cvcDeliveryOrderDao.insert(cvcDeliveryOrder);
		return cvcDeliveryOrderDao.getInserId();
	}

	@Override
	public MiniDaoPage<CvcDeliveryOrderEntity> getAll(CvcDeliveryOrderEntity cvcDeliveryOrder, int page, int rows) {
		return cvcDeliveryOrderDao.getAll(cvcDeliveryOrder, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcDeliveryOrderDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcDeliveryOrderDao.deleteById(id);
		}
	}
	
	@Override
	public List<CvcDeliveryOrderEntity> getDeliveryCondition(int orderId) {
		return cvcDeliveryOrderDao.getDeliveryCondition(orderId);
	}

	@Override
	public void updateSigndate(int orderId, String signdate) {
		cvcDeliveryOrderDao.updateSigndate(orderId, signdate);
	}

	@Override
	public void updateNu(int orderId, int shippingId, String shippingName, String invoiceNo) {
		cvcDeliveryOrderDao.updateNu(orderId, shippingId, shippingName, invoiceNo);
	}
}
