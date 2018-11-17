package com.xuzy.hotel.menuclassfry.service;
import com.xuzy.hotel.menuclassfry.entity.TMenuClassfryEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TMenuClassfryServiceI extends CommonService{
	
 	public void delete(TMenuClassfryEntity entity) throws Exception;
 	
 	public Serializable save(TMenuClassfryEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TMenuClassfryEntity entity) throws Exception;
 	
}
