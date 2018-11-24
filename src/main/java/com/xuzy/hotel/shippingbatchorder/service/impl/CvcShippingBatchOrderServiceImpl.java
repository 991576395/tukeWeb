package com.xuzy.hotel.shippingbatchorder.service.impl;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.util.PhpDateUtils;
import com.xuzy.hotel.order.dao.CvcOrderInfoDao;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.shippingbatch.dao.CvcShippingBatchDao;
import com.xuzy.hotel.shippingbatch.entity.CvcShippingBatchEntity;
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
	
	@Resource
	private CvcOrderInfoDao cvcOrderInfoDao;
	
	@Resource
	private CvcShippingBatchDao cvcShippingBatchDao;

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

	@Override
	public int getCount(CvcShippingBatchOrderEntity cvcShippingBatchOrder) {
		return cvcShippingBatchOrderDao.getCount(cvcShippingBatchOrder);
	}

	@Override
	public CvcShippingBatchOrderEntity getEntityByInvoiceNo(String invoiceNo) {
		return cvcShippingBatchOrderDao.getEntityByInvoiceNo(invoiceNo);
	}

	@Override
	public void updateBatchOrderStatus(int status, long shippingTime, int orderId, String batchNo) {
		cvcShippingBatchOrderDao.updateBatchOrderStatus(status, shippingTime, orderId, batchNo);
	}

	@Override
	public void deleteBybatchNo(String batchNo) {
		cvcShippingBatchOrderDao.deleteBybatchNo(batchNo);
	}

	@Override
	public List<CvcShippingBatchOrderEntity> getEntitysByBatchNo(String batchNo,int orderId) {
		return cvcShippingBatchOrderDao.getEntitysByBatchNo(batchNo);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void batchInsert(List<CvcShippingBatchOrderEntity> batchOrderEntities, String orderBatchNo) {
		int size = 0;
		String batchNo = DateFormatUtils.format(Calendar.getInstance(), "yyyyMMddHHmmss");
		List<Integer> notInOrders = new ArrayList<>(); 
		for (CvcShippingBatchOrderEntity cvcShippingBatchOrderEntity : batchOrderEntities) {
			if(StringUtils.isEmpty(cvcShippingBatchOrderEntity.getOrderId()) || 
					StringUtils.isEmpty(cvcShippingBatchOrderEntity.getShippingName())) {
				//不存在
				continue;
			}
			//
			CvcOrderInfoEntity orderInfoEntity = cvcOrderInfoDao.getOnlyEntity(Integer.parseInt(cvcShippingBatchOrderEntity.getOrderId()));
			int is_order_batch_no_ok = orderInfoEntity != null ? 1:0;
			cvcShippingBatchOrderEntity.setIsOrderBatchNoOk(is_order_batch_no_ok);
			cvcShippingBatchOrderEntity.setAddTime(PhpDateUtils.getTime()+"");
			cvcShippingBatchOrderEntity.setShippingTime(0);
			cvcShippingBatchOrderEntity.setIsOffharbour(0);
			cvcShippingBatchOrderEntity.setIsPostorder(0);
			cvcShippingBatchOrderEntity.setStatus(0);
			cvcShippingBatchOrderEntity.setIsOrderBatchNoOk(0);
			cvcShippingBatchOrderEntity.setBatchNo(batchNo);
			cvcShippingBatchOrderEntity.setOrderBatchNo(orderBatchNo);
			cvcShippingBatchOrderDao.insert(cvcShippingBatchOrderEntity);
			
			if(orderInfoEntity != null && orderInfoEntity.getTkOrderStatus() != 2) {
				notInOrders.add(orderInfoEntity.getId());
			}
			size++;
		}
		
		if(CollectionUtils.isEmpty(notInOrders)) {
			int shipping_batch = 0;
			CvcShippingBatchEntity cvcShippingBatchEntity = new CvcShippingBatchEntity();
			cvcShippingBatchEntity.setBatchNo(batchNo);
			cvcShippingBatchEntity.setShippingCountOk(0);
			cvcShippingBatchEntity.setOrderBatchNo(orderBatchNo);
			cvcShippingBatchEntity.setShippingCount(size);
			cvcShippingBatchEntity.setAddTime((int)PhpDateUtils.getTime());
			
			List<CvcShippingBatchOrderEntity> batchOrderEntitiesList = cvcShippingBatchOrderDao.getEntitysByBatchNo(orderBatchNo);
			if(CollectionUtils.isNotEmpty(batchOrderEntitiesList)) {
				for (CvcShippingBatchOrderEntity cvcShippingBatchOrderEntity : batchOrderEntitiesList) {
					CvcOrderInfoEntity cvcOrderInfoEntity = cvcOrderInfoDao.getEntity(cvcShippingBatchOrderEntity.getId(), orderBatchNo);
					if(cvcOrderInfoEntity == null) {
						shipping_batch = 1;
						break;
					}
				}
			}
			cvcShippingBatchEntity.setMsgStatus(shipping_batch);
			cvcShippingBatchDao.insert(cvcShippingBatchEntity);
		}else {
			//删除批次订单
			cvcShippingBatchOrderDao.deleteBybatchNo(orderBatchNo);
		}
	}
}
