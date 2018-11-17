package com.xuzy.hotel.ylrequest;

/**
 * Created by uatzx03548 on 2018/10/29.
 */
public class RequestGetHead {
    /**
     *
     */
    private int Sequence;

    private String ServiceCode;

    private String DeviceCode;

    private String AuthKey;

    /**
     * 参数
     */
    private Object Params;


    public int getSequence() {
        return Sequence;
    }

    public void setSequence(int sequence) {
        Sequence = sequence;
    }

    public String getServiceCode() {
        return ServiceCode;
    }

    public void setServiceCode(String serviceCode) {
        ServiceCode = serviceCode;
    }

    public String getDeviceCode() {
        return DeviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        DeviceCode = deviceCode;
    }

    public String getAuthKey() {
        return AuthKey;
    }

    public void setAuthKey(String authKey) {
        AuthKey = authKey;
    }

    public Object getParams() {
        return Params;
    }

    public void setParams(Object params) {
        Params = params;
    }
}
