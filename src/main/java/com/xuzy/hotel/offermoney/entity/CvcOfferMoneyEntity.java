package com.xuzy.hotel.offermoney.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 报价表
 * @author onlineGenerator
 * @date 2019-05-02 12:33:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cvc_offer_money", schema = "")
@SuppressWarnings("serial")
public class CvcOfferMoneyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**是否本公司*/
	private java.lang.String ifMyCompany;
	/**销售不含税价*/
	@Excel(name="销售不含税价",width=15)
	private java.lang.String xiaoshoubuhanshuijia;
	/**销售的增值税*/
	@Excel(name="销售的增值税",width=15)
	private java.lang.String xiaoshoudezhengzhishui;
	/**销售含税价*/
	@Excel(name="销售含税价",width=15)
	private java.lang.String xiaoshouhanshuijia;
	/**采购不含税价*/
	@Excel(name="采购不含税价",width=15)
	private java.lang.String caigoubuhanshuijia;
	/**采购的增值税*/
	@Excel(name="采购的增值税",width=15)
	private java.lang.String caigoudezengzhishui;
	/**采购的含税价*/
	@Excel(name="采购的含税价",width=15)
	private java.lang.String caigoudehanshuijia;
	/**运费不含税价*/
	@Excel(name="运费不含税价",width=15)
	private java.lang.String yunfeibuhanshuijia;
	/**运费增值税*/
	@Excel(name="运费增值税",width=15)
	private java.lang.String yunfeizengzhishui;
	/**运费含税价*/
	@Excel(name="运费含税价",width=15)
	private java.lang.String yunfeihanshuijia;
	/**包装费不含税价*/
	@Excel(name="包装费不含税价",width=15)
	private java.lang.String baozhuangfeibuhanshuijia;
	/**包装费增值税*/
	@Excel(name="包装费增值税",width=15)
	private java.lang.String baozhuangfeizengzhishui;
	/**包装费含税价*/
	@Excel(name="包装费含税价",width=15)
	private java.lang.String baozhuangfeihanshuijia;
	/**装卸费不含税价*/
	@Excel(name="装卸费不含税价",width=15)
	private java.lang.String zhuangxiefeibuhanshuijia;
	/**装卸费增值税*/
	@Excel(name="装卸费增值税",width=15)
	private java.lang.String zhuangxiefeizengzhishui;
	/**装卸费含税价*/
	@Excel(name="装卸费含税价",width=15)
	private java.lang.String zhuangxiefeihanshuijia;
	/**仓储费不含税价*/
	@Excel(name="仓储费不含税价",width=15)
	private java.lang.String cangchufeibuhanshuijia;
	/**仓储费增值税*/
	@Excel(name="仓储费增值税",width=15)
	private java.lang.String cangchufeizengzhishui;
	/**仓储费含税价*/
	@Excel(name="仓储费含税价",width=15)
	private java.lang.String cangchufeihanshuijia;
	/**本次货物缴纳的增值税*/
	@Excel(name="本次货物缴纳的增值税",width=15)
	private java.lang.String bencihuowunashuidezengzhishui;
	/**增值税附加税*/
	@Excel(name="增值税附加税",width=15)
	private java.lang.String zengzhishuifujiashui;
	/**经营成本标准*/
	@Excel(name="经营成本标准",width=15)
	private java.lang.String jinyingchenbenbiaozhun;
	/**本单经营成本*/
	@Excel(name="本单经营成本",width=15)
	private java.lang.String bendanjinyinchengben;
	/**本单收入*/
	@Excel(name="本单收入",width=15)
	private java.lang.String bendanshouru;
	/**本单成本*/
	@Excel(name="本单成本",width=15)
	private java.lang.String bendanchengben;
	/**本单利润*/
	@Excel(name="本单利润",width=15)
	private java.lang.String bendanlirun;
	/**本单所得税*/
	@Excel(name="本单所得税",width=15)
	private java.lang.String bendansuodeshui;
	/**本单净利润*/
	@Excel(name="本单净利润",width=15)
	private java.lang.String bendanjinlirun;
	/**本单现金流入*/
	@Excel(name="本单现金流入",width=15)
	private java.lang.String bendanxianjinliuru;
	/**本单成本现金流出*/
	@Excel(name="本单成本现金流出",width=15)
	private java.lang.String bendanchenbenxianjinliuchu;
	/**本单净现金流*/
	@Excel(name="本单净现金流",width=15)
	private java.lang.String bendanjinxianjinliu;
	/**本单税金流出*/
	@Excel(name="本单税金流出",width=15)
	private java.lang.String bendanshuijinliuchu;
	/**本单毛利率*/
	@Excel(name="本单毛利率",width=15)
	private java.lang.String bendanmaolilv;
	/**本单单位产品不含税售价*/
	@Excel(name="本单单位产品不含税售价",width=15)
	private java.lang.String bendandanweichanpinbuhssj;
	/**本单单位产品含税售价*/
	@Excel(name="本单单位产品含税售价",width=15)
	private java.lang.String bendandanweichanpinhssj;
	/**商品名称*/
	@Excel(name="商品名称",width=15)
	private java.lang.String goodName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否本公司
	 */

	@Column(name ="IF_MY_COMPANY",nullable=true,length=1)
	public java.lang.String getIfMyCompany(){
		return this.ifMyCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否本公司
	 */
	public void setIfMyCompany(java.lang.String ifMyCompany){
		this.ifMyCompany = ifMyCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售不含税价
	 */

	@Column(name ="XIAOSHOUBUHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getXiaoshoubuhanshuijia(){
		return this.xiaoshoubuhanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售不含税价
	 */
	public void setXiaoshoubuhanshuijia(java.lang.String xiaoshoubuhanshuijia){
		this.xiaoshoubuhanshuijia = xiaoshoubuhanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售的增值税
	 */

	@Column(name ="XIAOSHOUDEZHENGZHISHUI",nullable=true,length=32)
	public java.lang.String getXiaoshoudezhengzhishui(){
		return this.xiaoshoudezhengzhishui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售的增值税
	 */
	public void setXiaoshoudezhengzhishui(java.lang.String xiaoshoudezhengzhishui){
		this.xiaoshoudezhengzhishui = xiaoshoudezhengzhishui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售含税价
	 */

	@Column(name ="XIAOSHOUHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getXiaoshouhanshuijia(){
		return this.xiaoshouhanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售含税价
	 */
	public void setXiaoshouhanshuijia(java.lang.String xiaoshouhanshuijia){
		this.xiaoshouhanshuijia = xiaoshouhanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购不含税价
	 */

	@Column(name ="CAIGOUBUHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getCaigoubuhanshuijia(){
		return this.caigoubuhanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购不含税价
	 */
	public void setCaigoubuhanshuijia(java.lang.String caigoubuhanshuijia){
		this.caigoubuhanshuijia = caigoubuhanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购的增值税
	 */

	@Column(name ="CAIGOUDEZENGZHISHUI",nullable=true,length=32)
	public java.lang.String getCaigoudezengzhishui(){
		return this.caigoudezengzhishui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购的增值税
	 */
	public void setCaigoudezengzhishui(java.lang.String caigoudezengzhishui){
		this.caigoudezengzhishui = caigoudezengzhishui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购的含税价
	 */

	@Column(name ="CAIGOUDEHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getCaigoudehanshuijia(){
		return this.caigoudehanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购的含税价
	 */
	public void setCaigoudehanshuijia(java.lang.String caigoudehanshuijia){
		this.caigoudehanshuijia = caigoudehanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运费不含税价
	 */

	@Column(name ="YUNFEIBUHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getYunfeibuhanshuijia(){
		return this.yunfeibuhanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运费不含税价
	 */
	public void setYunfeibuhanshuijia(java.lang.String yunfeibuhanshuijia){
		this.yunfeibuhanshuijia = yunfeibuhanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运费增值税
	 */

	@Column(name ="YUNFEIZENGZHISHUI",nullable=true,length=32)
	public java.lang.String getYunfeizengzhishui(){
		return this.yunfeizengzhishui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运费增值税
	 */
	public void setYunfeizengzhishui(java.lang.String yunfeizengzhishui){
		this.yunfeizengzhishui = yunfeizengzhishui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运费含税价
	 */

	@Column(name ="YUNFEIHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getYunfeihanshuijia(){
		return this.yunfeihanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运费含税价
	 */
	public void setYunfeihanshuijia(java.lang.String yunfeihanshuijia){
		this.yunfeihanshuijia = yunfeihanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装费不含税价
	 */

	@Column(name ="BAOZHUANGFEIBUHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getBaozhuangfeibuhanshuijia(){
		return this.baozhuangfeibuhanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装费不含税价
	 */
	public void setBaozhuangfeibuhanshuijia(java.lang.String baozhuangfeibuhanshuijia){
		this.baozhuangfeibuhanshuijia = baozhuangfeibuhanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装费增值税
	 */

	@Column(name ="BAOZHUANGFEIZENGZHISHUI",nullable=true,length=32)
	public java.lang.String getBaozhuangfeizengzhishui(){
		return this.baozhuangfeizengzhishui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装费增值税
	 */
	public void setBaozhuangfeizengzhishui(java.lang.String baozhuangfeizengzhishui){
		this.baozhuangfeizengzhishui = baozhuangfeizengzhishui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装费含税价
	 */

	@Column(name ="BAOZHUANGFEIHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getBaozhuangfeihanshuijia(){
		return this.baozhuangfeihanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装费含税价
	 */
	public void setBaozhuangfeihanshuijia(java.lang.String baozhuangfeihanshuijia){
		this.baozhuangfeihanshuijia = baozhuangfeihanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装卸费不含税价
	 */

	@Column(name ="ZHUANGXIEFEIBUHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getZhuangxiefeibuhanshuijia(){
		return this.zhuangxiefeibuhanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装卸费不含税价
	 */
	public void setZhuangxiefeibuhanshuijia(java.lang.String zhuangxiefeibuhanshuijia){
		this.zhuangxiefeibuhanshuijia = zhuangxiefeibuhanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装卸费增值税
	 */

	@Column(name ="ZHUANGXIEFEIZENGZHISHUI",nullable=true,length=32)
	public java.lang.String getZhuangxiefeizengzhishui(){
		return this.zhuangxiefeizengzhishui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装卸费增值税
	 */
	public void setZhuangxiefeizengzhishui(java.lang.String zhuangxiefeizengzhishui){
		this.zhuangxiefeizengzhishui = zhuangxiefeizengzhishui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  装卸费含税价
	 */

	@Column(name ="ZHUANGXIEFEIHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getZhuangxiefeihanshuijia(){
		return this.zhuangxiefeihanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  装卸费含税价
	 */
	public void setZhuangxiefeihanshuijia(java.lang.String zhuangxiefeihanshuijia){
		this.zhuangxiefeihanshuijia = zhuangxiefeihanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓储费不含税价
	 */

	@Column(name ="CANGCHUFEIBUHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getCangchufeibuhanshuijia(){
		return this.cangchufeibuhanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓储费不含税价
	 */
	public void setCangchufeibuhanshuijia(java.lang.String cangchufeibuhanshuijia){
		this.cangchufeibuhanshuijia = cangchufeibuhanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓储费增值税
	 */

	@Column(name ="CANGCHUFEIZENGZHISHUI",nullable=true,length=32)
	public java.lang.String getCangchufeizengzhishui(){
		return this.cangchufeizengzhishui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓储费增值税
	 */
	public void setCangchufeizengzhishui(java.lang.String cangchufeizengzhishui){
		this.cangchufeizengzhishui = cangchufeizengzhishui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  仓储费含税价
	 */

	@Column(name ="CANGCHUFEIHANSHUIJIA",nullable=true,length=32)
	public java.lang.String getCangchufeihanshuijia(){
		return this.cangchufeihanshuijia;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  仓储费含税价
	 */
	public void setCangchufeihanshuijia(java.lang.String cangchufeihanshuijia){
		this.cangchufeihanshuijia = cangchufeihanshuijia;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本次货物缴纳的增值税
	 */

	@Column(name ="BENCIHUOWUNASHUIDEZENGZHISHUI",nullable=true,length=32)
	public java.lang.String getBencihuowunashuidezengzhishui(){
		return this.bencihuowunashuidezengzhishui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本次货物缴纳的增值税
	 */
	public void setBencihuowunashuidezengzhishui(java.lang.String bencihuowunashuidezengzhishui){
		this.bencihuowunashuidezengzhishui = bencihuowunashuidezengzhishui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  增值税附加税
	 */

	@Column(name ="ZENGZHISHUIFUJIASHUI",nullable=true,length=32)
	public java.lang.String getZengzhishuifujiashui(){
		return this.zengzhishuifujiashui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  增值税附加税
	 */
	public void setZengzhishuifujiashui(java.lang.String zengzhishuifujiashui){
		this.zengzhishuifujiashui = zengzhishuifujiashui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经营成本标准
	 */

	@Column(name ="JINYINGCHENBENBIAOZHUN",nullable=true,length=32)
	public java.lang.String getJinyingchenbenbiaozhun(){
		return this.jinyingchenbenbiaozhun;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经营成本标准
	 */
	public void setJinyingchenbenbiaozhun(java.lang.String jinyingchenbenbiaozhun){
		this.jinyingchenbenbiaozhun = jinyingchenbenbiaozhun;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单经营成本
	 */

	@Column(name ="BENDANJINYINCHENGBEN",nullable=true,length=32)
	public java.lang.String getBendanjinyinchengben(){
		return this.bendanjinyinchengben;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单经营成本
	 */
	public void setBendanjinyinchengben(java.lang.String bendanjinyinchengben){
		this.bendanjinyinchengben = bendanjinyinchengben;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单收入
	 */

	@Column(name ="BENDANSHOURU",nullable=true,length=32)
	public java.lang.String getBendanshouru(){
		return this.bendanshouru;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单收入
	 */
	public void setBendanshouru(java.lang.String bendanshouru){
		this.bendanshouru = bendanshouru;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单成本
	 */

	@Column(name ="BENDANCHENGBEN",nullable=true,length=32)
	public java.lang.String getBendanchengben(){
		return this.bendanchengben;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单成本
	 */
	public void setBendanchengben(java.lang.String bendanchengben){
		this.bendanchengben = bendanchengben;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单利润
	 */

	@Column(name ="BENDANLIRUN",nullable=true,length=32)
	public java.lang.String getBendanlirun(){
		return this.bendanlirun;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单利润
	 */
	public void setBendanlirun(java.lang.String bendanlirun){
		this.bendanlirun = bendanlirun;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单所得税
	 */

	@Column(name ="BENDANSUODESHUI",nullable=true,length=32)
	public java.lang.String getBendansuodeshui(){
		return this.bendansuodeshui;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单所得税
	 */
	public void setBendansuodeshui(java.lang.String bendansuodeshui){
		this.bendansuodeshui = bendansuodeshui;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单净利润
	 */

	@Column(name ="BENDANJINLIRUN",nullable=true,length=32)
	public java.lang.String getBendanjinlirun(){
		return this.bendanjinlirun;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单净利润
	 */
	public void setBendanjinlirun(java.lang.String bendanjinlirun){
		this.bendanjinlirun = bendanjinlirun;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单现金流入
	 */

	@Column(name ="BENDANXIANJINLIURU",nullable=true,length=32)
	public java.lang.String getBendanxianjinliuru(){
		return this.bendanxianjinliuru;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单现金流入
	 */
	public void setBendanxianjinliuru(java.lang.String bendanxianjinliuru){
		this.bendanxianjinliuru = bendanxianjinliuru;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单成本现金流出
	 */

	@Column(name ="BENDANCHENBENXIANJINLIUCHU",nullable=true,length=32)
	public java.lang.String getBendanchenbenxianjinliuchu(){
		return this.bendanchenbenxianjinliuchu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单成本现金流出
	 */
	public void setBendanchenbenxianjinliuchu(java.lang.String bendanchenbenxianjinliuchu){
		this.bendanchenbenxianjinliuchu = bendanchenbenxianjinliuchu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单净现金流
	 */

	@Column(name ="BENDANJINXIANJINLIU",nullable=true,length=32)
	public java.lang.String getBendanjinxianjinliu(){
		return this.bendanjinxianjinliu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单净现金流
	 */
	public void setBendanjinxianjinliu(java.lang.String bendanjinxianjinliu){
		this.bendanjinxianjinliu = bendanjinxianjinliu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单税金流出
	 */

	@Column(name ="BENDANSHUIJINLIUCHU",nullable=true,length=32)
	public java.lang.String getBendanshuijinliuchu(){
		return this.bendanshuijinliuchu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单税金流出
	 */
	public void setBendanshuijinliuchu(java.lang.String bendanshuijinliuchu){
		this.bendanshuijinliuchu = bendanshuijinliuchu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单毛利率
	 */

	@Column(name ="BENDANMAOLILV",nullable=true,length=32)
	public java.lang.String getBendanmaolilv(){
		return this.bendanmaolilv;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单毛利率
	 */
	public void setBendanmaolilv(java.lang.String bendanmaolilv){
		this.bendanmaolilv = bendanmaolilv;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单单位产品不含税售价
	 */

	@Column(name ="BENDANDANWEICHANPINBUHSSJ",nullable=true,length=32)
	public java.lang.String getBendandanweichanpinbuhssj(){
		return this.bendandanweichanpinbuhssj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单单位产品不含税售价
	 */
	public void setBendandanweichanpinbuhssj(java.lang.String bendandanweichanpinbuhssj){
		this.bendandanweichanpinbuhssj = bendandanweichanpinbuhssj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本单单位产品含税售价
	 */

	@Column(name ="BENDANDANWEICHANPINHSSJ",nullable=true,length=32)
	public java.lang.String getBendandanweichanpinhssj(){
		return this.bendandanweichanpinhssj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本单单位产品含税售价
	 */
	public void setBendandanweichanpinhssj(java.lang.String bendandanweichanpinhssj){
		this.bendandanweichanpinhssj = bendandanweichanpinhssj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品名称
	 */

	@Column(name ="GOOD_NAME",nullable=true,length=32)
	public java.lang.String getGoodName(){
		return this.goodName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品名称
	 */
	public void setGoodName(java.lang.String goodName){
		this.goodName = goodName;
	}
}
