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
 	public CvcOfferMoneyEntity calculate(CvcOfferMoneyEntity entity) throws Exception;
 	
 	/**
 	 * 通过公式计算其他公司上传后结果
 	 * @param entity
 	 * @throws Exception
 	 */
 	public void calculateOther() throws Exception;

 	/**
 	 * 上下调净利润
 	 * @param entity
 	 * @param number
 	 * @throws Exception
 	 */
 	public void upOrDownCalculate(CvcOfferMoneyEntity entity,double number) throws Exception;

    void batchInsert(List<CvcOfferMoneyEntity> cvcOfferMoneyEntityList, String ifMyCompany, String fileName);
}
