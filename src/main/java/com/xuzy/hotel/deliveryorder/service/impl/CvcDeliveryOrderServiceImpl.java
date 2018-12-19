package com.xuzy.hotel.deliveryorder.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appinterface.app.base.exception.XuException;
import com.util.PhpDateUtils;
import com.xuzy.hotel.deliverygoods.dao.CvcDeliveryGoodsDao;
import com.xuzy.hotel.deliverygoods.entity.CvcDeliveryGoodsEntity;
import com.xuzy.hotel.deliveryorder.dao.CvcDeliveryOrderDao;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;
import com.xuzy.hotel.deliveryorder.service.CvcDeliveryOrderService;
import com.xuzy.hotel.order.dao.CvcOrderInfoDao;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.orderaction.dao.CvcOrderActionDao;
import com.xuzy.hotel.orderaction.entity.CvcOrderActionEntity;
import com.xuzy.hotel.ordergoods.dao.CvcOrderGoodsDao;
import com.xuzy.hotel.ordergoods.entity.CvcOrderGoodsEntity;
import com.xuzy.hotel.shipping.dao.CvcShippingDao;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;
import com.xuzy.hotel.shippingbatchorder.dao.CvcShippingBatchOrderDao;

/**
 * 描述：物流信息表
 * @author: www.jeecg.org
 * @since：2018年11月04日 09时59分48秒 星期日 
 * @version:1.0
 */

@Service("cvcDeliveryOrderService")
public class CvcDeliveryOrderServiceImpl implements CvcDeliveryOrderService {
	private static final Logger logger = Logger.getLogger(CvcDeliveryOrderServiceImpl.class);
	
	@Resource
	private CvcDeliveryOrderDao cvcDeliveryOrderDao;
	
	@Resource
	private CvcOrderInfoDao cvcOrderInfoDao;
	
	@Resource
	private CvcShippingBatchOrderDao cvcShippingBatchOrderDao;
	
	@Resource
	private CvcShippingDao cvcShippingDao;
	
	@Resource
	private CvcOrderGoodsDao cvcOrderGoodsDao;
	
	@Resource
	private CvcDeliveryGoodsDao cvcDeliveryGoodsDao;
	
	@Resource
	private CvcOrderActionDao cvcOrderActionDao;

	@Override
	public CvcDeliveryOrderEntity get(String id) {
		return cvcDeliveryOrderDao.get(id);
	}

	@Override
	public int update(CvcDeliveryOrderEntity cvcDeliveryOrder) {
		return cvcDeliveryOrderDao.update(cvcDeliveryOrder);
	}

	@Override
	@Transactional
	public int insert(CvcDeliveryOrderEntity cvcDeliveryOrder) {
		cvcDeliveryOrderDao.insert(cvcDeliveryOrder);
		return	cvcDeliveryOrderDao.getInserId();
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

	@Override
	public void updateErrorCode(String shippingCode, String invoiceNo) {
		cvcDeliveryOrderDao.updateErrorCode(shippingCode, invoiceNo);
	}

	@Override
	public CvcDeliveryOrderEntity getEntityByinvoiceNo(String invoiceNo) {
		return cvcDeliveryOrderDao.getEntityByinvoiceNo(invoiceNo);
	}

	@Override
	@Transactional(rollbackFor=XuException.class)
	public void addDeliveryOrderByOrder(CvcOrderInfoEntity orderInfoEntity,String shippingName,String batchSendNo,int isPostorder) {
		try {
			if(!StringUtils.isEmpty(shippingName)) {
				CvcShippingEntity cvcShippingEntity = cvcShippingDao.get(shippingName);
				if(cvcShippingEntity == null) {
					cvcShippingEntity = new CvcShippingEntity();
					cvcShippingEntity.setShippingName(shippingName);
					cvcShippingEntity.setEnabled(1);
					//其他 添加快递公司
					int id = cvcShippingDao.insert(cvcShippingEntity);
					cvcShippingEntity.setShippingId(id);
				}
				/* 生成发货单 */
		        /* 获取发货单号和流水号 */
				String delivery_sn = DateFormatUtils.format(Calendar.getInstance(), "yyyyMMddHHmmssSSS");
				//保存发货订单
				CvcDeliveryOrderEntity cvcDeliveryOrderEntity = new CvcDeliveryOrderEntity();
				cvcDeliveryOrderEntity.setDeliverySn(delivery_sn);
				cvcDeliveryOrderEntity.setOrderId(orderInfoEntity.getId());
				//设置更新时间
				cvcDeliveryOrderEntity.setUpdateTime(PhpDateUtils.getTime());
				//修改人
				cvcDeliveryOrderEntity.setActionUser(ResourceUtil.getSessionUser().getUserName());
				cvcDeliveryOrderEntity.setAddTime(Integer.parseInt(orderInfoEntity.getOldAddTime()));
				cvcDeliveryOrderEntity.setStatus(2);
				cvcDeliveryOrderEntity.setOrderSn(orderInfoEntity.getId()+"");
				cvcDeliveryOrderEntity.setShippingId(cvcShippingEntity.getShippingId());
				cvcDeliveryOrderEntity.setShippingName(shippingName);
				cvcDeliveryOrderEntity.setUserId(orderInfoEntity.getUserId());
				cvcDeliveryOrderEntity.setActionUser(ResourceUtil.getSessionUser().getUserName());
				cvcDeliveryOrderEntity.setConsignee(orderInfoEntity.getConsignee());
				cvcDeliveryOrderEntity.setAddress(orderInfoEntity.getAddress());
				cvcDeliveryOrderEntity.setTel(orderInfoEntity.getTel());
				cvcDeliveryOrderEntity.setPreArrivalDate(orderInfoEntity.getPreArrivalDate());
				cvcDeliveryOrderEntity.setInvoiceNo(orderInfoEntity.getInvoiceNo());
				
				int deliveryId = insert(cvcDeliveryOrderEntity);
				List<CvcOrderGoodsEntity> cvcOrderGoodsEntities = cvcOrderGoodsDao.getGoods(orderInfoEntity.getId());
				if(CollectionUtils.isNotEmpty(cvcOrderGoodsEntities)) {
					for(CvcOrderGoodsEntity entity:cvcOrderGoodsEntities) {
						entity.setFormatedSubtotal(entity.getGoodsPrice().multiply(new BigDecimal(entity.getGoodsNumber())));
					}
				}
				
				if(deliveryId > 0 && CollectionUtils.isNotEmpty(cvcOrderGoodsEntities)) {
					//发货单商品入库
					for(CvcOrderGoodsEntity cvcOrderGoodsEntity:cvcOrderGoodsEntities) {
						CvcDeliveryGoodsEntity cvcDeliveryGoods = new CvcDeliveryGoodsEntity();
						cvcDeliveryGoods.setDeliveryId(deliveryId);
						cvcDeliveryGoods.setGoodsId(cvcOrderGoodsEntity.getGoodsId());
						cvcDeliveryGoods.setSendNumber(cvcOrderGoodsEntity.getGoodsNumber());
						cvcDeliveryGoodsDao.insert(cvcDeliveryGoods);
					}
				}
			}
			
			int size = cvcOrderGoodsDao.getOrderFinish(orderInfoEntity.getId());
			if(orderInfoEntity.getOrderStatus() != 1 && orderInfoEntity.getOrderStatus() != 5
					&& orderInfoEntity.getOrderStatus() != 6) {
				//        1); // 已确认  5); // 已分单  6); // 部分分单
				orderInfoEntity.setOrderStatus(1);
				orderInfoEntity.setConfirmTime(PhpDateUtils.getTime()+"");
			}
			orderInfoEntity.setOrderStatus(size > 0 ?5:6);// 全部分单、部分分单
			orderInfoEntity.setYlOrderStatus(3);
			orderInfoEntity.setTkOrderStatus(3);
			orderInfoEntity.setShippingStatus(size > 0 ?6:50);
			cvcOrderInfoDao.updateOrder(orderInfoEntity.getId(),orderInfoEntity.getOrderStatus(),3,orderInfoEntity.getShippingStatus(),orderInfoEntity.getConfirmTime());
			if(StringUtils.isNotEmpty(batchSendNo)) {
				//批量发货修改
				cvcShippingBatchOrderDao.updateBatchOrderStatus(isPostorder, PhpDateUtils.getTime(), orderInfoEntity.getId(), batchSendNo);
			}
			//添加操作记录
			CvcOrderActionEntity cvcOrderAction = new CvcOrderActionEntity();
			cvcOrderAction.setOrderId(orderInfoEntity.getId());
			cvcOrderAction.setActionUser(ResourceUtil.getSessionUser().getUserName());
			cvcOrderAction.setOrderStatus(orderInfoEntity.getOrderStatus());
			cvcOrderAction.setShippingStatus(orderInfoEntity.getShippingStatus());
			cvcOrderAction.setPayStatus(0);
			cvcOrderAction.setActionPlace(0);
			cvcOrderAction.setActionNote("");
			cvcOrderAction.setLogTime((int)PhpDateUtils.getTime());
			cvcOrderActionDao.insert(cvcOrderAction );
		} catch (Exception e) {
			logger.error("订单发货异常！", e);
			throw new XuException("订单发货异常！");
		}
	}
}
