package com.xuzy.hotel.ylrequest.module;

/**
 * 物流请求监听
 * @author Administrator
 *
 */
public class RequestPostOrder {
	
	
	
	/**
	 * 快递公司
	 */
	private String company;
	
	/**
	 * 订单号
	 */
	private String number;
		
	/**
	 * 密钥
	 */
	private String key;
	
	private Parameter parameters;
	
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Parameter getParameters() {
		return parameters;
	}

	public void setParameters(Parameter parameters) {
		this.parameters = parameters;
	}


	private class Parameter{
		/**
		 * 回调url
		 */
		private String callbackurl = "";

		public String getCallbackurl() {
			return callbackurl;
		}

		public void setCallbackurl(String callbackurl) {
			this.callbackurl = callbackurl;
		}
	}
}
