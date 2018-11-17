package com.xuzy.hotel.ylrequest.module;

/**
 * Created by uatzx03548 on 2018/11/6.
 */
public class ASAResponseBody {
    private String CryptAESKey;

    private String CryptAESIV;

    private String ErrorResult;


    public String getCryptAESKey() {
        return CryptAESKey;
    }

    public void setCryptAESKey(String cryptAESKey) {
        CryptAESKey = cryptAESKey;
    }

    public String getCryptAESIV() {
        return CryptAESIV;
    }

    public void setCryptAESIV(String cryptAESIV) {
        CryptAESIV = cryptAESIV;
    }

    public String getErrorResult() {
        return ErrorResult;
    }

    public void setErrorResult(String errorResult) {
        ErrorResult = errorResult;
    }

    @Override
    public String toString() {
        return "ASAResponseBody{" +
                "CryptAESKey='" + CryptAESKey + '\'' +
                ", CryptAESIV='" + CryptAESIV + '\'' +
                ", ErrorResult='" + ErrorResult + '\'' +
                '}';
    }
}
