package com.xuzy.hotel.yldeliveryinfo.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.yldeliveryinfo.entity.CvcYlDeliveryInfoEntity;

/**
 * 描述：伊利物流表
 * @author: www.jeecg.org
 * @since：2018年11月20日 22时03分58秒 星期二 
 * @version:1.0
 */
public interface CvcYlDeliveryInfoService {
	public CvcYlDeliveryInfoEntity get(String id);

	public int update(CvcYlDeliveryInfoEntity cvcYlDeliveryInfo);

	public void insert(CvcYlDeliveryInfoEntity cvcYlDeliveryInfo);

	public MiniDaoPage<CvcYlDeliveryInfoEntity> getAll(CvcYlDeliveryInfoEntity cvcYlDeliveryInfo,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
