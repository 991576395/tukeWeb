package com.xuzy.hotel.checkingaccountorder.service.impl;

import java.util.Calendar;

import org.apache.commons.collections.CollectionUtils;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;
import com.xuzy.hotel.checkingaccount.service.CvcCheckingAccountService;
import com.xuzy.hotel.checkingaccountorder.entity.CvcCheckingAccountOrderEntity;
import com.xuzy.hotel.checkingaccountorder.service.CvcCheckingAccountOrderService;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.ylrequest.module.RequestCheckingAccountDetailAddJson;

/**
 * 
 * @author zmeng
 *
 */
@Service("checkAndUpdateRunable")
public class CheckAndUpdateRunable implements Runnable {

	private int checkingAccountId;

	@Autowired
	private CvcCheckingAccountOrderService cvcCheckingAccountOrderService;

	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;

	@Autowired
	private CvcCheckingAccountService cvcCheckingAccountService;

	public int getCheckingAccountId() {
		return checkingAccountId;
	}

	public void setCheckingAccountId(int checkingAccountId) {
		this.checkingAccountId = checkingAccountId;
	}

	@Override
	public void run() {
		CvcCheckingAccountEntity cvcOrderInfoEntity = cvcCheckingAccountService.get(checkingAccountId + "");
		boolean start = true;
		int page = 1;
		while (start) {
			CvcCheckingAccountOrderEntity query = new CvcCheckingAccountOrderEntity();
			query.setIsAddCheckingAccount(0);
			query.setCheckingAccountId(checkingAccountId);
			MiniDaoPage<CvcCheckingAccountOrderEntity> list = cvcCheckingAccountOrderService.getAll(query, page, 100);
			if (CollectionUtils.isNotEmpty(list.getResults())) {
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
					// 调用上传订单详情接口
//					ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
//							.setSequence(2)
//							.setServiceCode("CRMIF.CheckingAccountDetailAddJson")
//							.setParams(checkingAccountDetailAddJson).builder(), null);
//					if(responseHead.getReturn() >= 0) {
					cvcCheckingAccountOrderService.updateAddCheckingAccount(checkingAccountId, entity.getOrderId(),
							Calendar.getInstance().getTimeInMillis());
//					}
				}
			} else {
				start = false;
				break;
			}
			page++;
		}
	}
}
