package com.xuzy.hotel.ylrequest;


import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.HttpRequest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wustrive.aesrsa.util.AES;
import com.wustrive.aesrsa.util.Base64;
import com.wustrive.aesrsa.util.RSA;
import com.xuzy.hotel.deliveryinfo.entity.CvcDeliveryInfoEntity;
import com.xuzy.hotel.order.dao.CvcOrderInfoDao;
import com.xuzy.hotel.order.module.CallBaseRequest;
import com.xuzy.hotel.order.module.Data;
import com.xuzy.hotel.order.module.LastResult;
import com.xuzy.hotel.ylrequest.module.ASABody;
import com.xuzy.hotel.ylrequest.module.ASAResponseBody;
import com.xuzy.hotel.ylrequest.module.Kuaidi100Request;
import com.xuzy.hotel.ylrequest.module.Kuaidi100Response;
import com.xuzy.hotel.ylrequest.module.LoginBody;
import com.xuzy.hotel.ylrequest.module.LoginResponseBody;
import com.xuzy.hotel.ylrequest.module.RequestDeliveryExchangeOrderJson;
import com.xuzy.hotel.ylrequest.module.RequestGetExchangeOrderListWaitDeliveryJson;
import com.xuzy.hotel.ylrequest.module.RequestRefuseExchangeOrderJson;
import com.xuzy.hotel.ylrequest.module.RequestSetOrdersReadJson;
import com.xuzy.hotel.ylrequest.module.RequestSignInExchangeOrderJson;
import com.xuzy.hotel.ylrequest.module.order.ExchangeOrder;

import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import oracle.net.aso.MD5;

/**
 * Created by uatzx03548 on 2018/10/29.
 */
public class ConmentHttp {
	
 	public static  Integer  size = 0;  
	
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ConmentHttp.class);
	
	
	public static Gson gson = new GsonBuilder().disableHtmlEscaping().create(); 
	
	private static final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
	
	private static final String KEY = "MfxXXpWd8126";
	private static final String URL = "http://www.kuaidi100.com/poll";
	private static final String URLNOW = "https://poll.kuaidi100.com/poll/query.do";
	private static final String CALLBACK = "http://47.96.119.244:8080/jeecg/callBack.do?result";
//	private static final String CALLBACK = "http://localhost:8080/tukeWeb/callBack.do?result";
	
    /**
     * 公用 mSequence
     */
    public static int mSequence = 0;
    	
    /**
     * 登陆失败次数
     */
    public static int  loginMaxFaild = 0;


    public static OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES).writeTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES)
            .build();
    
    /**
     * 物流状态监听
     * @param company 
     * @param number 
     */
    public static Kuaidi100Response postorder(String company, String number) { 
    	Kuaidi100Request kuaidi100Request = new Kuaidi100Request();
    	kuaidi100Request.setCompany(company);
    	kuaidi100Request.setNumber(number);
    	kuaidi100Request.setKey(KEY);
    	kuaidi100Request.getParameters().setCallbackurl(CALLBACK);
		// 开始请求URL
        Request request = new Request.Builder().url(URL)
                .post(new FormBody.Builder().add("schema", "json").add("param", gson.toJson(kuaidi100Request)).build())
                .build();
        Response response = null;
		try {
			response = ConmentHttp.okHttpClient.newCall(request).execute();
			String result = response.body().string();
			logger.info("result:"+result);
			return gson.fromJson(result, Kuaidi100Response.class);
		} catch (IOException e) {
			logger.error("订阅快递100异常",e);
		}
		return null;
    }
    
    
    public static void postErrorOrder(List<Data> datas,CvcDeliveryInfoEntity entity) { 
    	CallBaseRequest callbaseRequest = new CallBaseRequest();
    	callbaseRequest.setMessage("ok");
    	LastResult lastResult = new LastResult();
    	lastResult.setData(datas);
    	lastResult.setState(entity.getState());
    	lastResult.setNu(entity.getNumber());
    	lastResult.setMessage("ok");
    	callbaseRequest.setLastResult(lastResult);
		// 开始请求
        Request request = new Request.Builder().url(CALLBACK)
                .post(new FormBody.Builder().add("param", gson.toJson(callbaseRequest)).build())
                .build();
        Response response = null;
		try {
			response = ConmentHttp.okHttpClient.newCall(request).execute();
			String result = response.body().string();
			logger.info("result:"+result);
		} catch (IOException e) {
			logger.error("订阅快递100异常",e);
		}
    }
    
    
    public static void postMyErrorOrder() { 
    	String value = "{\"message\":\"ok\",\"nu\":\"240505147514\",\"ischeck\":\"1\",\"condition\":\"F00\",\"com\":\"shunfeng\",\"status\":\"200\",\"state\":\"3\",\"data\":[{\"time\":\"2019-01-21 10:43:32\",\"ftime\":\"2019-01-21 10:43:32\",\"context\":\"[周口市]已签收,感谢使用顺丰,期待再次为您服务\"},{\"time\":\"2019-01-21 10:43:14\",\"ftime\":\"2019-01-21 10:43:14\",\"context\":\"[周口市]快件交给李海燕，正在派送途中（联系电话：18839430299）\"},{\"time\":\"2019-01-20 09:26:05\",\"ftime\":\"2019-01-20 09:26:05\",\"context\":\"[周口市]收方客户要求自取快件,待自取\"},{\"time\":\"2019-01-20 09:09:48\",\"ftime\":\"2019-01-20 09:09:48\",\"context\":\"[周口市]快件交给梁磊阳，正在派送途中（联系电话：17538051642）\"},{\"time\":\"2019-01-20 08:27:20\",\"ftime\":\"2019-01-20 08:27:20\",\"context\":\"[周口市]快件到达 【周口扶沟鸿昌大道营业点】\"},{\"time\":\"2019-01-20 06:58:19\",\"ftime\":\"2019-01-20 06:58:19\",\"context\":\"[周口市]快件已发车\"},{\"time\":\"2019-01-19 22:17:22\",\"ftime\":\"2019-01-19 22:17:22\",\"context\":\"[周口市]快件在【周口开元集散点】已装车,准备发往 【周口扶沟鸿昌大道营业点】\"},{\"time\":\"2019-01-19 21:55:48\",\"ftime\":\"2019-01-19 21:55:48\",\"context\":\"[周口市]快件到达 【周口开元集散点】\"},{\"time\":\"2019-01-19 17:28:51\",\"ftime\":\"2019-01-19 17:28:51\",\"context\":\"[郑州市]快件已发车\"},{\"time\":\"2019-01-19 17:01:52\",\"ftime\":\"2019-01-19 17:01:52\",\"context\":\"[郑州市]快件在【郑州圃田集散中心】已装车,准备发往 【周口开元集散点】\"},{\"time\":\"2019-01-19 13:51:46\",\"ftime\":\"2019-01-19 13:51:46\",\"context\":\"[郑州市]快件到达 【郑州圃田集散中心】\"},{\"time\":\"2019-01-19 02:40:12\",\"ftime\":\"2019-01-19 02:40:12\",\"context\":\"[北京市]快件已发车\"},{\"time\":\"2019-01-19 02:39:58\",\"ftime\":\"2019-01-19 02:39:58\",\"context\":\"[北京市]快件在【北京大兴集散中心】已装车,准备发往下一站\"},{\"time\":\"2019-01-18 23:00:16\",\"ftime\":\"2019-01-18 23:00:16\",\"context\":\"[北京市]快件到达 【北京大兴集散中心】\"},{\"time\":\"2019-01-18 21:44:37\",\"ftime\":\"2019-01-18 21:44:37\",\"context\":\"[北京市]快件已发车\"},{\"time\":\"2019-01-18 21:05:49\",\"ftime\":\"2019-01-18 21:05:49\",\"context\":\"[北京市]快件在【北京百荣营业点】已装车,准备发往 【北京大兴集散中心】\"},{\"time\":\"2019-01-18 20:12:16\",\"ftime\":\"2019-01-18 20:12:16\",\"context\":\"[北京市]顺丰速运 已收取快件\"}]}";
    	
    	String str = "{\"status\":\"shutdown\",\"billstatus\":\"check\",\"message\":\"\",\"lastResult\":"+value+"}";
    	// 开始请求
        Request request = new Request.Builder().url(CALLBACK)
                .post(new FormBody.Builder().add("param", str).build())
                .build();
        Response response = null;
		try {
			response = ConmentHttp.okHttpClient.newCall(request).execute();
			String result = response.body().string();
			logger.info("result:"+result);
		} catch (IOException e) {
			logger.error("订阅快递100异常",e);
		}
    }
    
    /**
     * 物流状态监听
     * @param company 
     * @param number 
     * @throws Exception 
     */
    public static Kuaidi100Response postorderNow(String company, String number) throws Exception { 
    	Kuaidi100Request kuaidi100Request = new Kuaidi100Request();
    	kuaidi100Request.setCompany(company);
    	kuaidi100Request.setNumber(number);
    	kuaidi100Request.setKey(KEY);
//    	kuaidi100Request.getParameters().setCallbackurl(CALLBACK);
    	
    	String param ="{\"com\":\""+company+"\",\"num\":\""+number+"\"}";
    	String customer = KEY;
		String key = KEY;
		String sign = md5(param+key+customer);
		HashMap params = new HashMap();
		params.put("param",param);
		params.put("sign",sign);
		params.put("customer",customer);
    	
		// 开始请求
        Request request = new Request.Builder().url(URLNOW)
                .post(new FormBody.Builder().add("schema", "json").add("param", gson.toJson(params)).build())
                .build();
        Response response = null;
		try {
			response = ConmentHttp.okHttpClient.newCall(request).execute();
			String result = response.body().string();
			logger.info("result:"+result);
			return gson.fromJson(result, Kuaidi100Response.class);
		} catch (IOException e) {
			logger.error("订阅快递100异常",e);
		}
		return null;
    }
    
    /**
     * 物流状态监听
     * @param company 
     * @param number 
     * @throws Exception 
     */
    public static String getOrderWuliu(String company, String number) throws Exception { 
    	String param ="{\"com\":\"zhongtong\",\"num\":\"451367907337\"}";
		String customer ="MfxXXpWd8126";
		String key = KEY;
		String sign = md5(param+key+customer);
		HashMap params = new HashMap();
		params.put("param",param);
		params.put("sign",sign);
		params.put("customer",customer);
		String resp;
		
		try {
			// 开始请求
			Request request = new Request.Builder().url("https://poll.kuaidi100.com/poll/query.do")
					.post(new FormBody.Builder().add("param", param)
							.add("sign",sign)
							.add("customer",customer).build())
	                .build();
	        Response response  = okHttpClient.newCall(request).execute();
			System.out.println(response.body().string());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * MD5方法
     * 
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text) throws Exception {
        //加密后的字符串
        String encodeStr=DigestUtils.md5Hex(text);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }



    public static ResponseHead sendHttp(TukeRequestBody content,Class moduleType) throws IOException {
//    	if(loginMaxFaild >= 3) {
//    		ResponseHead head = new ResponseHead();
//    		head.setReturn(-1000);
//    		head.setReturnInfo("登录失败次数超过3次，请联系伊利或者重试！");
//    		loginMaxFaild = 0;
//    		return head;
//    	}
    	
    	
        StringBuffer sb = new StringBuffer();
        sb.append("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:dat=\"http://mmp.meichis.com/DataInterface/\">\r\n" + 
        		"   <soap:Header/>\r\n" + 
        		"   <soap:Body>\r\n" + 
        		"      <dat:Call>\r\n" + 
        		"         <!--Optional:-->\r\n" + 
        		"         <dat:RequestPack>");
        Gson gson = new GsonBuilder().disableHtmlEscaping().create(); 
        String ss1 = gson.toJson(content.getRequestPackBody());
        sb.append(ss1);
        sb.append(
                "</dat:RequestPack></dat:Call>\r\n" + 
                "   </soap:Body>\r\n" + 
                "</soap:Envelope>");
        logger.info("xml request： \n"+sb.toString());
        // 开始请求
        Request request = new Request.Builder().url(Config.SOAP_URL)
                .post(MultipartBody.create(MediaType.parse("application/soap+xml; charset=utf-8"),sb.toString()))
                .addHeader("action","http://mmp.meichis.com/DataInterface/Call")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        ResponseHead head = parseResponse(response.body().string(),moduleType);
        
        if(head.getReturn() < 0 && ("AuthKey Invalid!".equals(head.getReturnInfo())
        		|| "Decrypt Failed!".equals(head.getReturnInfo()))) {
        	getREAValue();
    		getLogin();
    		
    		content = new TukeRequestBody.Builder()
    				.setParams(content.getRequestPackBody().getParams())
    				.setSequence(content.getRequestPackBody().getSequence())
    				.setServiceCode(content.getRequestPackBody().getServiceCode())
    				.builder();
    		
    		if(loginMaxFaild >= 3 && StringUtils.isEmpty(content.getRequestPackBody().getAuthKey())) {
        		head = new ResponseHead();
        		head.setReturn(-1000);
        		head.setReturnInfo("登录失败次数超过3次，请联系伊利或者重试！");
        		loginMaxFaild = 0;
        		return head;
        	}
    		sendHttp(content,moduleType);
        }else if(head.getReturn() >= 0 && !"CRMIF.ApplyAESEncryptKeyJson".equals(content.getRequestPackBody().getServiceCode())){
        	loginMaxFaild = 0;
        }
        return head;
    }

    
    public static void getLogin() {
    	//登陆
		LoginBody loginBody = new LoginBody();
		loginBody.setUserName(Config.USERNAME);
		loginBody.setPassword(Config.PASSWORD);
		String params = ConmentHttp.gson.toJson(loginBody);
		try {
			params = new String(Base64.encode(AES.encrypt(params.getBytes(), Config.getAESKey() .getBytes(),Config.getAESIv().getBytes())));
			ResponseHead value = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setSequence(1)
					 .setServiceCode("CRMIF.LoginEx_ForDeliver")
					.setParams(params)
					.builder(),LoginResponseBody.class);
			LoginResponseBody loginResponseBody = (LoginResponseBody)value.getBody();
			if(value.getReturn() == 0) {
				Config.saveAuthkey(loginResponseBody.getAuthKey());
			}else {
				loginMaxFaild ++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


    public static void getREAValue() {
    	//获取密钥
		ASABody asaBody = new ASABody();
		asaBody.setModulus(RSA.modulus);
		asaBody.setExponent(RSA.exponent);
		try {
			ResponseHead RSAHead = ConmentHttp.sendHttp(
					new TukeRequestBody.Builder().setSequence(0).setServiceCode("CRMIF.ApplyAESEncryptKeyJson")
							.setParams(ConmentHttp.gson.toJson(asaBody)).builder(),
					ASAResponseBody.class);
			if (RSAHead.getReturn() == 0) {
				ASAResponseBody body = (ASAResponseBody) RSAHead.getBody();
				Config.saveAESKey(RSA.decrypt(body.getCryptAESKey(), RSA.privatekey));
				Config.saveAESIv(RSA.decrypt(body.getCryptAESIV(), RSA.privatekey));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static ResponseHead parseResponse(String value,Class moduleType) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new ByteArrayInputStream(value.getBytes()));
			Element element = document.getDocumentElement();
			NodeList list = element.getElementsByTagName("CallResult");
			if(list.getLength() > 0) {
				ResponseHead head = ConmentHttp.gson.fromJson(list.item(0).getTextContent(), ResponseHead.class);
				logger.info("response： \n"+head.toString());
				if(head.getReturn() >= 0 && head!=null && moduleType != null) {
					if(head.getSequence() != 0) {
						head.setResult(new String(AES.decrypt(Base64.decode(head.getResult().getBytes()),Config.getAESKey() .getBytes(),Config.getAESIv().getBytes())));
					}
					logger.info("getResult： \n"+head.getResult());
					Object obj = null;
					if(head.getResult().startsWith("[{")) {
						obj = head.getResult();
//						obj = ConmentHttp.gson.fromJson(head.getResult(), new TypeToken<List<Object>>(){}.getType());
					}else if(head.getResult().equals("[]")) {
						obj = null;
//						obj = ConmentHttp.gson.fromJson(head.getResult(), new TypeToken<List<Object>>(){}.getType());
					}else {
						obj = ConmentHttp.gson.fromJson(head.getResult(), moduleType);
					}
					head.setBody(obj);
				}
				return head;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
    
	
	private static void RefuseExchangeOrderJson(int orderId) {
		RequestRefuseExchangeOrderJson exchangeOrderJson = new RequestRefuseExchangeOrderJson();
		exchangeOrderJson.setOrderID(orderId);
		try {
			ResponseHead head = sendHttp(new TukeRequestBody.Builder()
					.setParams(exchangeOrderJson).setSequence(2)
					.setServiceCode("CRMIF.RefuseExchangeOrderJson").builder(), null);
			if(head.getReturn() >= 0) {
				IOUtils.write("\n"+orderId+"	"+"请求成功", new FileOutputStream("log.txt",true));
			}else {
				IOUtils.write("\n"+orderId+"	"+"请求失败"+"	"+" 原因:"+head.getReturnInfo(), new FileOutputStream("log.txt",true));
			}
		} catch (IOException e) {
			try {
				IOUtils.write("\n"+orderId+"	"+"请求失败"+"	"+" 异常:"+e.getMessage(), new FileOutputStream("log.txt",true));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * 签收
	 * @throws IOException
	 */
	private static void sign() throws IOException {
		RequestSignInExchangeOrderJson exchangeOrderJson = new RequestSignInExchangeOrderJson();
//		exchangeOrderJson.setOrderID(11607310);
//		exchangeOrderJson.setSignInMan("[恩施]已签收,感谢使用顺丰,期待再次为您服务");
//		exchangeOrderJson.setSignInDate("2018-09-06 14:30:27");
		
		exchangeOrderJson.setOrderID(11762926);
		exchangeOrderJson.setSignInMan("[武汉市]已签收,感谢使用顺丰,期待再次为您服务");
		exchangeOrderJson.setSignInDate("2018-10-13 09:34:14");
		
		ResponseHead value = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setSequence(4)
				 .setServiceCode("CRMIF.SignInExchangeOrderJson")
				.setParams(exchangeOrderJson)
				.builder(),null);
		System.out.println(value);
	}
	
	
	/**
	 * 配送中
	 * @throws IOException
	 */
	private static void DeliveryExchangeOrderJson() throws IOException {
		RequestDeliveryExchangeOrderJson exchangeOrderJson = new RequestDeliveryExchangeOrderJson();
//		exchangeOrderJson.setOrderID(11607310);
//		exchangeOrderJson.setSignInMan("[恩施]已签收,感谢使用顺丰,期待再次为您服务");
//		exchangeOrderJson.setSignInDate("2018-09-06 14:30:27");
		exchangeOrderJson.setOrderID(11762926);
		exchangeOrderJson.setDeliveryingDate("2018-10-11 15:25:08");
		
		ResponseHead value = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setSequence(4)
				 .setServiceCode("CRMIF.SignInExchangeOrderJson")
				.setParams(exchangeOrderJson)
				.builder(),null);
		System.out.println(value);
	}
	
	
	/**
	 * 抓单
	 */
	private static void getOrder() {
		RequestGetExchangeOrderListWaitDeliveryJson requestGetExchangeOrderListWaitDeliveryJson = new RequestGetExchangeOrderListWaitDeliveryJson();
		requestGetExchangeOrderListWaitDeliveryJson.setDeliverer(Config.DELIVERER);
		try {
			ResponseHead head =  ConmentHttp.sendHttp(new TukeRequestBody.Builder()
					.setSequence(3).setParams(requestGetExchangeOrderListWaitDeliveryJson)
					.setServiceCode("CRMIF.GetExchangeOrderListWaitDeliveryJson").builder(), ExchangeOrder.class);
			if(head.getReturn() >= 0) {
				List<ExchangeOrder> exchangeOrders = ConmentHttp.gson.fromJson(head.getResult(), new TypeToken<List<ExchangeOrder>>(){}.getType());
//				List<ExchangeOrder> exchangeOrders = ConmentHttp.gson.fromJson(result, new TypeToken<List<ExchangeOrder>>(){}.getType());
//				if(CollectionUtils.isNotEmpty(exchangeOrders)) {
//					cvcGetOrderStatisticsEntity = cvcGetOrderStatisticsService.addOrUpdateOrder(exchangeOrders);
//				}
				System.out.println(exchangeOrders.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
//		getOrder();
		postMyErrorOrder();
		
//		String json = "[{\"ID\":11912994,\"ClientID\":12595038,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"15878349585\",\"AcceptDate\":\"2018-11-09T18:47:48.63\",\"ConfirmDate\":\"2018-11-10T14:37:30\",\"PreArrivalDate\":\"2018-11-09T18:47:48.677\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":41978,\"DeliveryOfficialCityCode\":\"450302\",\"DeliveryOfficialCityName\":\"广西壮族自治区 桂林市 秀峰区 秀峰街道\",\"DeliveryAddre\":\"广西壮族自治区桂林市秀峰区秀峰街道 广源国际社区二栋三单元803 (备用电话：015878349585)\",\"Consignee\":\"金梦娜\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896796,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913996,\"ClientID\":17388628,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"13839854227\",\"AcceptDate\":\"2018-11-10T09:57:41.707\",\"ConfirmDate\":\"2018-11-10T14:28:14.997\",\"PreArrivalDate\":\"2018-11-10T09:57:41.753\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1198,\"DeliveryOfficialCityCode\":\"411202\",\"DeliveryOfficialCityName\":\"河南省 三门峡市 湖滨区\",\"DeliveryAddre\":\"河南省三门峡市湖滨区华创国际广场51号楼2单元2109 (备用电话：013839854227)\",\"Consignee\":\"赵朋华\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897798,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11897265,\"ClientID\":12402423,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"13561957959\",\"AcceptDate\":\"2018-11-01T13:56:32.01\",\"ConfirmDate\":\"2018-11-11T10:38:59.967\",\"PreArrivalDate\":\"2018-11-01T13:56:32.067\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":21282,\"DeliveryOfficialCityCode\":\"371122\",\"DeliveryOfficialCityName\":\"山东省 日照市 莒县 龙山镇\",\"DeliveryAddre\":\"山东省日照市莒县龙山镇 龙山镇西涝坡村 (备用电话：015163365906)\",\"Consignee\":\"张永秀\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15881069,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912355,\"ClientID\":18032910,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"013891736863\",\"AcceptDate\":\"2018-11-09T14:22:52.743\",\"ConfirmDate\":\"2018-11-10T14:27:21.373\",\"PreArrivalDate\":\"2018-11-09T14:22:52.773\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":925,\"DeliveryOfficialCityCode\":\"610324\",\"DeliveryOfficialCityName\":\"陕西省 宝鸡市 扶风县\",\"DeliveryAddre\":\"陕西省宝鸡市扶风县 老区华山大药房二店 (备用电话：013891736863)\",\"Consignee\":\"d高红涛\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896157,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11881044,\"ClientID\":11278153,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"013849798180\",\"AcceptDate\":\"2018-10-27T14:16:32.85\",\"ConfirmDate\":\"2018-11-11T11:09:23.057\",\"PreArrivalDate\":\"2018-10-27T14:16:32.853\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":37251,\"DeliveryOfficialCityCode\":\"411325\",\"DeliveryOfficialCityName\":\"河南省 南阳市 内乡县 灌张镇\",\"DeliveryAddre\":\"河南省南阳市内乡县灌张镇 泉舟奶粉专卖店 (备用电话：013849798180)\",\"Consignee\":\"贾正攀\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15864848,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11881055,\"ClientID\":11539137,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"013598269908\",\"AcceptDate\":\"2018-10-27T14:19:20.833\",\"ConfirmDate\":\"2018-11-11T11:09:28.45\",\"PreArrivalDate\":\"2018-10-27T14:19:20.89\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":37251,\"DeliveryOfficialCityCode\":\"411325\",\"DeliveryOfficialCityName\":\"河南省 南阳市 内乡县 灌张镇\",\"DeliveryAddre\":\"河南省南阳市内乡县灌张镇 泉舟奶粉专卖店 (备用电话：013598269908)\",\"Consignee\":\"齐雪华\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15864859,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11897697,\"ClientID\":9895206,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"13193969889\",\"AcceptDate\":\"2018-11-01T17:06:52.367\",\"ConfirmDate\":\"2018-11-11T11:21:27.32\",\"PreArrivalDate\":\"2018-11-01T17:06:52.43\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1198,\"DeliveryOfficialCityCode\":\"411202\",\"DeliveryOfficialCityName\":\"河南省 三门峡市 湖滨区\",\"DeliveryAddre\":\"河南省三门峡市湖滨区 湖滨区  建设路宏远市场亿天元孕婴广场 (备用电话：013193969889)\",\"Consignee\":\"刘\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15881501,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11897747,\"ClientID\":15353071,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"013525891773\",\"AcceptDate\":\"2018-11-01T17:24:51.38\",\"ConfirmDate\":\"2018-11-11T11:21:02.193\",\"PreArrivalDate\":\"2018-11-01T17:24:51.41\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1198,\"DeliveryOfficialCityCode\":\"411202\",\"DeliveryOfficialCityName\":\"河南省 三门峡市 湖滨区\",\"DeliveryAddre\":\"河南省三门峡市湖滨区 建设路宏远市场亿天元孕婴店 (备用电话：013525891773)\",\"Consignee\":\"美丽\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15881551,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913354,\"ClientID\":21084376,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利微信兑换\",\"TeleNum\":\"18331829579\",\"AcceptDate\":\"2018-11-09T21:02:31.853\",\"ConfirmDate\":\"2018-11-10T14:29:09.41\",\"PreArrivalDate\":\"2018-11-09T21:02:31.817\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1312,\"DeliveryOfficialCityCode\":\"131181\",\"DeliveryOfficialCityName\":\"河北省 衡水市 冀州市\",\"DeliveryAddre\":\"河北省衡水市冀州市 河北省衡水市冀州县西王镇东罗口村 (备用电话：018331829579)\",\"Consignee\":\"周雨\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897156,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913754,\"ClientID\":16366644,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"RMS------裴建会于2018-11-09 20:36:39,将状态更新为订单提交\",\"TeleNum\":\"18137640429\",\"AcceptDate\":\"2018-11-09T20:36:39.627\",\"ConfirmDate\":\"2018-11-10T14:32:45.483\",\"PreArrivalDate\":\"1900-01-01T00:00:00\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":2205,\"DeliveryOfficialCityCode\":\"411727\",\"DeliveryOfficialCityName\":\"河南省 驻马店市 汝南县\",\"DeliveryAddre\":\"河南省驻马店市汝南县井街 (备用电话：013900000000)\",\"Consignee\":\"田文清\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897556,\"Product\":\"1001010\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912250,\"ClientID\":18902013,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"18779962634\",\"AcceptDate\":\"2018-11-09T13:30:17.037\",\"ConfirmDate\":\"2018-11-10T14:32:50.837\",\"PreArrivalDate\":\"2018-11-09T13:30:17.083\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":26229,\"DeliveryOfficialCityCode\":\"360803\",\"DeliveryOfficialCityName\":\"江西省 吉安市 青原区 河东镇\",\"DeliveryAddre\":\"江西省吉安市青原区河东镇 龙湖大厦八楼801 (备用电话：018779962634)\",\"Consignee\":\"罗晶\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896052,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913757,\"ClientID\":16366644,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"商家中心------23270101496于2018-11-09 22:06:57,将状态更新为订单提交\",\"TeleNum\":\"13845733333\",\"AcceptDate\":\"2018-11-09T22:06:57.04\",\"ConfirmDate\":\"2018-11-10T14:34:33.07\",\"PreArrivalDate\":\"1900-01-01T00:00:00\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":3642,\"DeliveryOfficialCityCode\":\"232701\",\"DeliveryOfficialCityName\":\"黑龙江省 大兴安岭地区 加格达奇区\",\"DeliveryAddre\":\"哈尔滨市南岗区哈西南郡香醍雅诺小区 (备用电话：013900000000)\",\"Consignee\":\"赵志明\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897559,\"Product\":\"1001003\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11861521,\"ClientID\":19735602,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"汶上县尚书路宝相小区\",\"TeleNum\":\"13355101116\",\"AcceptDate\":\"2018-10-21T16:21:05.747\",\"ConfirmDate\":\"2018-11-11T10:45:22.947\",\"PreArrivalDate\":\"2018-10-21T16:21:05.613\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":20943,\"DeliveryOfficialCityCode\":\"370830\",\"DeliveryOfficialCityName\":\"山东省 济宁市 汶上县 汶上镇\",\"DeliveryAddre\":\"山东省济宁市汶上县汶上镇 山东省济宁市汶上县尚书路宝相小区 (备用电话：013355101116)\",\"Consignee\":\"徐恩举\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15845325,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913746,\"ClientID\":16366644,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"商家中心------2201220159于2018-11-09 11:56:31,将状态更新为订单提交\",\"TeleNum\":\"18943071252\",\"AcceptDate\":\"2018-11-09T11:56:31.283\",\"ConfirmDate\":\"2018-11-10T14:25:13.73\",\"PreArrivalDate\":\"1900-01-01T00:00:00\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1920,\"DeliveryOfficialCityCode\":\"220102\",\"DeliveryOfficialCityName\":\"吉林省 长春市 南关区\",\"DeliveryAddre\":\"吉林省长春市九台区吉林市结核病医院护理部 (备用电话：013900000000)\",\"Consignee\":\"于维\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897548,\"Product\":\"1001003\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913510,\"ClientID\":15523270,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"13947998243\",\"AcceptDate\":\"2018-11-09T22:12:43.45\",\"ConfirmDate\":\"2018-11-10T14:36:21.93\",\"PreArrivalDate\":\"2018-11-09T22:12:43.39\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":2710,\"DeliveryOfficialCityCode\":\"152502\",\"DeliveryOfficialCityName\":\"内蒙古自治区 锡林郭勒盟 锡林浩特市\",\"DeliveryAddre\":\"内蒙古自治区锡林郭勒盟锡林浩特市 朝阳小区5号楼1单元101室 (备用电话：018648048598)\",\"Consignee\":\"贾伟\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897312,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11914412,\"ClientID\":15387866,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"018160532326\",\"AcceptDate\":\"2018-11-10T12:54:30.54\",\"ConfirmDate\":\"2018-11-10T14:34:19.393\",\"PreArrivalDate\":\"2018-11-10T12:54:30.517\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":8126,\"DeliveryOfficialCityCode\":\"650105\",\"DeliveryOfficialCityName\":\"新疆维吾尔自治区 乌鲁木齐市 水磨沟区 水磨沟街道\",\"DeliveryAddre\":\"新疆维吾尔自治区乌鲁木齐市水磨沟区水磨沟街道 新疆乌鲁木齐市水磨沟区水磨沟街道温泉东路287号维斯特小区三期80号楼 (备用电话：018160532326)\",\"Consignee\":\"马维娟\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15898214,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912224,\"ClientID\":19134744,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利微信兑换\",\"TeleNum\":\"15319092303\",\"AcceptDate\":\"2018-11-09T13:12:00.983\",\"ConfirmDate\":\"2018-11-10T14:30:48.337\",\"PreArrivalDate\":\"2018-11-09T13:12:00.863\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1658,\"DeliveryOfficialCityCode\":\"610502\",\"DeliveryOfficialCityName\":\"陕西省 渭南市 临渭区\",\"DeliveryAddre\":\"陕西省渭南市临渭区 乐天大街仁和大厦一单元2303室 (备用电话：015591381060)\",\"Consignee\":\"赵艳\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896026,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912624,\"ClientID\":16802010,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"15104679263\",\"AcceptDate\":\"2018-11-09T16:20:38.657\",\"ConfirmDate\":\"2018-11-10T14:36:30.783\",\"PreArrivalDate\":\"2018-11-09T16:20:38.69\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":2739,\"DeliveryOfficialCityCode\":\"230110\",\"DeliveryOfficialCityName\":\"黑龙江省 哈尔滨市 香坊区\",\"DeliveryAddre\":\"黑龙江省哈尔滨市香坊区 幸福头道街18号万年乐仓买 (备用电话：015104679263)\",\"Consignee\":\"藤女士\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896426,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11870235,\"ClientID\":19391594,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利WAP兑换\",\"TeleNum\":\"15231688277\",\"AcceptDate\":\"2018-10-24T11:23:31.057\",\"ConfirmDate\":\"2018-11-10T15:29:03.193\",\"PreArrivalDate\":\"2018-10-24T11:23:31.04\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"<br/>----审核人:宁志凯于 2018-11-10 15:29:03 审核通过------△\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1783,\"DeliveryOfficialCityCode\":\"130824\",\"DeliveryOfficialCityName\":\"河北省 承德市 滦平县\",\"DeliveryAddre\":\"河北省承德市滦平县 聚贤楼横街艺宝阁 (备用电话：015037011737)\",\"Consignee\":\"朱涛\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15854039,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912870,\"ClientID\":19717148,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利微信兑换\",\"TeleNum\":\"13954675989\",\"AcceptDate\":\"2018-11-09T18:08:15.393\",\"ConfirmDate\":\"2018-11-10T14:27:06.54\",\"PreArrivalDate\":\"2018-11-09T18:08:15.377\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":831,\"DeliveryOfficialCityCode\":\"370502\",\"DeliveryOfficialCityName\":\"山东省 东营市 东营区\",\"DeliveryAddre\":\"山东省东营市东营区 西城南一路名流世家小区28号楼2单元402 (备用电话：013954675989)\",\"Consignee\":\"于雪\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896672,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11897292,\"ClientID\":12206299,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"15949991978\",\"AcceptDate\":\"2018-11-01T14:10:56.857\",\"ConfirmDate\":\"2018-11-11T10:38:52.273\",\"PreArrivalDate\":\"2018-11-01T14:10:56.827\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":21282,\"DeliveryOfficialCityCode\":\"371122\",\"DeliveryOfficialCityName\":\"山东省 日照市 莒县 龙山镇\",\"DeliveryAddre\":\"山东省日照市莒县龙山镇 龙山镇东楼村125号 (备用电话：013606330435)\",\"Consignee\":\"徐立华\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15881096,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912400,\"ClientID\":11369734,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"13792290633\",\"AcceptDate\":\"2018-11-09T14:41:15.1\",\"ConfirmDate\":\"2018-11-10T14:40:28.577\",\"PreArrivalDate\":\"2018-11-09T14:41:15.16\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":21963,\"DeliveryOfficialCityCode\":\"371626\",\"DeliveryOfficialCityName\":\"山东省 滨州市 邹平县 邹平镇\",\"DeliveryAddre\":\"山东省滨州市邹平县邹平镇 高新办小果村 (备用电话：013792290633)\",\"Consignee\":\"袁女士\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896202,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912426,\"ClientID\":21574728,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"18081334482\",\"AcceptDate\":\"2018-11-09T14:53:56.967\",\"ConfirmDate\":\"2018-11-10T14:27:10.047\",\"PreArrivalDate\":\"2018-11-09T14:53:56.997\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":12173,\"DeliveryOfficialCityCode\":\"511181\",\"DeliveryOfficialCityName\":\"四川省 乐山市 峨眉山市 符溪镇\",\"DeliveryAddre\":\"四川省乐山市峨眉山市符溪镇 符溪镇溪谷二期 (备用电话：018081334482)\",\"Consignee\":\"孙泽莉\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896228,\"Product\":\"10070169\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913398,\"ClientID\":20930329,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利WAP兑换\",\"TeleNum\":\"13614793446\",\"AcceptDate\":\"2018-11-09T21:21:21.14\",\"ConfirmDate\":\"2018-11-10T14:36:20.477\",\"PreArrivalDate\":\"2018-11-09T21:21:21.107\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":2710,\"DeliveryOfficialCityCode\":\"152502\",\"DeliveryOfficialCityName\":\"内蒙古自治区 锡林郭勒盟 锡林浩特市\",\"DeliveryAddre\":\"内蒙古自治区锡林郭勒盟锡林浩特市 元上塬小区15#3单元501 (备用电话：013614793446)\",\"Consignee\":\"孟晖\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897200,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913747,\"ClientID\":16366644,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"商家中心------2201220159于2018-11-09 11:56:31,将状态更新为订单提交\",\"TeleNum\":\"18943071252\",\"AcceptDate\":\"2018-11-09T11:56:31.47\",\"ConfirmDate\":\"2018-11-10T14:25:14.057\",\"PreArrivalDate\":\"1900-01-01T00:00:00\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1920,\"DeliveryOfficialCityCode\":\"220102\",\"DeliveryOfficialCityName\":\"吉林省 长春市 南关区\",\"DeliveryAddre\":\"吉林省长春市九台区吉林市结核病医院护理部 (备用电话：013900000000)\",\"Consignee\":\"于维\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897549,\"Product\":\"1001011\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11914398,\"ClientID\":13264859,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"013947051055\",\"AcceptDate\":\"2018-11-10T12:49:08.487\",\"ConfirmDate\":\"2018-11-10T14:27:10.79\",\"PreArrivalDate\":\"2018-11-10T12:49:08.463\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":52180,\"DeliveryOfficialCityCode\":\"150723\",\"DeliveryOfficialCityName\":\"内蒙古自治区 呼伦贝尔市 鄂伦春自治旗 大杨树镇\",\"DeliveryAddre\":\"内蒙古自治区呼伦贝尔市鄂伦春自治旗大杨树镇 大杨树镇吉日庆典一楼门市 (备用电话：013947051055)\",\"Consignee\":\"马伟华\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15898200,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913921,\"ClientID\":18657570,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"15034922340\",\"AcceptDate\":\"2018-11-10T09:22:45.867\",\"ConfirmDate\":\"2018-11-10T14:28:45.493\",\"PreArrivalDate\":\"2018-11-10T09:22:45.897\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1265,\"DeliveryOfficialCityCode\":\"150103\",\"DeliveryOfficialCityName\":\"内蒙古自治区 呼和浩特市 回民区\",\"DeliveryAddre\":\"内蒙古自治区呼和浩特市回民区草原明珠小区17号楼一单元202室 (备用电话：015034922340)\",\"Consignee\":\"郭钰峰\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897723,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912373,\"ClientID\":15745695,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利微信兑换\",\"TeleNum\":\"15964660100\",\"AcceptDate\":\"2018-11-09T14:30:25.24\",\"ConfirmDate\":\"2018-11-10T14:31:40.37\",\"PreArrivalDate\":\"2018-11-09T14:30:25.23\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1890,\"DeliveryOfficialCityCode\":\"371702\",\"DeliveryOfficialCityName\":\"山东省 菏泽市 牡丹区\",\"DeliveryAddre\":\"山东省菏泽市牡丹区 南站小区10号楼四单元202室 (备用电话：015964660100)\",\"Consignee\":\"赵磊\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896175,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11897725,\"ClientID\":13396024,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"15139807077\",\"AcceptDate\":\"2018-11-01T17:16:58.443\",\"ConfirmDate\":\"2018-11-11T11:21:09.417\",\"PreArrivalDate\":\"2018-11-01T17:16:58.477\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1198,\"DeliveryOfficialCityCode\":\"411202\",\"DeliveryOfficialCityName\":\"河南省 三门峡市 湖滨区\",\"DeliveryAddre\":\"河南省三门峡市湖滨区 建设路宏远市场亿天元孕婴店 (备用电话：015139807077)\",\"Consignee\":\"美丽\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15881529,\"Product\":\"10010423\",\"BookQuantity\":2,\"SignInQuantity\":2}]},{\"ID\":11912425,\"ClientID\":22165505,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利微信兑换\",\"TeleNum\":\"13716891298\",\"AcceptDate\":\"2018-11-09T14:53:22.803\",\"ConfirmDate\":\"2018-11-10T14:41:00.21\",\"PreArrivalDate\":\"2018-11-09T14:53:22.787\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":719,\"DeliveryOfficialCityCode\":\"110115\",\"DeliveryOfficialCityName\":\"北京市 市辖区 大兴区\",\"DeliveryAddre\":\"北京市市辖区大兴区 北京市大兴区黄村镇宋庄村 (备用电话：013716891298)\",\"Consignee\":\"董春生\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896227,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912274,\"ClientID\":21186030,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利微信兑换\",\"TeleNum\":\"15909578620\",\"AcceptDate\":\"2018-11-09T13:43:10.557\",\"ConfirmDate\":\"2018-11-10T14:39:10.58\",\"PreArrivalDate\":\"2018-11-09T13:43:10.53\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":3105,\"DeliveryOfficialCityCode\":\"640402\",\"DeliveryOfficialCityName\":\"宁夏回族自治区 固原市 原州区\",\"DeliveryAddre\":\"宁夏回族自治区固原市原州区 宁夏固原市原州区锦绣苑4号楼1单元 (备用电话：015909578620)\",\"Consignee\":\"郑向荣\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896076,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11848036,\"ClientID\":22270682,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"13633359655\",\"AcceptDate\":\"2018-10-17T21:20:57.07\",\"ConfirmDate\":\"2018-11-11T09:14:51.15\",\"PreArrivalDate\":\"2018-10-17T21:20:57.013\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":38670,\"DeliveryOfficialCityCode\":\"130322\",\"DeliveryOfficialCityName\":\"河北省 秦皇岛市 昌黎县 刘台庄镇\",\"DeliveryAddre\":\"河北省秦皇岛市昌黎县刘台庄镇 刘台庄镇家惠超市对面112号 (备用电话：013373285099)\",\"Consignee\":\"罗长伟\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15831840,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11914210,\"ClientID\":18294671,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利微信兑换\",\"TeleNum\":\"16604723055\",\"AcceptDate\":\"2018-11-10T11:23:02.1\",\"ConfirmDate\":\"2018-11-10T14:30:07.36\",\"PreArrivalDate\":\"2018-11-10T11:23:02.03\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1532,\"DeliveryOfficialCityCode\":\"150203\",\"DeliveryOfficialCityName\":\"内蒙古自治区 包头市 昆都仑区\",\"DeliveryAddre\":\"内蒙古自治区包头市昆都仑区 白云路西乌兰道颐园小区底店梁记家常菜 (备用电话：016604723055)\",\"Consignee\":\"梁霞\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15898012,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913750,\"ClientID\":16366644,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"商家中心------3209230112于2018-11-09 15:37:10,将状态更新为订单提交\",\"TeleNum\":\"13092107395\",\"AcceptDate\":\"2018-11-09T15:37:10.483\",\"ConfirmDate\":\"2018-11-10T14:27:37.123\",\"PreArrivalDate\":\"1900-01-01T00:00:00\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":950,\"DeliveryOfficialCityCode\":\"320923\",\"DeliveryOfficialCityName\":\"江苏省 盐城市 阜宁县\",\"DeliveryAddre\":\"阜宁县盛利家园6号楼101室 (备用电话：013900000000)\",\"Consignee\":\"孙楠\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897552,\"Product\":\"1001010\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11897786,\"ClientID\":13068995,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"018239802542\",\"AcceptDate\":\"2018-11-01T17:42:22.01\",\"ConfirmDate\":\"2018-11-11T11:21:29.557\",\"PreArrivalDate\":\"2018-11-01T17:42:22.003\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1198,\"DeliveryOfficialCityCode\":\"411202\",\"DeliveryOfficialCityName\":\"河南省 三门峡市 湖滨区\",\"DeliveryAddre\":\"河南省三门峡市湖滨区 建设路宏远市场亿天元孕婴店 (备用电话：018239802542)\",\"Consignee\":\"美丽\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15881590,\"Product\":\"10010423\",\"BookQuantity\":2,\"SignInQuantity\":2}]},{\"ID\":11913180,\"ClientID\":16874324,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利WAP兑换\",\"TeleNum\":\"15930605571\",\"AcceptDate\":\"2018-11-09T19:58:35.07\",\"ConfirmDate\":\"2018-11-10T14:25:34.607\",\"PreArrivalDate\":\"2018-11-09T19:58:35.043\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":475,\"DeliveryOfficialCityCode\":\"131081\",\"DeliveryOfficialCityName\":\"河北省 廊坊市 霸州市\",\"DeliveryAddre\":\"河北省廊坊市霸州市 北杨庄村民中心 (备用电话：015081665533)\",\"Consignee\":\"张娜\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896982,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11914045,\"ClientID\":18650242,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"修改送货地址信息\",\"TeleNum\":\"15936221928\",\"AcceptDate\":\"2018-11-10T10:17:03.313\",\"ConfirmDate\":\"2018-11-10T14:30:51.81\",\"PreArrivalDate\":\"2018-11-10T10:17:03.28\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1668,\"DeliveryOfficialCityCode\":\"411122\",\"DeliveryOfficialCityName\":\"河南省 漯河市 临颍县\",\"DeliveryAddre\":\"河南省漯河市临颍县 城关镇东风巷65号县直幼儿园路口南边路 (备用电话：015936221928)\",\"Consignee\":\"梁卜允\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897847,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11897714,\"ClientID\":13245763,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"15346102229\",\"AcceptDate\":\"2018-11-01T17:11:24.983\",\"ConfirmDate\":\"2018-11-11T11:21:17.277\",\"PreArrivalDate\":\"2018-11-01T17:11:24.993\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1198,\"DeliveryOfficialCityCode\":\"411202\",\"DeliveryOfficialCityName\":\"河南省 三门峡市 湖滨区\",\"DeliveryAddre\":\"河南省三门峡市湖滨区 湖滨区 湖滨区 建设路宏远市场亿天元孕婴广场 (备用电话：015346102229)\",\"Consignee\":\"梅丽丽\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15881518,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912841,\"ClientID\":18803228,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利微信兑换\",\"TeleNum\":\"15094000833\",\"AcceptDate\":\"2018-11-09T18:00:39.177\",\"ConfirmDate\":\"2018-11-10T14:30:16.193\",\"PreArrivalDate\":\"2018-11-09T18:00:39.147\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1553,\"DeliveryOfficialCityCode\":\"610122\",\"DeliveryOfficialCityName\":\"陕西省 西安市 蓝田县\",\"DeliveryAddre\":\"陕西省西安市蓝田县曳湖镇杜坪村 (备用电话：015094000833)\",\"Consignee\":\"陈英茹\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896643,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11913741,\"ClientID\":16366644,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"商家中心------34032339004于2018-11-09 10:21:15,将状态更新为订单提交\",\"TeleNum\":\"18160819373\",\"AcceptDate\":\"2018-11-09T10:21:15.693\",\"ConfirmDate\":\"2018-11-10T14:25:12.313\",\"PreArrivalDate\":\"1900-01-01T00:00:00\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1045,\"DeliveryOfficialCityCode\":\"340323\",\"DeliveryOfficialCityName\":\"安徽省 蚌埠市 固镇县\",\"DeliveryAddre\":\"安徽省蚌埠市固镇县城翠湖花园 (备用电话：013900000000)\",\"Consignee\":\"陈雷\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15897543,\"Product\":\"1001004\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11912556,\"ClientID\":17050398,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"通过伊利WAP兑换\",\"TeleNum\":\"13201518361\",\"AcceptDate\":\"2018-11-09T15:50:51.467\",\"ConfirmDate\":\"2018-11-10T14:30:26.923\",\"PreArrivalDate\":\"2018-11-09T15:50:51.43\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":1588,\"DeliveryOfficialCityCode\":\"610425\",\"DeliveryOfficialCityName\":\"陕西省 咸阳市 礼泉县\",\"DeliveryAddre\":\"陕西省咸阳市礼泉县城关镇张里村 (备用电话：015619541296)\",\"Consignee\":\"郑帅\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15896358,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]},{\"ID\":11811288,\"ClientID\":12132682,\"State\":12,\"StateName\":\"已审核\",\"OrderSource\":5,\"OrderSourceName\":\"积分订单\",\"AcceptRemark\":\"\",\"TeleNum\":\"015994123539\",\"AcceptDate\":\"2018-10-10T10:34:17.72\",\"ConfirmDate\":\"2018-11-11T10:53:58.063\",\"PreArrivalDate\":\"2018-10-10T10:34:17.68\",\"OFFHardbourDate\":\"1900-01-01T00:00:00\",\"BeginDeliveryDate\":\"1900-01-01T00:00:00\",\"SignInDate\":\"1900-01-01T00:00:00\",\"SignInMan\":\"\",\"Remark\":\"\",\"DeliveryCompany\":\"\",\"DeliverySheetCode\":\"\",\"DeliveryOfficialCity\":36459,\"DeliveryOfficialCityCode\":\"410523\",\"DeliveryOfficialCityName\":\"河南省 安阳市 汤阴县 菜园镇\",\"DeliveryAddre\":\"河南省安阳市汤阴县菜园镇 菜园镇南街步行街BABY宝贝 (备用电话：015994123539)\",\"Consignee\":\"刘怡瑶\",\"Deliverer\":16,\"AccountType\":\"金领冠\",\"Items\":[{\"ID\":15795092,\"Product\":\"10010423\",\"BookQuantity\":1,\"SignInQuantity\":1}]}]\r\n";
//		Object obj = ConmentHttp.gson.fromJson(json, new TypeToken<List<Object>>(){}.getType());
//		System.out.println(obj);
//		RefuseExchangeOrderJson(11928244);
//		String json = "[\"9727493\",\"9736004\",\"9736454\",\"9737432\",\"9747386\",\"9766715\",\"9803216\",\"9805774\",\"9836011\",\"9844311\",\"9877113\",\"9894955\",\"9895199\",\"9895973\",\"9896807\",\"9896862\",\"9897006\",\"9897463\",\"9897501\",\"9904303\",\"9905227\",\"9911852\",\"9911873\",\"9912017\",\"9912101\",\"9912182\",\"9912303\",\"9912643\",\"9913020\",\"9913124\",\"9913146\",\"9913161\",\"9913227\",\"9913296\",\"9913314\",\"9913430\",\"9913437\",\"9913469\",\"9913477\",\"9913526\",\"9913725\",\"9913830\",\"9914030\",\"9914144\",\"9914199\",\"9914291\",\"9914579\",\"9915012\",\"9915329\",\"9915359\",\"9915570\",\"9916358\",\"9916856\",\"9916959\",\"9918369\",\"9918596\",\"9918661\",\"9919121\",\"9919303\",\"9921007\",\"9921031\",\"9921460\",\"9922044\",\"9922100\",\"9922372\",\"9922569\",\"9922714\",\"9922831\",\"9923095\",\"9923619\",\"9923906\",\"9924075\",\"9924302\",\"9925653\",\"9926456\",\"9926562\",\"9926878\",\"9927268\",\"9927305\",\"9927360\",\"9927458\",\"9927612\",\"9927653\",\"9927921\",\"9928274\",\"9928374\",\"9928498\",\"9928520\",\"9928862\",\"9928894\",\"9928941\",\"9929375\",\"9929769\",\"9929831\",\"9929869\",\"9929966\",\"9930049\",\"9930115\",\"9930217\",\"9930226\",\"9930563\",\"9930621\",\"9930700\",\"9930725\",\"9930816\",\"9930864\",\"9930935\",\"9931108\",\"9931567\",\"9931639\",\"9931952\",\"9932120\",\"9932166\",\"9932439\",\"9932640\",\"9932901\",\"9933040\",\"9933160\",\"9933200\",\"9933340\",\"9933438\",\"9933833\",\"9933850\",\"9934089\",\"9938655\",\"9940914\",\"9942233\",\"9942238\",\"9942249\"]";
//		List<Integer> objs = ConmentHttp.gson.fromJson(json, new TypeToken<List<Integer>>(){}.getType());
//		System.out.println(objs.size());
//		for(Integer va:objs) {
//			RefuseExchangeOrderJson(9768073);
//		}
//		sign();
//		DeliveryExchangeOrderJson();
//		Method method = CvcOrderInfoDao.class.getMethod("getAccountOrders", String.class,String.class,String.class);
//		String name = method.getDeclaringClass().getName();
//		System.out.println(name);
//		String path = name.replace(".", "/").replace("/dao/", "/sql/") + "_" + method.getName() + ".sql";
//		System.out.println(path);
//		getOrderWuliu("","");
		//20181214
//		postorder("shentong","3391128260685");
//		postorder("shentong","3391128485761");
//		postorder("shentong","3391128042280");
//		postorder("shentong","3391128402366");
//		postorder("shentong","3391128402342");
//		postorder("shentong","3391128187997");
//		postorder("shentong","3391128042205");
//		postorder("shentong","3391128327211");
//		postorder("shentong","3391128042163");
//		postorder("shentong","3391128116536");
//		postorder("shentong","3391128042138");
//		postorder("shentong","3391128402263");
//		postorder("shentong","3391128402238");
//		postorder("shentong","3391128187875");
//		postorder("shentong","3391128187810");
//		postorder("shentong","3391127940317");
//		postorder("shentong","3391127347564");
//		postorder("shentong","3391128402226");
//		postorder("shentong","3391128485566");
			
		//20181213
//		postorder("shentong","3390260303900");
//		postorder("shentong","3390260285172");
//		postorder("shentong","3390260359752");
//		postorder("shentong","3390260280745");
//		postorder("shentong","3390259434007");
//		postorder("shentong","3390260211909");
//		postorder("shentong","3390259274791");
//		postorder("shentong","3390259274808");
//		postorder("shentong","3390260211892");
//		postorder("shentong","3390259430708");
//		postorder("shentong","3390260126730");
//		postorder("shentong","3390260126728");
//		postorder("shentong","3390260273219");
//		postorder("shunfeng","297236785316");
//		postorder("shentong","3390260261468");
//		postorder("shentong","3390259492882");
//		postorder("shentong","3390260385844");
//		postorder("shentong","3390259424050");
//		postorder("shentong","3390259265703");
//		postorder("shentong","3390259492810");
//		postorder("shentong","3390260073236");
//		postorder("shentong","3390260116295");
//		postorder("shentong","3390260192499");
		//20181217
//		postorder("shentong","3391127378866");
//		postorder("shentong","3391127302578");
//		postorder("shentong","3391126696582");
//		postorder("shentong","3391127302580");
//		postorder("shentong","3391127465992");
//		postorder("shentong","3391127544099");
//		postorder("shentong","3391127618187");
//		postorder("shentong","3391127193834");
//		postorder("shentong","3391127544129");
//		postorder("shentong","3391127686868");
//		postorder("shentong","3391127378957");
//		postorder("shentong","3391127544257");
//		postorder("shentong","3391126696703");
//		postorder("shentong","3391127236061");
//		postorder("shentong","3391127114644");
//		postorder("shentong","3391127687163");
//		postorder("shentong","3391127544324");
//		postorder("shentong","3391127687254");
//		postorder("shentong","3391127379392");
//		postorder("shentong","3391127236292");
//		postorder("shentong","3391127544464");
//		postorder("shentong","3391127236437");
//		postorder("shentong","3391127687369");
//		postorder("shentong","3391126697071");
//		postorder("shentong","3391126697113");
//		postorder("shentong","3391127687412");
//		postorder("shentong","3391127466754");
//		postorder("shentong","3391127302920");
//		postorder("shentong","3391127379665");
//		postorder("shentong","3391127194669");
//		postorder("shentong","3391127618801");
//		postorder("shentong","3391127379695");
//		postorder("shentong","3391126697253");
//		postorder("shentong","3391127544968");
//		postorder("shentong","3391127618886");
//		postorder("shentong","3391127687855");
//		postorder("shentong","3391127545032");
//		postorder("shentong","3391127379847");
//		postorder("shentong","3391127687886");
//		postorder("shentong","3391127303146");
//		postorder("shentong","3391127687965");
//		postorder("shentong","3391127115443");
//		postorder("shentong","3391126697370");
//		postorder("shentong","3391127195085");
//		postorder("shentong","3391126697411");
//		postorder("shentong","3391126697423");
//		postorder("shentong","3391127619125");
//		postorder("shentong","3391127688107");
//		postorder("shentong","3391127688119");
//		postorder("shentong","3391127688132");
//		postorder("shentong","3391127115686");
//		postorder("shentong","3391127115698");
//		postorder("shentong","3391126697605");
//		postorder("shentong","3391127195304");
//		postorder("shentong","3391126697666");
//		postorder("shentong","3391127380076");
//		postorder("shentong","3391126697691");
//		postorder("shentong","3391127380106");
//		postorder("shentong","3391127619351");
//		postorder("shentong","3391126697775");
//		postorder("shentong","3391127115870");
//		postorder("shentong","3391127115893");
//		postorder("shentong","3391127467784");
//		postorder("shentong","3391126697848");
//		postorder("shentong","3391127303535");
//		postorder("shentong","3391126697885");
//		postorder("shentong","3391127380131");
//		postorder("shentong","3391127619545");
//		postorder("shentong","3391127619612");
//		postorder("shentong","3391127237431");
//		postorder("shentong","3391127468250");
//		postorder("shentong","3391127237485");
//		postorder("shentong","3391127303640");
//		postorder("shentong","3391126697988");
//		postorder("shentong","3391127195780");
//		postorder("shentong","3391127116187");
//		postorder("shentong","3391127882799");
		//20181218
//		postorder("shentong","3391282846958");
			
		//20181219
//		postorder("shentong","3391284130689");
//		postorder("shentong","3391283981040");
//		postorder("shentong","3391284131749");
//		postorder("shentong","3391283981348");
//		postorder("shentong","3391283730163");
//		postorder("shentong","3391283729650");

		
//		postorderNow("shunfeng","297236769433");
//		postorder("shentong","3392772492063");
		
//		postorder("shunfeng","296909731486");	
		
		
//		postorder("shentong","3391456772945");
//		postorder("shentong","3391456303085");
//		postorder("shentong","3391456149335");
//		postorder("shentong","3391457043990");
//		postorder("shentong","3391456980524");
//		postorder("shentong","3391456297415");
//		postorder("shentong","3391456620831");
//		postorder("shentong","3391456758075");
//		postorder("shentong","3391456980548");
//		postorder("shentong","3391456149354");
//		postorder("shentong","3391456303103");
//		postorder("shentong","3391456902327");
//		postorder("shentong","3391456823399");
//		postorder("shentong","3391457119169");
//		postorder("shentong","3391457133395");
//		postorder("shentong","3391457059257");
//		postorder("shentong","3391456149366");
//		postorder("shentong","3391456823405");
//		postorder("shentong","3391457059275");
//		postorder("shentong","3391456634927");
//		postorder("shentong","3391456902339");
//		postorder("shentong","3391456758105");
//		postorder("shentong","3391456902345");
//		postorder("shentong","3391457133474");
//		postorder("shentong","3391456823521");
//		postorder("shentong","3391456895793");
//		postorder("shentong","3391456823533");
//		postorder("shentong","3391457059336");
//		postorder("shentong","3391457133619");
//		postorder("shentong","3391457133632");
//		postorder("shentong","3391456823569");
//		postorder("shentong","3391456635106");
//		postorder("shentong","3391456902388");
//		postorder("shentong","3391456823605");
//		postorder("shentong","3391457059415");
//		postorder("shentong","3391456823624");
//		postorder("shentong","3391456823648");
//		postorder("shentong","3391457133814");
//		postorder("shentong","3391456902406");
//		postorder("shentong","3391456708936");
//		postorder("shentong","3391456709050");
//		postorder("shentong","3391456773385");
//		postorder("shentong","3391456149457");
//		postorder("shentong","3391456149469");
//		postorder("shentong","3391456303346");
//		postorder("shentong","3391457059531");
//		postorder("shentong","3391456620915");
//		postorder("shentong","3391456297460");
//		postorder("shentong","3391456823685");
//		postorder("shentong","3391456149494");
//		postorder("shentong","3391457133929");
//		postorder("shentong","3391456823697");
//		postorder("shentong","3391456149536");
//		postorder("shentong","3391456694287");
//		postorder("shentong","3391456898189");
//		postorder("shentong","3391456635507");
//		postorder("shentong","3391456149561");
//		postorder("shentong","3391456709218");
//		postorder("shentong","3391456635532");
//		postorder("shentong","3391456980937");
//		postorder("shentong","3391457059755");
//		postorder("shentong","3391456902467");
//		postorder("shentong","3391456149615");
//		postorder("shentong","3391457059798");
//		postorder("shentong","3391456980974");
//		postorder("shentong","3391456149676");
//		postorder("shentong","3391457134169");
//		postorder("shunfeng","252397283386");
//		postorder("shunfeng","252397283304");
//		postorder("shunfeng","252397283491");
//		postorder("shunfeng","252397283816");
//		postorder("shentong","3391457059830");
//		postorder("shentong","3391456303425");
//		postorder("shentong","3391456709437");
//		postorder("shentong","3391456303437");
//		postorder("shentong","3391456981025");
//		postorder("shentong","3391456303455");
//		postorder("shentong","3391456303462");
//		postorder("shentong","3391457134339");
//		postorder("shentong","3391456902583");
//		postorder("shentong","3391456981074");
//		postorder("shentong","3391457134479");
//		postorder("shentong","3391456709528");
//		postorder("shentong","3391456709530");
//		postorder("shentong","3391456762335");
//		postorder("shentong","3391457060105");
//		postorder("shentong","3391456823820");
//		postorder("shentong","3391457060124");
//		postorder("shentong","3391456144958");
//		postorder("shentong","3391456981116");
//		postorder("shentong","3391457134583");
//		postorder("shentong","3391456902315");
//		postorder("shentong","3391456823326");
//		postorder("shentong","3391456303516");
//		postorder("shentong","3391456709607");
//		postorder("shentong","3391456902716");
//		postorder("shentong","3391456981268");
//		postorder("shentong","3391456902303");
//		postorder("shentong","3391456149785");
		
		
//		RequestSetOrdersReadJson params = new RequestSetOrdersReadJson();
//		params.setOrderIDs("12007591,12007592,12007594");
//		ResponseHead head = ConmentHttp.sendHttp(new TukeRequestBody.Builder()
//				.setSequence(2)
//				.setServiceCode("CRMIF.SetOrdersReadJson")
//				.setParams(params).builder(), null);
		
		
		
	}
}
