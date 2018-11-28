package com.xuzy.hotel.shippingbatchorder.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.shippingbatchorder.entity.CvcShippingBatchOrderEntity;
import com.xuzy.hotel.shippingbatchorder.entity.ResponseTotelEntity;
import com.xuzy.hotel.shippingbatchorder.service.CvcShippingBatchOrderService;

 /**
 * 描述：批量发货订单表
 * @author: www.jeecg.org
 * @since：2018年11月21日 20时52分03秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/cvcShippingBatchOrder")
public class CvcShippingBatchOrderController extends BaseController{
	 @Autowired
	 private CvcShippingBatchOrderService cvcShippingBatchOrderService;
	 
	 @Autowired
		private CvcOrderInfoService cvcOrderInfoService;

	/**
	 * 列表页面
	 * 
	 * @return
	 */
	@RequestMapping(params = "toList", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(HttpServletRequest request) throws Exception {
		String batchNo = request.getParameter("batchNo");
		request.setAttribute("batchNo", batchNo);
		return new ModelAndView("com/xuzy/hotel/shippingbatch/batchOrderList");
	}
	
	@RequestMapping(params = "datagrid")
	public void datagrid(CvcShippingBatchOrderEntity query,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		MiniDaoPage<CvcShippingBatchOrderEntity> list = cvcShippingBatchOrderService.getAll(query, dataGrid.getPage(), dataGrid.getRows());
		if(CollectionUtils.isNotEmpty(list.getResults())) {
			for (CvcShippingBatchOrderEntity entity : list.getResults()) {
				if(entity.getIsOrderBatchNoOk() == 0) {
					entity.setIsOrderBatchNoOkStr("<font color=\"red\">否</font>");
				}else {
					entity.setIsOrderBatchNoOkStr("是");
				}
			}
		}
		dataGrid.setResults(SystemTools.convertPaginatedList(list));
		dataGrid.setTotal(cvcShippingBatchOrderService.getCount(query));
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	/**
	 * 发货
	 * @return
	 */
	@RequestMapping(params = "ship",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson ship(@RequestParam(required = true, value = "batchNo" ) String batchNo,
			@RequestParam(required = false, value = "orderId" ) String orderId,
			@RequestParam(required = false, value = "first" ) int first,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		try {
			ResponseTotelEntity responseTotelEntity = new ResponseTotelEntity(); 
			//是否批量发货
			boolean isBatch = true;
			CvcShippingBatchOrderEntity entity = new CvcShippingBatchOrderEntity();
			entity.setBatchNo(batchNo);
			if(StringUtils.isNotEmpty(orderId)) {
				isBatch = false;
				entity.setOrderId(orderId);
			}
			entity.setStatus(0);
			entity.setIsOrderBatchNoOk(1);
			MiniDaoPage<CvcShippingBatchOrderEntity> miniDaoPage = cvcShippingBatchOrderService.getAll(entity, 1, 10);
			int totleSize = 0;
			int sucSize = 0;
			int faildSize = 0;
			String totleSizeString = request.getParameter("totleSize");
			if(StringUtils.isNotEmpty(totleSizeString)) {
				totleSize = Integer.parseInt(totleSizeString);
			}
			
			String sucSizeString = request.getParameter("sucSize");
			if(StringUtils.isNotEmpty(sucSizeString)) {
				sucSize = Integer.parseInt(sucSizeString);
			}
			
			String faildSizeString = request.getParameter("faildSize");
			if(StringUtils.isNotEmpty(faildSizeString)) {
				faildSize = Integer.parseInt(faildSizeString);
			}
			
			if(first == 1 && isBatch) {
				//批量发货统计总数返回
				totleSize = cvcShippingBatchOrderService.getCount(entity);
				responseTotelEntity.setTotelSize(totleSize);
			}
			List<CvcShippingBatchOrderEntity> batchOrderEntities = miniDaoPage.getResults();
			if(CollectionUtils.isNotEmpty(batchOrderEntities)) {
				for (CvcShippingBatchOrderEntity cvcShippingBatchOrderEntity : batchOrderEntities) {
					//循环发货
					j = cvcOrderInfoService.sendOrder(cvcOrderInfoService.get(cvcShippingBatchOrderEntity.getId())
							,cvcShippingBatchOrderEntity.getShippingName(), batchNo);
					if(j.isSuccess()) {
						sucSize ++;
					}else {
						faildSize ++;
					}
				}
			}
			responseTotelEntity.setSucSize(sucSize);
			responseTotelEntity.setFaildSize(faildSize);
			j.setObj(responseTotelEntity);
			j.setMsg("保存成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}

	 /**
	  * 详情
	  * @return
	  */
	@RequestMapping(params="toDetail",method = RequestMethod.GET)
	public void cvcShippingBatchOrderDetail(@RequestParam(required = true, value = "id" ) String id,HttpServletResponse response,HttpServletRequest request)throws Exception{
			VelocityContext velocityContext = new VelocityContext();
			String viewName = "hotel/shippingbatchorder/cvcShippingBatchOrder-detail.vm";
			CvcShippingBatchOrderEntity cvcShippingBatchOrder = cvcShippingBatchOrderService.get(id);
			velocityContext.put("cvcShippingBatchOrder",cvcShippingBatchOrder);
			ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public void toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 VelocityContext velocityContext = new VelocityContext();
		 String viewName = "hotel/shippingbatchorder/cvcShippingBatchOrder-add.vm";
		 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute CvcShippingBatchOrderEntity cvcShippingBatchOrder){
		AjaxJson j = new AjaxJson();
		try {
			cvcShippingBatchOrderService.insert(cvcShippingBatchOrder);
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
			 CvcShippingBatchOrderEntity cvcShippingBatchOrder = cvcShippingBatchOrderService.get(id);
			 velocityContext.put("cvcShippingBatchOrder",cvcShippingBatchOrder);
			 String viewName = "hotel/shippingbatchorder/cvcShippingBatchOrder-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute CvcShippingBatchOrderEntity cvcShippingBatchOrder){
		AjaxJson j = new AjaxJson();
		try {
			cvcShippingBatchOrderService.update(cvcShippingBatchOrder);
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
				cvcShippingBatchOrderService.delete(id);
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
			cvcShippingBatchOrderService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("批量删除失败");
		}
		return j;
	}

}

