package com.xuzy.hotel.order.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateFormatUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.order.dao.CvcOrderInfoDao;
import com.xuzy.hotel.order.entity.CvcDeliveryGoodsEntity;
import com.xuzy.hotel.order.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.service.CvcOrderInfoService;

/**
 * 描述：订单表
 * @author: www.jeecg.org
 * @since：2018年10月28日 18时23分43秒 星期日 
 * @version:1.0
 */

@Service("cvcOrderInfoService")
public class CvcOrderInfoServiceImpl implements CvcOrderInfoService {
	@Resource
	private CvcOrderInfoDao cvcOrderInfoDao;
	

	@Override
	public CvcOrderInfoEntity get(int id) {
		return cvcOrderInfoDao.get(id);
	}

	@Override
	public int update(CvcOrderInfoEntity cvcOrderInfo) {
		return cvcOrderInfoDao.update(cvcOrderInfo);
	}

	@Override
	public void insert(CvcOrderInfoEntity cvcOrderInfo) {
		cvcOrderInfoDao.insert(cvcOrderInfo);
		
	}

	@Override
	public MiniDaoPage<CvcOrderInfoEntity> getAll(CvcOrderInfoEntity cvcOrderInfo, int page, int rows) {
		return cvcOrderInfoDao.getAll(cvcOrderInfo, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcOrderInfoDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcOrderInfoDao.deleteById(id);
		}
	}

	@Override
	public int getCount(CvcOrderInfoEntity cvcOrderInfo, int page, int rows) {
		// TODO Auto-generated method stub
		return cvcOrderInfoDao.getCount(cvcOrderInfo);
	}

	@Override
	public CvcOrderInfoEntity getOrder(CvcOrderInfoEntity cvcOrderInfo) {
		CvcOrderInfoEntity cvcOrderInfoEntity = cvcOrderInfoDao.getOrder(cvcOrderInfo);
		if (cvcOrderInfoEntity != null) {
			cvcOrderInfoEntity.setOldAddTime(cvcOrderInfoEntity.getAddTime());
			// 格式化时间
			cvcOrderInfoEntity.setAddTime(DateFormatUtils
					.format(Long.parseLong(cvcOrderInfoEntity.getAddTime() + "000"), "yyyy-MM-dd HH:mm:ss"));
			cvcOrderInfoEntity.setGetTime(DateFormatUtils
					.format(Long.parseLong(cvcOrderInfoEntity.getGetTime() + "000"), "yyyy-MM-dd HH:mm:ss"));
		}
		return cvcOrderInfoEntity;
	}

	@Override
	public CvcDeliveryOrderEntity getDeliveryOrderByOrderId(int orderId) {
		CvcDeliveryOrderEntity deliveryOrder = cvcOrderInfoDao.getDeliveryOrderByOrderId(orderId);
		if(deliveryOrder != null) {
			deliveryOrder.setActionUser(cvcOrderInfoDao.getActionUserByOrderId(orderId));
			
			deliveryOrder.setAddTimeString(DateFormatUtils.format(new Timestamp(Long.parseLong(deliveryOrder.getAddTime()+"000")), "yyyy-MM-dd HH:mm:ss"));
		}
		return deliveryOrder;
	}

	@Override
	public CvcDeliveryInfoEntity getDeliveryInfosByInvoiceNo(String invoiceNo) {
		return cvcOrderInfoDao.getAll(invoiceNo);
	}

	@Override
	public void updateHandle(int orderId, int handleStatus, int handleTime, String handleUser) {
		cvcOrderInfoDao.updateHandle(orderId, handleStatus, handleTime, handleUser);
	}
	
	
	@Override
	public void insert(CvcDeliveryGoodsEntity cvcDeliveryGoods) {
		cvcOrderInfoDao.insert(cvcDeliveryGoods);
	}

	@Override
	public List<CvcOrderInfoEntity> getCanReadOrders(String batchNo) {
		return cvcOrderInfoDao.getCanReadOrders(batchNo);
	}

	@Override
	public MiniDaoPage<CvcOrderInfoEntity> getExceptionOrderListAll(CvcOrderInfoEntity cvcOrderInfo, int page,
			int rows) {
		return cvcOrderInfoDao.getExceptionOrderListAll(cvcOrderInfo, page, rows);
	}

	@Override
	public int getExceptionOrderCount(CvcOrderInfoEntity query) {
		return cvcOrderInfoDao.getExceptionOrderCount(query);
	}

	@Override
	public List<CvcOrderInfoEntity> getAccountOrderList(String userName, String startTime, String endTime) {
		return cvcOrderInfoDao.getAccountOrders(userName, startTime, endTime);
	}

	@Override
	public void updateStatusByOrderId(int orderId, int status) {
		cvcOrderInfoDao.updateStatusByOrderId(orderId, status);
	}
}
