package com.xuzy.hotel.ylrequest;

import java.io.ByteArrayInputStream;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.wustrive.aesrsa.util.AES;
import com.wustrive.aesrsa.util.Base64;
import com.wustrive.aesrsa.util.RSA;
import com.xuzy.hotel.ylrequest.module.ASABody;
import com.xuzy.hotel.ylrequest.module.ASAResponseBody;
import com.xuzy.hotel.ylrequest.module.LoginBody;
import com.xuzy.hotel.ylrequest.module.LoginResponseBody;

/**
 * Created by uatzx03548 on 2018/10/29.
 */
public class ParseResponseUtils {
	
	public static void main1(String[] args) throws Exception {
		Map<String, String> map = RSA.generateKeyPair();
		System.out.println(map.get("modulus"));
		System.out.println(map.get("exponent"));
		RSA.privatekey = map.get("privateKey");
		System.out.println(RSA.privatekey );
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		//获取密钥
		ASABody asaBody = new ASABody();
		asaBody.setModulus(RSA.modulus);
		asaBody.setExponent(RSA.exponent);
//		try {
//			Map<String, String> map = RSA.generateKeyPair();
//			asaBody.setModulus(map.get("modulus"));
//			asaBody.setExponent(map.get("exponent"));
//			RSA.privatekey = map.get("privateKey");
//			System.out.println(RSA.privatekey );
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		ResponseHead head = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setSequence(0)
				// .setServiceCode("CRMIF.LoginEx_ForDeliver")
				.setServiceCode("CRMIF.ApplyAESEncryptKeyJson")
				// .setDeviceCode(UUID.randomUUID().toString())
				.setParams(ConmentHttp.gson.toJson(asaBody)).builder(),ASAResponseBody.class);
//		ResponseHead head = parseResponse(value,ASAResponseBody.class);
		ASAResponseBody body = (ASAResponseBody) head.getBody();
		Config.aes_key = RSA.decrypt(body.getCryptAESKey(), RSA.privatekey);
		Config.aes_iv =RSA.decrypt(body.getCryptAESIV(), RSA.privatekey);
		
//		LoginBody loginBody = new LoginBody();
//		loginBody.setUserName(Config.USERNAME);
//		loginBody.setPassword(Config.PASSWORD);
//		String params = ConmentHttp.gson.toJson(loginBody);
//		params = new String(Base64.encode(AES.encrypt(params.getBytes(), Config.aes_key .getBytes(),Config.aes_iv.getBytes())));
//		value = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setSequence(3)
//				 .setServiceCode("CRMIF.LoginEx_ForDeliver")
//				.setParams(params)
//				.builder());
//		head = parseResponse(value,LoginResponseBody.class);
//		LoginResponseBody loginResponseBody = (LoginResponseBody)head.getBody();
//		Config.authkey = loginResponseBody.getAuthKey();
//		System.out.println("Config.authkey:"+Config.authkey);
		
//		RequestSignInExchangeOrderJson exchangeOrderJson = new RequestSignInExchangeOrderJson();
//		exchangeOrderJson.setOrderID(11762926);
//		exchangeOrderJson.setSignInMan("[武汉市]已签收,感谢使用顺丰,期待再次为您服务");
//		exchangeOrderJson.setSignInDate("2018-10-13 09:34:14");
//		
//		System.out.println(ConmentHttp.gson.toJson(exchangeOrderJson));
//		value = ConmentHttp.sendHttp(new TukeRequestBody.Builder().setSequence(4)
//				 .setServiceCode("CRMIF.SignInExchangeOrderJson")
//				.setParams(exchangeOrderJson)
//				.builder());
//		head = parseResponse(value,null);
//		System.out.println(head);
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
				if(head!=null && moduleType != null) {
					if(head.getSequence() != 0) {
						head.setResult(new String(AES.decrypt(Base64.decode(head.getResult().getBytes()),Config.aes_key .getBytes(),Config.aes_iv.getBytes())));
					}
					System.out.println(head.getResult());
				    Object obj = ConmentHttp.gson.fromJson(head.getResult(), moduleType);
					head.setBody(obj);
				}
				return head;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

}
