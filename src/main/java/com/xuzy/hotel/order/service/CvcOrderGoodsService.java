package com.xuzy.hotel.order.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.order.entity.CvcOrderGoodsEntity;

/**
 * @author: www.jeecg.org
 * @since：2018年11月03日 12时14分09秒 星期六 
 * @version:1.0
 */
public interface CvcOrderGoodsService {
	public CvcOrderGoodsEntity get(String id);

	public int update(CvcOrderGoodsEntity cvcOrderGoods);

	public void insert(CvcOrderGoodsEntity cvcOrderGoods);

	public List<CvcOrderGoodsEntity> getAll(int orderId);	
}
