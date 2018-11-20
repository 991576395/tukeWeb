package com.xuzy.hotel.deliveryinfo.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;

/**
 * 描述：物流表
 * @author: www.jeecg.org
 * @since：2018年11月20日 20时42分45秒 星期二 
 * @version:1.0
 */
public interface CvcDeliveryInfoService {
	public CvcDeliveryInfoEntity get(String id);

	public int update(CvcDeliveryInfoEntity cvcDeliveryInfo);

	public void insert(CvcDeliveryInfoEntity cvcDeliveryInfo);

	public MiniDaoPage<CvcDeliveryInfoEntity> getAll(CvcDeliveryInfoEntity cvcDeliveryInfo,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
