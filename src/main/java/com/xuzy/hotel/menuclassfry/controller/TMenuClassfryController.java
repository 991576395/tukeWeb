package com.xuzy.hotel.menuclassfry.controller;
import com.xuzy.hotel.menuclassfry.entity.TMenuClassfryEntity;
import com.xuzy.hotel.menuclassfry.service.TMenuClassfryServiceI;
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
import org.jeecgframework.core.util.oConvertUtils;
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
 * @Description: 菜单分类表
 * @author onlineGenerator
 * @date 2018-03-04 10:35:16
 * @version V1.0   
 *
 */
@Api(value="TMenuClassfry",description="菜单分类表",tags="tMenuClassfryController")
@Controller
@RequestMapping("/tMenuClassfryController")
public class TMenuClassfryController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TMenuClassfryController.class);

	@Autowired
	private TMenuClassfryServiceI tMenuClassfryService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 菜单分类表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/xuzy/hotel/menuclassfry/tMenuClassfryList");
	}
	
	@RequestMapping(params = "choiceClassfry")
	public ModelAndView choiceTableTag(HttpServletRequest request) {
		ModelAndView  mv = new ModelAndView("com/xuzy/hotel/menuclassfry/choiceMenuClassfry");
		String ids = oConvertUtils.getString(request.getParameter("ids"));
		mv.addObject("ids", ids);
		return mv;
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
	public void datagrid(TMenuClassfryEntity tMenuClassfry,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TMenuClassfryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tMenuClassfry, request.getParameterMap());
		try{
			//自定义追加查询条件
			TSUser user = ResourceUtil.getSessionUser();
			cq.eq("company.id", user.getCompany().getId());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tMenuClassfryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除菜单分类表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TMenuClassfryEntity tMenuClassfry, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tMenuClassfry = systemService.getEntity(TMenuClassfryEntity.class, tMenuClassfry.getId());
		message = "菜单分类表删除成功";
		try{
			tMenuClassfryService.delete(tMenuClassfry);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜单分类表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除菜单分类表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "菜单分类表删除成功";
		try{
			for(String id:ids.split(",")){
				TMenuClassfryEntity tMenuClassfry = systemService.getEntity(TMenuClassfryEntity.class, 
				id
				);
				tMenuClassfryService.delete(tMenuClassfry);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "菜单分类表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加菜单分类表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TMenuClassfryEntity tMenuClassfry, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "菜单分类表添加成功";
		try{
			TSUser user = ResourceUtil.getSessionUser();
			tMenuClassfry.setCompany(user.getCompany());
			
			tMenuClassfryService.save(tMenuClassfry);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "菜单分类表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新菜单分类表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TMenuClassfryEntity tMenuClassfry, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "菜单分类表更新成功";
		TMenuClassfryEntity t = tMenuClassfryService.get(TMenuClassfryEntity.class, tMenuClassfry.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tMenuClassfry, t);
			
			TSUser user = ResourceUtil.getSessionUser();
			t.setCompany(user.getCompany());
			
			tMenuClassfryService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "菜单分类表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 菜单分类表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TMenuClassfryEntity tMenuClassfry, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tMenuClassfry.getId())) {
			tMenuClassfry = tMenuClassfryService.getEntity(TMenuClassfryEntity.class, tMenuClassfry.getId());
			req.setAttribute("tMenuClassfryPage", tMenuClassfry);
		}
		return new ModelAndView("com/xuzy/hotel/menuclassfry/tMenuClassfry-add");
	}
	/**
	 * 菜单分类表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TMenuClassfryEntity tMenuClassfry, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tMenuClassfry.getId())) {
			tMenuClassfry = tMenuClassfryService.getEntity(TMenuClassfryEntity.class, tMenuClassfry.getId());
			req.setAttribute("tMenuClassfryPage", tMenuClassfry);
		}
		return new ModelAndView("com/xuzy/hotel/menuclassfry/tMenuClassfry-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tMenuClassfryController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TMenuClassfryEntity tMenuClassfry,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TMenuClassfryEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tMenuClassfry, request.getParameterMap());
		List<TMenuClassfryEntity> tMenuClassfrys = this.tMenuClassfryService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"菜单分类表");
		modelMap.put(NormalExcelConstants.CLASS,TMenuClassfryEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("菜单分类表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tMenuClassfrys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TMenuClassfryEntity tMenuClassfry,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"菜单分类表");
    	modelMap.put(NormalExcelConstants.CLASS,TMenuClassfryEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("菜单分类表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TMenuClassfryEntity> listTMenuClassfryEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TMenuClassfryEntity.class,params);
				for (TMenuClassfryEntity tMenuClassfry : listTMenuClassfryEntitys) {
					tMenuClassfryService.save(tMenuClassfry);
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
	@ApiOperation(value="菜单分类表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TMenuClassfryEntity>> list() {
		List<TMenuClassfryEntity> listTMenuClassfrys=tMenuClassfryService.getList(TMenuClassfryEntity.class);
		return Result.success(listTMenuClassfrys);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取菜单分类表信息",notes="根据ID获取菜单分类表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TMenuClassfryEntity task = tMenuClassfryService.get(TMenuClassfryEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取菜单分类表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建菜单分类表")
	public ResponseMessage<?> create(@ApiParam(name="菜单分类表对象")@RequestBody TMenuClassfryEntity tMenuClassfry, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TMenuClassfryEntity>> failures = validator.validate(tMenuClassfry);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tMenuClassfryService.save(tMenuClassfry);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("菜单分类表信息保存失败");
		}
		return Result.success(tMenuClassfry);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新菜单分类表",notes="更新菜单分类表")
	public ResponseMessage<?> update(@ApiParam(name="菜单分类表对象")@RequestBody TMenuClassfryEntity tMenuClassfry) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TMenuClassfryEntity>> failures = validator.validate(tMenuClassfry);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tMenuClassfryService.saveOrUpdate(tMenuClassfry);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新菜单分类表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新菜单分类表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除菜单分类表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tMenuClassfryService.deleteEntityById(TMenuClassfryEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("菜单分类表删除失败");
		}

		return Result.success();
	}
}
