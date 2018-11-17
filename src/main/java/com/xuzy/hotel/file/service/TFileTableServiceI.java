package com.xuzy.hotel.file.service;
import com.xuzy.hotel.file.entity.TFileTableEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TFileTableServiceI extends CommonService{
	
 	public void delete(TFileTableEntity entity) throws Exception;
 	
 	public Serializable save(TFileTableEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TFileTableEntity entity) throws Exception;
 	
}
