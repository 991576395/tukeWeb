package com.xuzy.hotel.tabletag.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.alibaba.fastjson.JSONArray;
import com.xuzy.hotel.tabletag.entity.TTableTagEntity;
import com.xuzy.hotel.tabletag.service.TTableTagServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 餐桌标签表
 * @author onlineGenerator
 * @date 2018-02-25 11:59:01
 * @version V1.0   
 *
 */
@Api(value="TTableTag",description="餐桌标签表",tags="tTableTagController")
@Controller
@RequestMapping("/tTableTagController")
public class TTableTagController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TTableTagController.class);

	@Autowired
	private TTableTagServiceI tTableTagService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@RequestMapping(params = "choiceTableTag")
	public ModelAndView choiceTableTag(HttpServletRequest request) {
		ModelAndView  mv = new ModelAndView("com/xuzy/hotel/tabletag/choiceTableTag");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
	}

	/**
	 * 餐桌标签表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/xuzy/hotel/tabletag/tTableTagList");
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
	public void datagrid(TTableTagEntity tTableTag,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TTableTagEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tTableTag, request.getParameterMap());
		try{
		//自定义追加查询条件
			TSUser user = ResourceUtil.getSessionUser();
			cq.eq("company.id", user.getCompany().getId());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tTableTagService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除餐桌标签表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TTableTagEntity tTableTag, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tTableTag = systemService.getEntity(TTableTagEntity.class, tTableTag.getId());
		message = "餐桌标签表删除成功";
		try{
			tTableTagService.delete(tTableTag);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "餐桌标签表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除餐桌标签表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "餐桌标签表删除成功";
		try{
			for(String id:ids.split(",")){
				TTableTagEntity tTableTag = systemService.getEntity(TTableTagEntity.class, 
				id
				);
				tTableTagService.delete(tTableTag);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "餐桌标签表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加餐桌标签表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TTableTagEntity tTableTag, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "餐桌标签表添加成功";
		try{
			TSUser user = ResourceUtil.getSessionUser();
			tTableTag.setCompany(user.getCompany());
			tTableTagService.save(tTableTag);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "餐桌标签表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新餐桌标签表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TTableTagEntity tTableTag, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "餐桌标签表更新成功";
		TTableTagEntity t = tTableTagService.get(TTableTagEntity.class, tTableTag.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tTableTag, t);
			TSUser user = ResourceUtil.getSessionUser();
			t.setCompany(user.getCompany());
			tTableTagService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "餐桌标签表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 餐桌标签表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TTableTagEntity tTableTag, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tTableTag.getId())) {
			tTableTag = tTableTagService.getEntity(TTableTagEntity.class, tTableTag.getId());
			req.setAttribute("tTableTagPage", tTableTag);
		}
		return new ModelAndView("com/xuzy/hotel/tabletag/tTableTag-add");
	}
	/**
	 * 餐桌标签表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TTableTagEntity tTableTag, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tTableTag.getId())) {
			tTableTag = tTableTagService.getEntity(TTableTagEntity.class, tTableTag.getId());
			req.setAttribute("tTableTagPage", tTableTag);
		}
		return new ModelAndView("com/xuzy/hotel/tabletag/tTableTag-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tTableTagController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TTableTagEntity tTableTag,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TTableTagEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tTableTag, request.getParameterMap());
		List<TTableTagEntity> tTableTags = this.tTableTagService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"餐桌标签表");
		modelMap.put(NormalExcelConstants.CLASS,TTableTagEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("餐桌标签表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tTableTags);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TTableTagEntity tTableTag,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"餐桌标签表");
    	modelMap.put(NormalExcelConstants.CLASS,TTableTagEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("餐桌标签表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TTableTagEntity> listTTableTagEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TTableTagEntity.class,params);
				for (TTableTagEntity tTableTag : listTTableTagEntitys) {
					tTableTagService.save(tTableTag);
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
	@ApiOperation(value="餐桌标签表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TTableTagEntity>> list() {
		List<TTableTagEntity> listTTableTags=tTableTagService.getList(TTableTagEntity.class);
		return Result.success(listTTableTags);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取餐桌标签表信息",notes="根据ID获取餐桌标签表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TTableTagEntity task = tTableTagService.get(TTableTagEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取餐桌标签表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建餐桌标签表")
	public ResponseMessage<?> create(@ApiParam(name="餐桌标签表对象")@RequestBody TTableTagEntity tTableTag, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TTableTagEntity>> failures = validator.validate(tTableTag);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tTableTagService.save(tTableTag);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("餐桌标签表信息保存失败");
		}
		return Result.success(tTableTag);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新餐桌标签表",notes="更新餐桌标签表")
	public ResponseMessage<?> update(@ApiParam(name="餐桌标签表对象")@RequestBody TTableTagEntity tTableTag) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TTableTagEntity>> failures = validator.validate(tTableTag);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tTableTagService.saveOrUpdate(tTableTag);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新餐桌标签表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新餐桌标签表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除餐桌标签表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tTableTagService.deleteEntityById(TTableTagEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("餐桌标签表删除失败");
		}

		return Result.success();
	}
}
