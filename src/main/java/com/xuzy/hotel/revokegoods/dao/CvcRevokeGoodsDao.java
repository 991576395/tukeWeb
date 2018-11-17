package com.xuzy.hotel.revokegoods.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.revokegoods.entity.CvcRevokeGoodsEntity;

/**
 * 描述：撤销商品表
 * @author：www.jeecg.org
 * @since：2018年11月03日 22时15分53秒 星期六 
 * @version:1.0
 */
@Repository
public interface CvcRevokeGoodsDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_revoke_goods WHERE ID = :id")
	CvcRevokeGoodsEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cvcRevokeGoods
	 * @return
	 */
	int update(@Param("cvcRevokeGoods") CvcRevokeGoodsEntity cvcRevokeGoods);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcRevokeGoods") CvcRevokeGoodsEntity cvcRevokeGoods);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcRevokeGoods
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcRevokeGoodsEntity.class)
	public MiniDaoPage<CvcRevokeGoodsEntity> getAll(@Param("cvcRevokeGoods") CvcRevokeGoodsEntity cvcRevokeGoods,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_revoke_goods WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_revoke_goods WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	 
	 
	 /**
		 * 查询返回Java对象
		 * @param id
		 * @return
		 */
		@Sql("SELECT * FROM cvc_revoke_goods WHERE order_id = :orderId")
		List<CvcRevokeGoodsEntity> getByOrderId(@Param("orderId") int orderId);
	
}

