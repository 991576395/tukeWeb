package com.xuzy.hotel.message.service;
import com.xuzy.hotel.message.entity.CvcMessageTableEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CvcMessageTableServiceI extends CommonService{
	
 	public void delete(CvcMessageTableEntity entity) throws Exception;
 	
 	public Serializable save(CvcMessageTableEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CvcMessageTableEntity entity) throws Exception;
 	
}
