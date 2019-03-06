package com.xuzy.hotel.ylrequest;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.tools.ant.taskdefs.SendEmail;
import org.jeecgframework.core.util.SendMailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;


@Service("exceptionCheckTask")
public class ExceptionCheckTask implements Job{
	
	@Autowired
	private CvcDeliveryInfoService cvcDeliveryInfoService;
	
	/*@Scheduled(cron="0 0/1 * * * ?")*/
	public void run() {
		long start = System.currentTimeMillis();
		org.jeecgframework.core.util.LogUtil.info("===================异常订单监控定时任务开始===================");
		
		List<CvcDeliveryInfoEntity> cvcDeliveryInfoEntities = cvcDeliveryInfoService.getListOneHours();
		if(CollectionUtils.isNotEmpty(cvcDeliveryInfoEntities)) {
			org.jeecgframework.core.util.LogUtil.info("发现签收失败条数："+cvcDeliveryInfoEntities.size());
			
			
			
			
//			SendMailUtil.
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
