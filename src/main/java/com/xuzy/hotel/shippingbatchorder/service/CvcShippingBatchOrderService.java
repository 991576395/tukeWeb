package com.xuzy.hotel.shippingbatchorder.service;

import java.util.List;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.shippingbatchorder.entity.CvcShippingBatchOrderEntity;

/**
 * 描述：批量发货订单表
 * @author: www.jeecg.org
 * @since：2018年11月21日 20时52分03秒 星期三 
 * @version:1.0
 */
public interface CvcShippingBatchOrderService {
	public CvcShippingBatchOrderEntity get(String id);

	public int update(CvcShippingBatchOrderEntity cvcShippingBatchOrder);

	public void insert(CvcShippingBatchOrderEntity cvcShippingBatchOrder);

	public MiniDaoPage<CvcShippingBatchOrderEntity> getAll(CvcShippingBatchOrderEntity cvcShippingBatchOrder,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
	int getCount( CvcShippingBatchOrderEntity cvcShippingBatchOrder);
	
	CvcShippingBatchOrderEntity getEntityByInvoiceNo( String invoiceNo);
	
	public void deleteBybatchNo( String batchNo);
	
	public void updateBatchOrderStatus(int status,long shippingTime, int orderId, String batchNo);
	
	List<CvcShippingBatchOrderEntity> getEntitysByBatchNo(String batchNo,int orderId);
	
	public void batchInsert(List<CvcShippingBatchOrderEntity> batchOrderEntities,String orderBatchNo);
}
