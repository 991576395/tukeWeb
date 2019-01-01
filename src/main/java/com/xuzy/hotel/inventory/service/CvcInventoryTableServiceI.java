package com.xuzy.hotel.inventory.service;
import com.xuzy.hotel.inventory.entity.CvcInventoryTableEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CvcInventoryTableServiceI extends CommonService{
	
 	public void delete(CvcInventoryTableEntity entity) throws Exception;
 	
 	public Serializable save(CvcInventoryTableEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CvcInventoryTableEntity entity) throws Exception;
 	
 	/**
 	 * 减一个库存
 	 * @return
 	 */
 	public int subInventory(String goodNumber,int size,int tryTime);
 	
}
