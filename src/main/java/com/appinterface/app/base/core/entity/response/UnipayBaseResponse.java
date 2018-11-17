package com.appinterface.app.base.core.entity.response;


import com.appinterface.app.base.core.contant.Contant;
import com.appinterface.app.base.core.entity.base.UnipayBaseDto;

/**
 * @ClassName: UnipayResponse 
 * @Description: 返回的基类
 * @author xuzhenyao
 * @date 2015年1月8日 下午5:14:46 
 */
public class UnipayBaseResponse {
	private Response response;
	
	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

//	/**
//	 * 响应头
//	 */
//	private Responsehead responsehead;
//	/**
//	 * 响应体
//	 */
//	private UnipayBaseDto responsebody;
	
	/**
	 * 响应签名
	 */
	private Responsesecurity responsesecurity;

	public UnipayBaseResponse() {
		super();
		response = new Response();
//		responsehead = new Responsehead();
		responsesecurity = new Responsesecurity();
		response.setResponsehead(new Responsehead());
		response.setResponsebody(new UnipayBaseDto());
	}
	
	public void setSig(String sig){
		responsesecurity.setData(sig);
	}
	
//	public Responsehead getResponsehead() {
//		return responsehead;
//	}
//
//	public void setResponsehead(Responsehead responsehead) {
//		this.responsehead = responsehead;
//	}
//
//	public UnipayBaseDto getResponsebody() {
//		return responsebody;
//	}

	public void setResponsebody(UnipayBaseDto responsebody) {
		response.setResponsebody(responsebody);
//		this.responsebody = responsebody;
	}

	public Responsesecurity getResponsesecurity() {
		return responsesecurity;
	}

	public void setResponsesecurity(Responsesecurity responsesecurity) {
		this.responsesecurity = responsesecurity;
	}
	
	/**
	 * @Title: setResponseCode 
	 * @Description:设置响应返回码 
	 * @param @param code 
	 * @return void
	 * @throws
	 */
	public void setResponseCode(String code){
		response.getResponsehead().setRespCode(code);
//		responsehead.setRespCode(code);
	}
	
	public void setFid(String fid){
		response.getResponsehead().setFid(fid);
	}
	public void setCoded(String code){
		response.getResponsehead().setCoded(code);
	}
	
	public void setFormatType(String type){
		response.getResponsehead().setFormatType(type);
	}
	
	public void setServerTimeStamp(String timestamp){
		response.getResponsehead().setServerTimeStamp(timestamp);
	}
	
	public void setSessionId(String sessionId){
		response.getResponsehead().setSessionId(sessionId);
	}
	
	/**
	 * @Title: setResponseMsg 
	 * @Description: 设置响应内容
	 * @param @param msg 
	 * @return void
	 * @throws
	 */
	public void setResponseMsg(String msg){
		response.getResponsehead().setRespMsg(msg);
//		responsehead.setRespMsg(msg);
	}
	
	/**
	 * @Title: setResponseSignRule 
	 * @Description: 设置响应签名规则
	 * @param  
	 * @return void
	 * @throws
	 */
	public void setResponseSignRule(String signRule){
		response.getResponsehead().setSignRule(signRule);
	}
	
	/**
	 * @Title: getErrorContent 
	 * @Description: 直接根据错误返回响应信息
	 * @param @return 
	 * @return UnipayBaseResponse
	 * @throws
	 */
	public static UnipayBaseResponse getErrorContent(Exception e,UnipayBaseResponse baseResponse){
		baseResponse.setResponseCode(Contant.CODE_FAIL);
		baseResponse.setResponsebody(new Responsebody(Contant.CODE_FAIL));
		baseResponse.setResponseMsg(e.getMessage());
		baseResponse.setCoded("UTF-8");
		baseResponse.setFormatType("json");
		baseResponse.setServerTimeStamp(String.valueOf(System.currentTimeMillis()));
		return baseResponse;
	}
	
	/**
	 * 版本更新
	 * @param url
	 * @param baseResponse
	 * @return
	 */
	public static UnipayBaseResponse getUpdateContent(String url,UnipayBaseResponse baseResponse){
		baseResponse.setResponseCode(Contant.VERSIONUPDATE);
		baseResponse.setResponsebody(new Responsebody(Contant.VERSIONUPDATE));
		baseResponse.setResponseMsg(url);
		baseResponse.setCoded("UTF-8");
		baseResponse.setFormatType("json");
		baseResponse.setServerTimeStamp(String.valueOf(System.currentTimeMillis()));
		return baseResponse;
	}
	

	/**
	 * @Title: getErrorContent 
	 * @Description: 直接根据错误返回响应信息
	 * @param @return 
	 * @return UnipayBaseResponse
	 * @throws
	 */
	public static UnipayBaseResponse getErrorContent(Exception e,String responseCode,UnipayBaseResponse baseResponse){
		baseResponse.setResponseCode(responseCode);
		baseResponse.setResponsebody(new Responsebody(responseCode));
		baseResponse.setResponseMsg(e.getMessage());
		baseResponse.setCoded("UTF-8");
		baseResponse.setFormatType("json");
		baseResponse.setServerTimeStamp(String.valueOf(System.currentTimeMillis()));
		return baseResponse;
	}
	
	public static UnipayBaseResponse getErrorContent(Exception e,String responseCode,UnipayBaseResponse baseResponse ,Responsebody responsebody){
		baseResponse.setResponseCode(responseCode);
		baseResponse.setResponsebody(responsebody);
		baseResponse.setResponseMsg(e.getMessage());
		baseResponse.setCoded("UTF-8");
		baseResponse.setFormatType("json");
		baseResponse.setServerTimeStamp(String.valueOf(System.currentTimeMillis()));
		return baseResponse;
	}
	
	
	
	/**
	 * 返回成功
	 * @Title: getSuccessContent 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param baseResponse
	 * @param @return 
	 * @return UnipayBaseResponse
	 * @throws
	 */
	public static UnipayBaseResponse getSuccessContent(UnipayBaseResponse baseResponse, Object bodyData){
		baseResponse.setResponseCode(Contant.CODE_SUCCESS);
		baseResponse.setResponseMsg("success");
		baseResponse.setResponsebody((UnipayBaseDto) bodyData);
		baseResponse.setCoded("UTF-8");
		baseResponse.setFormatType("json");
		baseResponse.setServerTimeStamp(String.valueOf(System.currentTimeMillis()));
		return baseResponse;
	}
	
	/**
	 * 返回成功
	 * @Title: getSuccessContent 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param baseResponse
	 * @param @return 
	 * @return UnipayBaseResponse
	 * @throws
	 */
	public static UnipayBaseResponse getSuccessContent(UnipayBaseResponse baseResponse, Object bodyData,String msg){
		baseResponse.setResponseCode(Contant.CODE_SUCCESS);
		baseResponse.setResponseMsg(msg);
		baseResponse.setResponsebody((UnipayBaseDto) bodyData);
		baseResponse.setCoded("UTF-8");
		baseResponse.setFormatType("json");
		baseResponse.setServerTimeStamp(String.valueOf(System.currentTimeMillis()));
		return baseResponse;
	}
	
	
	public static UnipayBaseResponse getSuccessContent2(UnipayBaseResponse baseResponse, Object bodyData, String sessionId) {
		baseResponse.setResponseCode(Contant.CODE_SUCCESS);
		baseResponse.setResponseMsg("success");
		baseResponse.setResponsebody((UnipayBaseDto) bodyData);
		baseResponse.setCoded("UTF-8");
		baseResponse.setFormatType("json");
		baseResponse.setSessionId(sessionId);
		baseResponse.setFormatType("json");
		baseResponse.setServerTimeStamp(String.valueOf(System.currentTimeMillis()));
		return baseResponse;
	}
	
	/**
	 * @Title: getSuccessContent 
	 * @Description: 
	 * @param @param baseResponse
	 * @param @param result
	 * @param @return 
	 * @return UnipayBaseResponse
	 * @throws
	 */
	public static UnipayBaseResponse getSuccessContent(UnipayBaseResponse baseResponse,boolean result){
		if(result){
			return getSuccessContent(baseResponse,new Responsebody(Contant.CODE_SUCCESS));
		}else{
			return getSuccessContent(baseResponse,new Responsebody(Contant.CODE_FAIL));
		}
	}
}
