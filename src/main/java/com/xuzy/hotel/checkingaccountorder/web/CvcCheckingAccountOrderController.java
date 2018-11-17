package com.xuzy.hotel.checkingaccountorder.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
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

import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;
import com.xuzy.hotel.checkingaccountorder.entity.CvcCheckingAccountOrderEntity;
import com.xuzy.hotel.checkingaccountorder.service.CvcCheckingAccountOrderService;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.service.CvcOrderInfoService;

 /**
 * 描述：对账订单表
 * @author: www.jeecg.org
 * @since：2018年11月15日 21时28分02秒 星期四 
 * @version:1.0
 */
@Controller
@RequestMapping("/cvcCheckingAccountOrder")
public class CvcCheckingAccountOrderController extends BaseController{
  @Autowired
  private CvcCheckingAccountOrderService cvcCheckingAccountOrderService;
  
  @Autowired
  private CvcOrderInfoService cvcOrderInfoService;
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping(params = "list", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView list(@ModelAttribute CvcCheckingAccountEntity query, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String checkingAccountId = request.getParameter("checkingAccountId");
		request.setAttribute("checkingAccountId", checkingAccountId);
		return new ModelAndView("com/xuzy/hotel/checkaccount/orderList");
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
	public void datagrid(CvcCheckingAccountOrderEntity query,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		MiniDaoPage<CvcCheckingAccountOrderEntity> list = cvcCheckingAccountOrderService.getAll(query, dataGrid.getPage(), dataGrid.getRows());
		dataGrid.setResults(SystemTools.convertPaginatedList(list));
		dataGrid.setTotal(cvcCheckingAccountOrderService.getCount(query));
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 上传对账明细
	 * @return
	 */
	@RequestMapping(params = "addCheckingAccount",method ={RequestMethod.GET, RequestMethod.POST})
	public AjaxJson addCheckingAccount(@RequestParam(required = true, value = "checkingAccountId" )Integer checkingAccountId)throws Exception{
		AjaxJson j = new AjaxJson();
		try {
			if(checkingAccountId == null) {
				j.setSuccess(false);
				j.setMsg("该对账单不存在！");
				return j;
			}
			CvcOrderInfoEntity  cvcOrderInfoEntity = cvcOrderInfoService.get(checkingAccountId);
			if(cvcOrderInfoEntity == null) {
				j.setSuccess(false);
				j.setMsg("该对账单不存在！");
				return j;
			}
			
			
			
			
			j.setMsg("上传成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("上传失败");
		}
		return j;
	}

	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute CvcCheckingAccountOrderEntity cvcCheckingAccountOrder){
		AjaxJson j = new AjaxJson();
		try {
			cvcCheckingAccountOrderService.insert(cvcCheckingAccountOrder);
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
			 CvcCheckingAccountOrderEntity cvcCheckingAccountOrder = cvcCheckingAccountOrderService.get(id);
			 velocityContext.put("cvcCheckingAccountOrder",cvcCheckingAccountOrder);
			 String viewName = "hotel/checkingaccountorder/cvcCheckingAccountOrder-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute CvcCheckingAccountOrderEntity cvcCheckingAccountOrder){
		AjaxJson j = new AjaxJson();
		try {
			cvcCheckingAccountOrderService.update(cvcCheckingAccountOrder);
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
				cvcCheckingAccountOrderService.delete(id);
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
			cvcCheckingAccountOrderService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("批量删除失败");
		}
		return j;
	}

}

