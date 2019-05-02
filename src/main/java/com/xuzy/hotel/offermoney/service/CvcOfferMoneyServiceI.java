package com.xuzy.hotel.offermoney.service;
import com.xuzy.hotel.offermoney.entity.CvcOfferMoneyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface CvcOfferMoneyServiceI extends CommonService{
	
 	public void delete(CvcOfferMoneyEntity entity) throws Exception;
 	
 	public Serializable save(CvcOfferMoneyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CvcOfferMoneyEntity entity) throws Exception;
 	

 	/**
 	 * 通过公式计算
 	 * @param entity
 	 * @throws Exception
 	 */
 	public void calculate(CvcOfferMoneyEntity entity) throws Exception;

    void batchInsert(List<CvcOfferMoneyEntity> cvcOfferMoneyEntityList);
}
