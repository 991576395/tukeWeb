package com.xuzy.hotel.menutable.controller;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSAttachment;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.jeecg.demo.entity.TSDocument;
import com.xuzy.hotel.menuclassfry.entity.TMenuClassfryEntity;
import com.xuzy.hotel.menutable.entity.TMenuTableEntity;
import com.xuzy.hotel.menutable.service.TMenuTableServiceI;

/**   
 * @Title: Controller
 * @Description: 菜名维护
 * @author zhangdaihao
 * @date 2018-03-04 10:57:18
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tMenuTableController")
public class TMenuTableController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TMenuTableController.class);

	@Autowired
	private TMenuTableServiceI tMenuTableService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	

	/**
	 * 菜名维护列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/xuzy/hotel/menu/tMenuTableList");
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
	public void datagrid(TMenuTableEntity tMenuTable,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TMenuTableEntity.class, dataGrid);
		//查询条件组装器
		try{
			//自定义追加查询条件
			TSUser user = ResourceUtil.getSessionUser();
			cq.eq("company.id", user.getCompany().getId());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tMenuTable, request.getParameterMap());
		this.tMenuTableService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除菜名维护
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TMenuTableEntity tMenuTable, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tMenuTable = systemService.getEntity(TMenuTableEntity.class, tMenuTable.getId());
		//删除原有文件
		systemService.delete(tMenuTable.getFileid());
		
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		File file = new File(getUploadBasePath(request)+File.separator+tMenuTable.getFileid().getRealpath());
		logger.info("--删除附件---"+getUploadBasePath(request)+File.separator+tMenuTable.getFileid().getRealpath()+" ---结果："+file.delete());
		
		message = "菜名维护删除成功";
		tMenuTableService.delete(tMenuTable);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}

	/**
	 * 保存文件
	 *
	 * @param document
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TSAttachment document) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		UploadFile uploadFile = new UploadFile(request, document);
		uploadFile.setCusPath("files");
		//设置weboffice转化【不设置该字段，则不做在线预览转化】
		uploadFile.setSwfpath("swfpath");
		document = systemService.uploadFile(uploadFile);
		attributes.put("url", document.getRealpath());
		attributes.put("fileKey", document.getId());
		attributes.put("name", document.getAttachmenttitle());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + document.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + document.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);
		return j;
	}
	
	/**
	 * 添加菜名维护
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TMenuTableEntity tMenuTable,HttpServletRequest request, HttpServletResponse response) {
		String message = null;
		AjaxJson j = new AjaxJson();
		TSUser user = ResourceUtil.getSessionUser();
		tMenuTable.setCompany(user.getCompany());
		if (StringUtil.isNotEmpty(tMenuTable.getId())) {
			message = "菜名维护更新成功";
			TMenuTableEntity t = tMenuTableService.get(TMenuTableEntity.class, tMenuTable.getId());
			try {
				if(!t.getFileid().getId().equals(tMenuTable.getFileid().getId())){
					//删除原有文件
					systemService.delete(t.getFileid());
					
					systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
					File file = new File(getUploadBasePath(request)+File.separator+t.getFileid().getRealpath());
					logger.info("--删除附件---"+getUploadBasePath(request)+File.separator+t.getFileid().getRealpath()+" ---结果："+file.delete());
				}
				MyBeanUtils.copyBeanNotNull2Bean(tMenuTable, t);
				tMenuTableService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "菜名维护更新失败";
			}
		} else {
			message = "菜名维护添加成功";
			tMenuTableService.save(tMenuTable);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}
	
	//获取上传根路径
	private String getUploadBasePath(HttpServletRequest request){

		String path=request.getSession().getServletContext().getRealPath("/");

//		ClassLoader classLoader = this.getClass().getClassLoader();  
//        URL resource = classLoader.getResource("sysConfig.properties");  
//        String path = resource.getPath(); 
//        path = path.substring(0,path.indexOf("sysConfig.properties"))+"online/template";
//		String path= this.getClass().getResource("/").getPath()+"online/template";

        path = path.replaceAll("%20", " ");//解决tomcat安装路径包含空格的问题
		return path;
	}

	/**
	 * 菜名维护列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TMenuTableEntity tMenuTable, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tMenuTable.getId())) {
			tMenuTable = tMenuTableService.getEntity(TMenuTableEntity.class, tMenuTable.getId());
			req.setAttribute("tMenuTablePage", tMenuTable);
		}
		return new ModelAndView("com/xuzy/hotel/menu/tMenuTable");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<TMenuTableEntity> list() {
		List<TMenuTableEntity> listTMenuTables=tMenuTableService.getList(TMenuTableEntity.class);
		return listTMenuTables;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		TMenuTableEntity task = tMenuTableService.get(TMenuTableEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TMenuTableEntity tMenuTable, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TMenuTableEntity>> failures = validator.validate(tMenuTable);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		tMenuTableService.save(tMenuTable);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = tMenuTable.getId();
		URI uri = uriBuilder.path("/rest/tMenuTableController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TMenuTableEntity tMenuTable) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TMenuTableEntity>> failures = validator.validate(tMenuTable);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		tMenuTableService.saveOrUpdate(tMenuTable);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		tMenuTableService.deleteEntityById(TMenuTableEntity.class, id);
	}
}
