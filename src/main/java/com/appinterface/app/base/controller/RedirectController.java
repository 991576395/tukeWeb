package com.appinterface.app.base.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.appinterface.app.base.context.AppLoaderServer;
import com.appinterface.app.base.context.LoadContext;
import com.appinterface.app.base.core.entity.request.AppRequest;
import com.appinterface.app.base.core.entity.request.Requestbody;
import com.appinterface.app.base.core.entity.request.Requesthead;
import com.appinterface.app.base.core.entity.request.UnipayBaseRequest;
import com.appinterface.app.base.core.entity.response.UnipayBaseResponse;
import com.appinterface.app.base.core.freemake.core.entity.ClassFiles;
import com.appinterface.app.base.core.helper.RequestHelper;
import com.appinterface.app.base.exception.XuException;
import com.sun.star.uno.TypeClass;
import com.xuzy.hotel.padversion.service.TAppVersionServiceI;

/**
 * 
 * @ClassName: RedirectController 
 * @Description: app接口基类
 * @author xuzhenyao
 * @date 2015-5-3 上午9:42:42 
 *
 */
@Controller
@RequestMapping("/appInterface")
public class RedirectController extends AppBaseController{
	private Logger logger = LoggerFactory.getLogger(RedirectController.class);
	
//	@Autowired
//	private SecurityService securityService;
	
	@Autowired
	private TAppVersionServiceI tAppVersionService;
	
	@RequestMapping(value="/app",method={RequestMethod.GET,RequestMethod.POST})
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		UnipayBaseResponse resBaseResponse = new UnipayBaseResponse();
		try {
			String json = RequestHelper.parstJsonFromRequest(request);
			logger.info("APP原始请求报文{}" ,json);
			
			AppRequest appReq = JSON.parseObject(json, AppRequest.class);
//			AppRequest appReq = GsonUtil.fromJson(json, AppRequest.class);
//			AppRequest appReq = securityService.parseRequest(json);
			if(appReq != null){
				UnipayBaseRequest uinRequest = appReq.getRequest();
				Requesthead head = uinRequest.getRequesthead();
				if(head == null){
					throw new XuException("数据格式异常!");
				}
				//校验版本
				if(checkVersion(head,resBaseResponse)) {
					if(!StringUtils.isEmpty(head.getSubMethod())){
						ClassFiles files = LoadContext.getClassF(head.getSubMethod());
						if(files == null){
							throw new XuException("跳转连接不存在!");
						}
						Class<?> cla = Class.forName(files.getClassName());
						Object obj = AppLoaderServer.getBean(cla);
						Method[] methods = cla.getMethods();
						Method m = getMethod(methods,files);
						if(m == null){
							throw new XuException(files.getF()+"不存在");
						}
//						String body = RequestHelper.getBody(json);
						String body = appReq.getRequest().getRequestbody().toString();
						//请求内容
						request.setAttribute("value", body);
						
						invokeThisMethod(m,request,response,files,resBaseResponse,head,obj);
					}else{
						throw new XuException("方法名不能为空!");
					}
				}
			}else{
				throw new XuException("数据格式异常!");
			}
		} catch (XuException e) {
			UnipayBaseResponse.getErrorContent(e,resBaseResponse);
			logger.error("index{}:",e);
		}catch (Exception e) {
			if(e.getCause() instanceof XuException) {
				UnipayBaseResponse.getErrorContent((XuException) e.getCause(),resBaseResponse);
			}else {
				UnipayBaseResponse.getErrorContent(new XuException("系统异常!"),resBaseResponse);
			}
			logger.error("index{}:",e);
		}
		printObj(response, resBaseResponse, true);
	}
	
	private boolean checkVersion(Requesthead head,UnipayBaseResponse resBaseResponse) {
		List<TSType> types = ResourceUtil.allTypes.get("appversion");
		TSType value = null;
		if(!CollectionUtils.isEmpty(types)) {
			for(TSType type :types) {
				if(type.getTypecode().equals(head.getOs())) {
					value = type;
				}
			}
		}
		if(value == null) {
			throw new XuException("版本异常！");
		}else {
			if(validateVersion(head.getAppCode(),value.getTypename())) {
				UnipayBaseResponse.getUpdateContent(tAppVersionService.appShouldUpdate(value.getTypecode(), value.getTypename()), resBaseResponse);
				return false;
			}
		}
		return true;
	}
	
	
	 /** 
     * 校验当前版本号是否小于指定版本号，如果小于则返回true 
     * @param curVer 
     * @param SpeVer 
     * @return curVer < SpeVer 返回true 
     * curVer >= SpeVer 返回false 
     */  
    public boolean validateVersion(String curVer,String speVer){  
        boolean flag = true;  
        String[] curVers = curVer.split("\\.");  
        String[] speVers = speVer.split("\\.");  
          
        int[] iCur = new int[curVers.length];  
        int[] iSper = new int[speVers.length];  
          
        for(int i = 0;i < curVers.length;i++){  
            iCur[i] = Integer.parseInt(curVers[i]);  
        }  
        for(int i = 0;i < speVers.length;i++){  
            iSper[i] = Integer.parseInt(speVers[i]);  
        }  
          
        int iFlag = 0;  
        if(curVers.length < speVers.length){  
            iFlag = validata(iSper, iCur);  
            if(iFlag > 0){  
                flag = true;  
            }else{  
                flag = false;  
            }  
        }else{  
            iFlag = validata(iCur, iSper);  
            if(iFlag >= 0){  
                flag = false;  
            }else{  
                flag = true;  
            }  
        }  
        return flag;  
    }  
    
    
    /** 
     *  
     * @param bigOne 
     * @param smallOne 
     * @return 1 说明 bigOne > smallOne 
     * -1 说明bigOne < smallOne 
     * 0 说明bigOne == smallOne 
     */  
    public int validata(int[] bigOne,int[] smallOne){  
        int flag = 0;  
        int temp = 0;  
        for(int i = 0;i < bigOne.length;i++){  
            if(i > smallOne.length-1){  
                temp = 0;  
            }else{  
                temp = smallOne[i];  
            }  
            if(temp < bigOne[i]){  
                flag = 1;  
                return flag;  
            }else if(temp > bigOne[i]){  
                flag = -1;  
                return flag;  
            }else{  
                if(i == bigOne.length-1){  
                    flag = 0;  
                }else{  
                    continue;  
                }  
            }  
        }  
        return flag;  
    }  


	/**
	 * @param uinRequest 
	 * @param response 
	 * @Title: invokeThisMethod 
	 * @Description:执行方法
	 * @param @param m
	 * @param @param request
	 * @param @param files
	 * @param @param resBaseResponse
	 * @param @param head
	 * @param @param obj
	 * @param @throws IllegalArgumentException
	 * @param @throws IllegalAccessException
	 * @param @throws InvocationTargetException 
	 * @return void
	 * @throws
	 */
	private void invokeThisMethod(Method m, HttpServletRequest request,
			HttpServletResponse response, ClassFiles files, UnipayBaseResponse resBaseResponse,
			Requesthead head, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class[] types = m.getParameterTypes();
		Object[] objects = null;
		if(types != null && types.length > 0){
			objects =  new Object[types.length];
			for(int i = 0;i < types.length;i++){
				if(types[i].getSuperclass().equals(Requestbody.class) ){
					Requestbody baseBaseRequest = UnipayBaseRequest.getInstent(request, files.getCla());
//					try {
//						
//						Method tm = baseBaseRequest.getClass().getDeclaredMethod("getRequestbody");
//						Object requestbody = tm.invoke(baseBaseRequest);
//						String md5Sig = createMD5Sig(requestbody);
//						String appMd5Sig = request.getAttribute("sig").toString();
//						if(!md5Sig.equals(appMd5Sig)){
//							logger.info(BaseTextUtil.partEncryptNum("不一致");
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
					objects[i] = baseBaseRequest;
				}else if(types[i].equals(UnipayBaseResponse.class)){
					objects[i]=resBaseResponse;
				}else if(types[i].equals(Requesthead.class)){
					objects[i]=head;
				}else if(types[i].equals(HttpServletRequest.class)){
					objects[i]=request;
				}else if(types[i].equals(HttpServletResponse.class)){
					objects[i]=response;
				}
			}
		}
		m.invoke(obj,objects);
	}
	
	/**
	 * @Title: getMethod 
	 * @Description: 获得方法
	 * @param @param methods
	 * @param @param files
	 * @param @return 
	 * @return Method
	 * @throws
	 */
	private Method getMethod(Method[] methods, ClassFiles files) {
		if(methods != null && methods.length > 0){
			for(Method method:methods){
				if(method.getName().equals(files.getF())){
					return method;
				}
			}
		}
		return null;
	}
	
	
	@RequestMapping(value="/wap",method={RequestMethod.GET,RequestMethod.POST})
	public void json(HttpServletRequest request, HttpServletResponse response){
		UnipayBaseResponse resBaseResponse = new UnipayBaseResponse();
		try {
			String json = RequestHelper.parstJsonFromRequest(request);
//			logger.info(BaseTextUtil.partEncryptNum("WAP原始请求报文:" + json));
			UnipayBaseRequest uinRequest = GsonUtil.fromJson(json, UnipayBaseRequest.class);
//			UnipayBaseRequest uinRequest = securityService.parseWapRequest(json);
//			UnipayBaseRequest uinRequest = UnipayBaseRequest.getInstent(json, UnipayBaseRequest.class);
			if(uinRequest != null){
				Requesthead head = uinRequest.getRequesthead();
//				Requesthead head = uinRequest.getRequest().getRequesthead();
				if(head == null){
					throw new XuException("数据格式异常!");
				}
				if(!StringUtils.isEmpty(head.getSubMethod())){
					ClassFiles files = LoadContext.getClassF(head.getSubMethod());
					if(files == null){
						throw new XuException("跳转连接不存在!");
					}
					Class cla = Class.forName(files.getClassName());
					String beanName = cla.getSimpleName().substring(0, 1).toLowerCase()+cla.getSimpleName().substring(1, cla.getSimpleName().length());
					ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
					Object obj = ac2.getBean(beanName);
					Method m = cla.getMethod(files.getF(),files.getCla(),UnipayBaseResponse.class);
					request.setAttribute("value", uinRequest.getRequestJson());
					m.invoke(obj, UnipayBaseRequest.getInstent(request, files.getCla()),resBaseResponse);
				}else{
					throw new XuException("方法名不能为空!");
				}
			}else{
				throw new XuException("数据格式异常!");
			}
		} catch (XuException e) {
			UnipayBaseResponse.getErrorContent(e,resBaseResponse);
			//e.printStackTrace();
			logger.error("json{}:",e);
		}catch (InvocationTargetException e) {
			UnipayBaseResponse.getErrorContent(new XuException(e.getCause().getMessage()),resBaseResponse);
			//e.printStackTrace();
			logger.error("json{}:",e);
		} 
		catch (Exception e) {
			UnipayBaseResponse.getErrorContent(new XuException("系统异常!"),resBaseResponse);
			//e.printStackTrace();
			logger.error("json{}:",e);
		}
		printObj(response, resBaseResponse, false);
	}
}
