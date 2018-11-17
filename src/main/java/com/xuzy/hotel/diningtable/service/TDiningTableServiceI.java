package com.xuzy.hotel.diningtable.service;
import com.xuzy.hotel.diningtable.entity.TDiningTableEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TDiningTableServiceI extends CommonService{
	
 	public void delete(TDiningTableEntity entity) throws Exception;
 	
 	public Serializable save(TDiningTableEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TDiningTableEntity entity) throws Exception;
 	
}
