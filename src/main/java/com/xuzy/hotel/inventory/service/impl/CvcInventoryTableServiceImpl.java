package com.xuzy.hotel.inventory.service.impl;
import com.xuzy.hotel.inventory.service.CvcInventoryTableServiceI;
import com.xuzy.hotel.message.entity.CvcMessageTableEntity;
import com.xuzy.hotel.message.service.CvcMessageTableServiceI;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.appinterface.app.base.exception.XuException;
import com.xuzy.hotel.inventory.entity.CvcInventoryTableEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("cvcInventoryTableService")
@Transactional
public class CvcInventoryTableServiceImpl extends CommonServiceImpl implements CvcInventoryTableServiceI {
	
	@Autowired
	private CvcMessageTableServiceI cvcMessageTableService;
	
 	public void delete(CvcInventoryTableEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(CvcInventoryTableEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(CvcInventoryTableEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(CvcInventoryTableEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(CvcInventoryTableEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(CvcInventoryTableEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(CvcInventoryTableEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("bpm_status", t.getBpmStatus());
		map.put("good_number", t.getGoodNumber());
		map.put("good_totle_size", t.getGoodTotleSize());
		map.put("good_size", t.getGoodSize());
		map.put("uodate_version", t.getUodateVersion());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,CvcInventoryTableEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{good_number}",String.valueOf(t.getGoodNumber()));
 		sql  = sql.replace("#{good_totle_size}",String.valueOf(t.getGoodTotleSize()));
 		sql  = sql.replace("#{good_size}",String.valueOf(t.getGoodSize()));
 		sql  = sql.replace("#{uodate_version}",String.valueOf(t.getUodateVersion()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("cvc_inventory_table",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public int subInventory(String goodNumber,int size,int tryTime) {
		if(StringUtils.isEmpty(goodNumber)) {
			throw new XuException("商品编号不能为空！");
		}
		List<CvcInventoryTableEntity> cvcInventoryTableEntitys = findByProperty(CvcInventoryTableEntity.class, "goodNumber", goodNumber);
		if(CollectionUtils.isEmpty(cvcInventoryTableEntitys)) {
			throw new XuException("不存在该商品编号库存，请添加库存后重试！");
		}
		CvcInventoryTableEntity cvcInventoryTableEntity =  cvcInventoryTableEntitys.get(0);
		if(cvcInventoryTableEntity == null) {
			throw new XuException("不存在该商品编号库存，请添加库存后重试！");
		}
		
		if(cvcInventoryTableEntity.getGoodSize() == 0) {
			throw new XuException("该商品库存已清空，请先补充！");
		}
		
		int result = executeSql("update cvc_inventory_table set GOOD_SIZE = GOOD_SIZE - ?,UODATE_VERSION = UODATE_VERSION + 1 where GOOD_NUMBER = ? and UODATE_VERSION = ?",size,cvcInventoryTableEntity.getGoodNumber(),
				cvcInventoryTableEntity.getUodateVersion());
		if(result == 1) {
			return result;
		}else {
			if(tryTime >= 5) {
				throw new XuException("减仓失败，请重试！");
			}
			
			long sleepTime = new Random(100).nextInt();
			try {
				Thread.sleep(100 + sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			subInventory(goodNumber,size,++tryTime);
		}
		return 0;
	}

	@Override
	public List<CvcMessageTableEntity> checkIfWillAlter() throws Exception {
		String valueNumber = ResourceUtil.searchAllTypesByCode("min","invetoryms");
		if(StringUtils.isEmpty(valueNumber)) {
			return null;
		}
		List<CvcInventoryTableEntity> inventoryTableEntities = findHql("from CvcInventoryTableEntity where goodSize <= ? ", Integer.parseInt(valueNumber));
		if(CollectionUtils.isNotEmpty(inventoryTableEntities)) {
			List<CvcMessageTableEntity> cvcMessageTableEntities = new ArrayList<CvcMessageTableEntity>();
			for (CvcInventoryTableEntity cvcInventoryTableEntity : inventoryTableEntities) {
				List<CvcMessageTableEntity> messageTableEntities = cvcMessageTableService.findHql("from CvcMessageTableEntity where type='I' and  baoLiuValue = ?", cvcInventoryTableEntity.getGoodNumber());
				if(CollectionUtils.isNotEmpty(messageTableEntities)) {
					for(CvcMessageTableEntity cvcMessageTableEntity : messageTableEntities) {
						if(0 == cvcMessageTableEntity.getIfRead()) {
							//消息未读
							cvcMessageTableEntities.add(messageTableEntities.get(0));
							break;
						}else {
							//消息已读 时间是否一致
							if(!cvcMessageTableEntity.getCreateDate().equals(cvcInventoryTableEntity.getUpdateDate())) {
								cvcMessageTableEntity.setCreateDate(cvcInventoryTableEntity.getUpdateDate());
								cvcMessageTableService.saveOrUpdate(cvcMessageTableEntity);
								//创建新消息
								cvcMessageTableEntity = new CvcMessageTableEntity();
								cvcMessageTableEntity.setCreateDate(cvcInventoryTableEntity.getUpdateDate());
								cvcMessageTableEntity.setType("I");
								cvcMessageTableEntity.setIfRead(0);
								cvcMessageTableEntity.setBaoLiuValue(cvcInventoryTableEntity.getGoodNumber());
								cvcMessageTableEntity.setMessageContent("商品"+cvcInventoryTableEntity.getGoodNumber()+"库存已不足"+valueNumber+"，请确认知晓！");
								cvcMessageTableService.save(cvcMessageTableEntity);
								cvcMessageTableEntities.add(cvcMessageTableEntity);
								break;
							}
						}
					}
					
				}else {
					//创建新消息
					CvcMessageTableEntity cvcMessageTableEntity = new CvcMessageTableEntity();
					cvcMessageTableEntity.setCreateDate(cvcInventoryTableEntity.getUpdateDate());
					cvcMessageTableEntity.setType("I");
					cvcMessageTableEntity.setIfRead(0);
					cvcMessageTableEntity.setBaoLiuValue(cvcInventoryTableEntity.getGoodNumber());
					cvcMessageTableEntity.setMessageContent("商品"+cvcInventoryTableEntity.getGoodNumber()+"库存已不足"+valueNumber+"，请确认知晓！");
					try {
						cvcMessageTableService.save(cvcMessageTableEntity);
					} catch (Exception e) {
						e.printStackTrace();
					}
					cvcMessageTableEntities.add(cvcMessageTableEntity);
				}
			}
			return cvcMessageTableEntities;
		}
		return null;
	}
}