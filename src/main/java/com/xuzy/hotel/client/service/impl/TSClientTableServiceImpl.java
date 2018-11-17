package com.xuzy.hotel.client.service.impl;
import com.xuzy.hotel.client.service.TSClientTableServiceI;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.appinterface.app.bussiness.client.dto.AlertBodyModule;
import com.xuzy.hotel.client.entity.TSClientTableEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import java.text.ParseException;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("tSClientTableService")
@Transactional
public class TSClientTableServiceImpl extends CommonServiceImpl implements TSClientTableServiceI {

	
 	public void delete(TSClientTableEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TSClientTableEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TSClientTableEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TSClientTableEntity t) throws Exception{
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
	private void doUpdateBus(TSClientTableEntity t) throws Exception{
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
	private void doDelBus(TSClientTableEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TSClientTableEntity t){
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
		map.put("name", t.getName());
		map.put("birthday", t.getBirthday());
		map.put("sex", t.getSex());
		map.put("address", t.getAddress());
		map.put("phone", t.getPhone());
		map.put("commpany", t.getCommpany());
		map.put("content", t.getContent());
		map.put("startorderdate", t.getStartorderdate());
		map.put("orderperiod", t.getOrderperiod());
		map.put("ordertype", t.getOrdertype());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TSClientTableEntity t){
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
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{birthday}",String.valueOf(t.getBirthday()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{address}",String.valueOf(t.getAddress()));
 		sql  = sql.replace("#{phone}",String.valueOf(t.getPhone()));
 		sql  = sql.replace("#{commpany}",String.valueOf(t.getCommpany()));
 		sql  = sql.replace("#{content}",String.valueOf(t.getContent()));
 		sql  = sql.replace("#{startorderdate}",String.valueOf(t.getStartorderdate()));
 		sql  = sql.replace("#{orderperiod}",String.valueOf(t.getOrderperiod()));
 		sql  = sql.replace("#{ordertype}",String.valueOf(t.getOrdertype()));
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
					javaInter.execute("t_s_client_table",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}

	@Override
	public List<AlertBodyModule> getClientBirthday(String yearMouth) {
		Date date = null;
		try {
			date = DateUtils.parseDate(yearMouth, new String[] {"yyyyMM"});
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		//开始时间
		date = calendar.getTime();
//		String startDate = DateFormatUtils.format(calendar, "MMdd");
		calendar.add(Calendar.MONTH, 3);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		Date endDate = calendar.getTime();
		//结束时间
//		String endDate = DateFormatUtils.format(calendar, "MMdd");
//		List<TSClientTableEntity> entitys = this.findHql("from TSClientTableEntity where SUBSTR(birthday,5,4) > ? and SUBSTR(birthday,5,4) < ?", startDate,endDate);
		List<TSClientTableEntity> entitys = this.findHql("from TSClientTableEntity ");
		if(!CollectionUtils.isEmpty(entitys)) {
			List<AlertBodyModule> bodyModule =  new ArrayList<>();
			for(TSClientTableEntity entity : entitys) {
				if(StringUtils.isNotEmpty(entity.getBirthday())) {
					//开始生日处理
					Date birthdayDate = null;
					try {
						birthdayDate = DateUtils.parseDate(entity.getBirthday(), new String[] {"yyyyMMdd"});
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Calendar birthdayCalendar = Calendar.getInstance();
					birthdayCalendar.setTime(birthdayDate);
					birthdayCalendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
					birthdayDate = birthdayCalendar.getTime();
					if(birthdayDate.after(date) && birthdayDate.before(endDate)) {
						//生日
						bodyModule.add(new AlertBodyModule(DateFormatUtils.format(birthdayDate, "yyyy-MM-dd"),"1",entity.getName()+("男".equals(entity.getSex())?"先生":"女士")+"生日"));
					}
				}
				
				String startDate = StringUtils.isNotEmpty(entity.getZuijinDate())?entity.getZuijinDate():entity.getStartorderdate();
				if(StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(entity.getOrderperiod())
						&& StringUtils.isNotEmpty(entity.getOrdertype())) {
					//开始需单逻辑
					Date xudanDate = null;
					try {
						xudanDate = DateUtils.parseDate(startDate, new String[] {"yyyy-MM-dd","yyyyMMdd"});
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Calendar xudanCalendar = Calendar.getInstance();
					xudanCalendar.setTime(xudanDate);
					//xudanCalendar.getTime().after(date) && 
					boolean ifSave = true;
					while(xudanCalendar.getTime().before(endDate)) {
						if(xudanCalendar.getTime().after(date)) {
							//不处于时间区域内
							if(ifSave) {
								//保存第一次满足条件时时间
								entity.setZuijinDate(DateFormatUtils.format(xudanCalendar, "yyyyMMdd"));
								super.saveOrUpdate(entity);
								ifSave = false;
								bodyModule.add(new AlertBodyModule(DateFormatUtils.format(xudanCalendar, "yyyy-MM-dd"),"2",entity.getName()+("男".equals(entity.getSex())?"先生":"女士")+"需要续单"));
							}
						}
						switch (entity.getOrdertype()) {
							case "1":
								//天
								xudanCalendar.add(Calendar.DAY_OF_YEAR, Integer.parseInt(entity.getOrderperiod()));
								break;
							case "2":
								//周
								xudanCalendar.add(Calendar.WEEK_OF_YEAR, Integer.parseInt(entity.getOrderperiod()));
								break;
							case "3":
								//月
								xudanCalendar.add(Calendar.MONTH, Integer.parseInt(entity.getOrderperiod()));
								break;
						}
						if(!xudanCalendar.getTime().after(date)) {
							//不处于时间区域内
							continue;
						}
						
						bodyModule.add(new AlertBodyModule(DateFormatUtils.format(xudanCalendar, "yyyy-MM-dd"),"2",entity.getName()+("男".equals(entity.getSex())?"先生":"女士")+"需要续单"));
					}
				}
			}
			return bodyModule;
		}
		return null;
	}
}