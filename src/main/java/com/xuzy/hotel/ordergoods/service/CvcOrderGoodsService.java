package com.xuzy.hotel.ordergoods.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.ordergoods.entity.CvcOrderGoodsEntity;

/**
 * 描述：订单商品表
 * @author: www.jeecg.org
 * @since：2018年11月25日 17时10分02秒 星期日 
 * @version:1.0
 */
public interface CvcOrderGoodsService {
	public CvcOrderGoodsEntity get(String id);

	public int update(CvcOrderGoodsEntity cvcOrderGoods);

	public void insert(CvcOrderGoodsEntity cvcOrderGoods);

	public MiniDaoPage<CvcOrderGoodsEntity> getAll(CvcOrderGoodsEntity cvcOrderGoods,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
	public List<CvcOrderGoodsEntity> getAll(int orderId);
	
}
