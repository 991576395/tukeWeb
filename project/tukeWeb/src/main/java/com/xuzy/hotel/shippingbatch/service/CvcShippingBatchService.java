package com.xuzy.hotel.shippingbatch.service;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import com.xuzy.hotel.shippingbatch.entity.CvcShippingBatchEntity;

/**
 * 描述：批量发货表
 * @author: www.jeecg.org
 * @since：2018年11月20日 20时41分17秒 星期二 
 * @version:1.0
 */
public interface CvcShippingBatchService {
	public CvcShippingBatchEntity get(String id);

	public int update(CvcShippingBatchEntity cvcShippingBatch);

	public void insert(CvcShippingBatchEntity cvcShippingBatch);

	public MiniDaoPage<CvcShippingBatchEntity> getAll(CvcShippingBatchEntity cvcShippingBatch,int page,int rows);

	public void delete(String id);
	
	public void batchDelete(String[] ids);
	
}
