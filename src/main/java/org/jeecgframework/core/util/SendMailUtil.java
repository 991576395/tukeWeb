package org.jeecgframework.core.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.params.ExcelExportEntity;
import org.jeecgframework.poi.excel.entity.vo.MapExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.export.ExcelExportServer;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * 
 * @author  张代浩
 *
 */
public class SendMailUtil
{
  //private static final String smtphost = "192.168.1.70";
  private static final String from = "xuzhenyaonew@163.com";
  private static final String fromName = "系统邮件，请勿回复！";
  private static final String charSet = "utf-8";
  private static final String username = "xuzhenyaonew@163.com";
  private static final String password = "a123456";
	private static Map<String, String> hostMap = new HashMap<String, String>();
	static {
		// 126
		hostMap.put("smtp.126", "smtp.126.com");
		// qq
		hostMap.put("smtp.qq", "smtp.qq.com");

		// 163
		hostMap.put("smtp.163", "smtp.163.com");

		// sina
		hostMap.put("smtp.sina", "smtp.sina.com.cn");

		// tom
		hostMap.put("smtp.tom", "smtp.tom.com");

		// 263
		hostMap.put("smtp.263", "smtp.263.net");

		// yahoo
		hostMap.put("smtp.yahoo", "smtp.mail.yahoo.com");

		// hotmail
		hostMap.put("smtp.hotmail", "smtp.live.com");

		// gmail
		hostMap.put("smtp.gmail", "smtp.gmail.com");
		hostMap.put("smtp.port.gmail", "465");
	}

	public static String getHost(String email) throws Exception {
		Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
		Matcher matcher = pattern.matcher(email);
		String key = "unSupportEmail";
		if (matcher.find()) {
			key = "smtp." + matcher.group(1);
		}
		if (hostMap.containsKey(key)) {
			return hostMap.get(key);
		} else {
			throw new Exception("unSupportEmail");
		}
	}

	public static int getSmtpPort(String email) throws Exception {
		Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
		Matcher matcher = pattern.matcher(email);
		String key = "unSupportEmail";
		if (matcher.find()) {
			key = "smtp.port." + matcher.group(1);
		}
		if (hostMap.containsKey(key)) {
			return Integer.parseInt(hostMap.get(key));
		} else {
			return 25;
		}
	}

	/**
	 * 发送模板邮件
	 * @param toMailAddr  收信人地址
	 * @param subject email主题
	 * @param templatePath 模板地址
	 * @param map 模板map
	 */
	public static void sendFtlMail(List<String> toMailAddrs, String subject,
			String templatePath,Object map){
	  Template template = null;
	  Configuration freeMarkerConfig = null;
	  HtmlEmail hemail = new HtmlEmail();
	    try {
	      hemail.setHostName(getHost(from));
		  hemail.setSmtpPort(getSmtpPort(from));
	      hemail.setCharset(charSet);
	      for (String string : toMailAddrs) {
	    	  hemail.addTo(string);
	      }
	      
	      hemail.addBcc(from);
	      hemail.setFrom(from, fromName);
	      hemail.setAuthentication(username, password);
	      hemail.setSubject(subject);
	      hemail.setSSL(true);
	      
	      
	      freeMarkerConfig = new Configuration();
	      freeMarkerConfig.setDirectoryForTemplateLoading(new File(getFilePath()));
	      // 获取模板
		  template = freeMarkerConfig.getTemplate(getFileName(templatePath),new Locale("Zh_cn"), "UTF-8");
			// 模板内容转换为string
		  String htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		  org.jeecgframework.core.util.LogUtil.info(htmlText);
	      hemail.setMsg(htmlText);
	      hemail.send();
	      org.jeecgframework.core.util.LogUtil.info("email send true!");
	    } catch (Exception e) {
	      e.printStackTrace();
	      org.jeecgframework.core.util.LogUtil.info("email send error!");
	    }
   }
	protected static final String HSSF = ".xls";
	protected static final String XSSF = ".xlsx";
	
	/**
	 * 发送 邮箱 附件
	 * @param toMailAddrs
	 * @param subject
	 * @param model 
	 * @param templatePath
	 * @param map
	 */
	public static void sendWithFileMail(List<String> toMailAddrs, String subject,
			Object... maps){
		MultiPartEmail hemail = new MultiPartEmail();
		try {
			hemail.setHostName(getHost(from));
			hemail.setSmtpPort(getSmtpPort(from));
			hemail.setCharset(charSet);
			for (String string : toMailAddrs) {
				hemail.addTo(string);
			}

			hemail.addBcc(from);
			hemail.setFrom(from, fromName);
			hemail.setAuthentication(username, password);
			hemail.setSubject(subject);
			hemail.setSSL(true);

			
			MimeMultipart mm = new MimeMultipart();
			for (int i = 0; i < maps.length; i++) {
				if(maps[i] instanceof ModelMap) {
					ModelMap model = (ModelMap) maps[i];
					String codedFileName = "临时文件";
					Workbook workbook = null;
					if (model.containsKey(NormalExcelConstants.MAP_LIST)) {
						List<Map<String, Object>> list = (List<Map<String, Object>>) model.get(NormalExcelConstants.MAP_LIST);
						if (list.size() == 0) {
							throw new RuntimeException("MAP_LIST IS NULL");
						}
						workbook = ExcelExportUtil.exportExcel((ExportParams) list.get(0).get(NormalExcelConstants.PARAMS), (Class<?>) list.get(0).get(NormalExcelConstants.CLASS), (Collection<?>) list.get(0).get(NormalExcelConstants.DATA_LIST));
						for (int j = 1; j < list.size(); j++) {
							new ExcelExportServer().createSheet(workbook, (ExportParams) list.get(j).get(NormalExcelConstants.PARAMS), (Class<?>) list.get(j).get(NormalExcelConstants.CLASS), (Collection<?>) list.get(j).get(NormalExcelConstants.DATA_LIST));
						}
					} else {
						workbook = ExcelExportUtil.exportExcel((ExportParams) model.get(NormalExcelConstants.PARAMS), (Class<?>) model.get(NormalExcelConstants.CLASS), (Collection<?>) model.get(NormalExcelConstants.DATA_LIST));
					}
					if (model.containsKey(NormalExcelConstants.FILE_NAME)) {
						codedFileName = (String) model.get(NormalExcelConstants.FILE_NAME);
					}
					if (workbook instanceof HSSFWorkbook) {
						codedFileName += HSSF;
					} else {
						codedFileName += XSSF;
					}
					
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					workbook.write(bos);
					bos.close();
					// 9. 创建附件"节点"
			        MimeBodyPart attachment = new MimeBodyPart();
			        // 读取本地文件
			        DataHandler dh2 = new DataHandler(new ByteArrayDataSource(bos.toByteArray(), "application/vnd.ms-excel"));
			        // 将附件数据添加到"节点"
			        attachment.setDataHandler(dh2);
			        // 设置附件的文件名（需要编码）
			        attachment.setFileName(MimeUtility.encodeText(codedFileName));     
			        mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
				}
			}
	        
	        mm.setSubType("mixed"); 
	        hemail.setContent(mm);
			hemail.send();
			org.jeecgframework.core.util.LogUtil.info("email send true!");
		} catch (Exception e) {
			e.printStackTrace();
			org.jeecgframework.core.util.LogUtil.info("email send error!");
		}
   }
	

	/**
	 * 发送普通邮件
	 * @param toMailAddr 收信人地址
	 * @param subject email主题
	 * @param message 发送email信息  
	 */
	public static void sendCommonMail(String toMailAddr, String subject, String message) {
		  HtmlEmail hemail = new HtmlEmail();
		try {
			hemail.setHostName(getHost(from));
			hemail.setSmtpPort(getSmtpPort(from));
			hemail.setCharset(charSet);
			hemail.addTo(toMailAddr);
			hemail.setFrom(from, fromName);
			hemail.setAuthentication(username, password);
			hemail.setSubject(subject);
			hemail.setMsg(message);
			hemail.send();
			org.jeecgframework.core.util.LogUtil.info("email send true!");
		} catch (Exception e) {
		      e.printStackTrace();
		      org.jeecgframework.core.util.LogUtil.info("email send error!");
		    }
		
	}
	
	public static String getHtmlText(String templatePath, Map<String, Object> map){
		  Template template = null;
		  String htmlText = "";
		  try {
			Configuration freeMarkerConfig = null;
			  freeMarkerConfig = new Configuration();
			  freeMarkerConfig.setDirectoryForTemplateLoading(new File(getFilePath()));
			  // 获取模板
			  template = freeMarkerConfig.getTemplate(getFileName(templatePath),new Locale("Zh_cn"), "UTF-8");
				// 模板内容转换为string
			  htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
			  org.jeecgframework.core.util.LogUtil.info(htmlText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return htmlText;
	}
    
  
  
  	private static String getFilePath() {
  		String path = getAppPath(SendMailUtil.class);
  		path = path + File.separator +"mailtemplate"+File.separator;
		path = path.replace("\\", "/");
		org.jeecgframework.core.util.LogUtil.info(path);
		return path;
	}

	private static String getFileName(String path) {
		path = path.replace("\\", "/");
		org.jeecgframework.core.util.LogUtil.info(path);
		return path.substring(path.lastIndexOf("/") + 1);
	}
  
	@SuppressWarnings("unchecked")
	public static String getAppPath(Class cls) {
		// 检查用户传入的参数是否为空
		if (cls == null)
			throw new java.lang.IllegalArgumentException("参数不能为空！");
		ClassLoader loader = cls.getClassLoader();
		// 获得类的全名，包括包名
		String clsName = cls.getName() + ".class";
		// 获得传入参数所在的包
		Package pack = cls.getPackage();
		String path = "";
		// 如果不是匿名包，将包名转化为路径
		if (pack != null) {
			String packName = pack.getName();
			// 此处简单判定是否是Java基础类库，防止用户传入JDK内置的类库
			if (packName.startsWith("java.") || packName.startsWith("javax."))
				throw new java.lang.IllegalArgumentException("不要传送系统类！");
			// 在类的名称中，去掉包名的部分，获得类的文件名
			clsName = clsName.substring(packName.length() + 1);
			// 判定包名是否是简单包名，如果是，则直接将包名转换为路径，
			if (packName.indexOf(".") < 0)
				path = packName + "/";
			else {// 否则按照包名的组成部分，将包名转换为路径
				int start = 0, end = 0;
				end = packName.indexOf(".");
				while (end != -1) {
					path = path + packName.substring(start, end) + "/";
					start = end + 1;
					end = packName.indexOf(".", start);
				}
				path = path + packName.substring(start) + "/";
			}
		}
		// 调用ClassLoader的getResource方法，传入包含路径信息的类文件名
		java.net.URL url = loader.getResource(path + clsName);
		// 从URL对象中获取路径信息
		String realPath = url.getPath();
		// 去掉路径信息中的协议名"file:"
		int pos = realPath.indexOf("file:");
		if (pos > -1)
			realPath = realPath.substring(pos + 5);
		// 去掉路径信息最后包含类文件信息的部分，得到类所在的路径
		pos = realPath.indexOf(path + clsName);
		realPath = realPath.substring(0, pos - 1);
		// 如果类文件被打包到JAR等文件中时，去掉对应的JAR等打包文件名
		if (realPath.endsWith("!"))
			realPath = realPath.substring(0, realPath.lastIndexOf("/"));
		/*------------------------------------------------------------ 
		 ClassLoader的getResource方法使用了utf-8对路径信息进行了编码，当路径 
		  中存在中文和空格时，他会对这些字符进行转换，这样，得到的往往不是我们想要 
		  的真实路径，在此，调用了URLDecoder的decode方法进行解码，以便得到原始的 
		  中文及空格路径 
		-------------------------------------------------------------*/
		try {
			realPath = java.net.URLDecoder.decode(realPath, "utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		org.jeecgframework.core.util.LogUtil.info("realPath----->"+realPath);
		return realPath;
	}
//	private static File getFile(String path){
//		File file = SendMail.class.getClassLoader().getResource("mailtemplate/test.ftl").getFile();
//		return file;
//	}
//  
  

  public static void main(String[] args)
  {
//	  HtmlEmail hemail = new HtmlEmail();
//	    try {
//	      hemail.setHostName("smtp.exmail.qq.com");
//	      hemail.setCharset("utf-8");
//	      hemail.addTo("fly.1206@qq.com");
//	      hemail.setFrom("zhoujunfeng@et-bank.com", "周俊峰");
//	      hemail.setAuthentication("zhoujunfeng@et-bank.com", "31415926@aa");
//	      hemail.setSubject("sendemail test!");
//	      hemail.setMsg("<a href=\"http://www.google.cn\">谷歌</a><br/>");
//	      hemail.send();
//	      org.jeecgframework.core.util.LogUtil.info("email send true!");
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	      org.jeecgframework.core.util.LogUtil.info("email send error!");
//	    }
	  List<Map<String, Object>> objs = new ArrayList<Map<String,Object>>();
	  
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("orderId", "1232424");
	  map.put("name", "小明");
	  map.put("phone", "13782761271");
	  map.put("firtTime", "2019-01-02");
	  objs.add(map);
	  objs.add(map);
	  objs.add(map);
	  
	  Map<String, Object> values = new HashMap<String, Object>();
	  values.put("sendLists", objs);
	  String templatePath = "mailtemplate/test.ftl";
	  sendFtlMail(new ArrayList<String>() {
		  {
			  add("991576395@qq.com");
//			  add("1075482109@qq.com");
		  }
	  }, "sendemail test!",templatePath, values);
//	  org.jeecgframework.core.util.LogUtil.info(getFileName("mailtemplate/test.ftl"));
  }

}