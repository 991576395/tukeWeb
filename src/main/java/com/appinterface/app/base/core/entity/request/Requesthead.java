package com.appinterface.app.base.core.entity.request;

/**
 * @ClassName: Resphead 
 * @Description: 报文头 
 * @author xuzhenyao
 * @date 2015年1月8日 下午4:34:05 
 *
 */
public class Requesthead {
	/**
	 * 设备号
	 */
	private String terminalCode;
	/**
	 * 设备类型
	 */
	private String deviceType;
	/**
	 * 操作系统
	 */
	private String os;
	/**
	 * OEM码
	 */
	private String oemCode;
	/**
	 * APP版本
	 */
	private String appCode;
	/**
	 * 安装时间戳
	 */
	private String installTimeStamp;
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
	private String localTimeStamp;
	/**
	 * 主服务类型
	 */
	private String masterMethod;
	
	/**
	 * 子服务类型
	 */
	private String subMethod;
	
	private String sessionId;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOemCode() {
		return oemCode;
	}

	public void setOemCode(String oemCode) {
		this.oemCode = oemCode;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getInstallTimeStamp() {
		return installTimeStamp;
	}

	public void setInstallTimeStamp(String installTimeStamp) {
		this.installTimeStamp = installTimeStamp;
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

	public String getLocalTimeStamp() {
		return localTimeStamp;
	}

	public void setLocalTimeStamp(String localTimeStamp) {
		this.localTimeStamp = localTimeStamp;
	}

	public String getMasterMethod() {
		return masterMethod;
	}

	public void setMasterMethod(String masterMethod) {
		this.masterMethod = masterMethod;
	}

	public String getSubMethod() {
		return subMethod;
	}

	public void setSubMethod(String subMethod) {
		this.subMethod = subMethod;
	}
}