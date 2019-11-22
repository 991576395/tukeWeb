package com.xuzy.hotel.ylrequest;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.util.PHPAndJavaSerialize;
import com.util.PhpDateUtils;
import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.module.Data;
import com.xuzy.hotel.order.module.DelivetyJson;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.order.web.OrderCallBack;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;
import com.xuzy.hotel.shipping.service.CvcShippingService;


@Service("wuliuCheckTask")
public class WuliuCheckTask implements Job{
	
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	@Autowired
	private CvcShippingService cvcShippingService;
	
	@Autowired
	private OrderCallBack orderCallBack;
	
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	
	public void run() {
//		if(true) {
//			return;
//		}
		long start = System.currentTimeMillis();
		org.jeecgframework.core.util.LogUtil.info("===================物流校验定时任务开始===================");
		
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if(hour >= 0 && hour <= 6) {
			org.jeecgframework.core.util.LogUtil.info("===================0 -- 6 点无需执行===================");
			return;
		}
//		taskExecutor.execute(new Runnable() {
//			@Override
//			public void run() {
//				long start = System.currentTimeMillis();
//				org.jeecgframework.core.util.LogUtil.info("===================申通物流校验定时任务开始===================");
//				//执行申通接口
//				cvcOrderInfoService.shengtongSearch();
//				long end = System.currentTimeMillis();
//				long times = end - start;
//				org.jeecgframework.core.util.LogUtil.info("===================申通物流校验定时任务开始========总耗时"+times+"毫秒");
//			}
//		});
		
		org.jeecgframework.core.util.LogUtil.info("===================申通物流校验定时任务开始===================");
		//执行申通接口
		cvcOrderInfoService.shengtongSearch();
		
		List<CvcOrderInfoEntity> results =cvcOrderInfoService.getTogezelWuliuList();
		doOrderArrays(results);
		
		org.jeecgframework.core.util.LogUtil.info("===================物流校验定时任务结束===================");
		long end = System.currentTimeMillis();
		long times = end - start;
		org.jeecgframework.core.util.LogUtil.info("总耗时"+times+"毫秒");
	}

	private void doOrderArrays(List<CvcOrderInfoEntity> results) {
		if(CollectionUtils.isNotEmpty(results)) {
			for (CvcOrderInfoEntity entity : results) {
				try {
					CvcShippingEntity cvcShipping = new CvcShippingEntity();
					cvcShipping.setEnabled(1);
					cvcShipping.setShippingName(entity.getShippingName());
					//查询快递公司
					MiniDaoPage<CvcShippingEntity> daoPage = cvcShippingService.getAll(cvcShipping, 1, 1);
					CvcShippingEntity cvcShippingEntity = null;
					if(CollectionUtils.isEmpty(daoPage.getResults())) {
						org.jeecgframework.core.util.LogUtil.info("该快递公司不存在！");
						continue;
					}else {
						cvcShippingEntity = daoPage.getResults().get(0);
					}
					String result = "";
					result = ConmentHttp.getOrderWuliu(cvcShippingEntity.getShippingCode(), entity.getInvoiceNo(), entity.getTel());
					if(StringUtils.isNotEmpty(result) && result.contains("\"message\":\"ok\"")) {
						String str = "{\"type\":\"1\",\"status\":\"shutdown\",\"billstatus\":\"check\",\"message\":\"\",\"lastResult\":"+result+"}";
//						ConmentHttp.postMyErrorOrder(result);
						orderCallBack.result(str);
						org.jeecgframework.core.util.LogUtil.info("手动获取物流："+result);
					}
				} catch (Exception e) {
					org.jeecgframework.core.util.LogUtil.error("处理异常："+ entity.getId(), e);
				}
			}
		}
		
	}

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		run();
	}
}
