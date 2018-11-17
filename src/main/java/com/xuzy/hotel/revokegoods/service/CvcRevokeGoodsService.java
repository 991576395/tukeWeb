package com.xuzy.hotel.revokegoods.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.revokegoods.entity.CvcRevokeGoodsEntity;

/**
 * 描述：撤销商品表
 * @author: www.jeecg.org
 * @since：2018年11月03日 22时15分53秒 星期六 
 * @version:1.0
 */
public interface CvcRevokeGoodsService {
	public CvcRevokeGoodsEntity get(String id);

	public int update(CvcRevokeGoodsEntity cvcRevokeGoods);

	public void insert(CvcRevokeGoodsEntity cvcRevokeGoods);

	public MiniDaoPage<CvcRevokeGoodsEntity> getAll(CvcRevokeGoodsEntity cvcRevokeGoods,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
	
	public List<CvcRevokeGoodsEntity> getByOrderId( int orderId);
}
