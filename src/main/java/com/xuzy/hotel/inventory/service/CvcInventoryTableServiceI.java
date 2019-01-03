package com.xuzy.hotel.inventory.service;
import java.io.Serializable;
import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.xuzy.hotel.inventory.entity.CvcInventoryTableEntity;
import com.xuzy.hotel.message.entity.CvcMessageTableEntity;

public interface CvcInventoryTableServiceI extends CommonService{
	
 	public void delete(CvcInventoryTableEntity entity) throws Exception;
 	
 	public Serializable save(CvcInventoryTableEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CvcInventoryTableEntity entity) throws Exception;
 	
 	/**
 	 * 减一个库存
 	 * @return
 	 */
 	public int subInventory(String goodNumber,int size,int tryTime);
 	
 	/**
 	 * 判断是否需要提示
 	 * @return
 	 */
 	public List<CvcMessageTableEntity> checkIfWillAlter() throws Exception;
 	
}
