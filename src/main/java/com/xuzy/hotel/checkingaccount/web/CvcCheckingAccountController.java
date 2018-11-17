package com.xuzy.hotel.checkingaccount.web;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.ResourceUtil;
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
import com.xuzy.hotel.checkingaccount.service.CvcCheckingAccountService;
import com.xuzy.hotel.checkingaccountorder.entity.CvcCheckingAccountOrderEntity;
import com.xuzy.hotel.checkingaccountorder.service.CvcCheckingAccountOrderService;
import com.xuzy.hotel.order.entity.CvcOrderGoodsEntity;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.service.CvcOrderGoodsService;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.ylrequest.Config;
import com.xuzy.hotel.ylrequest.ConmentHttp;
import com.xuzy.hotel.ylrequest.ResponseHead;
import com.xuzy.hotel.ylrequest.TukeRequestBody;
import com.xuzy.hotel.ylrequest.module.RequestCheckingAcccountInfoAddJson;
import com.xuzy.hotel.ylrequest.module.RequestUpdateCheckingAccountInfoJson;
import com.xuzy.hotel.ylrequest.module.ResponseCheckingAcccountInfoAddJson;

 /**
 * 描述：对账表
 * @author: www.jeecg.org
 * @since：2018年11月14日 19时44分59秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/cvcCheckingAccount")
public class CvcCheckingAccountController extends BaseController{
  @Autowired
  private CvcCheckingAccountService cvcCheckingAccountService;
  
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView list(@ModelAttribute CvcCheckingAccountEntity query,HttpServletRequest request,HttpServletResponse response) throws Exception{
		return new ModelAndView("com/xuzy/hotel/checkaccount/tlist");
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
	public void datagrid(CvcCheckingAccountEntity query,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		MiniDaoPage<CvcCheckingAccountEntity> list = cvcCheckingAccountService.getAll(query, dataGrid.getPage(), dataGrid.getRows());
		if(CollectionUtils.isNotEmpty(list.getResults())) {
			for (CvcCheckingAccountEntity entity : list.getResults()) {
				entity.setAddTimeFormat(DateFormatUtils.format(Long.parseLong(entity.getAddTime()+"000"), "yyyy-MM-dd HH:mm:ss"));
			}
		}
		dataGrid.setResults(SystemTools.convertPaginatedList(list));
		dataGrid.setTotal(cvcCheckingAccountService.getCount(query));
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(params = "toAdd",method ={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView toAddDialog(HttpServletRequest request,HttpServletResponse response)throws Exception{
		 return new ModelAndView("com/xuzy/hotel/checkaccount/tCheckingAccount-add");
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	@RequestMapping(params = "doAdd",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doAdd(@ModelAttribute CvcCheckingAccountEntity cvcCheckingAccount){
		AjaxJson j = new AjaxJson();
		try {
			String userName = ResourceUtil.searchAllTypesByCode(cvcCheckingAccount.getAccountType()+"","atType");
			List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoService.getAccountOrderList(userName, cvcCheckingAccount.getStartTime(), cvcCheckingAccount.getEndTime());
			if(CollectionUtils.isEmpty(cvcOrderInfoEntities)) {
				j.setSuccess(false);
				j.setMsg("该时间段内不存在已签收订单！");
				return j;
			}
			RequestCheckingAcccountInfoAddJson moduleType = new RequestCheckingAcccountInfoAddJson();
			moduleType.setDeliver(Config.DELIVERER);
			moduleType.setBeginDate(cvcCheckingAccount.getStartTime());
			moduleType.setEndDate(cvcCheckingAccount.getEndTime());
			moduleType.setTopic(cvcCheckingAccount.getTopic());
			moduleType.setAccountType(cvcCheckingAccount.getAccountType());
//			ResponseHead head = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setParams(moduleType).setSequence(2)
//					.setServiceCode("CRMIF.CheckingAcccountInfoAddJson").builder(), ResponseCheckingAcccountInfoAddJson.class);
//			if(head.getReturn() >= 0) {
//				ResponseCheckingAcccountInfoAddJson responseCheckingAcccountInfoAddJson = (ResponseCheckingAcccountInfoAddJson) head.getBody();
//				
//				int CheckAccountInfoID = responseCheckingAcccountInfoAddJson.getCheckAccountInfoID();	
				int CheckAccountInfoID = 123456;	
				if(CheckAccountInfoID > 0 && !CollectionUtils.isEmpty(cvcOrderInfoEntities)) {
					CvcCheckingAccountEntity accountEntity = cvcCheckingAccountService.get(CheckAccountInfoID+"");
					if(accountEntity == null) {
						accountEntity = new CvcCheckingAccountEntity();
						accountEntity.setCheckingAccountId(CheckAccountInfoID);
						accountEntity.setTopic(cvcCheckingAccount.getTopic());
						accountEntity.setAccountType(cvcCheckingAccount.getAccountType());
						accountEntity.setDeliver(Config.DELIVERER);
						accountEntity.setOppstaff(1);
						accountEntity.setStartTime(cvcCheckingAccount.getStartTime());
						accountEntity.setEndTime(cvcCheckingAccount.getEndTime());
						accountEntity.setAddTime(Calendar.getInstance().getTimeInMillis());
						accountEntity.setIsBalance(0);
						
						cvcCheckingAccountService.insert(accountEntity,CheckAccountInfoID,cvcOrderInfoEntities);
					}
				}
				j.setMsg("保存成功");
//			}else {
//				j.setSuccess(false);
//				j.setMsg("伊利接口调用失败！");
//			}
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("保存失败");
		}
		return j;
	}

	/**
	  * 重新生成对账明细
	  * @return
	  */
	@RequestMapping(params="updateCheckingAccountOrder",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson updateCheckingAccountOrder(@RequestParam(required = true, value = "checkingAccountId" ) Integer checkingAccountId,HttpServletResponse response,HttpServletRequest request)throws Exception{
		AjaxJson j = new AjaxJson();
		try {
			if(checkingAccountId == null) {
				j.setSuccess(false);
				j.setMsg("对账表头不存在");
				return j;
			}
			CvcCheckingAccountEntity cvcCheckingAccount = cvcCheckingAccountService.get(checkingAccountId+"");
			if(cvcCheckingAccount == null){
				j.setSuccess(false);
				j.setMsg("对账表头不存在");
				return j;
			}
			String userName = ResourceUtil.searchAllTypesByCode(cvcCheckingAccount.getAccountType()+"","atType");
			List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoService.getAccountOrderList(userName, cvcCheckingAccount.getStartTime(), cvcCheckingAccount.getEndTime());
			if(CollectionUtils.isEmpty(cvcOrderInfoEntities)) {
				j.setSuccess(false);
				j.setMsg("该时间段内不存在已签收订单！");
				return j;
			}
			cvcCheckingAccountService.update(cvcCheckingAccount,checkingAccountId,cvcOrderInfoEntities);
			j.setMsg("生成成功");
		} catch (Exception e) {
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("生成失败");
		}
		return j;
	
	}

	/**
	  * 封帐
	  * @return
	  */
	@RequestMapping(params="makeBalance",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson makeBalance(@RequestParam(required = true, value = "checkingAccountId" ) Integer checkingAccountId,HttpServletResponse response,HttpServletRequest request)throws Exception{
		AjaxJson j = new AjaxJson();
		try {
			if(checkingAccountId == null) {
				j.setSuccess(false);
				j.setMsg("对账表头不存在");
				return j;
			}
			CvcCheckingAccountEntity cvcCheckingAccount = cvcCheckingAccountService.get(checkingAccountId+"");
			if(cvcCheckingAccount == null){
				j.setSuccess(false);
				j.setMsg("对账表头不存在");
				return j;
			}
			int value = cvcCheckingAccountService.makeBalance(cvcCheckingAccount);
			j.setMsg("成功标记："+value+"个已结算的订单！");
		} catch (Exception e) {
			e.printStackTrace();
		    log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("标记失败");
		}
		return j;
	
	}
	 /**
	  * 更新对账明细信息
	  * @return
	  */
	@RequestMapping(params="updateCheckingAccount",method = RequestMethod.GET)
	public AjaxJson updateCheckingAccount(@RequestParam(required = true, value = "checkAccountInfoID" ) Integer checkAccountInfoID,HttpServletResponse response,HttpServletRequest request)throws Exception{
		AjaxJson j = new AjaxJson();
		try {
			if(checkAccountInfoID == null) {
				j.setSuccess(false);
				j.setMsg("对账表头不存在");
				return j;
			}
			CvcCheckingAccountEntity cvcCheckingAccount = cvcCheckingAccountService.get(checkAccountInfoID+"");
			if(cvcCheckingAccount == null){
				j.setSuccess(false);
				j.setMsg("对账表头不存在");
				return j;
			}
			RequestUpdateCheckingAccountInfoJson moduleType = new RequestUpdateCheckingAccountInfoJson();
			moduleType.setCheckAccountInfoID(checkAccountInfoID);
			moduleType.setBeginDate(cvcCheckingAccount.getStartTime());
			moduleType.setEndDate(cvcCheckingAccount.getEndTime());
			moduleType.setTopic(cvcCheckingAccount.getTopic());
			moduleType.setAccountType(cvcCheckingAccount.getAccountType());
//			ResponseHead head = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setParams(moduleType).setSequence(2)
//					.setServiceCode("CRMIF.UpdateCheckingAccountInfoJson").builder(), null);
//			if(head.getReturn() >= 0) {
			
				cvcCheckingAccountService.update(cvcCheckingAccount);
				j.setMsg("保存成功");
//			}else {
//				j.setSuccess(false);
//				j.setMsg("伊利接口调用失败！");
//			}
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
			 CvcCheckingAccountEntity cvcCheckingAccount = cvcCheckingAccountService.get(id);
			 velocityContext.put("cvcCheckingAccount",cvcCheckingAccount);
			 String viewName = "hotel/checkingaccount/cvcCheckingAccount-edit.vm";
			 ViewVelocity.view(request,response,viewName,velocityContext);
	}

	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(params = "doEdit",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson doEdit(@ModelAttribute CvcCheckingAccountEntity cvcCheckingAccount){
		AjaxJson j = new AjaxJson();
		try {
			cvcCheckingAccountService.update(cvcCheckingAccount);
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
	public AjaxJson doDelete(@RequestParam(required = true, value = "id" ) Integer id){
			AjaxJson j = new AjaxJson();
			try {
				if(id == null) {
					j.setSuccess(false);
					j.setMsg("该对账表头不存在！");
					return j;
				}
				CvcCheckingAccountEntity  accountEntity = cvcCheckingAccountService.get(id+"");
				if(accountEntity == null) {
					j.setSuccess(false);
					j.setMsg("该对账表头不存在！");
					return j;
				}
				
				if(accountEntity.getIsBalance() == 1) {
					j.setSuccess(false);
					j.setMsg("该对账表头已经封账，不能删除！");
					return j;
				}
				
				cvcCheckingAccountService.delete(id+"");
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
			cvcCheckingAccountService.batchDelete(ids);
			j.setMsg("批量删除成功");
		} catch(Exception e) {
			log.info(e.getMessage());
			j.setSuccess(false);
			j.setMsg("批量删除失败");
		}
		return j;
	}

}

