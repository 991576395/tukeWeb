package com.appinterface.app.base.core.freemake.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: AppMethod 
 * @Description: app方法类
 * @author xuzhenyao
 * @date 2015-6-5 上午10:00:55 
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AppMethod {
	/**
	 * @Title: method 
	 * @Description: 标识方法名
	 * @param @return 
	 * @return String
	 * @throws
	 */
	String method();
	/**
	 * @Title: body 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return 
	 * @return Class
	 * @throws
	 */
	Class body();
}
