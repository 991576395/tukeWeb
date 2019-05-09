package com.xuzy.hotel.deliveryinfonew.service;
import com.xuzy.hotel.deliveryinfonew.entity.CvcDeliveryInfoNewEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CvcDeliveryInfoNewServiceI extends CommonService{
	
 	public void delete(CvcDeliveryInfoNewEntity entity) throws Exception;
 	
 	public Serializable save(CvcDeliveryInfoNewEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CvcDeliveryInfoNewEntity entity) throws Exception;
 	
}
