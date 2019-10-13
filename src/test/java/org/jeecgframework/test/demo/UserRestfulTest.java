package org.jeecgframework.test.demo;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.jeecgframework.AbstractUnitTest;
import org.jeecgframework.core.util.PasswordUtil;
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
import com.xuzy.hotel.checkingaccount.entity.CvcCheckingAccountEntity;
import com.xuzy.hotel.checkingaccount.service.CvcCheckingAccountService;
import com.xuzy.hotel.checkingaccountorder.service.CvcCheckingAccountOrderService;
import com.xuzy.hotel.inventory.service.CvcInventoryTableServiceI;
import com.xuzy.hotel.order.entity.CvcOrderInfoEntity;
import com.xuzy.hotel.order.module.CallBaseRequest;
import com.xuzy.hotel.order.service.CvcOrderInfoService;
import com.xuzy.hotel.order.web.CvcOrderInfoController;
import com.xuzy.hotel.order.web.OrderCallBack;
import com.xuzy.hotel.ylrequest.ConmentHttp;
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
	
	//测试del
	@Test
	public void testDelete() throws Exception {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("X-Auth-Token", UUID.randomUUID().toString());
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		template.delete("http://localhost:8080/jeecg/rest/user/{id}","111111");
		
//		List<CvcOrderInfoEntity> cvcOrderInfoEntities = cvcOrderInfoService.getTogezelWuliuList();
//		for (CvcOrderInfoEntity cvcOrderInfoEntity : cvcOrderInfoEntities) {
//			System.out.println(cvcOrderInfoEntity.getId());
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
		
		systemService.initAllTypeGroups();
		
		CallBaseRequest baseRequest = ConmentHttp.postShentongValue("773001633635405",FileUtils.readFileToString(new File("/Users/zmeng/Documents/ceshi"), "utf-8"));
		ConmentHttp.postMyErrorOrder(baseRequest);
		orderCallBack.runByRequest(baseRequest);
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
	
	}
}


