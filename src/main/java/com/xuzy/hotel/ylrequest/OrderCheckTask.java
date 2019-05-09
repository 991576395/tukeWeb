package com.xuzy.hotel.ylrequest;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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
//		if(true) {
//			return;
//		}
		long start = System.currentTimeMillis();
		org.jeecgframework.core.util.LogUtil.info("===================订单校验定时任务开始===================");
		
		//已签收
		List<CvcDeliveryInfoEntity> entities = cvcDeliveryInfoService.getAllError();
		for (CvcDeliveryInfoEntity entity : entities) {
			List<Data> datas = PHPAndJavaSerialize.unserializePHParray(entity.getData(),DelivetyJson.class);
			ConmentHttp.postErrorOrder(datas, entity);
		}
		
		//离港中 且有异常订单
		CvcOrderInfoEntity query = new CvcOrderInfoEntity();
		query.setOrderStatus(3);
		query.setExceptionStatusString("1");
		MiniDaoPage<CvcOrderInfoEntity> list = cvcOrderInfoService.getAll(query, 1, 500);
		doOrderArrays(list.getResults());
		//已签收订单
		List<CvcOrderInfoEntity>  cvcOrderInfoEntities = cvcOrderInfoService.getWillSignList();
		doOrderArrays(cvcOrderInfoEntities);
		
		
		org.jeecgframework.core.util.LogUtil.info("===================订单校验定时任务结束===================");
		long end = System.currentTimeMillis();
		long times = end - start;
		org.jeecgframework.core.util.LogUtil.info("总耗时"+times+"毫秒");
	}

	private void doOrderArrays(List<CvcOrderInfoEntity> results) {
		if(CollectionUtils.isNotEmpty(results)) {
			for (CvcOrderInfoEntity entity : results) {
				try {
					entity = cvcOrderInfoService.get(entity.getId());
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
					ConmentHttp.postorder(cvcShippingEntity.getShippingCode(), entity.getInvoiceNo());
//					result = ConmentHttp.getOrderWuliu(cvcShippingEntity.getShippingCode(), entity.getInvoiceNo(), entity.getTel());
//					if(StringUtils.isNotEmpty(result) && result.contains("\"message\":\"ok\"")) {
//						ConmentHttp.postMyErrorOrder(result);
//						org.jeecgframework.core.util.LogUtil.info("手动获取物流："+result);
//					}
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
