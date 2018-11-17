package com.appinterface.app.base.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.appinterface.app.base.core.freemake.core.entity.ClassFiles;

/**
 * @ClassName: LoadContext
 * @Description: app接口配置文件
 * @author xuzhenyao
 * @date 2015-4-30 下午1:42:28
 * 
 */
public class LoadContext {
	protected final static Log logger = LogFactory.getLog(LoadContext.class);
	/**
	 * 根目录
	 */
	public static String rootPath = "";
	/**
	 * app接口转发配置文件
	 */
	public static String path = "";
	
	/**
	 * 配置文件方法名和跳转关系
	 */
	public static Map<String, String> map = new HashMap<String, String>();
	public static ArrayList<String> classFiles = new ArrayList<String>();
	/**
	 * 加载完的所有配置信息
	 */
	public static List<ClassFiles> allClass = new ArrayList<ClassFiles>();

	public static ClassFiles getClassF(String method) {
		if(allClass != null && allClass.size() > 0){
			for(ClassFiles c:allClass){
				List<String> ms = c.getMethods();
				if(ms != null && ms.size() > 0){
					for(int i = 0;i < ms.size();i++){
						if(ms.get(i).trim().equals(method.trim())){
							return new ClassFiles(c.getClassName(), method, c.getFilds().get(i),c.getClas().get(i));
						}
					}
				}
			}
		}
		return null;
	}
}
