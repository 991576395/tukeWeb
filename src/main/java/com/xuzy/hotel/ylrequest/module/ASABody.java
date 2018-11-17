package com.xuzy.hotel.ylrequest.module;

/**
 * Created by uatzx03548 on 2018/10/29.
 */
public class ASABody extends BaseBody{
    /**
     * 公钥模
     */
    private String Modulus;
    /**
     * 公钥
     */
    private String Exponent;

    public String getModulus() {
        return Modulus;
    }

    public void setModulus(String modulus) {
        Modulus = modulus;
    }

    public String getExponent() {
        return Exponent;
    }

    public void setExponent(String exponent) {
        Exponent = exponent;
    }
}
