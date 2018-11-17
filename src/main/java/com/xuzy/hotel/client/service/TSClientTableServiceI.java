package com.xuzy.hotel.client.service;
import java.io.Serializable;
import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import com.appinterface.app.bussiness.client.dto.AlertBodyModule;
import com.xuzy.hotel.client.entity.TSClientTableEntity;

public interface TSClientTableServiceI extends CommonService{
	
 	public void delete(TSClientTableEntity entity) throws Exception;
 	
 	public Serializable save(TSClientTableEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSClientTableEntity entity) throws Exception;
 	
 	/**
 	 * 根据年月匹配客户生日
 	 * @param yearMouth
 	 * @return
 	 */
 	public List<AlertBodyModule> getClientBirthday(String yearMouth);
 	
}
