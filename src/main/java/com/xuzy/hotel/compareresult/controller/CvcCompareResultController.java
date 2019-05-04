package com.xuzy.hotel.compareresult.controller;
import com.xuzy.hotel.compareresult.entity.CvcCompareResultEntity;
import com.xuzy.hotel.compareresult.service.CvcCompareResultServiceI;
import com.xuzy.hotel.offermoney.service.CvcOfferMoneyServiceI;

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
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
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
import org.apache.commons.collections.CollectionUtils;
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
 * @Description: 对比结果表
 * @author onlineGenerator
 * @date 2019-05-03 15:12:05
 * @version V1.0   
 *
 */
@Api(value="CvcCompareResult",description="对比结果表",tags="cvcCompareResultController")
@Controller
@RequestMapping("/cvcCompareResultController")
public class CvcCompareResultController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CvcCompareResultController.class);

	@Autowired
	private CvcCompareResultServiceI cvcCompareResultService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	@Autowired
	private CvcOfferMoneyServiceI cvcOfferMoneyService;

	/**
	 * 对比结果表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		
		return new ModelAndView("com/xuzy/hotel/compareresult/cvcCompareResultList");
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
	public void datagrid(CvcCompareResultEntity cvcCompareResult,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		try {
			cvcOfferMoneyService.calculateOther();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CriteriaQuery cq = new CriteriaQuery(CvcCompareResultEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, cvcCompareResult, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.cvcCompareResultService.getDataGridReturn(cq, true);
		
		
		TagUtil.datagrid(response, dataGrid);
	}
	

	/**
	 * 删除对比结果表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(CvcCompareResultEntity cvcCompareResult, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		cvcCompareResult = systemService.getEntity(CvcCompareResultEntity.class, cvcCompareResult.getId());
		message = "对比结果表删除成功";
		try{
			cvcCompareResultService.delete(cvcCompareResult);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "对比结果表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除对比结果表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "对比结果表删除成功";
		try{
			for(String id:ids.split(",")){
				CvcCompareResultEntity cvcCompareResult = systemService.getEntity(CvcCompareResultEntity.class, 
				id
				);
				cvcCompareResultService.delete(cvcCompareResult);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "对比结果表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加对比结果表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(CvcCompareResultEntity cvcCompareResult, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "对比结果表添加成功";
		try{
			cvcCompareResultService.save(cvcCompareResult);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "对比结果表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新对比结果表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(CvcCompareResultEntity cvcCompareResult, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "对比结果表更新成功";
		CvcCompareResultEntity t = cvcCompareResultService.get(CvcCompareResultEntity.class, cvcCompareResult.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(cvcCompareResult, t);
			cvcCompareResultService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "对比结果表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 对比结果表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(CvcCompareResultEntity cvcCompareResult, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(cvcCompareResult.getId())) {
			cvcCompareResult = cvcCompareResultService.getEntity(CvcCompareResultEntity.class, cvcCompareResult.getId());
			req.setAttribute("cvcCompareResultPage", cvcCompareResult);
		}
		return new ModelAndView("com/xuzy/hotel/compareresult/cvcCompareResult-add");
	}
	/**
	 * 对比结果表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(CvcCompareResultEntity cvcCompareResult, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(cvcCompareResult.getId())) {
			cvcCompareResult = cvcCompareResultService.getEntity(CvcCompareResultEntity.class, cvcCompareResult.getId());
			req.setAttribute("cvcCompareResultPage", cvcCompareResult);
		}
		return new ModelAndView("com/xuzy/hotel/compareresult/cvcCompareResult-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","cvcCompareResultController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(CvcCompareResultEntity cvcCompareResult,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(CvcCompareResultEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, cvcCompareResult, request.getParameterMap());
		List<CvcCompareResultEntity> cvcCompareResults = this.cvcCompareResultService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"对比结果表");
		modelMap.put(NormalExcelConstants.CLASS,CvcCompareResultEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("对比结果表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,cvcCompareResults);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(CvcCompareResultEntity cvcCompareResult,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"对比结果表");
    	modelMap.put(NormalExcelConstants.CLASS,CvcCompareResultEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("对比结果表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<CvcCompareResultEntity> listCvcCompareResultEntitys = ExcelImportUtil.importExcel(file.getInputStream(),CvcCompareResultEntity.class,params);
				for (CvcCompareResultEntity cvcCompareResult : listCvcCompareResultEntitys) {
					cvcCompareResultService.save(cvcCompareResult);
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
	@ApiOperation(value="对比结果表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<CvcCompareResultEntity>> list() {
		List<CvcCompareResultEntity> listCvcCompareResults=cvcCompareResultService.getList(CvcCompareResultEntity.class);
		return Result.success(listCvcCompareResults);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取对比结果表信息",notes="根据ID获取对比结果表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		CvcCompareResultEntity task = cvcCompareResultService.get(CvcCompareResultEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取对比结果表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建对比结果表")
	public ResponseMessage<?> create(@ApiParam(name="对比结果表对象")@RequestBody CvcCompareResultEntity cvcCompareResult, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CvcCompareResultEntity>> failures = validator.validate(cvcCompareResult);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			cvcCompareResultService.save(cvcCompareResult);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("对比结果表信息保存失败");
		}
		return Result.success(cvcCompareResult);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新对比结果表",notes="更新对比结果表")
	public ResponseMessage<?> update(@ApiParam(name="对比结果表对象")@RequestBody CvcCompareResultEntity cvcCompareResult) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<CvcCompareResultEntity>> failures = validator.validate(cvcCompareResult);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			cvcCompareResultService.saveOrUpdate(cvcCompareResult);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新对比结果表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新对比结果表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除对比结果表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			cvcCompareResultService.deleteEntityById(CvcCompareResultEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("对比结果表删除失败");
		}

		return Result.success();
	}
}
