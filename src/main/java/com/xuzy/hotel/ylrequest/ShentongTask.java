package com.xuzy.hotel.ylrequest;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.util.PHPAndJavaSerialize;
import com.util.PhpDateUtils;
import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.module.Data;
import com.xuzy.hotel.order.module.DelivetyJson;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;
import com.xuzy.hotel.shipping.service.CvcShippingService;


/**
 * 申通接口调用
 * @author zmeng
 *
 */
@Service("shentongTask")
public class ShentongTask implements Job{
	
	private static final Logger objLog = Logger.getLogger(ShentongTask.class);
	
	
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	public void run() {
		long start = System.currentTimeMillis();
		objLog.info("===================申通物流调用定时任务开始===================");
		//待发货申通集合
		List<CvcOrderInfoEntity> shentongList = cvcOrderInfoService.getShentongList();
		for (CvcOrderInfoEntity cvcOrderInfoEntity : shentongList) {
			//申通发货
			
			
		}
		objLog.info("===================申通物流调用定时任务结束===================");
		long end = System.currentTimeMillis();
		long times = end - start;
		objLog.info("总耗时"+times+"毫秒");
	}
	

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		run();
	}
}
