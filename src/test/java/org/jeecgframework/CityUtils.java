package org.jeecgframework;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONArray;

public class CityUtils {
	private static List<CityModule> cityModules;
	
	static {
		String json = "";
		try {
			json = FileUtils.readFileToString(new File("/Users/zmeng/Documents/demo/china_regions/json/region.json"), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		cityModules = JSONArray.parseArray(json,CityModule.class);
	}
	
	/**
	 * 匹配城市一级省市
	 * @return
	 */
	public static CityModule getProvince(String name) {
		CityModule cityModule = parseOne(cityModules,new CityModule(name));
		return cityModule;
	}
	
	private static CityModule parseOne(List<CityModule> cityModules,CityModule cityModule) {
		int index = cityModules.indexOf(cityModule);
//		System.out.println(index);
		if(index == -1) {
			return null;
		}
		cityModule = cityModules.get(index);
//		System.out.println(cityModule.toString());
		return cityModule;
	}
	
	
	/**
	 * 匹配城市级省市
	 * @return
	 */
	public static CityModule getCity(String name) {
		CityModule cityModule = parseOne(cityModules,new CityModule(name));
		if(!cityModule.getName().equals(name)) {
			return cityModule;
		}else {
			cityModule = parseOne(cityModule.getChild(),new CityModule(name));
		}
//		System.out.println(cityModule.toString());
		return cityModule;
	}
	
	
	/**
	 * 匹配城市级省市
	 * @return
	 */
	public static CityModule getQu(String name) {
		CityModule cityModule = parseOne(cityModules,new CityModule(name));
		if(!cityModule.getName().equals(name)) {
			return cityModule;
		}else {
			cityModule = parseOne(cityModule.getChild(),new CityModule(name));
		}
//		System.out.println(cityModule.toString());
		return cityModule;
	}
	
	
	
	/**

	* 解析地址

	* @author lin

	* @param address

	* @return

	*/
	public static Map<String,String> addressResolution(String address){
		String regex="(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
		Matcher m= Pattern.compile(regex).matcher(address);
		String province=null,city=null,county=null,town=null,village=null;
		Map<String,String> map = new HashMap<>();
		while(m.find()){
			province=m.group("province");
			if(!StringUtils.isEmpty(province)) {
				map.put("province", province);
			}
			
			city=m.group("city");
			if(!StringUtils.isEmpty(city)) {
				map.put("city", city);
			}

			county=m.group("county");
			if(!StringUtils.isEmpty(county)) {
				map.put("county", county);
			}
			town=m.group("town");
			if(!StringUtils.isEmpty(town)) {
				map.put("town", town);
			}
			village=m.group("village");
			if(!StringUtils.isEmpty(town)) {
				map.put("town", town);
			}
		}
		
		return map;
	}
	
	
	public static void main(String[] args) {
		System.out.println(addressResolution("湖北省武汉市洪山区"));
	}
}
