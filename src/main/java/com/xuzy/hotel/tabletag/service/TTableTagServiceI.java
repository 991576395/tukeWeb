package com.xuzy.hotel.tabletag.service;
import com.xuzy.hotel.tabletag.entity.TTableTagEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TTableTagServiceI extends CommonService{
	
 	public void delete(TTableTagEntity entity) throws Exception;
 	
 	public Serializable save(TTableTagEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TTableTagEntity entity) throws Exception;
 	
}
