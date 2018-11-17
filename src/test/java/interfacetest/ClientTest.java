package interfacetest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.appinterface.app.base.core.entity.request.AppRequest;
import com.appinterface.app.base.core.entity.request.Requestbody;
import com.appinterface.app.base.core.entity.request.Requesthead;
import com.appinterface.app.base.core.entity.request.UnipayBaseRequest;
import com.appinterface.app.bussiness.client.dto.GetAlertDto;
import com.appinterface.app.bussiness.client.dto.QueryClientDto;
import com.google.gson.Gson;
import com.xuzy.hotel.client.entity.TSClientTableEntity;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ClientTest {
	@Test
	public void test() throws ClientProtocolException, IOException {
		AppRequest request = new AppRequest();
		UnipayBaseRequest<TSClientTableEntity> requestData=  new UnipayBaseRequest();
		Requesthead requesthead = new Requesthead();
		requesthead.setSubMethod("addOrUpdateClientInfo");
		requesthead.setOs("android");
		requesthead.setAppCode("1.1.23");
		
		TSClientTableEntity entity = new TSClientTableEntity();
//		entity.setId("4028d68163c4cc0e0163c4cd18090000");
		entity.setName("測試");
		entity.setAddress("上海市浦東新區");
		entity.setCommpany("浦發銀行技術中心");
		entity.setBirthday("19921217");
		entity.setPhone("13795463263");
		entity.setSex("女");
		entity.setOrderperiod("1");
		entity.setOrdertype("1");
		entity.setContent("啊告訴了大家哥斯拉打卡快樂管理");
		requestData.setRequestbody(entity);
		
		Gson gson = new Gson();
		requestData.setRequesthead(requesthead);
		request.setRequest(requestData);
		request.setRequestsecurity(null);
		
		
		String requesString =  gson.toJson(request);
		System.out.println(requesString);
		
		OkHttpClient client= new OkHttpClient();
		Call call= client.newCall(new Request.Builder().url("http://localhost:8080/jeecg/appInterface/app.do").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requesString)).build());
		Response response = call.execute();
		System.out.println(response.body().string());
	} 
	
	
	@Test
	public void test1() throws ClientProtocolException, IOException {
		AppRequest request = new AppRequest();
		UnipayBaseRequest<QueryClientDto> requestData=  new UnipayBaseRequest();
		Requesthead requesthead = new Requesthead();
		requesthead.setSubMethod("findAllClientInfo");
		requesthead.setOs("android");
		requesthead.setAppCode("1.1.23");
		
		QueryClientDto entity = new QueryClientDto();
		entity.setCurPage(5);
		entity.setPageSize(3);
		requestData.setRequestbody(entity);
		
		Gson gson = new Gson();
		requestData.setRequesthead(requesthead);
		request.setRequest(requestData);
		request.setRequestsecurity(null);
		
		
		String requesString =  gson.toJson(request);
		System.out.println(requesString);
		
		OkHttpClient client= new OkHttpClient();
		Call call= client.newCall(new Request.Builder().url("http://localhost:8080/jeecg/appInterface/app.do").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requesString)).build());
		Response response = call.execute();
		System.out.println(response.body().string());
	} 
	
	
	@Test
	public void test2() throws ClientProtocolException, IOException {
		AppRequest request = new AppRequest();
		UnipayBaseRequest<GetAlertDto> requestData=  new UnipayBaseRequest();
		Requesthead requesthead = new Requesthead();
		requesthead.setSubMethod("getAlertByDate");
		requesthead.setOs("android");
		requesthead.setAppCode("1.1.23");
		
		GetAlertDto entity = new GetAlertDto();
		entity.setDate("201806");
		requestData.setRequestbody(entity);
		
		Gson gson = new Gson();
		requestData.setRequesthead(requesthead);
		request.setRequest(requestData);
		request.setRequestsecurity(null);
		
		
		String requesString =  gson.toJson(request);
		System.out.println(requesString);
		
		OkHttpClient client= new OkHttpClient();
		Call call= client.newCall(new Request.Builder().url("http://localhost:8080/jeecg/appInterface/app.do").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requesString)).build());
		Response response = call.execute();
		System.out.println(response.body().string());
	} 
	
	@Test
	public void test3() throws ClientProtocolException, IOException {
		AppRequest request = new AppRequest();
		UnipayBaseRequest<Requestbody> requestData=  new UnipayBaseRequest();
		Requesthead requesthead = new Requesthead();
		requesthead.setSubMethod("findAllName");
		requesthead.setOs("android");
		requesthead.setAppCode("1.1.23");
		
		requestData.setRequestbody(new Requestbody());
		
		Gson gson = new Gson();
		requestData.setRequesthead(requesthead);
		request.setRequest(requestData);
		request.setRequestsecurity(null);
		
		
		String requesString =  gson.toJson(request);
		System.out.println(requesString);
		
		OkHttpClient client= new OkHttpClient();
		Call call= client.newCall(new Request.Builder().url("http://localhost:8080/jeecg/appInterface/app.do").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requesString)).build());
		Response response = call.execute();
		System.out.println(response.body().string());
	} 
	
	
	
	@Test
	public void test4() throws ClientProtocolException, IOException {
		OkHttpClient client= new OkHttpClient();
		Call call= client.newCall(new Request.Builder().url("http://47.96.119.244:8080/").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "")).build());
		Response response = call.execute();
		System.out.println(response.body().string());
	} 
}
