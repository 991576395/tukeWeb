package com.xuzy.hotel.shipping.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.shipping.entity.CvcShippingEntity;

/**
 * 描述：物流表
 * @author：www.jeecg.org
 * @since：2018年10月28日 14时36分19秒 星期日 
 * @version:1.0
 */
@Repository
public interface CvcShippingDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_shipping WHERE ID = :id")
	CvcShippingEntity get(@Param("id") String id);
	
	
	/**
	 * 修改数据
	 * @param cvcShipping
	 * @return
	 */
	int update(@Param("cvcShipping") CvcShippingEntity cvcShipping);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcShipping") CvcShippingEntity cvcShipping);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcShipping
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcShippingEntity.class)
	public MiniDaoPage<CvcShippingEntity> getAll(@Param("cvcShipping") CvcShippingEntity cvcShipping,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_shipping WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_shipping WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

