package com.appinterface.app.base.core.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

public class RequestHelper {
	
	private static  Logger logger = LoggerFactory.getLogger(RequestHelper.class);
	
	/**
	 * @Title: parstJsonFromRequest 
	 * @Description: 解析tap协议内容 
	 * @param @param request
	 * @param @return 
	 * @return String
	 * @throws
	 */
	public static String parstJsonFromRequest(HttpServletRequest request){
		ServletInputStream bi = null;
		StringBuffer sb = new StringBuffer();
		InputStreamReader reader = null;
		try {
			bi = request.getInputStream();
			reader = new InputStreamReader(bi, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String str = "";
			while((str = bufferedReader.readLine()) != null){
				sb.append(str);
			}
		} catch (IOException e1) {
			//throw new XuException("读取报文异常!");
			logger.error("parstJsonFromRequest{}:",e1);
		} finally{
			try {
				if(bi != null){
					bi.close();
				}
				if(reader != null){
					reader.close();
				}
			} catch (IOException e) {
				//e.printStackTrace();
				logger.error("parstJsonFromRequest{}:",e);
			}
		}
		return sb.toString().trim();
	}
	
	
	public static String getBody(String json) {
		JSONObject js = JSONObject.fromObject(json);
		String req = js.getString("request");
		return req;
	}
}
