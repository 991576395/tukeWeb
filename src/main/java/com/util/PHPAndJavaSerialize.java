package com.util;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.phprpc.util.AssocArray;
import org.phprpc.util.Cast;
import org.phprpc.util.PHPSerializer;

import com.xuzy.hotel.order.module.DelivetyJson;

/**
 * java与php 转换序列化
 * @author Administrator
 *
 */
public class PHPAndJavaSerialize {
	
	/**
	 * 反序列化对象方法
	 * @param content
	 * @param tClass
	 * @return
	 * @throws Exception
	 */
	public static <T>T getUnserialize(String content,Class tClass) throws Exception {
	    PHPSerializer p = new PHPSerializer();
	    if (StringUtils.isEmpty(content))
	        return null;
	     
	    return (T) p.unserialize(content.getBytes(),tClass);
	}
	
	public static String serialize(Object obj) {
		PHPSerializer p = new PHPSerializer();
		byte[] bs = null;
		try {
			bs = p.serialize(obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new String(bs);
	}
	
	public static String serializeArray(Object obj,Class cls) {
		PHPSerializer p = new PHPSerializer();
		byte[] bs = null;
		try {
//			HashMap ht = new HashMap();
//	        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//	        int hv = p.serialize(stream, obj, ht, 1);
//	        byte[] result = stream.toByteArray();
			bs = p.serialize(obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new String(bs);
	}
	
	
	/** * 对php序列化的字符串，进行反序列化 */
	public static <T>List<T> unserializePHParray(String content,Class tClass) {
		List<T> list = new ArrayList<T>();
		PHPSerializer p = new PHPSerializer();
		if (StringUtils.isEmpty(content))
			return null;
		try {
			AssocArray array = (AssocArray) p.unserialize(content.getBytes());
			for (int i = 0; i < array.size(); i++) {
				T t = (T) Cast.cast(array.get(i), tClass);
				list.add(t);
			}
		} catch (Exception e) {
			System.out.println("反序列化PHParray: " + content + " 失败！！！");
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		String string  = "a:2:{i:0;a:3:{s:4:\"time\";s:19:\"2017-03-06 21:46:36\";s:5:\"ftime\";s:19:\"2017-03-06 21:46:36\";s:7:\"context\";s:49:\"福建省泉州市晋江市二部公司 已打包\";}i:1;a:3:{s:4:\"time\";s:19:\"2017-03-06 21:43:39\";s:5:\"ftime\";s:19:\"2017-03-06 21:43:39\";s:7:\"context\";s:69:\"福建省泉州市晋江市二部公司(点击查询电话) 已揽收\";}}";
		
		List<DelivetyJson> datas = PHPAndJavaSerialize.unserializePHParray(string,DelivetyJson.class);
		System.out.println(datas.toString());
		System.out.println(PHPAndJavaSerialize.serialize(datas));
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(1540954355);
//		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		System.out.println(time.format(1540954355));
//		System.out.println(DateFormatUtils.format(new Timestamp(Long.parseLong(1540954355+"000")), "yyyy-MM-dd HH:mm:ss"));
//		
//		long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
//		System.out.println(timeStamp);
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
//		String sd = sdf.format(new Date(timeStamp));   // 时间戳转换成时间
//		System.out.println(sd);//打印出你要的时间
	}

}
