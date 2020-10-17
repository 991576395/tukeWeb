package com.xuzy.hotel.ylrequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.util.RedisUtil;

/**
 * Created by uatzx03548 on 2018/10/29.
 */
public class Config implements Serializable{
	public static final String ConfigRedis = "tuke_Config";
	
	
	public static final boolean ISDEBUG = true;
	
    public static final String USERNAME = "DeliverAnonymous";//"DeliverPBH";//CRMIF.LoginEx_ForDeliver接口所需账号参数
    public static final String PASSWORD = "DeliverAnonymous123!";//"pinbohui123!";//CRMIF.LoginEx_ForDeliver接口所需密码参数
    public static final String DEVICECODE = "1C-65-9D-EE-E6-7B";
    public static final String SOAP_URL = "http://interface.yilibabyclub.com/CRMIF2/MCSWSIAPI.asmx?wsdl";//"http://interface.yilibabyclub.com/CRMIF2/MCSWSIAPI.asmx?wsdl";//webservice地址
    public static String aes_key = "";//AES密钥
    public static String aes_iv = "";//AES向量
    public static String authkey = "";//授权key
    
    /**
     * 伊利商户号
     */
    public static final  int DELIVERER = 16;
    
    public String KEY = "MfxXXpWd8126";
	public String SCHEMA = "json";
	public String URL = "http://www.kuaidi100.com/poll";
	public String CALLBACK = "callback.php";
    

    public static List<String> not_encrypt = new ArrayList(2){
        {
            add("CRMIF.ApplyAESEncryptKeyJson");
            add("CRMIF.LoginEx_ForDeliver");
        }
    };
    
    
    /**
     * 获取缓存密钥
     * @return
     */
    public static String getAESKey() {
//    	if(RedisUtil.StringR.hasKey("aes_key")) {
//    		aes_key = RedisUtil.StringR.get("aes_key");
//    	} 
    	if(StringUtils.isEmpty(aes_key)) {
    		ConmentHttp.getREAValue();
    	}
    	return aes_key;
    }
    
    public static void saveAESKey(String aesKeyString) {
//    	RedisUtil.StringR.set("aes_key",aesKeyString);
    	aes_key = aesKeyString;
    }
    
    /**
     * 获取缓存向量
     * @return
     */
    public static String getAESIv() {
//    	if(RedisUtil.StringR.hasKey("aes_iv")) {
//    		aes_iv = RedisUtil.StringR.get("aes_iv");
//    	} 
    	if(StringUtils.isEmpty(aes_iv)) {
    		ConmentHttp.getREAValue();
    	}
    	return aes_iv;
    }
    
    public static void saveAESIv(String aesIvString) {
//    	RedisUtil.StringR.set("aes_iv",aesIvString);
    	aes_iv = aesIvString;
    }
    
    /**
     * 获取缓存向量
     * @return
     */
    public static String getAuthkey() {
//    	if(RedisUtil.StringR.hasKey("authkey")) {
//    		authkey = RedisUtil.StringR.get("authkey");
//    	} 
    	
    	if(StringUtils.isEmpty(authkey)) {
    		ConmentHttp.getLogin();
    	}
    	return authkey;
    }
    
    public static void saveAuthkey(String authkeyString) {
//    	RedisUtil.StringR.set("authkey",authkeyString);
    	authkey = authkeyString;
    }

}
