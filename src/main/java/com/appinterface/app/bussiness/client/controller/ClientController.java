package com.appinterface.app.bussiness.client.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.HqlQuery;
import org.jeecgframework.core.common.hibernate.qbc.PageList;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.appinterface.app.base.core.entity.request.Requestbody;
import com.appinterface.app.base.core.entity.response.UnipayBaseResponse;
import com.appinterface.app.base.core.freemake.annotation.App;
import com.appinterface.app.base.core.freemake.annotation.AppMethod;
import com.appinterface.app.base.exception.XuException;
import com.appinterface.app.bussiness.client.dto.GetAlertDto;
import com.appinterface.app.bussiness.client.dto.QueryClientDto;
import com.appinterface.app.bussiness.client.dto.ResponseAlertDto;
import com.appinterface.app.bussiness.client.dto.ResponseClientDto;
import com.xuzy.hotel.client.entity.TSClientTableEntity;
import com.xuzy.hotel.client.service.TSClientTableServiceI;

@App
public class ClientController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private TSClientTableServiceI tSClientTableService;
	@Autowired
	private SystemService systemService;
	
	@AppMethod(method="addOrUpdateClientInfo",body=TSClientTableEntity.class)
	public void addOrUpdateClientInfo(TSClientTableEntity tSClientTable,UnipayBaseResponse response) {
		LOGGER.info("-----------addClientInfo-----------");
		String message = null;
		if(tSClientTable != null) {
			if(StringUtils.isEmpty(tSClientTable.getId())) {
				try{
					tSClientTable.setCreateDate(new Date());
					message = "客户表添加成功";
					tSClientTableService.save(tSClientTable);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				}catch(Exception e){
					e.printStackTrace();
					message = "客户表添加失败";
					throw new XuException(message);
				}
			}else {
				message = "客户表更新成功";
				TSClientTableEntity t = tSClientTableService.get(TSClientTableEntity.class, tSClientTable.getId());
				try {
					MyBeanUtils.copyBeanNotNull2Bean(tSClientTable, t);
					t.setUpdateDate(new Date());
					t.setZuijinDate("");
					tSClientTableService.saveOrUpdate(t);
					systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
				} catch (Exception e) {
					e.printStackTrace();
					message = "客户表更新失败";
					throw new BusinessException(message);
				}
			}
		}
		response = UnipayBaseResponse.getSuccessContent(response, null,message);
	}
	
	
	@AppMethod(method="findAllClientInfo",body=QueryClientDto.class)
	public void findAllClientInfo(QueryClientDto dto,UnipayBaseResponse response) {
		LOGGER.info("-----------findAllClientInfo-----------");
		String message = null;
		Map<String, Object> map = tSClientTableService.findOneForJdbc("select count(*) as size  from t_s_client_table order by CREATE_DATE desc");
		Long size = (Long) map.get("size");
		List<TSClientTableEntity> results = null;
		if(size > 0) {
			StringBuffer sb = new StringBuffer();
			sb.append("select *  from t_s_client_table ");
			if(!StringUtils.isEmpty(dto.getOrderSize()) || !StringUtils.isEmpty(dto.getOrderTime())) {
				sb.append("order by ");
//				if(!StringUtils.isEmpty(dto.getOrderSize())) {
//					sb.append("1".equals(dto.getOrderSize())?" CREATE_DATE ":" CREATE_DATE DESC");
//				}
				if(!StringUtils.isEmpty(dto.getOrderTime())) {
					sb.append("1".equals(dto.getOrderTime())?" CREATE_DATE ":" CREATE_DATE DESC");
				}
			}
			results = tSClientTableService.findObjForJdbc(sb.toString(),
					dto.getCurPage(), dto.getPageSize(),TSClientTableEntity.class);
		}
		ResponseClientDto clientDto = new ResponseClientDto();
		clientDto.setCount(size.intValue());
		clientDto.setCurPageNO(dto.getCurPage());
		clientDto.setResults(results);
		
		response = UnipayBaseResponse.getSuccessContent(response,clientDto,message);
	}
	
	@AppMethod(method="findAllName",body=Requestbody.class)
	public void findAllName(Requestbody dto,UnipayBaseResponse response) {
		LOGGER.info("-----------findAllClientInfo-----------");
		String message = null;
		List<TSClientTableEntity> results = null;
		List<Map<String, Object>> mapResults = tSClientTableService.findForJdbc("select id,name from t_s_client_table order by CREATE_DATE desc");
		if(CollectionUtils.isNotEmpty(mapResults)) {
			results = new ArrayList<>();
			for(Map<String, Object> m:mapResults) {
				TSClientTableEntity entity = new TSClientTableEntity();
				entity.setId((String)m.get("id"));
				entity.setName((String)m.get("name"));
				results.add(entity);
			}
		}
		ResponseClientDto clientDto = new ResponseClientDto();
		clientDto.setResults(results);
		response = UnipayBaseResponse.getSuccessContent(response,clientDto,message);
	}
	
	
	@AppMethod(method="deleteClientInfo",body=TSClientTableEntity.class)
	public void deleteClientInfo(TSClientTableEntity tSClientTable,UnipayBaseResponse response) {
		String message = null;
		tSClientTable = systemService.getEntity(TSClientTableEntity.class, tSClientTable.getId());
		message = "客户表删除成功";
		try{
			tSClientTableService.delete(tSClientTable);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客户表删除失败";
			throw new XuException(message);
		}
		response = UnipayBaseResponse.getSuccessContent(response, null,message);
	}
	
	@AppMethod(method="getAlertByDate",body=GetAlertDto.class)
	public void getAlertByDate(GetAlertDto requestDto,UnipayBaseResponse response) {
		String message = null;
		//匹配客户生日
		
		ResponseAlertDto dto = new ResponseAlertDto();
		dto.setAlterBodys(tSClientTableService.getClientBirthday(requestDto.getDate()));
		message = "成功";
		
		response = UnipayBaseResponse.getSuccessContent(response,dto,message);
	}
	
}
