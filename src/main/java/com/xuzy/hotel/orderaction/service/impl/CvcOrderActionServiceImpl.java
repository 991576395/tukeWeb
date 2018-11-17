package com.xuzy.hotel.orderaction.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.jeecgframework.core.util.MutiLangUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.orderaction.dao.CvcOrderActionDao;
import com.xuzy.hotel.orderaction.entity.CvcOrderActionEntity;
import com.xuzy.hotel.orderaction.service.CvcOrderActionService;

/**
 * 描述：操作表
 * @author: www.jeecg.org
 * @since：2018年11月03日 22时39分29秒 星期六 
 * @version:1.0
 */

@Service("cvcOrderActionService")
public class CvcOrderActionServiceImpl implements CvcOrderActionService {
	@Resource
	private CvcOrderActionDao cvcOrderActionDao;
	

	@Override
	public CvcOrderActionEntity get(String id) {
		return cvcOrderActionDao.get(id);
	}

	@Override
	public int update(CvcOrderActionEntity cvcOrderAction) {
		return cvcOrderActionDao.update(cvcOrderAction);
	}

	@Override
	public void insert(CvcOrderActionEntity cvcOrderAction) {
		cvcOrderActionDao.insert(cvcOrderAction);
		
	}

	@Override
	public MiniDaoPage<CvcOrderActionEntity> getAll(CvcOrderActionEntity cvcOrderAction, int page, int rows) {
		return cvcOrderActionDao.getAll(cvcOrderAction, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcOrderActionDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcOrderActionDao.deleteById(id);
		}
	}

	@Override
	public List<CvcOrderActionEntity> getNewByOrderId(int orderId) {
		List<CvcOrderActionEntity> actionEntities = cvcOrderActionDao.getNewByOrderId(orderId);
		if(CollectionUtils.isNotEmpty(actionEntities)) {
			for (CvcOrderActionEntity cvcOrderActionEntity : actionEntities) {
				List<TSType> typeList = ResourceUtil.allTypes.get("oas");
				for (TSType type : typeList) {
					if(type.getTypecode().equals(cvcOrderActionEntity.getOrderStatus())) {
						cvcOrderActionEntity.setOrderStatusString(type.getTypename());
					}
				}
				
				List<TSType> typeList1 = ResourceUtil.allTypes.get("paystatus");
				for (TSType type : typeList1) {
					if(type.getTypecode().equals(cvcOrderActionEntity.getPayStatus())) {
						cvcOrderActionEntity.setPayStatusString(type.getTypename());
					}
				}
				
				List<TSType> typeList2 = ResourceUtil.allTypes.get("sstatus");
				for (TSType type : typeList2) {
					if(type.getTypecode().equals(cvcOrderActionEntity.getShippingStatus())) {
						cvcOrderActionEntity.setShippingStatusString(type.getTypename());
					}
				}
				
				cvcOrderActionEntity.setActionTime(DateFormatUtils.format(new Timestamp(Long.parseLong(cvcOrderActionEntity.getLogTime()+"000")), "yyyy-MM-dd HH:mm:ss"));
			}
		}
		
		return actionEntities;
	}
}
