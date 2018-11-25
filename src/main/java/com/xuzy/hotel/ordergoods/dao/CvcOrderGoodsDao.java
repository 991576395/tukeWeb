package com.xuzy.hotel.ordergoods.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.ordergoods.entity.CvcOrderGoodsEntity;

/**
 * 描述：订单商品表
 * @author：www.jeecg.org
 * @since：2018年11月25日 17时10分02秒 星期日 
 * @version:1.0
 */
@Repository
public interface CvcOrderGoodsDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_order_goods WHERE ID = :id")
	CvcOrderGoodsEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cvcOrderGoods
	 * @return
	 */
	int update(@Param("cvcOrderGoods") CvcOrderGoodsEntity cvcOrderGoods);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcOrderGoods") CvcOrderGoodsEntity cvcOrderGoods);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcOrderGoods
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcOrderGoodsEntity.class)
	public MiniDaoPage<CvcOrderGoodsEntity> getAll(@Param("cvcOrderGoods") CvcOrderGoodsEntity cvcOrderGoods,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_order_goods WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_order_goods WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

