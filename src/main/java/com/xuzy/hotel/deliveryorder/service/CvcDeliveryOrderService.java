package com.xuzy.hotel.deliveryorder.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.deliveryorder.entity.CvcDeliveryOrderEntity;

/**
 * 描述：物流信息表
 * @author: www.jeecg.org
 * @since：2018年11月04日 09时59分48秒 星期日 
 * @version:1.0
 */
public interface CvcDeliveryOrderService {
	public CvcDeliveryOrderEntity get(String id);

	public int update(CvcDeliveryOrderEntity cvcDeliveryOrder);

	public int insert(CvcDeliveryOrderEntity cvcDeliveryOrder);

	public MiniDaoPage<CvcDeliveryOrderEntity> getAll(CvcDeliveryOrderEntity cvcDeliveryOrder,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
	/**
	 * 获取发货情况
	 */
	public List<CvcDeliveryOrderEntity> getDeliveryCondition(int orderId);
	/**
	 * 修改签收时间
	 * @param orderId
	 * @param signdate
	 */
	public void updateSigndate(int orderId,String signdate);
	
	/**
	 * 修改快递公司
	 * @param orderId
	 * @param shippingId
	 * @param shippingName
	 * @param invoiceNo
	 */
	public void updateNu(int orderId,int shippingId,String shippingName,String invoiceNo);

}
