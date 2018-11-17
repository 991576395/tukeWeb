package com.xuzy.hotel.company.service;
import com.xuzy.hotel.company.entity.TSCompanyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TSCompanyServiceI extends CommonService{
	
 	public void delete(TSCompanyEntity entity) throws Exception;
 	
 	public Serializable save(TSCompanyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSCompanyEntity entity) throws Exception;
 	
}
