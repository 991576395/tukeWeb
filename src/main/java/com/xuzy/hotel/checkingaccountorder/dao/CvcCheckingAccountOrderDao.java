package com.xuzy.hotel.checkingaccountorder.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.checkingaccountorder.entity.CvcCheckingAccountOrderEntity;

/**
 * 描述：对账订单表
 * @author：www.jeecg.org
 * @since：2018年11月15日 21时28分02秒 星期四 
 * @version:1.0
 */
@Repository
public interface CvcCheckingAccountOrderDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_checking_account_order WHERE ID = :id")
	CvcCheckingAccountOrderEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cvcCheckingAccountOrder
	 * @return
	 */
	int update(@Param("cvcCheckingAccountOrder") CvcCheckingAccountOrderEntity cvcCheckingAccountOrder);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcCheckingAccountOrder") CvcCheckingAccountOrderEntity cvcCheckingAccountOrder);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcCheckingAccountOrder
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcCheckingAccountOrderEntity.class)
	public MiniDaoPage<CvcCheckingAccountOrderEntity> getAll(@Param("cvcCheckingAccountOrder") CvcCheckingAccountOrderEntity cvcCheckingAccountOrder,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_checking_account_order WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_checking_account_order WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

