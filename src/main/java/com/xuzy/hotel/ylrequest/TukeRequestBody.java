package com.xuzy.hotel.ylrequest;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.wustrive.aesrsa.util.AES;
import com.wustrive.aesrsa.util.Base64;

/**
 * Created by uatzx03548 on 2018/10/29.
 */
public class TukeRequestBody {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TukeRequestBody.class);
	
	
    /**
     *
     */
    private RequestGetHead RequestPackBody;

    private String RequestPack;

    public RequestGetHead getRequestPackBody() {
        return RequestPackBody;
    }

    public void setRequestPackBody(RequestGetHead requestPackBody) {
        RequestPackBody = requestPackBody;
    }

    public String getRequestPack() {
        return RequestPack;
    }

    public void setRequestPack(String requestPack) {
        RequestPack = requestPack;
    }

    public static class Builder{
        private int Sequence;

        private String ServiceCode;

        private String DeviceCode;

        private String AuthKey;

        /**
         * 参数
         */
        private Object Params;


        public Builder setSequence(int sequence) {
            Sequence = sequence;
            return this;
        }

        public Builder setServiceCode(String serviceCode) {
            ServiceCode = serviceCode;
            return this;
        }

        public Builder setDeviceCode(String deviceCode) {
            DeviceCode = deviceCode;
            return this;
        }

        public Builder setAuthKey(String authKey) {
            AuthKey = authKey;
            return this;
        }

        public Builder setParams(Object params) {
            Params = params;
            return this;
        }

        public TukeRequestBody builder(){
            TukeRequestBody tukeRequestBody = new TukeRequestBody();
            RequestGetHead requestGetHead = new RequestGetHead();
            requestGetHead.setServiceCode(ServiceCode);
            requestGetHead.setSequence(Sequence);
            requestGetHead.setDeviceCode(Config.DEVICECODE);
           
            if(Config.not_encrypt.contains(ServiceCode)){
                //不需要加密
                requestGetHead.setParams(Params);
                requestGetHead.setAuthKey("");
            }else{
                requestGetHead.setAuthKey(Config.getAuthkey());
                
                String params = ConmentHttp.gson.toJson(Params);
                try {
                	logger.info("接口参数："+params);
					requestGetHead.setParams(new String(Base64.encode(AES.encrypt(params.getBytes("UTF-8"), Config.getAESKey().getBytes(),Config.getAESIv().getBytes()))));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
            }
            tukeRequestBody.setRequestPackBody(requestGetHead);
            return tukeRequestBody;
        }
    }

}
