package com.appinterface.app.base.core.entity.response;

/**
 * @ClassName: Responsehead 
 * @Description: 响应参数头
 * @author xuzhenyao
 * @date 2015年1月8日 下午6:24:39 
 *
 */
public class Responsehead {
	/**
	 * 响应码
	 */
	private String respCode;
	/**
	 * 错误信息
	 */
	private String respMsg;
	/**
	 * 签名规则
	 */
	private String signRule;
	/**
	 * 加密规则
	 */
	private String encrypt;
	/**
	 * 编码格式
	 */
	private String coded;
	/**
	 * 报文格式类型
	 */
	private String formatType;
	/**
	 * 本地请求时间<到毫秒>
	 */
	private String serverTimeStamp;
	
	/**
	 * 维护session
	 */
	private String sessionId;
	
	/**
	 * fid
	 * @return
	 */
     private String fid;
     
     
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getSignRule() {
		return signRule;
	}
	public void setSignRule(String signRule) {
		this.signRule = signRule;
	}
	public String getEncrypt() {
		return encrypt;
	}
	public void setEncrypt(String encrypt) {
		this.encrypt = encrypt;
	}
	public String getCoded() {
		return coded;
	}
	public void setCoded(String coded) {
		this.coded = coded;
	}
	public String getFormatType() {
		return formatType;
	}
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}
	public String getServerTimeStamp() {
		return serverTimeStamp;
	}
	public void setServerTimeStamp(String serverTimeStamp) {
		this.serverTimeStamp = serverTimeStamp;
	}
}
