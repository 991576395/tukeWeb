package com.appinterface.app.base.core.freemake.core.entity;

import java.util.List;

/**
 * @ClassName: ClassFiles 
 * @Description: 注解信息实体
 * @author xuzhenyao
 * @date 2015-6-5 上午10:23:49 
 *
 */
public class ClassFiles {
	/**
	 * @app注解的类
	 */
	private String ClassName;				//App注解-处理请求的类
	private List<String> methods;			//AppMethod注解的-转发的请求方法
	private List<String> filds;				//具体的实现方法
	private List<Class> clas;				//注解的 请求的参数实体类
	private String m;
	private String f;
	
	private Class cla;
	
	public ClassFiles(String className, String m, String f, Class cla) {
		super();
		ClassName = className;
		this.m = m;
		this.f = f;
		this.cla = cla;
	}

	public ClassFiles() {
		super();
	}
	
	
	
	public List<Class> getClas() {
		return clas;
	}
	public void setClas(List<Class> clas) {
		this.clas = clas;
	}
	public Class getCla() {
		return cla;
	}
	public void setCla(Class cla) {
		this.cla = cla;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public List<String> getMethods() {
		return methods;
	}
	public void setMethods(List<String> methods) {
		this.methods = methods;
	}
	public List<String> getFilds() {
		return filds;
	}
	public void setFilds(List<String> filds) {
		this.filds = filds;
	}
}
