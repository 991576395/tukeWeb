package com.xuzy.hotel.deliverygoods.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.deliverygoods.entity.CvcDeliveryGoodsEntity;

/**
 * 描述：发货商品表
 * @author：www.jeecg.org
 * @since：2018年11月25日 17时11分43秒 星期日 
 * @version:1.0
 */
@Repository
public interface CvcDeliveryGoodsDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_delivery_goods WHERE ID = :id")
	CvcDeliveryGoodsEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cvcDeliveryGoods
	 * @return
	 */
	int update(@Param("cvcDeliveryGoods") CvcDeliveryGoodsEntity cvcDeliveryGoods);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcDeliveryGoods") CvcDeliveryGoodsEntity cvcDeliveryGoods);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcDeliveryGoods
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcDeliveryGoodsEntity.class)
	public MiniDaoPage<CvcDeliveryGoodsEntity> getAll(@Param("cvcDeliveryGoods") CvcDeliveryGoodsEntity cvcDeliveryGoods,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_delivery_goods WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_delivery_goods WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

