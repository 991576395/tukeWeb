package com.xuzy.hotel.offermoney.service.impl;
import com.xuzy.hotel.offermoney.service.CvcOfferMoneyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.xuzy.hotel.offermoney.entity.CvcOfferMoneyEntity;
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

@Service("cvcOfferMoneyService")
@Transactional
public class CvcOfferMoneyServiceImpl extends CommonServiceImpl implements CvcOfferMoneyServiceI {

	
 	public void delete(CvcOfferMoneyEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(CvcOfferMoneyEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(CvcOfferMoneyEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(CvcOfferMoneyEntity t) throws Exception{
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
	private void doUpdateBus(CvcOfferMoneyEntity t) throws Exception{
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
	private void doDelBus(CvcOfferMoneyEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(CvcOfferMoneyEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("if_my_company", t.getIfMyCompany());
		map.put("xiaoshoubuhanshuijia", t.getXiaoshoubuhanshuijia());
		map.put("xiaoshoudezhengzhishui", t.getXiaoshoudezhengzhishui());
		map.put("xiaoshouhanshuijia", t.getXiaoshouhanshuijia());
		map.put("caigoubuhanshuijia", t.getCaigoubuhanshuijia());
		map.put("caigoudezengzhishui", t.getCaigoudezengzhishui());
		map.put("caigoudehanshuijia", t.getCaigoudehanshuijia());
		map.put("yunfeibuhanshuijia", t.getYunfeibuhanshuijia());
		map.put("yunfeizengzhishui", t.getYunfeizengzhishui());
		map.put("yunfeihanshuijia", t.getYunfeihanshuijia());
		map.put("baozhuangfeibuhanshuijia", t.getBaozhuangfeibuhanshuijia());
		map.put("baozhuangfeizengzhishui", t.getBaozhuangfeizengzhishui());
		map.put("baozhuangfeihanshuijia", t.getBaozhuangfeihanshuijia());
		map.put("zhuangxiefeibuhanshuijia", t.getZhuangxiefeibuhanshuijia());
		map.put("zhuangxiefeizengzhishui", t.getZhuangxiefeizengzhishui());
		map.put("zhuangxiefeihanshuijia", t.getZhuangxiefeihanshuijia());
		map.put("cangchufeibuhanshuijia", t.getCangchufeibuhanshuijia());
		map.put("cangchufeizengzhishui", t.getCangchufeizengzhishui());
		map.put("cangchufeihanshuijia", t.getCangchufeihanshuijia());
		map.put("bencihuowunashuidezengzhishui", t.getBencihuowunashuidezengzhishui());
		map.put("zengzhishuifujiashui", t.getZengzhishuifujiashui());
		map.put("jinyingchenbenbiaozhun", t.getJinyingchenbenbiaozhun());
		map.put("bendanjinyinchengben", t.getBendanjinyinchengben());
		map.put("bendanshouru", t.getBendanshouru());
		map.put("bendanchengben", t.getBendanchengben());
		map.put("bendanlirun", t.getBendanlirun());
		map.put("bendansuodeshui", t.getBendansuodeshui());
		map.put("bendanjinlirun", t.getBendanjinlirun());
		map.put("bendanxianjinliuru", t.getBendanxianjinliuru());
		map.put("bendanchenbenxianjinliuchu", t.getBendanchenbenxianjinliuchu());
		map.put("bendanjinxianjinliu", t.getBendanjinxianjinliu());
		map.put("bendanshuijinliuchu", t.getBendanshuijinliuchu());
		map.put("bendanmaolilv", t.getBendanmaolilv());
		map.put("bendandanweichanpinbuhssj", t.getBendandanweichanpinbuhssj());
		map.put("bendandanweichanpinhssj", t.getBendandanweichanpinhssj());
		map.put("good_name", t.getGoodName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,CvcOfferMoneyEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{if_my_company}",String.valueOf(t.getIfMyCompany()));
 		sql  = sql.replace("#{xiaoshoubuhanshuijia}",String.valueOf(t.getXiaoshoubuhanshuijia()));
 		sql  = sql.replace("#{xiaoshoudezhengzhishui}",String.valueOf(t.getXiaoshoudezhengzhishui()));
 		sql  = sql.replace("#{xiaoshouhanshuijia}",String.valueOf(t.getXiaoshouhanshuijia()));
 		sql  = sql.replace("#{caigoubuhanshuijia}",String.valueOf(t.getCaigoubuhanshuijia()));
 		sql  = sql.replace("#{caigoudezengzhishui}",String.valueOf(t.getCaigoudezengzhishui()));
 		sql  = sql.replace("#{caigoudehanshuijia}",String.valueOf(t.getCaigoudehanshuijia()));
 		sql  = sql.replace("#{yunfeibuhanshuijia}",String.valueOf(t.getYunfeibuhanshuijia()));
 		sql  = sql.replace("#{yunfeizengzhishui}",String.valueOf(t.getYunfeizengzhishui()));
 		sql  = sql.replace("#{yunfeihanshuijia}",String.valueOf(t.getYunfeihanshuijia()));
 		sql  = sql.replace("#{baozhuangfeibuhanshuijia}",String.valueOf(t.getBaozhuangfeibuhanshuijia()));
 		sql  = sql.replace("#{baozhuangfeizengzhishui}",String.valueOf(t.getBaozhuangfeizengzhishui()));
 		sql  = sql.replace("#{baozhuangfeihanshuijia}",String.valueOf(t.getBaozhuangfeihanshuijia()));
 		sql  = sql.replace("#{zhuangxiefeibuhanshuijia}",String.valueOf(t.getZhuangxiefeibuhanshuijia()));
 		sql  = sql.replace("#{zhuangxiefeizengzhishui}",String.valueOf(t.getZhuangxiefeizengzhishui()));
 		sql  = sql.replace("#{zhuangxiefeihanshuijia}",String.valueOf(t.getZhuangxiefeihanshuijia()));
 		sql  = sql.replace("#{cangchufeibuhanshuijia}",String.valueOf(t.getCangchufeibuhanshuijia()));
 		sql  = sql.replace("#{cangchufeizengzhishui}",String.valueOf(t.getCangchufeizengzhishui()));
 		sql  = sql.replace("#{cangchufeihanshuijia}",String.valueOf(t.getCangchufeihanshuijia()));
 		sql  = sql.replace("#{bencihuowunashuidezengzhishui}",String.valueOf(t.getBencihuowunashuidezengzhishui()));
 		sql  = sql.replace("#{zengzhishuifujiashui}",String.valueOf(t.getZengzhishuifujiashui()));
 		sql  = sql.replace("#{jinyingchenbenbiaozhun}",String.valueOf(t.getJinyingchenbenbiaozhun()));
 		sql  = sql.replace("#{bendanjinyinchengben}",String.valueOf(t.getBendanjinyinchengben()));
 		sql  = sql.replace("#{bendanshouru}",String.valueOf(t.getBendanshouru()));
 		sql  = sql.replace("#{bendanchengben}",String.valueOf(t.getBendanchengben()));
 		sql  = sql.replace("#{bendanlirun}",String.valueOf(t.getBendanlirun()));
 		sql  = sql.replace("#{bendansuodeshui}",String.valueOf(t.getBendansuodeshui()));
 		sql  = sql.replace("#{bendanjinlirun}",String.valueOf(t.getBendanjinlirun()));
 		sql  = sql.replace("#{bendanxianjinliuru}",String.valueOf(t.getBendanxianjinliuru()));
 		sql  = sql.replace("#{bendanchenbenxianjinliuchu}",String.valueOf(t.getBendanchenbenxianjinliuchu()));
 		sql  = sql.replace("#{bendanjinxianjinliu}",String.valueOf(t.getBendanjinxianjinliu()));
 		sql  = sql.replace("#{bendanshuijinliuchu}",String.valueOf(t.getBendanshuijinliuchu()));
 		sql  = sql.replace("#{bendanmaolilv}",String.valueOf(t.getBendanmaolilv()));
 		sql  = sql.replace("#{bendandanweichanpinbuhssj}",String.valueOf(t.getBendandanweichanpinbuhssj()));
 		sql  = sql.replace("#{bendandanweichanpinhssj}",String.valueOf(t.getBendandanweichanpinhssj()));
 		sql  = sql.replace("#{good_name}",String.valueOf(t.getGoodName()));
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
					javaInter.execute("cvc_offer_money",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}