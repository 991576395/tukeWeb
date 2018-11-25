package com.xuzy.hotel.ylrequest.module;

/**
 * Auto-generated: 2018-11-22 21:56:45
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Kuaidi100Request {

    private String company;
    private String number;
    private String from;
    private String to;
    private String key;
    private ParametersBody parameters = new ParametersBody();
    
    
    public ParametersBody getParameters() {
		return parameters;
	}
	public void setParameters(ParametersBody parameters) {
		this.parameters = parameters;
	}
	public void setCompany(String company) {
         this.company = company;
     }
     public String getCompany() {
         return company;
     }

    public void setNumber(String number) {
         this.number = number;
     }
     public String getNumber() {
         return number;
     }

    public void setFrom(String from) {
         this.from = from;
     }
     public String getFrom() {
         return from;
     }

    public void setTo(String to) {
         this.to = to;
     }
     public String getTo() {
         return to;
     }

    public void setKey(String key) {
         this.key = key;
     }
     public String getKey() {
         return key;
     }

}