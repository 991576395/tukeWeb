package com.xuzy.hotel.ylrequest;

import java.util.List;

import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.util.PHPAndJavaSerialize;
import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.module.Data;
import com.xuzy.hotel.order.module.DelivetyJson;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;
import com.xuzy.hotel.shipping.service.CvcShippingService;


@Service("orderCheckTask")
public class OrderCheckTask implements Job{
	
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	@Autowired
	private CvcShippingService cvcShippingService;
	
	@Autowired
	private CvcDeliveryInfoService cvcDeliveryInfoService;
	
	/*@Scheduled(cron="0 0/1 * * * ?")*/
	public void run() {
		long start = System.currentTimeMillis();
		org.jeecgframework.core.util.LogUtil.info("===================订单校验定时任务开始===================");
		List<CvcDeliveryInfoEntity> entities = cvcDeliveryInfoService.getAllError();
		for (CvcDeliveryInfoEntity entity : entities) {
			List<Data> datas = PHPAndJavaSerialize.unserializePHParray(entity.getData(),DelivetyJson.class);
			ConmentHttp.postErrorOrder(datas, entity);
		}
		org.jeecgframework.core.util.LogUtil.info("===================订单校验定时任务结束===================");
		long end = System.currentTimeMillis();
		long times = end - start;
		org.jeecgframework.core.util.LogUtil.info("总耗时"+times+"毫秒");
	}

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		run();
	}
}
