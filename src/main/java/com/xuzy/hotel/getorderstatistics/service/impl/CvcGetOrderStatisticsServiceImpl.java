package com.xuzy.hotel.getorderstatistics.service.impl;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.util.PhpDateUtils;
import com.xuzy.hotel.getorderstatistics.dao.CvcGetOrderStatisticsDao;
import com.xuzy.hotel.getorderstatistics.entity.CvcGetOrderStatisticsEntity;
import com.xuzy.hotel.getorderstatistics.service.CvcGetOrderStatisticsService;
import com.xuzy.hotel.order.dao.CvcOrderInfoDao;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.ordergoods.dao.CvcOrderGoodsDao;
import com.xuzy.hotel.ordergoods.entity.CvcOrderGoodsEntity;
import com.xuzy.hotel.ylrequest.module.order.ExchangeOrder;
import com.xuzy.hotel.ylrequest.module.order.ExchangeOrderDetail;

/**
 * 描述：抓单表
 * @author: www.jeecg.org
 * @since：2018年11月10日 17时34分59秒 星期六 
 * @version:1.0
 */

@Service("cvcGetOrderStatisticsService")
public class CvcGetOrderStatisticsServiceImpl implements CvcGetOrderStatisticsService {
	@Resource
	private CvcGetOrderStatisticsDao cvcGetOrderStatisticsDao;
	
	@Resource
	private CvcOrderInfoDao cvcOrderInfoDao;
	
	@Resource
	private CvcOrderGoodsDao cvcOrderGoodsDao;

	@Override
	public CvcGetOrderStatisticsEntity get(String id) {
		return cvcGetOrderStatisticsDao.get(id);
	}

	@Override
	public int update(CvcGetOrderStatisticsEntity cvcGetOrderStatistics) {
		return cvcGetOrderStatisticsDao.update(cvcGetOrderStatistics);
	}

	@Override
	public void insert(CvcGetOrderStatisticsEntity cvcGetOrderStatistics) {
		cvcGetOrderStatisticsDao.insert(cvcGetOrderStatistics);
	}

	@Override
	public MiniDaoPage<CvcGetOrderStatisticsEntity> getAll(CvcGetOrderStatisticsEntity cvcGetOrderStatistics, int page, int rows) {
		return cvcGetOrderStatisticsDao.getAll(cvcGetOrderStatistics, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcGetOrderStatisticsDao.delete(id);
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcGetOrderStatisticsDao.deleteById(id);
		}
	}
	
	public void addOffharbourCount(String batchNo)
	{
		 cvcGetOrderStatisticsDao.addOffharbourCount(batchNo);
	}

	@Override
	public int getCount(CvcGetOrderStatisticsEntity query, int page, int rows) {
		return cvcGetOrderStatisticsDao.getCount(query,page,rows);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public CvcGetOrderStatisticsEntity addOrUpdateOrder(List<ExchangeOrder> exchangeOrders) {
		CvcGetOrderStatisticsEntity cvcGetOrderStatisticsEntity = null;
		String unified_batch_no  = DateFormatUtils.format(Calendar.getInstance(), "yyyyMMdd");
		String batch_no  = DateFormatUtils.format(Calendar.getInstance(), "yyyyMMddHHmmss");
		String add_time = PhpDateUtils.getTime()+"";
		//添加总数
		int orderCount = 0;
		for (ExchangeOrder exchangeOrder : exchangeOrders) {
			CvcOrderInfoEntity cvcOrderInfoEntity = cvcOrderInfoDao.get(exchangeOrder.getID());
			if(cvcOrderInfoEntity == null) {
				System.out.println(exchangeOrder.getID());
				cvcOrderInfoEntity = new CvcOrderInfoEntity();
				cvcOrderInfoEntity.setBatchNo(unified_batch_no);
				cvcOrderInfoEntity.setId(exchangeOrder.getID());
				cvcOrderInfoEntity.setOrderSn(exchangeOrder.getID()+"");
				cvcOrderInfoEntity.setUserId(Integer.parseInt((exchangeOrder.getClientID()+"").trim()));
				cvcOrderInfoEntity.setUserName(exchangeOrder.getAccountType());
				cvcOrderInfoEntity.setTel(exchangeOrder.getTeleNum());
				cvcOrderInfoEntity.setConsignee(exchangeOrder.getConsignee());
				cvcOrderInfoEntity.setAddress(exchangeOrder.getDeliveryAddre());
				cvcOrderInfoEntity.setRemark(exchangeOrder.getAcceptRemark());
				try {
					cvcOrderInfoEntity.setAddTime(""+PhpDateUtils.getTime(DateUtils.parseDate(exchangeOrder.getAcceptDate(),new String[] {"yyyy-MM-dd'T'HH:mm:ss.sss","yyyy-MM-dd'T'HH:mm:ss"})));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					cvcOrderInfoEntity.setConfirmTime(""+PhpDateUtils.getTime(DateUtils.parseDate(exchangeOrder.getConfirmDate(),new String[] {"yyyy-MM-dd'T'HH:mm:ss.sss","yyyy-MM-dd'T'HH:mm:ss"})));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				cvcOrderInfoEntity.setGetTime(PhpDateUtils.getTime()+"");
				cvcOrderInfoDao.insertOrder(cvcOrderInfoEntity);
				for (ExchangeOrderDetail exchangeOrderDetail : exchangeOrder.getItems()) {
					CvcOrderGoodsEntity  cvcOrderGoods = new CvcOrderGoodsEntity();
					cvcOrderGoods.setOrderId(exchangeOrder.getID());
					cvcOrderGoods.setGoodsId(exchangeOrderDetail.getProduct());
					cvcOrderGoods.setGoodsSn(exchangeOrderDetail.getProduct());
					cvcOrderGoods.setGoodsNumber(exchangeOrderDetail.getBookQuantity());
					cvcOrderGoodsDao.insert(cvcOrderGoods);
				}
				orderCount++;
			}
		}
		
		if(orderCount > 0) {
			//入库成功抓单
			cvcGetOrderStatisticsEntity = cvcGetOrderStatisticsDao.getByBatchNo(unified_batch_no);
			if(cvcGetOrderStatisticsEntity == null) {
				cvcGetOrderStatisticsEntity = new CvcGetOrderStatisticsEntity();
				cvcGetOrderStatisticsEntity.setUnifiedBatchNo(unified_batch_no);
				cvcGetOrderStatisticsEntity.setBatchNo(batch_no);
				cvcGetOrderStatisticsEntity.setAddTime(Integer.parseInt(add_time));
				cvcGetOrderStatisticsEntity.setOrderCount(orderCount);
				cvcGetOrderStatisticsDao.insert(cvcGetOrderStatisticsEntity);
			}else {
				cvcGetOrderStatisticsDao.addOrderCount(orderCount, unified_batch_no, add_time);
			}
		}
		return cvcGetOrderStatisticsEntity;
	}

	@Override
	@Transactional
	public int addwaitDeliveryCount(int orderCount, String batchNo) {
		if(StringUtils.isEmpty(batchNo)) {
			cvcOrderInfoDao.updateOrderRead();
		}else {
			cvcOrderInfoDao.updateOrderRead(batchNo);
		}
//		cvcGetOrderStatisticsDao.addwaitDeliveryCount(orderCount, batchNo);
		return 1;
	}

	@Override
	public void addExceptionCount(String batchNo) {
		cvcGetOrderStatisticsDao.addExceptionCount(batchNo);
	}
}
