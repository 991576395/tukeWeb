package com.xuzy.hotel.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 描述：订单表
 * @author: www.jeecg.org
 * @since：2018年11月04日 12时17分32秒 星期日 
 * @version:1.0
 */
public class CvcOrderInfoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 *order_id
	 */
	@Excel(name="订单号",orderNum="1")
	private Integer id;
	/**
	 *order_sn
	 */
	private String orderSn;
	/**
	 *user_id
	 */
	@Excel(name="用户ID",orderNum="2")
	private Integer userId;
	/**
	 *积分账户
	 */
	@Excel(name="积分账户",orderNum="6")
	private String userName;
	/**
	 *order_status
	 */
	private Integer orderStatus;
	/**
	 *tk订单状态
	 */
	private Integer tkOrderStatus;
	
	@Excel(name="订单状态",orderNum="13")
	private String tkOrderStatusString;
	/**
	 *shipping_status
	 */
	private Integer shippingStatus;
	/**
	 *pay_status
	 */
	private Integer payStatus;
	/**
	 *consignee
	 */
	@Excel(name="收货人",orderNum="5")
	private String consignee;
	/**
	 *country
	 */
	private Integer country;
	/**
	 *province
	 */
	private Integer province;
	/**
	 *city
	 */
	private Integer city;
	/**
	 *district
	 */
	private Integer district;
	/**
	 *address
	 */
	@Excel(name="收货地址",width=20,orderNum="9")
	private String address;
	/**
	 *zipcode
	 */
	private String zipcode;
	/**
	 *tel
	 */
	@Excel(name="收货人电话",orderNum="10")
	private String tel;
	/**
	 *mobile
	 */
	private String mobile;
	/**
	 *email
	 */
	private String email;
	/**
	 *best_time
	 */
	private String bestTime;
	/**
	 *sign_building
	 */
	private String signBuilding;
	/**
	 *postscript
	 */
	private String postscript;
	/**
	 *shipping_id
	 */
	private Integer shippingId;
	/**
	 *shipping_name
	 */
	@Excel(name="快递公司",orderNum="11")
	private String shippingName;
	/**
	 *pay_id
	 */
	private Integer payId;
	/**
	 *pay_name
	 */
	private String payName;
	/**
	 *how_oos
	 */
	private String howOos;
	/**
	 *how_surplus
	 */
	private String howSurplus;
	/**
	 *pack_name
	 */
	private String packName;
	/**
	 *card_name
	 */
	private String cardName;
	/**
	 *card_message
	 */
	private String cardMessage;
	/**
	 *inv_payee
	 */
	private String invPayee;
	/**
	 *inv_content
	 */
	private String invContent;
	/**
	 *goods_amount
	 */
	private BigDecimal goodsAmount;
	/**
	 *shipping_fee
	 */
	private BigDecimal shippingFee;
	/**
	 *insure_fee
	 */
	private BigDecimal insureFee;
	/**
	 *pay_fee
	 */
	private BigDecimal payFee;
	/**
	 *pack_fee
	 */
	private BigDecimal packFee;
	/**
	 *card_fee
	 */
	private BigDecimal cardFee;
	/**
	 *money_paid
	 */
	private BigDecimal moneyPaid;
	/**
	 *surplus
	 */
	private BigDecimal surplus;
	/**
	 *integral
	 */
	private Integer integral;
	/**
	 *integral_money
	 */
	private BigDecimal integralMoney;
	/**
	 *bonus
	 */
	private BigDecimal bonus;
	/**
	 *order_amount
	 */
	private BigDecimal orderAmount;
	/**
	 *from_ad
	 */
	private Integer fromAd;
	/**
	 *referer
	 */
	private String referer;
	/**
	 *add_time
	 */
	@Excel(name="下单时间",width=20,orderNum="3")
	private String addTime;
	/**
	 * 未转换格式后的时间
	 */
	private String oldAddTime;

	private String addTime_begin1;
	private String addTime_end2;
	
	private Integer addTimeBegin;
	private Integer addTimeEnd;
	
	/**
	 *confirm_time
	 */
	private String confirmTime;
	/**
	 *pay_time
	 */
	private Integer payTime;
	/**
	 *shipping_time
	 */
	private Integer shippingTime;
	/**
	 *用户取消订单时间
	 */
	private Integer cancelTime;
	/**
	 *管理员返款时间
	 */
	private Integer refundTime;
	/**
	 *pack_id
	 */
	private Integer packId;
	/**
	 *card_id
	 */
	private Integer cardId;
	/**
	 *bonus_id
	 */
	private Integer bonusId;
	/**
	 *invoice_no
	 */
	@Excel(name="快递单号",width=20,orderNum="12")
	private String invoiceNo;
	/**
	 *extension_code
	 */
	private String extensionCode;
	/**
	 *extension_id
	 */
	private Integer extensionId;
	/**
	 *to_buyer
	 */
	private String toBuyer;
	/**
	 *pay_note
	 */
	private String payNote;
	/**
	 *agency_id
	 */
	private Integer agencyId;
	/**
	 *inv_type
	 */
	private String invType;
	/**
	 *tax
	 */
	private BigDecimal tax;
	/**
	 *is_separate
	 */
	private Integer isSeparate;
	/**
	 *parent_id
	 */
	private Integer parentId;
	/**
	 *discount
	 */
	private BigDecimal discount;
	/**
	 *prefer_deliverdate
	 */
	private String preferDeliverdate;
	/**
	 *enterprise_id
	 */
	private Integer enterpriseId;
	/**
	 *送货时间
	 */
	private String customDate;
	/**
	 *支付银行code
	 */
	private String orderSourceName;
	/**
	 *enterprise_discount
	 */
	private BigDecimal enterpriseDiscount;
	/**
	 *gift_card
	 */
	private BigDecimal giftCard;
	/**
	 *cps_id
	 */
	private Integer cpsId;
	/**
	 *是否显示
	 *
	 *1 默认为1，表示未处理异常
	 *2 表示处理过异常
	 */
	private Integer isShow;
	/**
	 * 父订单id
	 */
	private Integer pId;
	/**
	 *邮乐发货运单号
	 */
	private String ordernumber;
	/**
	 *供应商id
	 */
	private Integer upcSuppliersId;
	/**
	 *邮乐订单号
	 */
	private String uleOrderId;
	/**
	 *bn_order_id
	 */
	private String bnOrderId;
	/**
	 *逆向订单号
	 */
	private String backOrderId;
	/**
	 *渠道t台秀ul邮乐
	 */
	private String channel;
	/**
	 *提货方式（0：送货到家；1：马上提货）
	 */
	private Integer sendType;
	/**
	 *订单类型（0：购物；2：开店）
	 */
	private Integer orderType;
	/**
	 *团号
	 */
	private Integer groupNo;
	/**
	 *频道商城名称
	 */
	private String channelName;
	/**
	 *是否为无来源
	 */
	private Integer isNoneChannel;
	/**
	 *idcard
	 */
	private String idcard;
	/**
	 *订单备注
	 */
	private String remark;
	/**
	 *抓单批次号
	 */
	@Excel(name="订单批次",orderNum="0")
	private String batchNo;
	/**
	 *异常状态（0:无异常；1:疑难；2:退签；3:退回；4:快递单号异常；5:超时关闭）
	 */
	private Integer exceptionStatus;
	
	@Excel(name="是否异常",orderNum="15")
	private String  exceptionStatusString;
	
	/**
	 *处理状态（0:未处理；1:已处理）
	 */
	private Integer handleStatus;
	/**
	 *操作人
	 */
	private String handleUser;
	/**
	 *处理时间
	 */
	private Integer handleTime;
	private String HandleTimeFormat;
	
	/**
	 *是否已结算
	 */
	private Integer isBalance;
	
	@Excel(name="是否结算",orderNum="16")
	private String isBalanceString;
	/**
	 *异常标记时间
	 */
	private Integer exceptionTime;
	/**
	 *伊利订单状态
	 */
	private Integer ylOrderStatus;
	
	@Excel(name="伊利订单状态 ",orderNum="14")
	private String ylOrderStatusString;
	
	/**
	 *抓单时间
	 */
	@Excel(name="抓单时间",width=20,orderNum="4")
	private String getTime;
	/**
	 *退货原因（0：无；1：包裹损坏；2：地址不详；3：退积分）
	 */
	private Integer returnReason;
	
	/**
	 * 所有费用
	 */
	private double totalFee;
	
	/**
	 * 礼品编号
	 * 
	 */
	@Excel(name="礼品编号",orderNum="7")
	private String goodsSn;
		
	@Excel(name="礼品数量",orderNum="8")
	private int goodsNumber;
	
	/**
	 *签收时间
	 */
	private String signinDate;
	/**
	 * 预计到达时间
	 */
	private String preArrivalDate;
	
	
	public String getPreArrivalDate() {
		return preArrivalDate;
	}
	public void setPreArrivalDate(String preArrivalDate) {
		this.preArrivalDate = preArrivalDate;
	}
	public String getSigninDate() {
		return signinDate;
	}
	public void setSigninDate(String signinDate) {
		this.signinDate = signinDate;
	}
	public String getHandleTimeFormat() {
		return HandleTimeFormat;
	}
	public void setHandleTimeFormat(String handleTimeFormat) {
		HandleTimeFormat = handleTimeFormat;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderSn() {
	    return this.orderSn;
	}
	public void setOrderSn(String orderSn) {
	    this.orderSn=orderSn;
	}
	public Integer getUserId() {
	    return this.userId;
	}
	public void setUserId(Integer userId) {
	    this.userId=userId;
	}
	public String getUserName() {
	    return this.userName;
	}
	public void setUserName(String userName) {
	    this.userName=userName;
	}
	public Integer getOrderStatus() {
	    return this.orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
	    this.orderStatus=orderStatus;
	}
	public Integer getTkOrderStatus() {
	    return this.tkOrderStatus;
	}
	public void setTkOrderStatus(Integer tkOrderStatus) {
	    this.tkOrderStatus=tkOrderStatus;
	}
	public Integer getShippingStatus() {
	    return this.shippingStatus;
	}
	public void setShippingStatus(Integer shippingStatus) {
	    this.shippingStatus=shippingStatus;
	}
	public Integer getPayStatus() {
	    return this.payStatus;
	}
	public void setPayStatus(Integer payStatus) {
	    this.payStatus=payStatus;
	}
	public String getConsignee() {
	    return this.consignee;
	}
	public void setConsignee(String consignee) {
	    this.consignee=consignee;
	}
	public Integer getCountry() {
	    return this.country;
	}
	public void setCountry(Integer country) {
	    this.country=country;
	}
	public Integer getProvince() {
	    return this.province;
	}
	public void setProvince(Integer province) {
	    this.province=province;
	}
	public Integer getCity() {
	    return this.city;
	}
	public void setCity(Integer city) {
	    this.city=city;
	}
	public Integer getDistrict() {
	    return this.district;
	}
	public void setDistrict(Integer district) {
	    this.district=district;
	}
	public String getAddress() {
	    return this.address;
	}
	public void setAddress(String address) {
	    this.address=address;
	}
	public String getZipcode() {
	    return this.zipcode;
	}
	public void setZipcode(String zipcode) {
	    this.zipcode=zipcode;
	}
	public String getTel() {
	    return this.tel;
	}
	public void setTel(String tel) {
	    this.tel=tel;
	}
	public String getMobile() {
	    return this.mobile;
	}
	public void setMobile(String mobile) {
	    this.mobile=mobile;
	}
	public String getEmail() {
	    return this.email;
	}
	public void setEmail(String email) {
	    this.email=email;
	}
	public String getBestTime() {
	    return this.bestTime;
	}
	public void setBestTime(String bestTime) {
	    this.bestTime=bestTime;
	}
	public String getSignBuilding() {
	    return this.signBuilding;
	}
	public void setSignBuilding(String signBuilding) {
	    this.signBuilding=signBuilding;
	}
	public String getPostscript() {
	    return this.postscript;
	}
	public void setPostscript(String postscript) {
	    this.postscript=postscript;
	}
	public Integer getShippingId() {
	    return this.shippingId;
	}
	public void setShippingId(Integer shippingId) {
	    this.shippingId=shippingId;
	}
	public String getShippingName() {
	    return this.shippingName;
	}
	public void setShippingName(String shippingName) {
	    this.shippingName=shippingName;
	}
	public Integer getPayId() {
	    return this.payId;
	}
	public void setPayId(Integer payId) {
	    this.payId=payId;
	}
	public String getPayName() {
	    return this.payName;
	}
	public void setPayName(String payName) {
	    this.payName=payName;
	}
	public String getHowOos() {
	    return this.howOos;
	}
	public void setHowOos(String howOos) {
	    this.howOos=howOos;
	}
	public String getHowSurplus() {
	    return this.howSurplus;
	}
	public void setHowSurplus(String howSurplus) {
	    this.howSurplus=howSurplus;
	}
	public String getPackName() {
	    return this.packName;
	}
	public void setPackName(String packName) {
	    this.packName=packName;
	}
	public String getCardName() {
	    return this.cardName;
	}
	public void setCardName(String cardName) {
	    this.cardName=cardName;
	}
	public String getCardMessage() {
	    return this.cardMessage;
	}
	public void setCardMessage(String cardMessage) {
	    this.cardMessage=cardMessage;
	}
	public String getInvPayee() {
	    return this.invPayee;
	}
	public void setInvPayee(String invPayee) {
	    this.invPayee=invPayee;
	}
	public String getInvContent() {
	    return this.invContent;
	}
	public void setInvContent(String invContent) {
	    this.invContent=invContent;
	}
	public BigDecimal getGoodsAmount() {
	    return this.goodsAmount;
	}
	public void setGoodsAmount(BigDecimal goodsAmount) {
	    this.goodsAmount=goodsAmount;
	}
	public BigDecimal getShippingFee() {
	    return this.shippingFee;
	}
	public void setShippingFee(BigDecimal shippingFee) {
	    this.shippingFee=shippingFee;
	}
	public BigDecimal getInsureFee() {
	    return this.insureFee;
	}
	public void setInsureFee(BigDecimal insureFee) {
	    this.insureFee=insureFee;
	}
	public BigDecimal getPayFee() {
	    return this.payFee;
	}
	public void setPayFee(BigDecimal payFee) {
	    this.payFee=payFee;
	}
	public BigDecimal getPackFee() {
	    return this.packFee;
	}
	public void setPackFee(BigDecimal packFee) {
	    this.packFee=packFee;
	}
	public BigDecimal getCardFee() {
	    return this.cardFee;
	}
	public void setCardFee(BigDecimal cardFee) {
	    this.cardFee=cardFee;
	}
	public BigDecimal getMoneyPaid() {
	    return this.moneyPaid;
	}
	public void setMoneyPaid(BigDecimal moneyPaid) {
	    this.moneyPaid=moneyPaid;
	}
	public BigDecimal getSurplus() {
	    return this.surplus;
	}
	public void setSurplus(BigDecimal surplus) {
	    this.surplus=surplus;
	}
	public Integer getIntegral() {
	    return this.integral;
	}
	public void setIntegral(Integer integral) {
	    this.integral=integral;
	}
	public BigDecimal getIntegralMoney() {
	    return this.integralMoney;
	}
	public void setIntegralMoney(BigDecimal integralMoney) {
	    this.integralMoney=integralMoney;
	}
	public BigDecimal getBonus() {
	    return this.bonus;
	}
	public void setBonus(BigDecimal bonus) {
	    this.bonus=bonus;
	}
	public BigDecimal getOrderAmount() {
	    return this.orderAmount;
	}
	public void setOrderAmount(BigDecimal orderAmount) {
	    this.orderAmount=orderAmount;
	}
	public Integer getFromAd() {
	    return this.fromAd;
	}
	public void setFromAd(Integer fromAd) {
	    this.fromAd=fromAd;
	}
	public String getReferer() {
	    return this.referer;
	}
	public void setReferer(String referer) {
	    this.referer=referer;
	}
	public String getAddTime() {
	    return this.addTime;
	}
	public void setAddTime(String addTime) {
	    this.addTime=addTime;
	}
	public String getConfirmTime() {
	    return this.confirmTime;
	}
	public void setConfirmTime(String confirmTime) {
	    this.confirmTime=confirmTime;
	}
	public Integer getPayTime() {
	    return this.payTime;
	}
	public void setPayTime(Integer payTime) {
	    this.payTime=payTime;
	}
	public Integer getShippingTime() {
	    return this.shippingTime;
	}
	public void setShippingTime(Integer shippingTime) {
	    this.shippingTime=shippingTime;
	}
	public Integer getCancelTime() {
	    return this.cancelTime;
	}
	public void setCancelTime(Integer cancelTime) {
	    this.cancelTime=cancelTime;
	}
	public Integer getRefundTime() {
	    return this.refundTime;
	}
	public void setRefundTime(Integer refundTime) {
	    this.refundTime=refundTime;
	}
	public Integer getPackId() {
	    return this.packId;
	}
	public void setPackId(Integer packId) {
	    this.packId=packId;
	}
	public Integer getCardId() {
	    return this.cardId;
	}
	public void setCardId(Integer cardId) {
	    this.cardId=cardId;
	}
	public Integer getBonusId() {
	    return this.bonusId;
	}
	public void setBonusId(Integer bonusId) {
	    this.bonusId=bonusId;
	}
	public String getInvoiceNo() {
	    return this.invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
	    this.invoiceNo=invoiceNo;
	}
	public String getExtensionCode() {
	    return this.extensionCode;
	}
	public void setExtensionCode(String extensionCode) {
	    this.extensionCode=extensionCode;
	}
	public Integer getExtensionId() {
	    return this.extensionId;
	}
	public void setExtensionId(Integer extensionId) {
	    this.extensionId=extensionId;
	}
	public String getToBuyer() {
	    return this.toBuyer;
	}
	public void setToBuyer(String toBuyer) {
	    this.toBuyer=toBuyer;
	}
	public String getPayNote() {
	    return this.payNote;
	}
	public void setPayNote(String payNote) {
	    this.payNote=payNote;
	}
	public Integer getAgencyId() {
	    return this.agencyId;
	}
	public void setAgencyId(Integer agencyId) {
	    this.agencyId=agencyId;
	}
	public String getInvType() {
	    return this.invType;
	}
	public void setInvType(String invType) {
	    this.invType=invType;
	}
	public BigDecimal getTax() {
	    return this.tax;
	}
	public void setTax(BigDecimal tax) {
	    this.tax=tax;
	}
	public Integer getIsSeparate() {
	    return this.isSeparate;
	}
	public void setIsSeparate(Integer isSeparate) {
	    this.isSeparate=isSeparate;
	}
	public Integer getParentId() {
	    return this.parentId;
	}
	public void setParentId(Integer parentId) {
	    this.parentId=parentId;
	}
	public BigDecimal getDiscount() {
	    return this.discount;
	}
	public void setDiscount(BigDecimal discount) {
	    this.discount=discount;
	}
	
	public String getPreferDeliverdate() {
		return preferDeliverdate;
	}
	public void setPreferDeliverdate(String preferDeliverdate) {
		this.preferDeliverdate = preferDeliverdate;
	}
	public Integer getEnterpriseId() {
	    return this.enterpriseId;
	}
	public void setEnterpriseId(Integer enterpriseId) {
	    this.enterpriseId=enterpriseId;
	}
	
	public String getCustomDate() {
		return customDate;
	}
	public void setCustomDate(String customDate) {
		this.customDate = customDate;
	}
	
	public String getOrderSourceName() {
		return orderSourceName;
	}
	public void setOrderSourceName(String orderSourceName) {
		this.orderSourceName = orderSourceName;
	}
	public BigDecimal getEnterpriseDiscount() {
	    return this.enterpriseDiscount;
	}
	public void setEnterpriseDiscount(BigDecimal enterpriseDiscount) {
	    this.enterpriseDiscount=enterpriseDiscount;
	}
	public BigDecimal getGiftCard() {
	    return this.giftCard;
	}
	public void setGiftCard(BigDecimal giftCard) {
	    this.giftCard=giftCard;
	}
	public Integer getCpsId() {
	    return this.cpsId;
	}
	public void setCpsId(Integer cpsId) {
	    this.cpsId=cpsId;
	}
	public Integer getIsShow() {
	    return this.isShow;
	}
	public void setIsShow(Integer isShow) {
	    this.isShow=isShow;
	}
	public Integer getPId() {
	    return this.pId;
	}
	public void setPId(Integer pId) {
	    this.pId=pId;
	}
	public String getOrdernumber() {
	    return this.ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
	    this.ordernumber=ordernumber;
	}
	public Integer getUpcSuppliersId() {
	    return this.upcSuppliersId;
	}
	public void setUpcSuppliersId(Integer upcSuppliersId) {
	    this.upcSuppliersId=upcSuppliersId;
	}
	public String getUleOrderId() {
	    return this.uleOrderId;
	}
	public void setUleOrderId(String uleOrderId) {
	    this.uleOrderId=uleOrderId;
	}
	public String getBnOrderId() {
	    return this.bnOrderId;
	}
	public void setBnOrderId(String bnOrderId) {
	    this.bnOrderId=bnOrderId;
	}
	public String getBackOrderId() {
	    return this.backOrderId;
	}
	public void setBackOrderId(String backOrderId) {
	    this.backOrderId=backOrderId;
	}
	public String getChannel() {
	    return this.channel;
	}
	public void setChannel(String channel) {
	    this.channel=channel;
	}
	public Integer getSendType() {
	    return this.sendType;
	}
	public void setSendType(Integer sendType) {
	    this.sendType=sendType;
	}
	public Integer getOrderType() {
	    return this.orderType;
	}
	public void setOrderType(Integer orderType) {
	    this.orderType=orderType;
	}
	public Integer getGroupNo() {
	    return this.groupNo;
	}
	public void setGroupNo(Integer groupNo) {
	    this.groupNo=groupNo;
	}
	public String getChannelName() {
	    return this.channelName;
	}
	public void setChannelName(String channelName) {
	    this.channelName=channelName;
	}
	public Integer getIsNoneChannel() {
	    return this.isNoneChannel;
	}
	public void setIsNoneChannel(Integer isNoneChannel) {
	    this.isNoneChannel=isNoneChannel;
	}
	public String getIdcard() {
	    return this.idcard;
	}
	public void setIdcard(String idcard) {
	    this.idcard=idcard;
	}
	public String getRemark() {
	    return this.remark;
	}
	public void setRemark(String remark) {
	    this.remark=remark;
	}
	public String getBatchNo() {
	    return this.batchNo;
	}
	public void setBatchNo(String batchNo) {
	    this.batchNo=batchNo;
	}
	public Integer getExceptionStatus() {
	    return this.exceptionStatus;
	}
	public void setExceptionStatus(Integer exceptionStatus) {
	    this.exceptionStatus=exceptionStatus;
	}
	public Integer getHandleStatus() {
	    return this.handleStatus;
	}
	public void setHandleStatus(Integer handleStatus) {
	    this.handleStatus=handleStatus;
	}
	public String getHandleUser() {
	    return this.handleUser;
	}
	public void setHandleUser(String handleUser) {
	    this.handleUser=handleUser;
	}
	public Integer getHandleTime() {
	    return this.handleTime;
	}
	public void setHandleTime(Integer handleTime) {
	    this.handleTime=handleTime;
	}
	public Integer getIsBalance() {
	    return this.isBalance;
	}
	public void setIsBalance(Integer isBalance) {
	    this.isBalance=isBalance;
	}
	public Integer getExceptionTime() {
	    return this.exceptionTime;
	}
	public void setExceptionTime(Integer exceptionTime) {
	    this.exceptionTime=exceptionTime;
	}
	public Integer getYlOrderStatus() {
	    return this.ylOrderStatus;
	}
	public void setYlOrderStatus(Integer ylOrderStatus) {
	    this.ylOrderStatus=ylOrderStatus;
	}
	
	public String getGetTime() {
		return getTime;
	}
	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}
	public Integer getReturnReason() {
	    return this.returnReason;
	}
	public void setReturnReason(Integer returnReason) {
	    this.returnReason=returnReason;
	}
	public String getAddTime_begin1() {
		return addTime_begin1;
	}
	public void setAddTime_begin1(String addTime_begin1) {
		this.addTime_begin1 = addTime_begin1;
	}
	public String getAddTime_end2() {
		return addTime_end2;
	}
	public void setAddTime_end2(String addTime_end2) {
		this.addTime_end2 = addTime_end2;
	}
	public Integer getAddTimeBegin() {
		return addTimeBegin;
	}
	public void setAddTimeBegin(Integer addTimeBegin) {
		this.addTimeBegin = addTimeBegin;
	}
	public Integer getAddTimeEnd() {
		return addTimeEnd;
	}
	public void setAddTimeEnd(Integer addTimeEnd) {
		this.addTimeEnd = addTimeEnd;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public String getGoodsSn() {
		return goodsSn;
	}
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}
	public String getOldAddTime() {
		return oldAddTime;
	}
	public void setOldAddTime(String oldAddTime) {
		this.oldAddTime = oldAddTime;
	}
	public String getTkOrderStatusString() {
		return tkOrderStatusString;
	}
	public void setTkOrderStatusString(String tkOrderStatusString) {
		this.tkOrderStatusString = tkOrderStatusString;
	}
	public String getExceptionStatusString() {
		return exceptionStatusString;
	}
	public void setExceptionStatusString(String exceptionStatusString) {
		this.exceptionStatusString = exceptionStatusString;
	}
	public String getIsBalanceString() {
		return isBalanceString;
	}
	public void setIsBalanceString(String isBalanceString) {
		this.isBalanceString = isBalanceString;
	}
	public String getYlOrderStatusString() {
		return ylOrderStatusString;
	}
	public void setYlOrderStatusString(String ylOrderStatusString) {
		this.ylOrderStatusString = ylOrderStatusString;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	
	
}

