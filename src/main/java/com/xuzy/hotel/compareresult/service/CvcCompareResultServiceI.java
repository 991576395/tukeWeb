package com.xuzy.hotel.compareresult.service;
import com.xuzy.hotel.compareresult.entity.CvcCompareResultEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CvcCompareResultServiceI extends CommonService{
	
 	public void delete(CvcCompareResultEntity entity) throws Exception;
 	
 	public Serializable save(CvcCompareResultEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CvcCompareResultEntity entity) throws Exception;
 	
}
