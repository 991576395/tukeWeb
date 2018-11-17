package com.xuzy.hotel.padversion.service;
import com.xuzy.hotel.padversion.entity.TAppVersionEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TAppVersionServiceI extends CommonService{
	
 	public void delete(TAppVersionEntity entity) throws Exception;
 	
 	public Serializable save(TAppVersionEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TAppVersionEntity entity) throws Exception;
 	
 	
 	public String appShouldUpdate(String os,String versionName);
 	
}
