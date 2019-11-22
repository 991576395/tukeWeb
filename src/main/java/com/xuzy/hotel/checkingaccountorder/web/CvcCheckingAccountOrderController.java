package com.xuzy.hotel.checkingaccountorder.web;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
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

import com.util.PhpDateUtils;
import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;
import com.xuzy.hotel.checkingaccount.service.CvcCheckingAccountService;
import com.xuzy.hotel.checkingaccountorder.entity.CvcCheckingAccountOrderEntity;
import com.xuzy.hotel.checkingaccountorder.service.CvcCheckingAccountOrderService;
import com.xuzy.hotel.checkingaccountorder.service.impl.CheckAndUpdateRunable;
import com.xuzy.hotel.company.entity.TSCompanyEntity;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.shippingbatchorder.entity.ResponseTotelEntity;
import com.xuzy.hotel.ylrequest.ConmentHttp;
import com.xuzy.hotel.ylrequest.ResponseHead;
import com.xuzy.hotel.ylrequest.TukeRequestBody;
import com.xuzy.hotel.ylrequest.module.RequestCheckingAccountDetailAddJson;

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
  
  @Autowired
  private CvcCheckingAccountService cvcCheckingAccountService;
  

  @Autowired
  private CheckAndUpdateRunable checkAndUpdateRunable;
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
	@ResponseBody
	public AjaxJson addCheckingAccount(@RequestParam(required = true, value = "checkingAccountId" )Integer checkingAccountId
			,@RequestParam(required = false, value = "first" ) int first
			,@RequestParam(required = false, value = "totelSize") int totelSize
			,@RequestParam(required = false, value = "sucSize" ) int sucSize
			,@RequestParam(required = false, value = "faildSize" ) int faildSize)throws Exception{
		AjaxJson j = new AjaxJson();
		ResponseTotelEntity responseTotelEntity = new ResponseTotelEntity(); 
		try {
			if(checkingAccountId == null) {
				j.setSuccess(false);
				j.setMsg("该对账单不存在！");
				return j;
			}
			CvcCheckingAccountEntity  cvcOrderInfoEntity = cvcCheckingAccountService.get(checkingAccountId+"");
			if(cvcOrderInfoEntity == null) {
				j.setSuccess(false);
				j.setMsg("该对账单不存在！");
				return j;
			}
			
			int page = 1;
			CvcCheckingAccountOrderEntity query = new CvcCheckingAccountOrderEntity();
			query.setIsAddCheckingAccount(0);
			query.setCheckingAccountId(checkingAccountId);
			if(first == 1) {
				//首次获取数量总数
				totelSize = cvcCheckingAccountOrderService.getCount(query);
			}
			responseTotelEntity.setTotelSize(totelSize);
			MiniDaoPage<CvcCheckingAccountOrderEntity> list = cvcCheckingAccountOrderService.getAll(query, page, 10);
			if(CollectionUtils.isNotEmpty(list.getResults())) {
//				checkAndUpdateRunable.setCheckingAccountId(checkingAccountId);
				for (CvcCheckingAccountOrderEntity entity : list.getResults()) {
					RequestCheckingAccountDetailAddJson checkingAccountDetailAddJson = new RequestCheckingAccountDetailAddJson();
					checkingAccountDetailAddJson.setCheckAccountInfoID(checkingAccountId);
					checkingAccountDetailAddJson.setOrderID(entity.getOrderId());
					checkingAccountDetailAddJson.setProductCode(entity.getGoodsSn());
					checkingAccountDetailAddJson.setQuantity(entity.getGoodsNumber());
					checkingAccountDetailAddJson.setEMSCompany(entity.getShippingName());
					checkingAccountDetailAddJson.setDeliver(cvcOrderInfoEntity.getDeliver());
					checkingAccountDetailAddJson.setAccountType(cvcOrderInfoEntity.getAccountType());
					checkingAccountDetailAddJson.setOppStaff(cvcOrderInfoEntity.getOppstaff());
//					
//					//调用上传订单详情接口
					ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
							.setSequence(2)
							.setServiceCode("CRMIF.CheckingAccountDetailAddJson")
							.setParams(checkingAccountDetailAddJson).builder(), null);
					if(responseHead.getReturn() >= 0) {
//					if(true) {
						cvcCheckingAccountOrderService.updateAddCheckingAccount(checkingAccountId, entity.getOrderId(), PhpDateUtils.getTime());
						sucSize++;
					}else {
						faildSize ++;
					}
				}
			}
			responseTotelEntity.setSucSize(sucSize);
			responseTotelEntity.setFaildSize(faildSize);
			j.setMsg("本次成功！");
			j.setObj(responseTotelEntity);
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("上传失败");
		}
		return j;
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(@RequestParam(required = true, value = "checkingAccountId" )Integer checkingAccountId,HttpServletRequest request
			,HttpServletResponse response,ModelMap modelMap) {
		List<CvcCheckingAccountOrderEntity> entitys = cvcCheckingAccountOrderService.getOrders(checkingAccountId);
		modelMap.put(NormalExcelConstants.FILE_NAME,DateFormatUtils.format(Calendar.getInstance(), "yyyyMMddHHmmss"));
		modelMap.put(NormalExcelConstants.CLASS,CvcCheckingAccountOrderEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams(null, null,
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,entitys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
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
	 * 公司维护编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(@RequestParam(required = false, value = "id" ) Integer id,@RequestParam(required = false, value = "orderId" ) Integer orderId,HttpServletRequest req) {
		CvcCheckingAccountOrderEntity  checkingAccountOrderEntity = cvcCheckingAccountOrderService.get(id,orderId);
		req.setAttribute("checkingAccountOrderEntity", checkingAccountOrderEntity);
		return new ModelAndView("com/xuzy/hotel/checkaccount/tCheckingAccountOrder-update");
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
			CvcCheckingAccountOrderEntity accountOrderEntity = cvcCheckingAccountOrderService.getById(cvcCheckingAccountOrder.getId());
			if(accountOrderEntity != null) {
				accountOrderEntity.setInvoiceNo(cvcCheckingAccountOrder.getInvoiceNo());
				accountOrderEntity.setShippingName(cvcCheckingAccountOrder.getShippingName());
				cvcCheckingAccountOrderService.update(accountOrderEntity);
			}
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
	@RequestMapping(params="doDelete",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doDelete(@RequestParam(required = false, value = "id" ) Integer id){
			AjaxJson j = new AjaxJson();
			try {
				if(id == null) {
					j.setSuccess(false);
					j.setMsg("参数异常！");
					return j;
				}
				CvcCheckingAccountOrderEntity  checkingAccountOrderEntity = cvcCheckingAccountOrderService.getById(id);
				if(checkingAccountOrderEntity == null) {
					j.setSuccess(false);
					j.setMsg("该订单不存在！");
					return j;
				}
				
				if(checkingAccountOrderEntity.getIsAddCheckingAccount() == 1) {
					j.setSuccess(false);
					j.setMsg("该订单已上传，不能删除！");
					return j;
				}
				CvcCheckingAccountEntity cvcCheckingAccountEntity = cvcCheckingAccountService.get(id+"");
				if(cvcCheckingAccountEntity.getIsBalance() == 1) {
					j.setSuccess(false);
					j.setMsg("该订单已结算，不能删除！");
					return j;
				}
				cvcCheckingAccountOrderService.delete(checkingAccountOrderEntity.getId()+"");
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

