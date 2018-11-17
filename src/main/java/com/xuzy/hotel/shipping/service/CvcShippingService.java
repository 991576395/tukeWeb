package com.xuzy.hotel.shipping.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;

/**
 * 描述：物流表
 * @author: www.jeecg.org
 * @since：2018年10月28日 14时36分19秒 星期日 
 * @version:1.0
 */
public interface CvcShippingService {
	public CvcShippingEntity get(String id);

	public int update(CvcShippingEntity cvcShipping);

	public void insert(CvcShippingEntity cvcShipping);

	public MiniDaoPage<CvcShippingEntity> getAll(CvcShippingEntity cvcShipping,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
