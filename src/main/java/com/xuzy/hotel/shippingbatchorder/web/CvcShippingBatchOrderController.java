package com.xuzy.hotel.shippingbatchorder.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.VelocityContext;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.p3.core.common.utils.AjaxJson;
import org.jeecgframework.p3.core.page.SystemTools;
import org.jeecgframework.p3.core.util.plugin.ViewVelocity;
import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xuzy.hotel.shippingbatchorder.entity.CvcShippingBatchOrderEntity;
import com.xuzy.hotel.shippingbatchorder.service.CvcShippingBatchOrderService;

 /**
 * 描述：批量发货订单表
 * @author: www.jeecg.org
 * @since：2018年11月21日 20时52分03秒 星期三 
 * @version:1.0
 */
@Controller
@RequestMapping("/hotel/cvcShippingBatchOrder")
public class CvcShippingBatchOrderController extends BaseController{
  @Autowired
  private CvcShippingBatchOrderService cvcShippingBatchOrderService;
  
	/**
	  * 列表页面
	  * @return
	  */
	@RequestMapping(params = "list",method = {RequestMethod.GET,RequestMethod.POST})
	public void list(@ModelAttribute CvcShippingBatchOrderEntity query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) throws Exception{
			try {
			 	LOG.info(request, " back list");
			 	//分页数据
				MiniDaoPage<CvcShippingBatchOrderEntity> list =  cvcShippingBatchOrderService.getAll(query,pageNo,pageSize);
				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("cvcShippingBatchOrder",query);
				velocityContext.put("pageInfos",SystemTools.convertPaginatedList(list));
				String viewName = "hotel/shippingbatchorder/cvcShippingBatchOrder-list.vm";
				ViewVelocity.view(request,response,viewName,velocityContext);
			} catch (Exception e) {
			e.printStackTrace();
			}
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

