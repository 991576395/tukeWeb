package org.jeecgframework.test.demo;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.jeecgframework.AbstractUnitTest;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.minidao.pojo.MiniDaoPage;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.util.PHPAndJavaSerialize;
import com.util.PhpDateUtils;
import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;
import com.xuzy.hotel.checkingaccount.service.CvcCheckingAccountService;
import com.xuzy.hotel.checkingaccountorder.service.CvcCheckingAccountOrderService;
import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.deliveryinfo.service.CvcDeliveryInfoService;
import com.xuzy.hotel.inventory.service.CvcInventoryTableServiceI;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.module.CallBaseRequest;
import com.xuzy.hotel.order.module.Data;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.order.web.CvcOrderInfoController;
import com.xuzy.hotel.order.web.OrderCallBack;
import com.xuzy.hotel.shipping.entity.CvcShippingEntity;
import com.xuzy.hotel.shipping.service.CvcShippingService;
import com.xuzy.hotel.ylrequest.ConmentHttp;
import com.xuzy.hotel.ylrequest.OrderCheckTask;
import com.xuzy.hotel.ylrequest.WuliuCheckTask;

/**
 * UserRestful单元测试Demo
 * 
 * @author scott
 */
public class UserRestfulTest extends AbstractUnitTest {
	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private CvcOrderInfoService cvcOrderInfoService;
	
	@Autowired
	private WuliuCheckTask wuliuCheckTask;
	
	 @Autowired
	 private CvcCheckingAccountService cvcCheckingAccountService;

	@Resource
	private OrderCallBack orderCallBack; 
	
	@Resource
	SystemService systemService;
	
	@Autowired
	OrderCheckTask orderCheckTask;
	
	
	
	@Autowired
	private CvcDeliveryInfoService cvcDeliveryInfoService;
	
	  
	// 测试get单个用户
	// @Test
	public void testGet() throws Exception {
		TSUser user = template.getForObject("http://localhost:8080/jeecg/rest/user/{id}", TSUser.class, "402880e74d75c4dd014d75d44af30005");

		// getForEntity与getForObject的区别是可以获取返回值和状态、头等信息
		ResponseEntity<TSUser> re = template.getForEntity("http://localhost:8080/jeecg/rest/user/{id}", TSUser.class, "402880e74d75c4dd014d75d44af30005");
		System.out.println(re.getStatusCode());
		System.out.println(re.getBody().getRealName());
	}

	// 测试get全部用户
	//@Test
	public void testGetAll() throws Exception {
		String str = template.getForObject("http://localhost:8080/jeecg/rest/user", String.class);
		
		Gson gson = new Gson();
		List<TSUser> list =gson.fromJson(str, new TypeToken<List<TSUser>>() {}.getType());
		for (TSUser r : list) {
			System.out.println("-----restful------" + r.getUserName());
			System.out.println("-----restful------" + r.getRealName());
		}
	}

	
	
	// 测试create
	 @Test
	public void testCreate() throws Exception {
		 HttpHeaders headers = new HttpHeaders();
		//  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 TSUser user = new TSUser();
		 user.setUserName("zhangsan");
		 user.setPassword(PasswordUtil.encrypt("zhangsan", "123456", PasswordUtil.getStaticSalt()));
		 user.setRealName("junit demo");
		 user.setStatus(Short.valueOf("1"));
		 user.setDeleteFlag(Short.valueOf("1"));
		 user.setDevFlag("1");
		 //  执行HTTP请求
//		 template.postForLocation("http://localhost:8080/jeecg/rest/user", user);
		 ResponseEntity<String> response = template.postForEntity("http://localhost:8080/jeecg/rest/user", user, String.class);
		 //  输出结果
		 System.out.println(response.getBody());
	}
	 
	 @Autowired
	 CvcOrderInfoController cvcOrderInfoController;
	 
	 @Autowired
	  private CvcCheckingAccountOrderService cvcCheckingAccountOrderService;
	// 测试update
	@Test
	public void testUpdate() throws Exception {
//		TSUser user = userService.get(TSUser.class, "402880e74d75c4dd014d75d44af30005");
//		user.setRealName("real demo");
//		template.put("http://localhost:8080/jeecg/rest/user/{id}", user, "402880e74d75c4dd014d75d44af30005");
		
//		int checkingAccountId = 864;
//		CvcCheckingAccountEntity  cvcOrderInfoEntity = cvcCheckingAccountService.get(checkingAccountId+"");
//		int page = 1;
//		CvcCheckingAccountOrderEntity query = new CvcCheckingAccountOrderEntity();
//		query.setIsAddCheckingAccount(0);
//		query.setOrderId(14032581);
//		MiniDaoPage<CvcCheckingAccountOrderEntity> list = cvcCheckingAccountOrderService.getAll(query, page, 10);
//		if(CollectionUtils.isNotEmpty(list.getResults())) {
//			for (CvcCheckingAccountOrderEntity entity : list.getResults()) {
//				RequestCheckingAccountDetailAddJson checkingAccountDetailAddJson = new RequestCheckingAccountDetailAddJson();
//				checkingAccountDetailAddJson.setCheckAccountInfoID(checkingAccountId);
//				checkingAccountDetailAddJson.setOrderID(entity.getOrderId());
//				checkingAccountDetailAddJson.setProductCode(entity.getGoodsSn());
//				checkingAccountDetailAddJson.setQuantity(entity.getGoodsNumber());
//				checkingAccountDetailAddJson.setEMSCompany("百世快递");
//				checkingAccountDetailAddJson.setDeliver(cvcOrderInfoEntity.getDeliver());
//				checkingAccountDetailAddJson.setAccountType(cvcOrderInfoEntity.getAccountType());
//				checkingAccountDetailAddJson.setOppStaff(cvcOrderInfoEntity.getOppstaff());
////				
////				//调用上传订单详情接口
//				ResponseHead responseHead = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
//						.setSequence(2)
//						.setServiceCode("CRMIF.CheckingAccountDetailAddJson")
//						.setParams(checkingAccountDetailAddJson).builder(), null);
//				if(responseHead.getReturn() >= 0) {
//					cvcCheckingAccountOrderService.updateAddCheckingAccount(checkingAccountId, entity.getOrderId(), PhpDateUtils.getTime());
//				}
//			}
//		}
		cvcOrderInfoController.orderStatusUpdate(14119978, "returnWareHouse", "", "");
	}
	
	@Autowired
	private CvcInventoryTableServiceI cvcInventoryTableService;
	
	@Autowired
	private CvcShippingService cvcShippingService;
	//测试del
	@Test
	public void testDelete() throws Exception {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("X-Auth-Token", UUID.randomUUID().toString());
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		template.delete("http://localhost:8080/jeecg/rest/user/{id}","111111");
		
//		CvcOrderInfoEntity cvcOrderInfo = new CvcOrderInfoEntity();
//		cvcOrderInfo.setId(14556995);
//		MiniDaoPage<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoService.getAll(cvcOrderInfo, 1, 1);
		
//		List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoService.getTogezelWuliuList();
//		for (CvcOrderInfoEntity cvcOrderInfoEntity : cvcOrderInfoEntities.getResults()) {
//			CvcShippingEntity cvcShipping = new CvcShippingEntity();
//			cvcShipping.setEnabled(1);
//			cvcShipping.setShippingName(cvcOrderInfoEntity.getShippingName());
//			//查询快递公司
//			MiniDaoPage<CvcShippingEntity> daoPage = cvcShippingService.getAll(cvcShipping, 1, 1);
//			CvcShippingEntity cvcShippingEntity = null;
//			if(CollectionUtils.isEmpty(daoPage.getResults())) {
//				continue;
//			}else {
//				cvcShippingEntity = daoPage.getResults().get(0);
//			}
//			String result = ConmentHttp.getOrderWuliu(cvcShippingEntity.getShippingCode(), cvcOrderInfoEntity.getInvoiceNo(), cvcOrderInfoEntity.getTel());
//			if(StringUtils.isNotEmpty(result) && result.contains("\"message\":\"ok\"")) {
//				ConmentHttp.postMyErrorOrder(result);
//			}
//		}
//		wuliuCheckTask.run();
		
//		final CountDownLatch countDownLatch = new CountDownLatch(100);
//		for(int i = 0; i < 100;i++) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						countDownLatch.await();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					//测试库存
//					cvcInventoryTableService.subInventory("100507001", 1, 0);
//				}
//			}).start();
//			countDownLatch.countDown();
//			System.out.println("启动:"+i);
//		}
//		
//		Thread.sleep(1000*60*60*10);
//		
//		systemService.initAllTypeGroups();
//		orderCheckTask.run();
//		CallBaseRequest baseRequest = ConmentHttp.postShentongValue("773017398093081",FileUtils.readFileToString(new File("/Users/zmeng/Documents/ceshi"), "utf-8"));
//		ConmentHttp.postMyErrorOrder(baseRequest);
//		orderCallBack.runByRequest(baseRequest);
//		发送物流
//		CvcCheckingAccountEntity cvcCheckingAccount = cvcCheckingAccountService.get("854");
//		List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoService.getAccountOrderList("", cvcCheckingAccount.getStartTime(), cvcCheckingAccount.getEndTime());
//		cvcCheckingAccountService.update(cvcCheckingAccount,cvcCheckingAccount.getCheckingAccountId(),cvcOrderInfoEntities);
//		RequestReturnedExchangeOrderJson exchangeOrderJson = new RequestReturnedExchangeOrderJson();
//		int id = 14108428;
//		exchangeOrderJson.setOrderID(id);
//		exchangeOrderJson.setReturningReason("");
//		exchangeOrderJson.setReturnedReason("");
//		ResponseHead head = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
//				.setParams(exchangeOrderJson).setSequence(2)
//				.setServiceCode("CRMIF.ReturnedExchangeOrderJson").builder(), null);
//		if(head.getReturn() >= 0) {
//			//退货
//			cvcOrderInfoService.updateStatusByOrderId(id, 8);
//		}
		
		//插入一条物流记录
		String values =	"ZL7ZVZGX4ZJS7S1,VZ7QX95BGWZZZ7V,ZG8ZR7V1KX2EZZ7,ZL7ZVZGXAZCA741,FZG5ZXX77DZZ1VC,VZ71XU77GCZZZ7A,1VZZ7GMZ15T7EZX,1ZFNV7Z7MZGZUXM";
		for(String value:values.split(",")) {
			CvcDeliveryInfoEntity cvcDeliveryInfo = new CvcDeliveryInfoEntity();
			cvcDeliveryInfo.setNumber(value);
			cvcDeliveryInfo.setMessage("ok");
			
			List<Data> datas = new ArrayList<>();
			Data data = new Data();
			data.setFtime(DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
			data.setTime(DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
			data.setContext("产品已经以短信的形式发送到您兑换的手机号上，请注意查收，如有疑问请致电010-67537412（工作日10:00-18:00）。");
			data.setShentongStatus("签收");
			datas.add(data);
			cvcDeliveryInfo.setData(PHPAndJavaSerialize.serialize(datas));
			cvcDeliveryInfo.setState(5);
			cvcDeliveryInfo.setCreateDate(DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
			//快递信息
			cvcDeliveryInfoService.insert(cvcDeliveryInfo);
		}
	}
	
	
	
	//测试del
	@Test
	public void addOrder() throws Exception {
//		CvcCheckingAccountEntity cvcCheckingAccount = cvcCheckingAccountService.get("904");
//		CvcOrderInfoEntity cvcOrderInfo = new CvcOrderInfoEntity();
//		cvcOrderInfo.setId(14431131);
//		MiniDaoPage<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoService.getAll(cvcOrderInfo, 1, 1);
//		cvcCheckingAccountService.update(cvcCheckingAccount,904,cvcOrderInfoEntities.getResults());
		CvcOrderInfoEntity query = new CvcOrderInfoEntity();
		query.setGetTimeStart("20200401");
		query.setGetTimeEnd("20200410");
		if(StringUtils.isNotEmpty(query.getGetTimeStart())) {
			try {
				Date date1 = DateUtils.parseDate(query.getGetTimeStart(),new String[] {"yyyyMMdd"}) ;
				query.setGetTimeStart(String.valueOf(PhpDateUtils.getTime(date1)));
			} catch (ParseException e) {
				query.setGetTimeStart("");
			}
		}
		
		if(StringUtils.isNotEmpty(query.getGetTimeEnd())) {
			try {
				Date date1 = DateUtils.parseDate(query.getGetTimeEnd(),new String[] {"yyyyMMdd"}) ;
				query.setGetTimeEnd(String.valueOf(PhpDateUtils.getTime(date1)));
			} catch (ParseException e) {
				query.setGetTimeEnd("");
			}
		}
		
		MiniDaoPage<CvcOrderInfoEntity> list = cvcOrderInfoService.getAll(query, 1, 30);
		if(CollectionUtils.isNotEmpty(list.getResults())) {
			for (CvcOrderInfoEntity entity : list.getResults()) {
				entity.setAddTime(PhpDateUtils.parseDate(Long.parseLong(entity.getAddTime()), "yyyy-MM-dd HH:mm:ss"));
				entity.setGetTime(PhpDateUtils.parseDate(Long.parseLong(entity.getGetTime()), "yyyy-MM-dd HH:mm:ss"));
				
				String value = (0 == entity.getExceptionStatus())?"无异常":"有异常";
				if(0 != entity.getExceptionStatus()) {
					value += (entity.getIsShow() == 1)?"(未处理)":"(已处理)";
				}
				
				entity.setExceptionStatusString(value);
			}
		}
		System.out.println(list.toString());
	}
}


