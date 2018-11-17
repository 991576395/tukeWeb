package com.appinterface.app.base.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.appinterface.app.base.core.entity.request.UnipayBaseRequest;
import com.appinterface.app.base.core.entity.response.UnipayBaseResponse;
import com.appinterface.app.base.exception.XuException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @ClassName: BaseController 
 * @Description:  
 * @author xuzhenyao
 * @date 2015-5-4 下午4:13:53 
 *
 */
public class AppBaseController {
	private Logger logger = LoggerFactory.getLogger(AppBaseController.class);
	private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	public String printObj(HttpServletResponse response, Object obj, boolean encryptFlag) {
		try {
			// String signStr = signFromJson(json);
			// json.setJson("sign", signStr);
			response.setContentType("application/json;charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
//			String result = gson.toJson(obj);
			
			String result = JSON.toJSONString(obj);
//			String sig = createMD5Sig(result);
			//加密reponse
			logger.info("rrrrrrrrrrrrrrrrrrrrrrrrrrrr");
//			result = result.replace("\"responsesecurity\":{}", "\"responsesecurity\":{\"data\":\"" + sig +"\"}");
			if(encryptFlag){
				//JSONObject jsonObject = JSONObject.fromObject(result);
				//String jsonResponse = jsonObject.getJSONObject("response").toString();
//				String jsonResponse = getRequestBody(result);
//				String oldRequestBody = jsonResponse;
				//3DES加密response,返回加密后报文
//				DesEncryptUtils desEncryptUtils = new DesEncryptUtils();
//				desEncryptUtils.init(AppConfig.getInstance().getValue("encrypt_key"), AppConfig.getInstance().getValue("encrypt_vec"));
//				jsonResponse = desEncryptUtils.encrypt(jsonResponse);
//				logger.info("返回加密前报文------{}",BaseTextUtil.partEncryptNum(result));
//				result = result.replace(oldRequestBody, "\""+jsonResponse+"\"");
				//jsonObject.put("response", jsonResponse);
//				result = result.replaceAll(System.getProperty("line.separator"), "");
//				logger.info("返回加密后报文------{}",BaseTextUtil.partEncryptNum(result));
			}
			//obj.getClass().getDeclaredMethod("setSig",String.class).invoke(obj, sig);
			logger.info("返回加签---------：{}"+result);
			response.getWriter().write(result);
//			logger.info("返回报文>>>>>>>>{}",BaseTextUtil.partEncryptNum(result));
			response.getWriter().flush();
		} catch (IOException e) {
			//e.printStackTrace();
			logger.error("printObj{}:",e);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("printObj{}:",e);
		}
		return null;
	}
	
	/**
	 * @ClassName: AppDoAll 
	 * @Description: app处理抽象类 
	 * @author xuzhenyao
	 * @date 2015-6-4 上午11:13:50 
	 *
	 */
	protected abstract class AppDoAll<T extends UnipayBaseRequest>{
		private T t;
		
		public AppDoAll(HttpServletResponse response, HttpServletRequest request,Class cla) {
			super();
			
			UnipayBaseResponse resBaseResponse = new UnipayBaseResponse();
			try {
				t = UnipayBaseRequest.getInstent(request, cla);
				toDoSelf(t,resBaseResponse);
			} catch (XuException e) {
				UnipayBaseResponse.getErrorContent(e,resBaseResponse);
				//e.printStackTrace();
				logger.error("AppDoAll{}:",e);
			} catch (Exception e) {
				UnipayBaseResponse.getErrorContent(new XuException("系统异常!"),resBaseResponse);
				//e.printStackTrace();
				logger.error("AppDoAll{}:",e);
			}
			printObj(response, resBaseResponse, true);
		}
		
		/**
		 * @Title: toDoSelf 
		 * @Description:处理基类
		 * @param  
		 * @return void
		 * @throws
		 */
		public abstract void toDoSelf(T t,UnipayBaseResponse resBaseResponse);
	}
	
	public String createMD5Sig(String resp){
//		resp = getRequestBody(resp);
//		resp = MD5.encrypt(resp + "741qaz!@#");
//		resp = MD5.encrypt("852wsx$%^" + resp);
		return resp;
	}
	
	private String getRequestBody(String resp){
		int responseIndex = resp.indexOf("\"response\"");
		int responsesecurityIndex = resp.indexOf("responsesecurity");
		if(responseIndex < responsesecurityIndex){
			resp = resp.substring(responseIndex+11,responsesecurityIndex-2);
		}else {
			resp = resp.substring(responseIndex+11,resp.length()-1);
		}
		return resp;
	}
}
