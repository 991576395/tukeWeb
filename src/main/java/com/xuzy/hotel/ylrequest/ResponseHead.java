package com.xuzy.hotel.ylrequest;


/**
 * Created by uatzx03548 on 2018/11/6.
 */
public class ResponseHead {
    private int Sequence;

    private int Return;

    private String ReturnInfo;

    private String Result;

    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public int getSequence() {
        return Sequence;
    }

    public void setSequence(int sequence) {
        Sequence = sequence;
    }

    public int getReturn() {
        return Return;
    }

    public void setReturn(int aReturn) {
        Return = aReturn;
    }

    public String getReturnInfo() {
        return ReturnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        ReturnInfo = returnInfo;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    @Override
    public String toString() {
        return "ResponseHead{" +
                "Sequence=" + Sequence +
                ", Return=" + Return +
                ", ReturnInfo='" + ReturnInfo + '\'' +
                ", Result='" + Result + '\'' +
                ", body=" + body +
                '}';
    }
}
