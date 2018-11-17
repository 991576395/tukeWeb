package com.xuzy.hotel.diningtable.controller;
import com.xuzy.hotel.diningtable.entity.TDiningTableEntity;
import com.xuzy.hotel.diningtable.service.TDiningTableServiceI;
import com.xuzy.hotel.tabletag.entity.TDiningTableTag;
import com.xuzy.hotel.tabletag.entity.TTableTagEntity;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 餐桌表
 * @author onlineGenerator
 * @date 2018-02-25 00:06:12
 * @version V1.0   
 *
 */
@Api(value="TDiningTable",description="餐桌表",tags="tDiningTableController")
@Controller
@RequestMapping("/tDiningTableController")
public class TDiningTableController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TDiningTableController.class);

	@Autowired
	private TDiningTableServiceI tDiningTableService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CommonService commonService;

	/**
	 * 餐桌表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/xuzy/hotel/diningtable/tDiningTableList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TDiningTableEntity tDiningTable,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TDiningTableEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tDiningTable, request.getParameterMap());
		try{
			TSUser user = ResourceUtil.getSessionUser();
			cq.eq("company.id", user.getCompany().getId());
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tDiningTableService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除餐桌表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TDiningTableEntity tDiningTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tDiningTable = systemService.getEntity(TDiningTableEntity.class, tDiningTable.getId());
		message = "餐桌表删除成功";
		try{
			tDiningTableService.delete(tDiningTable);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "餐桌表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除餐桌表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "餐桌表删除成功";
		try{
			for(String id:ids.split(",")){
				TDiningTableEntity tDiningTable = systemService.getEntity(TDiningTableEntity.class, 
				id
				);
				tDiningTableService.delete(tDiningTable);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "餐桌表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加餐桌表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TDiningTableEntity tDiningTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "餐桌表添加成功";
		String tags = request.getParameter("tableTagId");
		try{
			TSUser user = ResourceUtil.getSessionUser();
			tDiningTable.setCompany(user.getCompany());
			
			List<TDiningTableTag> tdiningTableTags = new ArrayList<TDiningTableTag>();
			//添加餐桌标签
			String[] tagsArr = tags.split(",");
			for(String tag:tagsArr){
				TDiningTableTag diningTag = new TDiningTableTag();
				TTableTagEntity tagEctity = new TTableTagEntity();
				tagEctity.setId(tag);
				diningTag.setTableTag(tagEctity);
				diningTag.setDiningTable(tDiningTable);
				
				tdiningTableTags.add(diningTag);
			}
			tDiningTable.setTdiningTableTags(tdiningTableTags);
			tDiningTableService.save(tDiningTable);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "餐桌表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新餐桌表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TDiningTableEntity tDiningTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "餐桌表更新成功";
		TDiningTableEntity t = tDiningTableService.get(TDiningTableEntity.class, tDiningTable.getId());
		String tags = request.getParameter("tableTagId");
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tDiningTable, t);
			
			commonService.executeSql("delete from t_dining_table_tag where dining_table_id=?",t.getId());
			
			List<TDiningTableTag> tdiningTableTags = new ArrayList<TDiningTableTag>();
			//添加餐桌标签
			String[] tagsArr = tags.split(",");
			for(String tag:tagsArr){
				TDiningTableTag diningTag = new TDiningTableTag();
				TTableTagEntity tagEctity = new TTableTagEntity();
				tagEctity.setId(tag);
				diningTag.setTableTag(tagEctity);
				diningTag.setDiningTable(tDiningTable);
				
				tdiningTableTags.add(diningTag);
			}
			t.setTdiningTableTags(tdiningTableTags);
			
			TSUser user = ResourceUtil.getSessionUser();
			t.setCompany(user.getCompany());
			
			tDiningTableService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "餐桌表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 餐桌表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TDiningTableEntity tDiningTable, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tDiningTable.getId())) {
			tDiningTable = tDiningTableService.getEntity(TDiningTableEntity.class, tDiningTable.getId());
			req.setAttribute("tDiningTablePage", tDiningTable);
		}
		return new ModelAndView("com/xuzy/hotel/diningtable/tDiningTable-add");
	}
	/**
	 * 餐桌表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TDiningTableEntity tDiningTable, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tDiningTable.getId())) {
			tDiningTable = tDiningTableService.getEntity(TDiningTableEntity.class, tDiningTable.getId());
			
			List<TDiningTableTag> tags = tDiningTable.getTdiningTableTags();
			StringBuilder tagIds = new StringBuilder();
			StringBuilder tagNames = new StringBuilder();
			for(TDiningTableTag tag:tags){
				tagIds.append(tag.getTableTag().getId());
				tagIds.append(",");
				tagNames.append(tag.getTableTag().getTagName());
				tagNames.append(",");
			}
			if(tagIds.length() > 0){
				tagIds.deleteCharAt(tagIds.length()-1);
				tagNames.deleteCharAt(tagNames.length()-1);
			}
			req.setAttribute("tableTagId", tagIds.toString());
			req.setAttribute("tagName", tagNames.toString());
			req.setAttribute("tDiningTablePage", tDiningTable);
		}
		return new ModelAndView("com/xuzy/hotel/diningtable/tDiningTable-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tDiningTableController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TDiningTableEntity tDiningTable,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TDiningTableEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tDiningTable, request.getParameterMap());
		List<TDiningTableEntity> tDiningTables = this.tDiningTableService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"餐桌表");
		modelMap.put(NormalExcelConstants.CLASS,TDiningTableEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("餐桌表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tDiningTables);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TDiningTableEntity tDiningTable,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"餐桌表");
    	modelMap.put(NormalExcelConstants.CLASS,TDiningTableEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("餐桌表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<TDiningTableEntity> listTDiningTableEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TDiningTableEntity.class,params);
				for (TDiningTableEntity tDiningTable : listTDiningTableEntitys) {
					tDiningTableService.save(tDiningTable);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="餐桌表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TDiningTableEntity>> list() {
		List<TDiningTableEntity> listTDiningTables=tDiningTableService.getList(TDiningTableEntity.class);
		return Result.success(listTDiningTables);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取餐桌表信息",notes="根据ID获取餐桌表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TDiningTableEntity task = tDiningTableService.get(TDiningTableEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取餐桌表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建餐桌表")
	public ResponseMessage<?> create(@ApiParam(name="餐桌表对象")@RequestBody TDiningTableEntity tDiningTable, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TDiningTableEntity>> failures = validator.validate(tDiningTable);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tDiningTableService.save(tDiningTable);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("餐桌表信息保存失败");
		}
		return Result.success(tDiningTable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新餐桌表",notes="更新餐桌表")
	public ResponseMessage<?> update(@ApiParam(name="餐桌表对象")@RequestBody TDiningTableEntity tDiningTable) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TDiningTableEntity>> failures = validator.validate(tDiningTable);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tDiningTableService.saveOrUpdate(tDiningTable);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新餐桌表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新餐桌表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除餐桌表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tDiningTableService.deleteEntityById(TDiningTableEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("餐桌表删除失败");
		}

		return Result.success();
	}
}
