package org.jeecgframework.core.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * ehcache 缓存工具类
 * 
 * cacheName在ehcache.xml中配置
 */
public class EhcacheUtil {

	//缓存NAME静态名称
	public static String DictCache = "dictCache";
	public static String EternalCache = "eternalCache";
	public static String TagCache = "tagCache";

	
	public static CacheManager manager = CacheManager.create();

	public static Object get(String cacheName, Object key) {
		return RedisUtil.ObjectR.get(cacheName+key);
	}
	
	public static HashMap getMap(String cacheName, Object key) {
		String jsonValue = (String) RedisUtil.ObjectR.get(cacheName+key);
		return (HashMap)JSONObject.parseObject(jsonValue, HashMap.class);
	}
	
	public static void putMap(String cacheName, Object key, Object value) {
		RedisUtil.ObjectR.set(cacheName+key, JSON.toJSONString(value));
	}

	public static void put(String cacheName, Object key, Object value) {
		RedisUtil.ObjectR.set(cacheName+key, value);
	}

	public static boolean remove(String cacheName, Object key) {
		RedisUtil.ObjectR.delete(cacheName+key);
		return get(cacheName,key) == null;
	}
	
	/**
	 * 清空系统Ehcache缓存
	 */
	public static void clean() {
		RedisUtil.cleanAll();
	}

	public static void main(String[] args) {
		String key = "key";
		String value = "hello";
		EhcacheUtil.put("mytest", key, value);
		System.out.println(EhcacheUtil.get("mytest", key));
	}

}