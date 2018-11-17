package com.appinterface.app.base.context;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.appinterface.app.base.core.freemake.annotation.App;
import com.appinterface.app.base.core.freemake.annotation.AppMethod;
import com.appinterface.app.base.core.freemake.core.entity.ClassFiles;
import com.appinterface.app.base.exception.XuException;

@Component
public class AppLoaderServer implements ApplicationContextAware,InitializingBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppLoaderServer.class);
	
	private static ApplicationContext ctx;
	
	public static Object getBean(String name){
		return ctx.getBean(name);
	}
	public static Object getBean(Class<?> requiredType){
		return ctx.getBean(requiredType);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx=ctx;
		Map<String, Object> serviceBeanMap = ctx.getBeansWithAnnotation(App.class); 
		if (serviceBeanMap != null && !serviceBeanMap.isEmpty()) {
			for (Object serviceBean : serviceBeanMap.values()) {
				String interfaceName = serviceBean.getClass()
						.getAnnotation(App.class).toString();
				addClass(serviceBean.getClass().getName());
			}
		}
	}
	
	private void addClass(String className){
		Class cla = null;
		try {
			cla = Class.forName(className);
			App app = (App) cla.getAnnotation(App.class);
			ClassFiles files = new ClassFiles();
			files.setClassName(className);
			List<String> ms = new ArrayList<String>();
			List<String> fs = new ArrayList<String>();
			List<Class> bodys = new ArrayList<Class>();
			if(app != null){
				Method[] methods = cla.getDeclaredMethods();
				if(methods != null && methods.length > 0){
					 for (Method method : methods) {
						 AppMethod appMethod = method.getAnnotation(AppMethod.class);
						 if(appMethod != null){
							 if(checkHaveMethod(appMethod)){
								 throw new XuException(appMethod.method()+"不能重复!");
							 }
							 ms.add(appMethod.method());
							 fs.add(method.getName());
							 bodys.add(appMethod.body());
						 }
			         }
				}
			}
			files.setMethods(ms);
			files.setFilds(fs);
			files.setClas(bodys);
			LoadContext.allClass.add(files);
		} catch (Exception e) {
			//throw new XuException(className+"找不到!");
			LOGGER.error("addClass{}:",e);
		}
	}
	
	private boolean checkHaveMethod(AppMethod appMethod) {
		for(ClassFiles files:LoadContext.allClass){
			List<String> alls = files.getMethods();
			if(alls != null && alls.size() > 0){
				for(String str :alls){
					if(str.equals(appMethod.method())){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}
	
}
