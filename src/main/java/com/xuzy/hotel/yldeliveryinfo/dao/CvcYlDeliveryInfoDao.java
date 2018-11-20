package com.xuzy.hotel.yldeliveryinfo.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.yldeliveryinfo.entity.CvcYlDeliveryInfoEntity;

/**
 * 描述：伊利物流表
 * @author：www.jeecg.org
 * @since：2018年11月20日 22时03分58秒 星期二 
 * @version:1.0
 */
@Repository
public interface CvcYlDeliveryInfoDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_yl_delivery_info WHERE ID = :id")
	CvcYlDeliveryInfoEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cvcYlDeliveryInfo
	 * @return
	 */
	int update(@Param("cvcYlDeliveryInfo") CvcYlDeliveryInfoEntity cvcYlDeliveryInfo);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcYlDeliveryInfo") CvcYlDeliveryInfoEntity cvcYlDeliveryInfo);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcYlDeliveryInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcYlDeliveryInfoEntity.class)
	public MiniDaoPage<CvcYlDeliveryInfoEntity> getAll(@Param("cvcYlDeliveryInfo") CvcYlDeliveryInfoEntity cvcYlDeliveryInfo,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_yl_delivery_info WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_yl_delivery_info WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

