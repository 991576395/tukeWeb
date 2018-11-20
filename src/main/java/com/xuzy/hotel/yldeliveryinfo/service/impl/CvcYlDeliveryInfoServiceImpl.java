package com.xuzy.hotel.yldeliveryinfo.service.impl;

import javax.annotation.Resource;
import java.util.UUID;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.yldeliveryinfo.dao.CvcYlDeliveryInfoDao;
import com.xuzy.hotel.yldeliveryinfo.entity.CvcYlDeliveryInfoEntity;
import com.xuzy.hotel.yldeliveryinfo.service.CvcYlDeliveryInfoService;

/**
 * 描述：伊利物流表
 * @author: www.jeecg.org
 * @since：2018年11月20日 22时03分58秒 星期二 
 * @version:1.0
 */

@Service("cvcYlDeliveryInfoService")
public class CvcYlDeliveryInfoServiceImpl implements CvcYlDeliveryInfoService {
	@Resource
	private CvcYlDeliveryInfoDao cvcYlDeliveryInfoDao;

	@Override
	public CvcYlDeliveryInfoEntity get(String id) {
		return cvcYlDeliveryInfoDao.get(id);
	}

	@Override
	public int update(CvcYlDeliveryInfoEntity cvcYlDeliveryInfo) {
		return cvcYlDeliveryInfoDao.update(cvcYlDeliveryInfo);
	}

	@Override
	public void insert(CvcYlDeliveryInfoEntity cvcYlDeliveryInfo) {
		String randomSeed = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
		cvcYlDeliveryInfo.setId(randomSeed);
		cvcYlDeliveryInfoDao.insert(cvcYlDeliveryInfo);
		
	}

	@Override
	public MiniDaoPage<CvcYlDeliveryInfoEntity> getAll(CvcYlDeliveryInfoEntity cvcYlDeliveryInfo, int page, int rows) {
		return cvcYlDeliveryInfoDao.getAll(cvcYlDeliveryInfo, page, rows);
	}

	@Override
	public void delete(String id) {
		cvcYlDeliveryInfoDao.delete(id);
		
	}
	
	@Override
	public void batchDelete(String[] ids) {
		for(int i = 0; i < ids.length; i++) {
			String id = ids[i];
			cvcYlDeliveryInfoDao.deleteById(id);
		}
	}
}
