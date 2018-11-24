package com.xuzy.hotel.shippingbatch.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.util.PhpDateUtils;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.shippingbatch.entity.CvcShippingBatchEntity;
import com.xuzy.hotel.shippingbatch.service.CvcShippingBatchService;
import com.xuzy.hotel.shippingbatchorder.entity.CvcShippingBatchOrderEntity;
import com.xuzy.hotel.shippingbatchorder.service.CvcShippingBatchOrderService;

 /**
 * 描述：批量发货表
 * @author: www.jeecg.org
 * @since：2018年11月20日 20时41分17秒 星期二 
 * @version:1.0
 */
@Controller
@RequestMapping("/cvcShippingBatch")
public class CvcShippingBatchController extends BaseController{
  @Autowired
  private CvcShippingBatchService cvcShippingBatchService;
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	 @Autowired
	 private CvcShippingBatchOrderService cvcShippingBatchOrderService;
  
  
  /**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CvcShippingBatchController.class);
  
	/**
	 * 列表页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "toList", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(HttpServletRequest request) throws Exception {
		return new ModelAndView("com/xuzy/hotel/shippingbatch/batchList");
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(CvcShippingBatchEntity query,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		MiniDaoPage<CvcShippingBatchEntity> list = cvcShippingBatchService.getAll(query, dataGrid.getPage(), dataGrid.getRows());
		if(CollectionUtils.isNotEmpty(list.getResults())) {
			for (CvcShippingBatchEntity entity : list.getResults()) {
				entity.setAddTimeFormat(PhpDateUtils.parseDate(entity.getAddTime(), "yyyy-MM-dd HH:mm:ss"));
				if(entity.getMsgStatus() == 1) {
					entity.setMsgStatusStr("<font color=\"red\">是</font>");
				}else {
					entity.setMsgStatusStr("否");
				}
			}
		}
		dataGrid.setResults(SystemTools.convertPaginatedList(list));
		dataGrid.setTotal(cvcShippingBatchService.getCount(query));
		TagUtil.datagrid(response, dataGrid);
	}

	
	/**
	 * 列表页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "toUpload", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView toUpload(HttpServletRequest request) throws Exception {
//		return new ModelAndView("com/xuzy/hotel/shippingbatch/uploadfile");
		return new ModelAndView("com/xuzy/hotel/shippingbatch/uploadfileCom");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		String orderBatchNo = request.getParameter("orderBatchNo");
		if(StringUtils.isEmpty(orderBatchNo)) {
			j.setSuccess(false);
			j.setMsg("订单批次号不能为空！");
			return j;
		}
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(0);
			params.setHeadRows(4);
			params.setNeedSave(true);
			try {
				List<CvcShippingBatchOrderEntity> batchOrderEntities = ExcelImportUtil.importExcel(file.getInputStream(),
						CvcShippingBatchOrderEntity.class, params);
				if (CollectionUtils.isNotEmpty(batchOrderEntities)) {
					cvcShippingBatchOrderService.batchInsert(batchOrderEntities, orderBatchNo);
					j.setMsg("文件导入成功！");
				}else {
					j.setMsg("识别内容为空");
					j.setSuccess(false);
				}
			} catch (Exception e) {
				j.setSuccess(false);
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			} finally {
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void cvcShippingBatchDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "hotel/shippingbatch/cvcShippingBatch-detail.vm";
			CvcShippingBatchEntity cvcShippingBatch = cvcShippingBatchService.get(id);
			velocityContext.put("cvcShippingBatch",cvcShippingBatch);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "hotel/shippingbatch/cvcShippingBatch-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute CvcShippingBatchEntity cvcShippingBatch){
		AjaxJson j = new AjaxJson();
		try {
			cvcShippingBatchService.insert(cvcShippingBatch);
			j.setMsg("保存成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
			 VelocityContext velocityContext = new VelocityContext();
			 CvcShippingBatchEntity cvcShippingBatch = cvcShippingBatchService.get(id);
			 velocityContext.put("cvcShippingBatch",cvcShippingBatch);
			 String viewName = "hotel/shippingbatch/cvcShippingBatch-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute CvcShippingBatchEntity cvcShippingBatch){
		AjaxJson j = new AjaxJson();
		try {
			cvcShippingBatchService.update(cvcShippingBatch);
			j.setMsg("编辑成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("编辑失败");
		}
		return j;
	}


	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(params="doDel",method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "batchNo" ) String batchNo){
			AjaxJson j = new AjaxJson();
			try {
				cvcShippingBatchService.delete(batchNo);
				j.setMsg("删除成功");
			} catch (Exception e) {
			    log.info(e.getMessage());
				j.setSuccess(false);
				j.setMsg("删除失败");
			}
			return j;
	}
	
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	@RequestMapping(params="batchDelete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(required = true, value = "ids") String[] ids) {
		AjaxJson j = new AjaxJson();
		try {
			cvcShippingBatchService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("批量删除失败");
		}
		return j;
	}

}

