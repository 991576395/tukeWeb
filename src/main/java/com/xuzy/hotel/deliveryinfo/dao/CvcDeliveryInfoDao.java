package com.xuzy.hotel.deliveryinfo.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.stereotype.Repository;

import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;

/**
 * 描述：物流表
 * 
 * @author：www.jeecg.org
 * @since：2018年11月20日 20时42分45秒 星期二
 * @version:1.0
 */
@Repository
public interface CvcDeliveryInfoDao {

	/**
	 * 查询返回Java对象
	 * 
	 * @param id
	 * @return
	 */
	@Sql("SELECT * FROM cvc_delivery_info WHERE ID = :id")
	CvcDeliveryInfoEntity get(@Param("id") String id);

	/**
	 * 修改数据
	 * 
	 * @param cvcDeliveryInfo
	 * @return
	 */
	int update(@Param("cvcDeliveryInfo") CvcDeliveryInfoEntity cvcDeliveryInfo);

	/**
	 * 插入数据
	 * 
	 * @param act
	 */
	void insert(@Param("cvcDeliveryInfo") CvcDeliveryInfoEntity cvcDeliveryInfo);

	/**
	 * 通用分页方法，支持（oracle、mysql、SqlServer、postgresql）
	 * 
	 * @param cvcDeliveryInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResultType(CvcDeliveryInfoEntity.class)
	public MiniDaoPage<CvcDeliveryInfoEntity> getAll(@Param("cvcDeliveryInfo") CvcDeliveryInfoEntity cvcDeliveryInfo,
			@Param("page") int page, @Param("rows") int rows);

	@Sql("DELETE from cvc_delivery_info WHERE ID = :id")
	public void delete(@Param("id") String id);

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 */
	@Sql("DELETE from cvc_delivery_info WHERE ID = :id")
	public void deleteById(@Param("id") String id);

	/**
	 * 获取物流流程
	 * 
	 * @param invoice_no
	 * @return
	 */
	@ResultType(CvcDeliveryInfoEntity.class)
	@Sql("SELECT id,data,state FROM  cvc_delivery_info WHERE number = :invoice_no ORDER BY id DESC LIMIT 1")
	public CvcDeliveryInfoEntity getAll(@Param("invoice_no") String invoice_no);

	
	@ResultType(CvcDeliveryInfoEntity.class)
	@Sql("select * from cvc_delivery_info i where i.number in (\r\n" + 
			"select d_o.invoice_no from cvc_order_info o left join cvc_delivery_order d_o on o.order_id = d_o.order_id   \r\n" + 
			"where o.tk_order_status=3 or o.tk_order_status=4\r\n" + 
			") and i.state = 3")
	public List<CvcDeliveryInfoEntity> getAllError();
	
	
	@ResultType(CvcDeliveryInfoEntity.class)
	@Sql("SELECT * FROM cvc_delivery_info where create_date is not NULL and create_date >= :startTime and create_date <= :endTime"
			+ " and state = 2")
	public List<CvcDeliveryInfoEntity> getListOneHours(@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	
	/**
	 * 首次派送时间
	 * @param invoice_no
	 * @return
	 */
	@ResultType(CvcDeliveryInfoEntity.class)
	@Sql("SELECT create_date FROM  cvc_delivery_info WHERE number = :invoice_no and state = 5 ORDER BY id LIMIT 1")
	public CvcDeliveryInfoEntity getFirstTime(@Param("invoice_no") String invoice_no);
}
