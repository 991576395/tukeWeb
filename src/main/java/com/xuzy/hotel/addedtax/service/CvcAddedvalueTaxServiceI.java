package com.xuzy.hotel.addedtax.service;
import com.xuzy.hotel.addedtax.entity.CvcAddedvalueTaxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CvcAddedvalueTaxServiceI extends CommonService{
	
 	public void delete(CvcAddedvalueTaxEntity entity) throws Exception;
 	
 	public Serializable save(CvcAddedvalueTaxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CvcAddedvalueTaxEntity entity) throws Exception;
 	
 	public CvcAddedvalueTaxEntity getEntityByName(String name) ;
 	
}
