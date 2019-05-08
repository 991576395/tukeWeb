package com.xuzy.hotel.offermoney.service.impl;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Formatter.BigDecimalLayoutForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xuzy.hotel.addedtax.entity.CvcAddedvalueTaxEntity;
import com.xuzy.hotel.addedtax.service.CvcAddedvalueTaxServiceI;
import com.xuzy.hotel.compareresult.entity.CvcCompareResultEntity;
import com.xuzy.hotel.compareresult.service.CvcCompareResultServiceI;
import com.xuzy.hotel.offermoney.dao.CvcOfferMoneyDao;
import com.xuzy.hotel.offermoney.entity.CvcOfferMoneyEntity;
import com.xuzy.hotel.offermoney.service.CvcOfferMoneyServiceI;

@Service("cvcOfferMoneyService")
@Transactional
public class CvcOfferMoneyServiceImpl extends CommonServiceImpl implements CvcOfferMoneyServiceI {

	@Autowired
	private CvcAddedvalueTaxServiceI cvcAddedvalueTaxService;
	@Autowired
	private CvcOfferMoneyDao cvcOfferMoneyDao;
	
	@Autowired
	private CvcCompareResultServiceI cvcCompareResultService;

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

	@Override
	public CvcOfferMoneyEntity calculate(CvcOfferMoneyEntity entity) throws Exception {
//		commonDao.get(entityName, id);
//		List<CvcAddedvalueTaxEntity> addedvalueTaxEntities = cvcAddedvalueTaxService.getList(CvcAddedvalueTaxEntity.class);
		//各种税率
		BigDecimal zengzhishuishuilv = null;
		//销售增值税
		CvcAddedvalueTaxEntity xiaoshouzhengzhishuilv = cvcAddedvalueTaxService.getEntityByName("产品增值税");
		//计算 销售的增值税
		String xiaoshoubuhanshuijia = entity.getXiaoshoubuhanshuijia();
		if(StringUtils.isNotEmpty(xiaoshoubuhanshuijia) && xiaoshouzhengzhishuilv != null) {
			zengzhishuishuilv = getShuilv(xiaoshouzhengzhishuilv);
			//销售的增值税
			entity.setXiaoshoudezhengzhishui(getBigdecimal(xiaoshoubuhanshuijia)
					.multiply(zengzhishuishuilv)
							.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
			//销售含税价
			entity.setXiaoshouhanshuijia(getBigdecimal(xiaoshoubuhanshuijia)
					.add(getBigdecimal(entity.getXiaoshoudezhengzhishui())).toString());
		}

		CvcAddedvalueTaxEntity caigouzengzhishuilv = cvcAddedvalueTaxService.getEntityByName("采购增值税");
		//采购不含税价
		String caigoubuhanshuijia = entity.getCaigoubuhanshuijia();
		if(StringUtils.isNotEmpty(caigoubuhanshuijia) && caigouzengzhishuilv!= null) {
			zengzhishuishuilv = getShuilv(caigouzengzhishuilv);
			//采购的增值税
			entity.setCaigoudezengzhishui(getBigdecimal(caigoubuhanshuijia)
					.multiply(zengzhishuishuilv)
							.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
			//采购的含税价
			entity.setCaigoudehanshuijia(getBigdecimal(caigoubuhanshuijia)
					.add(getBigdecimal(entity.getCaigoudezengzhishui())).toString());
		}

		CvcAddedvalueTaxEntity yunfeizengzhishuilv = cvcAddedvalueTaxService.getEntityByName("运费增值税");
		// 运费不含税价
		String yunfeibuhanshuijia = entity.getYunfeibuhanshuijia();
		if (StringUtils.isNotEmpty(yunfeibuhanshuijia) && yunfeizengzhishuilv != null) {
			zengzhishuishuilv = getShuilv(yunfeizengzhishuilv);
			// 运费增值税
			entity.setYunfeizengzhishui(getBigdecimal(yunfeibuhanshuijia)
					.multiply(zengzhishuishuilv).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			//运费含税价
			entity.setYunfeihanshuijia(
					getBigdecimal(yunfeibuhanshuijia).add(getBigdecimal(entity.getYunfeizengzhishui())).toString());
		}
		
		CvcAddedvalueTaxEntity baozhuangfeizengzhishuilv = cvcAddedvalueTaxService.getEntityByName("包装费增值税");
		// 包装费不含税价
		String baozhuanbuhanshuijia = entity.getBaozhuangfeibuhanshuijia();
		if (StringUtils.isNotEmpty(baozhuanbuhanshuijia) && baozhuangfeizengzhishuilv != null) {
			zengzhishuishuilv = getShuilv(baozhuangfeizengzhishuilv);
			// 包装费增值税
			entity.setBaozhuangfeizengzhishui(getBigdecimal(baozhuanbuhanshuijia)
					.multiply(zengzhishuishuilv).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			// 包装费含税价
			entity.setBaozhuangfeihanshuijia(
					getBigdecimal(baozhuanbuhanshuijia).add(getBigdecimal(entity.getBaozhuangfeizengzhishui())).toString());
		}
		
		CvcAddedvalueTaxEntity zhuangxiefeizengzhishuilv = cvcAddedvalueTaxService.getEntityByName("装卸费增值税");
		// 装卸费不含税价
		String zhuangxiefeibuhanshuijia = entity.getZhuangxiefeibuhanshuijia();
		if (StringUtils.isNotEmpty(zhuangxiefeibuhanshuijia) && zhuangxiefeizengzhishuilv != null) {
			zengzhishuishuilv = getShuilv(zhuangxiefeizengzhishuilv);
			//装卸费增值税
			entity.setZhuangxiefeizengzhishui(getBigdecimal(zhuangxiefeibuhanshuijia)
					.multiply(zengzhishuishuilv).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			// 装卸费含税价
			entity.setZhuangxiefeihanshuijia(getBigdecimal(zhuangxiefeibuhanshuijia)
					.add(getBigdecimal(entity.getZhuangxiefeizengzhishui())).toString());
		}
		
		CvcAddedvalueTaxEntity cangchufeizengzhishuilv = cvcAddedvalueTaxService.getEntityByName("仓储费增值税");
		// 仓储费不含税价
		String cangzhushuibuhanshuijia = entity.getCangchufeibuhanshuijia();
		if (StringUtils.isNotEmpty(cangzhushuibuhanshuijia) && cangchufeizengzhishuilv != null) {
			zengzhishuishuilv = getShuilv(cangchufeizengzhishuilv);
			// 仓储费增值税
			entity.setCangchufeizengzhishui(getBigdecimal(cangzhushuibuhanshuijia)
					.multiply(zengzhishuishuilv).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
			// 仓储费含税价
			entity.setCangchufeihanshuijia(getBigdecimal(cangzhushuibuhanshuijia)
					.add(getBigdecimal(entity.getCangchufeizengzhishui())).toString());
		}

		//本次货物缴纳的增值税
		String bencihuowujiaonadezengzhishui =
				getBigdecimal(entity.getXiaoshoudezhengzhishui())
				.subtract(getBigdecimal(entity.getCaigoudezengzhishui()))
				.subtract(getBigdecimal(entity.getYunfeizengzhishui()))
				.subtract(getBigdecimal(entity.getBaozhuangfeizengzhishui()))
				.subtract(getBigdecimal(entity.getZhuangxiefeizengzhishui()))
				.subtract(getBigdecimal(entity.getCangchufeizengzhishui()))
				.toString();
		entity.setBencihuowunashuidezengzhishui(bencihuowujiaonadezengzhishui);
		// 增值税附加税 = 本次货物缴纳的增值税*0.12
		entity.setZengzhishuifujiashui(getBigdecimal(bencihuowujiaonadezengzhishui)
				.multiply(getBigdecimal(0.12).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());

		//经营成本标准（除上面直接成本后的费用：如差旅费、招待费、人员薪酬、房租等等）
		String jinyinchenben = entity.getJinyingchenbenbiaozhun();
		if (StringUtils.isNotEmpty(jinyinchenben)) {
			//本单经营成本
			entity.setBendanjinyinchengben(getBigdecimal(jinyinchenben)
					.multiply(getBigdecimal(entity.getXiaoshouhanshuijia()).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
		}

		//本单收入 == 销售不含税价
		entity.setBendanshouru(entity.getXiaoshoubuhanshuijia());
		//本单成本
		entity.setBendanchengben(
				getBigdecimal(entity.getCaigoubuhanshuijia())
				.add(getBigdecimal(entity.getYunfeibuhanshuijia()))
				.add(getBigdecimal(entity.getBaozhuangfeibuhanshuijia()))
				.add(getBigdecimal(entity.getZhuangxiefeibuhanshuijia()))
				.add(getBigdecimal(entity.getCangchufeibuhanshuijia()))
				.add(getBigdecimal(entity.getZengzhishuifujiashui()))
//				.add(getBigdecimal(entity.getBendanjinyinchengben()))
				.toString()
					);
		//本单利润
		entity.setBendanlirun(
				getBigdecimal(entity.getBendanshouru())
				.subtract(getBigdecimal(entity.getBendanchengben()))
				.toString()
				);
		CvcAddedvalueTaxEntity qiyesuodeshuilv = cvcAddedvalueTaxService.getEntityByName("企业所得税");
		//本单所得税 = 本单利润*0.25
		if(qiyesuodeshuilv != null) {
			BigDecimal qiyesuode = getShuilv(cangchufeizengzhishuilv);
			entity.setBendansuodeshui(getBigdecimal(entity.getBendanlirun())
					.multiply(qiyesuode).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		}

		//本单净利润
		entity.setBendanjinlirun(
				getBigdecimal(entity.getBendanlirun())
				.subtract(getBigdecimal(entity.getBendansuodeshui()))
				.toString());

		//本单现金流入
		entity.setBendanxianjinliuru(entity.getXiaoshouhanshuijia());

		//本单成本现金流出
		entity.setBendanchenbenxianjinliuchu(
				getBigdecimal(entity.getCaigoudehanshuijia())
				.add(getBigdecimal(entity.getYunfeihanshuijia()))
				.add(getBigdecimal(entity.getBaozhuangfeihanshuijia()))
				.add(getBigdecimal(entity.getZhuangxiefeihanshuijia()))
				.add(getBigdecimal(entity.getCangchufeihanshuijia()))
				.add(getBigdecimal(entity.getBendanjinyinchengben()))
				.toString()
				);
		
		if(StringUtils.isEmpty(entity.getXiaoshoubuhanshuijia())) {
			//无销售不含税价，使用本单成本现金流出 填充
			entity.setXiaoshoubuhanshuijia(entity.getBendanchenbenxianjinliuchu());
			return calculate(entity);
		}
		
		//本单税金流出
		entity.setBendanshuijinliuchu(
				getBigdecimal(entity.getBencihuowunashuidezengzhishui())
				.add(getBigdecimal(entity.getZengzhishuifujiashui()))
				.add(getBigdecimal(entity.getBendansuodeshui()))
				.toString()
				);

		//本单净现金流
		entity.setBendanjinxianjinliu(
				getBigdecimal(entity.getBendanxianjinliuru())
				.subtract(getBigdecimal(entity.getBendanchenbenxianjinliuchu()))
				.subtract(getBigdecimal(entity.getBendanshuijinliuchu()))
				.toString()
				);

		//本单毛利率
		if(getBigdecimal(entity.getBendanlirun()).doubleValue() != 0 &&
				getBigdecimal(entity.getXiaoshoubuhanshuijia()).doubleValue() != 0){
			entity.setBendanmaolilv(
					getBigdecimal(entity.getBendanlirun())
					.divide(getBigdecimal(entity.getXiaoshoubuhanshuijia()),2, BigDecimal.ROUND_HALF_UP)
					.multiply(getBigdecimal(100))
					.toString());
		}
		
		

		entity.setBendandanweichanpinbuhssj(entity.getXiaoshoubuhanshuijia());
		entity.setBendandanweichanpinhssj(entity.getXiaoshouhanshuijia());
		
		
		//折扣率
		String guanwangtishuijia = entity.getGuangwangtishuijia();
		BigDecimal value = getBigdecimal(guanwangtishuijia).subtract(getBigdecimal(entity.getXiaoshoubuhanshuijia()));
		if (getBigdecimal(guanwangtishuijia).doubleValue() != 0 && 
				value.doubleValue() != 0) {
			value = value.divide(getBigdecimal(guanwangtishuijia),4, BigDecimal.ROUND_HALF_UP);
			entity.setZhekoulv(value.multiply(getBigdecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		}
		return entity;
	}

	public BigDecimal getBigdecimal(Object value) {
		BigDecimal  numnber = new BigDecimal("0.0");
		try {
			numnber = new BigDecimal(value.toString());
		} catch (Exception e) {
			return numnber;
		}
		return numnber;
	}
	
	private BigDecimal getShuilv(CvcAddedvalueTaxEntity xiaoshouzhengzhishuilv) {
		// 值税税率
		BigDecimal zengzhishuishuilv = getBigdecimal(0);
		if (xiaoshouzhengzhishuilv != null) {
			zengzhishuishuilv = getBigdecimal(xiaoshouzhengzhishuilv.getAddedvalueTax());
			if(zengzhishuishuilv.doubleValue() != 0) {
				zengzhishuishuilv = zengzhishuishuilv.divide(getBigdecimal(100).setScale(4, BigDecimal.ROUND_HALF_UP));
			}
		}
		return zengzhishuishuilv;
	}

	@Override
	public void upOrDownCalculate(CvcOfferMoneyEntity entity,String goodName, double number) throws Exception {
		if(entity == null) {
			List<CvcOfferMoneyEntity> cvcOfferMoneyEntities = commonDao.findHql("from CvcOfferMoneyEntity where ifMyCompany = '1' and goodName=?",goodName);
			if(CollectionUtils.isNotEmpty(cvcOfferMoneyEntities)) {
				entity = cvcOfferMoneyEntities.get(0);
			}
			if(entity == null) {
				//本公司该商品为空
				return;
			}
		}
		
		CvcAddedvalueTaxEntity xiaoshouzhengzhishuilv = cvcAddedvalueTaxService.getEntityByName("产品增值税");
		//值税税率
		BigDecimal zengzhishuishuilv = getShuilv(xiaoshouzhengzhishuilv);
		
		boolean isAdd = number > 0;
		//新比例
		BigDecimal newMath =  getBigdecimal(Math.abs(number)).divide(getBigdecimal(100),4,BigDecimal.ROUND_HALF_UP);
		BigDecimal valueJinlirun = getBigdecimal(0);
		if(StringUtils.isNotEmpty(entity.getBendanjinlirun())) {
			//计算提升火减少净利润值
			valueJinlirun = getBigdecimal(entity.getBendanjinlirun())
					.multiply(newMath)
					.setScale(2, BigDecimal.ROUND_HALF_UP);
			if(isAdd) {
				valueJinlirun = valueJinlirun.add(getBigdecimal(entity.getBendanjinlirun()));
			}else {
				valueJinlirun = getBigdecimal(entity.getBendanjinlirun()).subtract(valueJinlirun);
			}
			valueJinlirun = valueJinlirun.divide(getBigdecimal(0.75),2, BigDecimal.ROUND_HALF_UP);
			valueJinlirun = valueJinlirun.add(getBigdecimal(entity.getBendanchengben()));
			valueJinlirun.divide(getBigdecimal(1).add(zengzhishuishuilv),2, BigDecimal.ROUND_HALF_UP);
			
		}
		entity.setXiaoshoubuhanshuijia(valueJinlirun.toString());
		entity = calculate(entity);
		
		commonDao.updateEntitie(entity);
	}

    
    
    /**
     * 批量保存报价商品信息
     * @param cvcOfferMoneyEntityList
     * @param ifMyCompany
     * @param fileName
     */
	@Override
	public void calculateOther() throws Exception {
		commonDao.executeHql("delete from CvcCompareResultEntity");
		
		List<CvcOfferMoneyEntity> cvcOfferMoneyOtherEntities = commonDao.findHql("from CvcOfferMoneyEntity where ifMyCompany = '0' ");
		for (CvcOfferMoneyEntity cvcOfferMoneyEntity : cvcOfferMoneyOtherEntities) {
			CvcOfferMoneyEntity ourEntity = null;
			List<CvcOfferMoneyEntity> cvcOfferMoneyEntities = commonDao.findHql("from CvcOfferMoneyEntity where ifMyCompany = '1' and goodName=?",cvcOfferMoneyEntity.getGoodName().trim());
			if(CollectionUtils.isNotEmpty(cvcOfferMoneyEntities)) {
				ourEntity = cvcOfferMoneyEntities.get(0);
			}
			if(ourEntity == null) {
				//本公司该商品为空
				continue;
			}
			
			CvcCompareResultEntity cvcCompareResultEntity = new CvcCompareResultEntity();
			cvcCompareResultEntity.setCompanyName(cvcOfferMoneyEntity.getCompanyName());
			cvcCompareResultEntity.setGoodName(cvcOfferMoneyEntity.getGoodName());
			
			if(StringUtils.isNotEmpty(cvcOfferMoneyEntity.getXiaoshoubuhanshuijia()) && StringUtils.isNotEmpty(ourEntity.getXiaoshoubuhanshuijia())
					&& getBigdecimal(ourEntity.getXiaoshoubuhanshuijia()).doubleValue() != 0) {
				BigDecimal tishuiResult = getBigdecimal(cvcOfferMoneyEntity.getXiaoshoubuhanshuijia())
						.divide(getBigdecimal(ourEntity.getXiaoshoubuhanshuijia()),2, BigDecimal.ROUND_HALF_UP);
						tishuiResult = tishuiResult.subtract(getBigdecimal(1));
						tishuiResult = tishuiResult.multiply(getBigdecimal(100)
								.setScale(2,BigDecimal.ROUND_HALF_UP));
				cvcCompareResultEntity.setTishuijiadbjg(tishuiResult.toString());
			}
			
			
			if(StringUtils.isNotEmpty(cvcOfferMoneyEntity.getXiaoshouhanshuijia()) && StringUtils.isNotEmpty(ourEntity.getXiaoshouhanshuijia())
					&& getBigdecimal(ourEntity.getXiaoshouhanshuijia()).doubleValue() != 0) {
				BigDecimal hanshuiResult = getBigdecimal(cvcOfferMoneyEntity.getXiaoshouhanshuijia())
						.divide(getBigdecimal(ourEntity.getXiaoshouhanshuijia()), 2, BigDecimal.ROUND_HALF_UP);
				hanshuiResult = hanshuiResult.subtract(getBigdecimal(1));
				hanshuiResult = hanshuiResult.multiply(getBigdecimal(100).setScale(2, BigDecimal.ROUND_HALF_UP));
				cvcCompareResultEntity.setHanshuijiadbjg(hanshuiResult.toString());
			}
			
			
			if(StringUtils.isNotEmpty(cvcOfferMoneyEntity.getQihuo())  && StringUtils.isNotEmpty(ourEntity.getQihuo())
					&& getBigdecimal(ourEntity.getQihuo()).doubleValue() != 0){
				BigDecimal qihuoResult = getBigdecimal(cvcOfferMoneyEntity.getQihuo())
						.divide(getBigdecimal(ourEntity.getQihuo()), 2, BigDecimal.ROUND_HALF_UP);
				qihuoResult = qihuoResult.subtract(getBigdecimal(1));
				qihuoResult = qihuoResult.multiply(getBigdecimal(100).setScale(2, BigDecimal.ROUND_HALF_UP));
				cvcCompareResultEntity.setHuoqidbjg(qihuoResult.toString());
				cvcCompareResultEntity.setHuoqidbjg(qihuoResult.toString());
			}
			
			cvcCompareResultService.save(cvcCompareResultEntity);
		}
	}
    /**
     * 批量保存报价商品信息
     * @param cvcOfferMoneyEntityList
     * @param ifMyCompany
     * @param fileName
     */
    @Override
    public void batchInsert(List<CvcOfferMoneyEntity> cvcOfferMoneyEntityList, String ifMyCompany, String fileName) {
        List<CvcOfferMoneyEntity> moneyEntityList = commonDao.findHql("from CvcOfferMoneyEntity u where u.ifMyCompany=?", ifMyCompany);
        Map<String, CvcOfferMoneyEntity> map = Maps.newHashMap();
        for (CvcOfferMoneyEntity cvcOfferMoneyEntity : moneyEntityList) {
            if ("0".equals(ifMyCompany)) {
                map.put(cvcOfferMoneyEntity.getGoodName() + ":" + cvcOfferMoneyEntity.getCompanyName(), cvcOfferMoneyEntity);
            } else {
                map.put(cvcOfferMoneyEntity.getGoodName(), cvcOfferMoneyEntity);
            }
        }
        Map<String, CvcOfferMoneyEntity> saveCvcOfferMoneyEntityMap = Maps.newHashMap();
        // 去除重复的商品，取最后一条
        for (CvcOfferMoneyEntity cvcOfferMoneyEntity : cvcOfferMoneyEntityList) {
            saveCvcOfferMoneyEntityMap.put(cvcOfferMoneyEntity.getGoodName(), cvcOfferMoneyEntity);
        }
        List<CvcOfferMoneyEntity> deleteCvcOfferMoneyEntityList = Lists.newArrayList();
        for (CvcOfferMoneyEntity cvcOfferMoneyEntity : saveCvcOfferMoneyEntityMap.values()) {
            String key = "0".equals(ifMyCompany) ? cvcOfferMoneyEntity.getGoodName() + ":" + cvcOfferMoneyEntity.getCompanyName() : cvcOfferMoneyEntity.getGoodName();
            CvcOfferMoneyEntity oldCvcOfferMoneyEntity = map.get(key);
            // 如果系统中存在一样的商品，则先删除再新增
            if (oldCvcOfferMoneyEntity != null) {
                deleteCvcOfferMoneyEntityList.add(oldCvcOfferMoneyEntity);
            }
            cvcOfferMoneyEntity.setIfMyCompany(ifMyCompany);
            cvcOfferMoneyEntity.setCompanyName(fileName);
            try {
            	cvcOfferMoneyEntity = calculate(cvcOfferMoneyEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        commonDao.deleteAllEntitie(deleteCvcOfferMoneyEntityList);
        commonDao.batchSave(cvcOfferMoneyEntityList);
    }

	@Override
	public CvcOfferMoneyEntity getGoodNameEntity(String goodName) {
		CvcOfferMoneyEntity ourEntity = null;
		List<CvcOfferMoneyEntity> cvcOfferMoneyEntities = commonDao.findHql("from CvcOfferMoneyEntity where ifMyCompany = '1' and goodName=?",goodName.trim());
		if(CollectionUtils.isNotEmpty(cvcOfferMoneyEntities)) {
			ourEntity = cvcOfferMoneyEntities.get(0);
		}
		return ourEntity;
	}

	@Override
	public void upOrDownTishuijiaCalculate(CvcOfferMoneyEntity entity, String goodName, double number)
			throws Exception {
		if(entity == null) {
			List<CvcOfferMoneyEntity> cvcOfferMoneyEntities = commonDao.findHql("from CvcOfferMoneyEntity where ifMyCompany = '1' and goodName=?",goodName);
			if(CollectionUtils.isNotEmpty(cvcOfferMoneyEntities)) {
				entity = cvcOfferMoneyEntities.get(0);
			}
			if(entity == null) {
				//本公司该商品为空
				return;
			}
		}
		
		//值税税率
		boolean isAdd = number > 0;
		//新比例
		BigDecimal newMath =  getBigdecimal(Math.abs(number)).divide(getBigdecimal(100),4,BigDecimal.ROUND_HALF_UP);
		BigDecimal valueJinlirun = getBigdecimal(0);
		if(StringUtils.isNotEmpty(entity.getXiaoshoubuhanshuijia())) {
			//计算提升火减少净利润值
			valueJinlirun = getBigdecimal(entity.getXiaoshoubuhanshuijia())
					.multiply(newMath)
					.setScale(2, BigDecimal.ROUND_HALF_UP);
			if(isAdd) {
				valueJinlirun = valueJinlirun.add(getBigdecimal(entity.getXiaoshoubuhanshuijia()));
			}else {
				valueJinlirun = getBigdecimal(entity.getXiaoshoubuhanshuijia()).subtract(valueJinlirun);
			}
		}
		entity.setXiaoshoubuhanshuijia(valueJinlirun.toString());
		entity = calculate(entity);
		
		commonDao.updateEntitie(entity);
	}
}