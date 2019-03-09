package com.xuzy.hotel.ylrequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.taskdefs.SendEmail;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.SendMailUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.service.CvcOrderInfoService;


@Service("exceptionCheckTask")
public class ExceptionCheckTask implements Job{
	
	@Autowired
	private CvcDeliveryInfoService cvcDeliveryInfoService;
	
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	/*@Scheduled(cron="0 0/1 * * * ?")*/
	public void run() {
		long start = System.currentTimeMillis();
		org.jeecgframework.core.util.LogUtil.info("===================异常订单监控定时任务开始===================");
		
		List<CvcDeliveryInfoEntity> cvcDeliveryInfoEntities = cvcDeliveryInfoService.getListOneHours();
		if(CollectionUtils.isNotEmpty(cvcDeliveryInfoEntities)) {
			org.jeecgframework.core.util.LogUtil.info("发现签收失败条数："+cvcDeliveryInfoEntities.size());
			List<Map<String, Object>> objs = new ArrayList<Map<String, Object>>();
			for (CvcDeliveryInfoEntity cvcDeliveryInfoEntity : cvcDeliveryInfoEntities) {
				CvcOrderInfoEntity cvcOrderInfo = new CvcOrderInfoEntity();
				cvcOrderInfo.setInvoiceNo(cvcDeliveryInfoEntity.getNumber());
				MiniDaoPage<CvcOrderInfoEntity> daoPage = cvcOrderInfoService.getAll(cvcOrderInfo, 1, 10);
				List<CvcOrderInfoEntity> cvcOrderInfoEntities = daoPage.getResults();
				if(CollectionUtils.isNotEmpty(cvcOrderInfoEntities)) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("orderId", cvcOrderInfoEntities.get(0).getOrderSn());
					map.put("name", cvcOrderInfoEntities.get(0).getConsignee());
					map.put("phone", StringUtils.isEmpty(cvcOrderInfoEntities.get(0).getTel())?cvcOrderInfoEntities.get(0).getMobile():cvcOrderInfoEntities.get(0).getTel());
					
					CvcDeliveryInfoEntity cvcDeliveryInfoEntity2 = cvcDeliveryInfoService.getFirstTime(cvcDeliveryInfoEntity.getNumber());
					map.put("firtTime", cvcDeliveryInfoEntity2 != null ?cvcDeliveryInfoEntity2.getCreateDate():"");
					objs.add(map);
				}
			}
			Map<String, Object> values = new HashMap<String, Object>();
			values.put("sendLists", objs);
			String templatePath = "mailtemplate/test.ftl";
			List<TSType> typeList = ResourceUtil.allTypes.get("sendEmail".toLowerCase());
			if(CollectionUtils.isNotEmpty(typeList)) {
				StringBuffer sBuffer = new StringBuffer();
				for (TSType tsType : typeList) {
					sBuffer.append(tsType.getTypecode());
					sBuffer.append(";");
				}
				SendMailUtil.sendFtlMail(sBuffer.toString(), "异常物流信息监控，系统自动发送邮件!", templatePath, values);
			}
		}
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
