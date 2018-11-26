package com.xuzy.hotel.getorderstatistics.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.reflect.TypeToken;
import com.util.PhpDateUtils;
import com.xuzy.hotel.getorderstatistics.entity.CvcGetOrderStatisticsEntity;
import com.xuzy.hotel.getorderstatistics.service.CvcGetOrderStatisticsService;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.ylrequest.Config;
import com.xuzy.hotel.ylrequest.ConmentHttp;
import com.xuzy.hotel.ylrequest.ResponseHead;
import com.xuzy.hotel.ylrequest.TukeRequestBody;
import com.xuzy.hotel.ylrequest.module.RequestGetExchangeOrderListWaitDeliveryJson;
import com.xuzy.hotel.ylrequest.module.RequestSetOrdersReadJson;
import com.xuzy.hotel.ylrequest.module.order.ExchangeOrder;

 /**
 * 描述：抓单表
 * @author: www.jeecg.org
 * @since：2018年11月10日 17时34分59秒 星期六 
 * @version:1.0
 */
@Controller
@RequestMapping("/cvcGetOrderStatistics")
public class CvcGetOrderStatisticsController extends BaseController{
  @Autowired
  private CvcGetOrderStatisticsService cvcGetOrderStatisticsService;
  
  @Autowired
  private CvcOrderInfoService cvcOrderInfoService;
  
  /**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/xuzy/hotel/getorderstatistics/getOrderStatisticsList");
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
	public void datagrid(CvcGetOrderStatisticsEntity query,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		MiniDaoPage<CvcGetOrderStatisticsEntity> list = cvcGetOrderStatisticsService.getAll(query, dataGrid.getPage(), dataGrid.getRows());
		dataGrid.setResults(SystemTools.convertPaginatedList(list));
		dataGrid.setTotal(cvcGetOrderStatisticsService.getCount(query, dataGrid.getPage(), dataGrid.getRows()));
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "toGetOrderList")
	public ModelAndView toGetOrderList(HttpServletRequest request) {
		return new ModelAndView("com/xuzy/hotel/getorderstatistics/getOrder");
	}
	
	
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "getOrderData")
	public void getOrderData(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		MiniDaoPage<CvcGetOrderStatisticsEntity> list = cvcGetOrderStatisticsService.getAll(query, dataGrid.getPage(), dataGrid.getRows());
//		dataGrid.setResults(SystemTools.convertPaginatedList(list));
//		dataGrid.setTotal(cvcGetOrderStatisticsService.getCount(query, dataGrid.getPage(), dataGrid.getRows()));
//		TagUtil.datagrid(response, dataGrid);
		String ifLoad = request.getParameter("ifLoad")==null?"":request.getParameter("ifLoad");
		if(StringUtils.isEmpty(ifLoad)) {
			dataGrid.setResults(SystemTools.convertPaginatedList(null));
			dataGrid.setTotal(0);
			TagUtil.datagrid(response, dataGrid);
			return;
		}
		RequestGetExchangeOrderListWaitDeliveryJson requestGetExchangeOrderListWaitDeliveryJson = new RequestGetExchangeOrderListWaitDeliveryJson();
		requestGetExchangeOrderListWaitDeliveryJson.setDeliverer(Config.DELIVERER);
		CvcGetOrderStatisticsEntity cvcGetOrderStatisticsEntity = null;
		//抓单
		try {
			ResponseHead head =  ConmentHttp.sendHttp(new TukeRequestBody.Builder()
					.setSequence(3).setParams(requestGetExchangeOrderListWaitDeliveryJson)
					.setServiceCode("CRMIF.GetExchangeOrderListWaitDeliveryJson").builder(), ExchangeOrder.class);
			if(head.getReturn() >= 0) {
				List<ExchangeOrder> exchangeOrders = ConmentHttp.gson.fromJson(head.getResult(), new TypeToken<List<ExchangeOrder>>(){}.getType());
				if(CollectionUtils.isNotEmpty(exchangeOrders)) {
					cvcGetOrderStatisticsEntity = cvcGetOrderStatisticsService.addOrUpdateOrder(exchangeOrders);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(cvcGetOrderStatisticsEntity != null) {
			String unified_batch_no  = DateFormatUtils.format(Calendar.getInstance(), "yyyyMMdd");
			CvcOrderInfoEntity query = new CvcOrderInfoEntity();
			query.setBatchNo(unified_batch_no);
//			query.setBatchNo("20181102");
			MiniDaoPage<CvcOrderInfoEntity> list = cvcOrderInfoService.getAll(query, dataGrid.getPage(), dataGrid.getRows());
			if(CollectionUtils.isNotEmpty(list.getResults())) {
				for (CvcOrderInfoEntity entity : list.getResults()) {
					entity.setAddTime(PhpDateUtils.parseDate(Long.parseLong(entity.getAddTime()), "yyyy-MM-dd HH:mm:ss"));
					entity.setGetTime(PhpDateUtils.parseDate(Long.parseLong(entity.getGetTime()), "yyyy-MM-dd HH:mm:ss"));
				}
			}
			dataGrid.setResults(SystemTools.convertPaginatedList(list));
			dataGrid.setTotal(cvcOrderInfoService.getCount(query, dataGrid.getPage(), dataGrid.getRows()));
			TagUtil.datagrid(response, dataGrid);
		}
	}
	
	
	
	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void cvcGetOrderStatisticsDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "hotel/getorderstatistics/cvcGetOrderStatistics-detail.vm";
			CvcGetOrderStatisticsEntity cvcGetOrderStatistics = cvcGetOrderStatisticsService.get(id);
			velocityContext.put("cvcGetOrderStatistics",cvcGetOrderStatistics);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}
	
	
	/**
	 * 确认订单
	 * @return
	 */
	@RequestMapping(params = "setOrderRead",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson setOrderRead(@RequestParam(required = true, value = "batchNo")String batchNo){
		AjaxJson j = new AjaxJson();
		try {
			List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoService.getCanReadOrders(batchNo);
			if(CollectionUtils.isEmpty(cvcOrderInfoEntities)) {
				j.setSuccess(false);
				j.setMsg("无可确认订单，请刷新页面重试！");
				return j; 
			}
			
			StringBuffer sb = new StringBuffer();
			for (CvcOrderInfoEntity cvcOrderInfoEntity : cvcOrderInfoEntities) {
				sb.append(cvcOrderInfoEntity.getId());
				sb.append(",");
			}
			if(sb.length() > 0) {
				sb.deleteCharAt(sb.length()-1);
			}
			
			RequestSetOrdersReadJson params = new RequestSetOrdersReadJson();
			params.setOrderIDs(sb.toString());
			ResponseHead head = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
					.setSequence(2)
					.setServiceCode("CRMIF.SetOrdersReadJson")
					.setParams(params).builder(), null);
			if(head.getReturn() >= 0) {
				cvcGetOrderStatisticsService.addwaitDeliveryCount(cvcOrderInfoEntities.size(),batchNo);
				
				j.setSuccess(true);
				j.setMsg("你已成功读取"+cvcOrderInfoEntities.size()+"个订单!");
			}else {
				j.setSuccess(false);
				j.setMsg("确认失败，原因:伊利接口调用失败!");
				return j;
			}
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "hotel/getorderstatistics/cvcGetOrderStatistics-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	

	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@RequestMapping(params="toEdit",method = RequestMethod.GET)
	public void toEdit(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request) throws Exception{
			 VelocityContext velocityContext = new VelocityContext();
			 CvcGetOrderStatisticsEntity cvcGetOrderStatistics = cvcGetOrderStatisticsService.get(id);
			 velocityContext.put("cvcGetOrderStatistics",cvcGetOrderStatistics);
			 String viewName = "hotel/getorderstatistics/cvcGetOrderStatistics-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute CvcGetOrderStatisticsEntity cvcGetOrderStatistics){
		AjaxJson j = new AjaxJson();
		try {
			cvcGetOrderStatisticsService.update(cvcGetOrderStatistics);
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
	@RequestMapping(params="doDelete",method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) String id){
			AjaxJson j = new AjaxJson();
			try {
				cvcGetOrderStatisticsService.delete(id);
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
			cvcGetOrderStatisticsService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("批量删除失败");
		}
		return j;
	}

}

