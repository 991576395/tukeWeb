package com.appinterface.app.base.core.freemake.core.helper;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.appinterface.app.base.context.LoadContext;
import com.appinterface.app.base.core.freemake.annotation.App;
import com.appinterface.app.base.core.freemake.annotation.AppMethod;
import com.appinterface.app.base.core.freemake.core.entity.ClassFiles;
import com.appinterface.app.base.exception.XuException;

/**
 * @ClassName: ResourseHelper 
 * @Description: 加载注解内容
 * @author xuzhenyao
 * @date 2015-6-5 上午10:44:12 s
 *
 */
public class ResourseHelper {
	private Logger logger = LoggerFactory.getLogger(ResourseHelper.class);
	private String path;

	public ResourseHelper(String path) {
		super();
		this.path = path;
		if(StringUtils.isEmpty(path)){
			throw new XuException("配置文件中 classUrl不能为空!");
		}
		init();
	}

	private void init() {
		String[] strs = path.split(";");
		if(strs != null && strs.length > 0){
			//根据地址获得地址下所有类名
			for(String str:strs){
				getAllFile(str.trim());
			}
		}
	}

	private void getAllFile(String str) {
		if(str.indexOf("*") > -1){
			File file = new File(LoadContext.rootPath+File.separator+str.replace(".*", "").replace(".", File.separator));
			if(file.exists()){
				resoulsFileToClass(file);
			}else{
				throw new XuException("配置文件中 classUrl路径有误找不到!");
			}
		}else{
			addClass(str);
		}
	}
	
	/**
	 * @Title: resoulsFileToClass 
	 * @Description: 解析下面
	 * @param @param file 
	 * @return void
	 * @throws
	 */
	private void resoulsFileToClass(File file){
		File[] files = file.listFiles();
		if(files != null && files.length > 0){
			for(File f:files){
				if(f.isDirectory()){
					resoulsFileToClass(f);
				}else if(f.isFile()){
					String className = f.getPath();
					if(className.indexOf(".xml") == -1){
						int index = className.indexOf(File.separator+"classes"+File.separator);
						if(index > -1){
							className = className.substring(index + 9, className.length());
							className = className.replace(File.separator, ".").replace(".java", "").replace(".class", "").replace("src.", "").replace("classes.", "");
							addClass(className);
						}
					}
				}
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
		} catch (ClassNotFoundException e) {
			logger.error("addClass{}:",e);
			//throw new XuException(className+"找不到!");
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
}
