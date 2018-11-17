package com.xuzy.hotel.orderaction.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.orderaction.entity.CvcOrderActionEntity;

/**
 * 描述：操作表
 * @author：www.jeecg.org
 * @since：2018年11月03日 22时39分29秒 星期六 
 * @version:1.0
 */
@Repository
public interface CvcOrderActionDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_order_action WHERE ID = :id")
	CvcOrderActionEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cvcOrderAction
	 * @return
	 */
	int update(@Param("cvcOrderAction") CvcOrderActionEntity cvcOrderAction);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcOrderAction") CvcOrderActionEntity cvcOrderAction);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcOrderAction
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcOrderActionEntity.class)
	public MiniDaoPage<CvcOrderActionEntity> getAll(@Param("cvcOrderAction") CvcOrderActionEntity cvcOrderAction,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_order_action WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_order_action WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
	 /**
 * 查询返回Java对象
	 * @param id
		* @return
	 */
	@Sql("SELECT * FROM cvc_order_action WHERE order_id = :orderId ORDER BY log_time DESC,action_id DESC LIMIT 1 ")
	List<CvcOrderActionEntity> getNewByOrderId(@Param("orderId") int orderId);
	 
}

