package com.xuzy.hotel.ylrequest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.tools.ant.taskdefs.SendEmail;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.SendMailUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.ylrequest.export.ExceptionOrderEntity;


@Service("exceptionCheckTask")
public class ExceptionCheckTask implements Job{
	
	@Autowired
	private CvcDeliveryInfoService cvcDeliveryInfoService;
	
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	/*@Scheduled(cron="0 0/1 * * * ?")*/
	public void run() {
//		if(true) {
//			return;
//		}
		long start = System.currentTimeMillis();
		org.jeecgframework.core.util.LogUtil.info("===================异常订单监控定时任务开始===================");
		//异常订单
		List<CvcDeliveryInfoEntity> cvcDeliveryInfoEntities = cvcDeliveryInfoService.getListOneHours();
		if (CollectionUtils.isNotEmpty(cvcDeliveryInfoEntities)) {
			org.jeecgframework.core.util.LogUtil.info("发现签收失败条数：" + cvcDeliveryInfoEntities.size());
			List<ExceptionOrderEntity> objs = new ArrayList<ExceptionOrderEntity>();
			for (CvcDeliveryInfoEntity cvcDeliveryInfoEntity : cvcDeliveryInfoEntities) {
				CvcOrderInfoEntity cvcOrderInfo = new CvcOrderInfoEntity();
				cvcOrderInfo.setInvoiceNo(cvcDeliveryInfoEntity.getNumber());
				cvcOrderInfo = cvcOrderInfoService.getOrder(cvcOrderInfo);
				if (cvcOrderInfo != null) {
					ExceptionOrderEntity entity = new ExceptionOrderEntity();
					entity.setOrderId(cvcOrderInfo.getId() + "");
					entity.setName(cvcOrderInfo.getConsignee());
					entity.setPhone(StringUtils.isEmpty(cvcOrderInfo.getTel())
							? StringUtils.isEmpty(cvcOrderInfo.getMobile()) ? "" : cvcOrderInfo.getMobile()
							: cvcOrderInfo.getTel());
					CvcDeliveryInfoEntity cvcDeliveryInfoEntity2 = cvcDeliveryInfoService
							.getFirstTime(cvcDeliveryInfoEntity.getNumber());
					entity.setFirtTime((cvcDeliveryInfoEntity2 != null
							&& StringUtils.isNotEmpty(cvcDeliveryInfoEntity2.getCreateDate()))
									? cvcDeliveryInfoEntity2.getCreateDate()
									: cvcDeliveryInfoEntity.getCreateDate());
					
					if(!objs.contains(entity)) {
						objs.add(entity);
					}
				}
			}
			if (CollectionUtils.isNotEmpty(objs)) {
				ModelMap modelMap = new ModelMap();
				modelMap.put(NormalExcelConstants.FILE_NAME,
						DateFormatUtils.format(Calendar.getInstance(), "yyyyMMdd") + "异常订单");
				modelMap.put(NormalExcelConstants.CLASS, ExceptionOrderEntity.class);
				modelMap.put(NormalExcelConstants.PARAMS, new ExportParams(null, null, "导出信息"));
				modelMap.put(NormalExcelConstants.DATA_LIST, objs);
				List<TSType> typeList = ResourceUtil.allTypes.get("sendEmail".toLowerCase());
				if(CollectionUtils.isNotEmpty(typeList) && CollectionUtils.isNotEmpty(objs)) {
					List<String> jieshourens = new ArrayList<>();
					for (TSType tsType : typeList) {
						jieshourens.add(tsType.getTypecode());
					}
					SendMailUtil.sendWithFileMail(jieshourens, "异常物流信息监控，系统自动发送邮件!", modelMap);
				}
			}
		}
		//即将超过3天未签收订单
		org.jeecgframework.core.util.LogUtil.info("===================异常订单监控定时任务结束===================");
		long end = System.currentTimeMillis();
		long times = end - start;
		org.jeecgframework.core.util.LogUtil.info("总耗时"+times+"毫秒");
	}

	

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		run();
	}
}
