package com.xuzy.hotel.offermoney.service.impl;
import com.xuzy.hotel.offermoney.dao.CvcOfferMoneyDao;
import com.xuzy.hotel.offermoney.service.CvcOfferMoneyServiceI;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

import com.xuzy.hotel.addedtax.entity.CvcAddedvalueTaxEntity;
import com.xuzy.hotel.addedtax.service.CvcAddedvalueTaxServiceI;
import com.xuzy.hotel.offermoney.entity.CvcOfferMoneyEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import java.math.BigDecimal;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("cvcOfferMoneyService")
@Transactional
public class CvcOfferMoneyServiceImpl extends CommonServiceImpl implements CvcOfferMoneyServiceI {

	@Autowired
	private CvcAddedvalueTaxServiceI cvcAddedvalueTaxService;
	@Autowired
	private CvcOfferMoneyDao cvcOfferMoneyDao;

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
	public void calculate(CvcOfferMoneyEntity entity) throws Exception {
//		commonDao.get(entityName, id);
		List<CvcAddedvalueTaxEntity> addedvalueTaxEntities = cvcAddedvalueTaxService.getList(CvcAddedvalueTaxEntity.class);
		//值税税率
		Double zengzhishuishuilv = 0.0;
		if(CollectionUtils.isNotEmpty(addedvalueTaxEntities)) {
			zengzhishuishuilv = addedvalueTaxEntities.get(0).getAddedvalueTax();
		}

		//计算 销售的增值税
		String xiaoshoubuhanshuijia = entity.getXiaoshoubuhanshuijia();
		if(StringUtils.isNotEmpty(xiaoshoubuhanshuijia)) {
			//销售的增值税
			entity.setXiaoshoudezhengzhishui(new BigDecimal(xiaoshoubuhanshuijia)
					.multiply(new BigDecimal(zengzhishuishuilv)
							.setScale(2,BigDecimal.ROUND_HALF_UP)).toString());
			//销售含税价
			entity.setXiaoshouhanshuijia(new BigDecimal(xiaoshoubuhanshuijia)
					.add(new BigDecimal(entity.getXiaoshoudezhengzhishui())).toString());
		}

		//采购不含税价
		String caigoubuhanshuijia = entity.getCaigoubuhanshuijia();
		if(StringUtils.isNotEmpty(caigoubuhanshuijia)) {
			//采购的增值税
			entity.setCaigoudezengzhishui(new BigDecimal(caigoubuhanshuijia)
					.multiply(new BigDecimal(zengzhishuishuilv)
							.setScale(2,BigDecimal.ROUND_HALF_UP)).toString());
			//采购的含税价
			entity.setCaigoudehanshuijia(new BigDecimal(caigoubuhanshuijia)
					.add(new BigDecimal(entity.getCaigoudezengzhishui())).toString());
		}

		// 运费不含税价
		String yunfeibuhanshuijia = entity.getYunfeibuhanshuijia();
		if (StringUtils.isNotEmpty(yunfeibuhanshuijia)) {
			// 运费增值税
			entity.setYunfeizengzhishui(new BigDecimal(yunfeibuhanshuijia)
					.multiply(new BigDecimal(zengzhishuishuilv).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
			//运费含税价
			entity.setYunfeihanshuijia(
					new BigDecimal(yunfeibuhanshuijia).add(new BigDecimal(entity.getYunfeizengzhishui())).toString());
		}

		// 包装费不含税价
		String baozhuanbuhanshuijia = entity.getBaozhuangfeibuhanshuijia();
		if (StringUtils.isNotEmpty(baozhuanbuhanshuijia)) {
			// 包装费增值税
			entity.setBaozhuangfeizengzhishui(new BigDecimal(baozhuanbuhanshuijia)
					.multiply(new BigDecimal(zengzhishuishuilv).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
			// 包装费含税价
			entity.setBaozhuangfeihanshuijia(
					new BigDecimal(baozhuanbuhanshuijia).add(new BigDecimal(entity.getBaozhuangfeizengzhishui())).toString());
		}

		// 装卸费不含税价
		String zhuangxiefeibuhanshuijia = entity.getZhuangxiefeibuhanshuijia();
		if (StringUtils.isNotEmpty(zhuangxiefeibuhanshuijia)) {
			//装卸费增值税
			entity.setZhuangxiefeizengzhishui(new BigDecimal(zhuangxiefeibuhanshuijia)
					.multiply(new BigDecimal(zengzhishuishuilv).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
			// 装卸费含税价
			entity.setZhuangxiefeihanshuijia(new BigDecimal(zhuangxiefeibuhanshuijia)
					.add(new BigDecimal(entity.getZhuangxiefeizengzhishui())).toString());
		}

		// 仓储费不含税价
		String cangzhushuibuhanshuijia = entity.getCangchufeibuhanshuijia();
		if (StringUtils.isNotEmpty(cangzhushuibuhanshuijia)) {
			// 仓储费增值税
			entity.setCangchufeizengzhishui(new BigDecimal(cangzhushuibuhanshuijia)
					.multiply(new BigDecimal(zengzhishuishuilv).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
			// 仓储费含税价
			entity.setCangchufeihanshuijia(new BigDecimal(cangzhushuibuhanshuijia)
					.add(new BigDecimal(entity.getCangchufeizengzhishui())).toString());
		}

		//本次货物缴纳的增值税
		String bencihuowujiaonadezengzhishui =
				new BigDecimal(entity.getXiaoshoudezhengzhishui())
				.subtract(new BigDecimal(entity.getCaigoudezengzhishui()))
				.subtract(new BigDecimal(entity.getYunfeizengzhishui()))
				.subtract(new BigDecimal(entity.getBaozhuangfeizengzhishui()))
				.subtract(new BigDecimal(entity.getZhuangxiefeizengzhishui()))
				.subtract(new BigDecimal(entity.getCangchufeizengzhishui()))
				.toString();
		entity.setBencihuowunashuidezengzhishui(bencihuowujiaonadezengzhishui);
		// 增值税附加税 = 本次货物缴纳的增值税*0.12
		entity.setZengzhishuifujiashui(new BigDecimal(bencihuowujiaonadezengzhishui)
				.multiply(new BigDecimal(0.12).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());

		//经营成本标准（除上面直接成本后的费用：如差旅费、招待费、人员薪酬、房租等等）
		String jinyinchenben = entity.getJinyingchenbenbiaozhun();
		if (StringUtils.isNotEmpty(jinyinchenben)) {
			//本单经营成本
			entity.setBendanjinyinchengben(new BigDecimal(jinyinchenben)
					.multiply(new BigDecimal(entity.getXiaoshouhanshuijia()).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
		}

		//本单收入 == 销售不含税价
		entity.setBendanshouru(entity.getXiaoshoubuhanshuijia());
		//本单成本
		entity.setBendanchengben(
				new BigDecimal(entity.getXiaoshoubuhanshuijia())
				.add(new BigDecimal(entity.getYunfeibuhanshuijia()))
				.add(new BigDecimal(entity.getBaozhuangfeibuhanshuijia()))
				.add(new BigDecimal(entity.getZhuangxiefeibuhanshuijia()))
				.add(new BigDecimal(entity.getCangchufeibuhanshuijia()))
				.add(new BigDecimal(entity.getZengzhishuifujiashui()))
				.add(new BigDecimal(entity.getBendanjinyinchengben()))
				.toString()
					);
		//本单利润
		entity.setBendanlirun(
				new BigDecimal(entity.getBendanshouru())
				.subtract(new BigDecimal(entity.getBendanchengben()))
				.toString()
				);

		//本单所得税 = 本单利润*0.25
		entity.setBendansuodeshui(new BigDecimal(entity.getBendanlirun())
				.multiply(new BigDecimal(0.25).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());

		//本单净利润
		entity.setBendanjinlirun(
				new BigDecimal(entity.getBendanlirun())
				.subtract(new BigDecimal(entity.getBendansuodeshui()))
				.toString());

		//本单现金流入
		entity.setBendanxianjinliuru(entity.getXiaoshouhanshuijia());

		//本单成本现金流出
		entity.setBendanchenbenxianjinliuchu(
				new BigDecimal(entity.getCaigoudehanshuijia())
				.add(new BigDecimal(entity.getYunfeihanshuijia()))
				.add(new BigDecimal(entity.getBaozhuangfeihanshuijia()))
				.add(new BigDecimal(entity.getZhuangxiefeihanshuijia()))
				.add(new BigDecimal(entity.getCangchufeihanshuijia()))
				.add(new BigDecimal(entity.getBendanjinyinchengben()))
				.toString()
				);

		//本单税金流出
		entity.setBendanshuijinliuchu(
				new BigDecimal(entity.getBencihuowunashuidezengzhishui())
				.add(new BigDecimal(entity.getZengzhishuifujiashui()))
				.add(new BigDecimal(entity.getBendansuodeshui()))
				.toString()
				);

		//本单净现金流
		entity.setBendanjinxianjinliu(
				new BigDecimal(entity.getBendanxianjinliuru())
				.subtract(new BigDecimal(entity.getBendanchenbenxianjinliuchu()))
				.subtract(new BigDecimal(entity.getBendanshuijinliuchu()))
				.toString()
				);

		//本单毛利率
		entity.setBendanmaolilv(
				new BigDecimal(entity.getBendanlirun())
				.multiply(new BigDecimal(entity.getXiaoshoubuhanshuijia()))
				.setScale(2, BigDecimal.ROUND_HALF_UP)
				.toString());

		entity.setBendandanweichanpinbuhssj(entity.getXiaoshoubuhanshuijia());
		entity.setBendandanweichanpinhssj(entity.getXiaoshouhanshuijia());
	}

	@Override
	public void batchInsert(List<CvcOfferMoneyEntity> cvcOfferMoneyEntityList) {
		cvcOfferMoneyDao.batchInsert(cvcOfferMoneyEntityList);
	}
}