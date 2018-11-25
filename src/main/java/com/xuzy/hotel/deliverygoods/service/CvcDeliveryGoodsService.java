package com.xuzy.hotel.deliverygoods.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.deliverygoods.entity.CvcDeliveryGoodsEntity;

/**
 * 描述：发货商品表
 * @author: www.jeecg.org
 * @since：2018年11月25日 17时11分43秒 星期日 
 * @version:1.0
 */
public interface CvcDeliveryGoodsService {
	public CvcDeliveryGoodsEntity get(String id);

	public int update(CvcDeliveryGoodsEntity cvcDeliveryGoods);

	public void insert(CvcDeliveryGoodsEntity cvcDeliveryGoods);

	public MiniDaoPage<CvcDeliveryGoodsEntity> getAll(CvcDeliveryGoodsEntity cvcDeliveryGoods,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
