package interfacetest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appinterface.app.base.core.entity.request.AppRequest;
import com.appinterface.app.base.core.entity.request.Requesthead;
import com.appinterface.app.base.core.entity.request.UnipayBaseRequest;
import com.appinterface.app.bussiness.user.dto.UserBody;
import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		AppRequest request = new AppRequest();
		UnipayBaseRequest<UserBody> requestData=  new UnipayBaseRequest();
		Requesthead requesthead = new Requesthead();
		requesthead.setSubMethod("login");
		requesthead.setOs("android");
		requesthead.setAppCode("1.1.3");
		
		UserBody userBody = new UserBody();
		
		userBody.setUserName("xuzhenyao");
		userBody.setPassword("123456");
		
		requestData.setRequestbody(userBody);
		
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
		//		String str = HttpRequest.sendPost("http://localhost:8080/jeecg/appInterface/app.do", requesString);
//		System.out.println(str);
	} 
	
	
	@Test
	public void testRegitster() throws ClientProtocolException, IOException {
		AppRequest request = new AppRequest();
		
		UnipayBaseRequest<UserBody> requestData=  new UnipayBaseRequest();
		Requesthead requesthead = new Requesthead();
		requesthead.setSubMethod("regiter");
		UserBody userBody = new UserBody();
		
		userBody.setUserName("xuzhenyao");
		userBody.setPassword("123456");
		userBody.setRealName("徐珍耀");
		
		
		userBody.setCompanyId("ff80818161c14bdf0161c14d85040004");
		requestData.setRequestbody(userBody);
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
		//		String str = HttpRequest.sendPost("http://localhost:8080/jeecg/appInterface/app.do", requesString);
//		System.out.println(str);
	} 
	
}
