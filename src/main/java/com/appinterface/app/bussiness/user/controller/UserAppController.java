package com.appinterface.app.bussiness.user.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.MutiLangServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.web.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.appinterface.app.base.core.entity.response.UnipayBaseResponse;
import com.appinterface.app.base.core.freemake.annotation.App;
import com.appinterface.app.base.core.freemake.annotation.AppMethod;
import com.appinterface.app.base.exception.XuException;
import com.appinterface.app.bussiness.user.dto.ResponseLoginDto;
import com.appinterface.app.bussiness.user.dto.UserBody;
import com.xuzy.hotel.company.entity.TSCompanyEntity;

@App
public class UserAppController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAppController.class);
	
	private UserService userService;
	
	@Autowired
	private MutiLangServiceI mutiLangService;
	
	private SystemService systemService;

	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@AppMethod(method="login",body=UserBody.class)
	public void login(UserBody requestLoginModule,UnipayBaseResponse response) {
		LOGGER.info("-----------login-----------");
		TSUser request= new TSUser();
		try {
			BeanUtils.copyProperties(request, requestLoginModule);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TSUser u  = userService.checkUserExits(request);
		if(u == null) {
			throw  new XuException("用戶不存在或密码错误");
		}
		if ( u.getStatus() != 0) {
			ResponseLoginDto dto = new ResponseLoginDto();
			if(u.getCompany() != null) {
				dto.setCompanyName(u.getCompany().getCompanyName());
			}
			dto.setRealName(u.getRealName());
			dto.setUserName(u.getUserName());
			response = UnipayBaseResponse.getSuccessContent(response, dto);
		} else {
			throw  new XuException(mutiLangService.getLang("common.lock.user"));
		}
	}
	
	@AppMethod(method="regiter",body=UserBody.class)
	public void regiter(UserBody requestLoginModule,UnipayBaseResponse response) {
		LOGGER.info("-----------regiter-----------");
		Short logType=Globals.Log_Type_INSERT;
		TSUser user= new TSUser();
		try {
			BeanUtils.copyProperties(user, requestLoginModule);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = "";
		TSUser users = systemService.findUniqueByProperty(TSUser.class, "userName",user.getUserName());
		if (users != null) {
			message = "用户: " + users.getUserName() + "已经存在";
			throw new XuException(message);
		} else {
			user.setPassword(PasswordUtil.encrypt(user.getUserName(), user.getPassword(), PasswordUtil.getStaticSalt()));
			user.setStatus(Globals.User_Normal);
			user.setDeleteFlag(Globals.Delete_Normal);
			user.setDevFlag("0");
			user.setCreateDate(new Date());
			if(StringUtil.isNotEmpty(requestLoginModule.getCompanyId())){
				//添加公司
				TSCompanyEntity company = new TSCompanyEntity();
				company.setId(requestLoginModule.getCompanyId());
				user.setCompany(company);
			}
			this.userService.saveOrUpdate(user, null, null);				
			message = "用户: " + user.getUserName() + "添加成功";
			
			systemService.addLog(message, logType, Globals.Log_Leavel_INFO);
			response = UnipayBaseResponse.getSuccessContent(response, null,message);
		}
	}
	
}
