package com.xuzy.hotel.deliveryinfo.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;

/**
 * 描述：物流表
 * @author：www.jeecg.org
 * @since：2018年11月20日 20时42分45秒 星期二 
 * @version:1.0
 */
@Repository
public interface CvcDeliveryInfoDao{

    /**
	 * 查询返回Java对象
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_delivery_info WHERE ID = :id")
	CvcDeliveryInfoEntity get(@Param("id") String id);
	
	/**
	 * 修改数据
	 * @param cvcDeliveryInfo
	 * @return
	 */
	int update(@Param("cvcDeliveryInfo") CvcDeliveryInfoEntity cvcDeliveryInfo);
	
	/**
	 * 插入数据
	 * @param act
	 */
	void insert(@Param("cvcDeliveryInfo") CvcDeliveryInfoEntity cvcDeliveryInfo);
	
	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * @param cvcDeliveryInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcDeliveryInfoEntity.class)
	public MiniDaoPage<CvcDeliveryInfoEntity> getAll(@Param("cvcDeliveryInfo") CvcDeliveryInfoEntity cvcDeliveryInfo,@Param("page")  int page,@Param("rows") int rows);
	
	@Sql("DELETE from cvc_delivery_info WHERE ID = :id")
	public void delete(@Param("id") String id);
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	 @Sql("DELETE from cvc_delivery_info WHERE ID = :id")
	 public void deleteById(@Param("id") String id);
	
}

