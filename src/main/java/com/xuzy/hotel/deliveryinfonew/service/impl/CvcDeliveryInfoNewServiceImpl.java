package com.xuzy.hotel.deliveryinfonew.service.impl;
import com.xuzy.hotel.deliveryinfonew.service.CvcDeliveryInfoNewServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.xuzy.hotel.deliveryinfonew.entity.CvcDeliveryInfoNewEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("cvcDeliveryInfoNewService")
@Transactional
public class CvcDeliveryInfoNewServiceImpl extends CommonServiceImpl implements CvcDeliveryInfoNewServiceI {

	
 	public void delete(CvcDeliveryInfoNewEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(CvcDeliveryInfoNewEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(CvcDeliveryInfoNewEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(CvcDeliveryInfoNewEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(CvcDeliveryInfoNewEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(CvcDeliveryInfoNewEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(CvcDeliveryInfoNewEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_date", t.getCreateDate());
		map.put("update_date", t.getUpdateDate());
		map.put("invoice_no", t.getInvoiceNo());
		map.put("shipping_name", t.getShippingName());
		map.put("shipping_id", t.getShippingId());
		map.put("kuaid100_result", t.getKuaid100Result());
		map.put("kuaid100_ftime", t.getKuaid100Ftime());
		map.put("kuaid100_status", t.getKuaid100Status());
		map.put("shentong_result", t.getShentongResult());
		map.put("shentong_ftime", t.getShentongFtime());
		map.put("shentong_status", t.getShentongStatus());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,CvcDeliveryInfoNewEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{invoice_no}",String.valueOf(t.getInvoiceNo()));
 		sql  = sql.replace("#{shipping_name}",String.valueOf(t.getShippingName()));
 		sql  = sql.replace("#{shipping_id}",String.valueOf(t.getShippingId()));
 		sql  = sql.replace("#{kuaid100_result}",String.valueOf(t.getKuaid100Result()));
 		sql  = sql.replace("#{kuaid100_ftime}",String.valueOf(t.getKuaid100Ftime()));
 		sql  = sql.replace("#{kuaid100_status}",String.valueOf(t.getKuaid100Status()));
 		sql  = sql.replace("#{shentong_result}",String.valueOf(t.getShentongResult()));
 		sql  = sql.replace("#{shentong_ftime}",String.valueOf(t.getShentongFtime()));
 		sql  = sql.replace("#{shentong_status}",String.valueOf(t.getShentongStatus()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("cvc_delivery_info_new",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}