package com.util;

import org.apache.commons.lang.StringUtils;

public class KuaidiUtils {
	
	/**
	 * 获取快递内容第一个括号内容
	 * @param value
	 * @return
	 */
	public static String getFirstValue(String value) {
		if(StringUtils.isEmpty(value)) {
			return "";
		}
		
		try {
			int start = value.indexOf("【");
			int end = value.indexOf("】");
			if(start != -1 && end != -1) {
				return value.substring(start+1, end);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
//		Pattern pattern = Pattern.compile("【.*】");
//		Matcher matcher = pattern.matcher(value);
//		if(matcher.find()) {
//			return matcher.group(0);
//		}
		return "";
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(getFirstValue("【北京亦庄东区公司】的【客户伊利 手机(18831076747)】已收件,扫描员是【后勤梁海兰】"));
	}
}
