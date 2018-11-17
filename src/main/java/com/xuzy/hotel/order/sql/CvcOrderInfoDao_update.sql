UPDATE cvc_order_info
SET 
	   <#if cvcOrderInfo.orderSn ?exists>
		   order_sn = :cvcOrderInfo.orderSn,
		</#if>
	   <#if cvcOrderInfo.userId ?exists>
		   user_id = :cvcOrderInfo.userId,
		</#if>
	   <#if cvcOrderInfo.userName ?exists>
		   user_name = :cvcOrderInfo.userName,
		</#if>
	   <#if cvcOrderInfo.orderStatus ?exists>
		   order_status = :cvcOrderInfo.orderStatus,
		</#if>
	   <#if cvcOrderInfo.tkOrderStatus ?exists>
		   tk_order_status = :cvcOrderInfo.tkOrderStatus,
		</#if>
	   <#if cvcOrderInfo.shippingStatus ?exists>
		   shipping_status = :cvcOrderInfo.shippingStatus,
		</#if>
	   <#if cvcOrderInfo.payStatus ?exists>
		   pay_status = :cvcOrderInfo.payStatus,
		</#if>
	   <#if cvcOrderInfo.consignee ?exists>
		   consignee = :cvcOrderInfo.consignee,
		</#if>
	   <#if cvcOrderInfo.country ?exists>
		   country = :cvcOrderInfo.country,
		</#if>
	   <#if cvcOrderInfo.province ?exists>
		   province = :cvcOrderInfo.province,
		</#if>
	   <#if cvcOrderInfo.city ?exists>
		   city = :cvcOrderInfo.city,
		</#if>
	   <#if cvcOrderInfo.district ?exists>
		   district = :cvcOrderInfo.district,
		</#if>
	   <#if cvcOrderInfo.address ?exists>
		   address = :cvcOrderInfo.address,
		</#if>
	   <#if cvcOrderInfo.zipcode ?exists>
		   zipcode = :cvcOrderInfo.zipcode,
		</#if>
	   <#if cvcOrderInfo.tel ?exists>
		   tel = :cvcOrderInfo.tel,
		</#if>
	   <#if cvcOrderInfo.mobile ?exists>
		   mobile = :cvcOrderInfo.mobile,
		</#if>
	   <#if cvcOrderInfo.email ?exists>
		   email = :cvcOrderInfo.email,
		</#if>
	   <#if cvcOrderInfo.bestTime ?exists>
		   best_time = :cvcOrderInfo.bestTime,
		</#if>
	   <#if cvcOrderInfo.signBuilding ?exists>
		   sign_building = :cvcOrderInfo.signBuilding,
		</#if>
	   <#if cvcOrderInfo.postscript ?exists>
		   postscript = :cvcOrderInfo.postscript,
		</#if>
	   <#if cvcOrderInfo.shippingId ?exists>
		   shipping_id = :cvcOrderInfo.shippingId,
		</#if>
	   <#if cvcOrderInfo.shippingName ?exists>
		   shipping_name = :cvcOrderInfo.shippingName,
		</#if>
	   <#if cvcOrderInfo.payId ?exists>
		   pay_id = :cvcOrderInfo.payId,
		</#if>
	   <#if cvcOrderInfo.payName ?exists>
		   pay_name = :cvcOrderInfo.payName,
		</#if>
	   <#if cvcOrderInfo.howOos ?exists>
		   how_oos = :cvcOrderInfo.howOos,
		</#if>
	   <#if cvcOrderInfo.howSurplus ?exists>
		   how_surplus = :cvcOrderInfo.howSurplus,
		</#if>
	   <#if cvcOrderInfo.packName ?exists>
		   pack_name = :cvcOrderInfo.packName,
		</#if>
	   <#if cvcOrderInfo.cardName ?exists>
		   card_name = :cvcOrderInfo.cardName,
		</#if>
	   <#if cvcOrderInfo.cardMessage ?exists>
		   card_message = :cvcOrderInfo.cardMessage,
		</#if>
	   <#if cvcOrderInfo.invPayee ?exists>
		   inv_payee = :cvcOrderInfo.invPayee,
		</#if>
	   <#if cvcOrderInfo.invContent ?exists>
		   inv_content = :cvcOrderInfo.invContent,
		</#if>
	   <#if cvcOrderInfo.goodsAmount ?exists>
		   goods_amount = :cvcOrderInfo.goodsAmount,
		</#if>
	   <#if cvcOrderInfo.shippingFee ?exists>
		   shipping_fee = :cvcOrderInfo.shippingFee,
		</#if>
	   <#if cvcOrderInfo.insureFee ?exists>
		   insure_fee = :cvcOrderInfo.insureFee,
		</#if>
	   <#if cvcOrderInfo.payFee ?exists>
		   pay_fee = :cvcOrderInfo.payFee,
		</#if>
	   <#if cvcOrderInfo.packFee ?exists>
		   pack_fee = :cvcOrderInfo.packFee,
		</#if>
	   <#if cvcOrderInfo.cardFee ?exists>
		   card_fee = :cvcOrderInfo.cardFee,
		</#if>
	   <#if cvcOrderInfo.moneyPaid ?exists>
		   money_paid = :cvcOrderInfo.moneyPaid,
		</#if>
	   <#if cvcOrderInfo.surplus ?exists>
		   surplus = :cvcOrderInfo.surplus,
		</#if>
	   <#if cvcOrderInfo.integral ?exists>
		   integral = :cvcOrderInfo.integral,
		</#if>
	   <#if cvcOrderInfo.integralMoney ?exists>
		   integral_money = :cvcOrderInfo.integralMoney,
		</#if>
	   <#if cvcOrderInfo.bonus ?exists>
		   bonus = :cvcOrderInfo.bonus,
		</#if>
	   <#if cvcOrderInfo.orderAmount ?exists>
		   order_amount = :cvcOrderInfo.orderAmount,
		</#if>
	   <#if cvcOrderInfo.fromAd ?exists>
		   from_ad = :cvcOrderInfo.fromAd,
		</#if>
	   <#if cvcOrderInfo.referer ?exists>
		   referer = :cvcOrderInfo.referer,
		</#if>
	   <#if cvcOrderInfo.addTime ?exists>
		   add_time = :cvcOrderInfo.addTime,
		</#if>
	   <#if cvcOrderInfo.confirmTime ?exists>
		   confirm_time = :cvcOrderInfo.confirmTime,
		</#if>
	   <#if cvcOrderInfo.payTime ?exists>
		   pay_time = :cvcOrderInfo.payTime,
		</#if>
	   <#if cvcOrderInfo.shippingTime ?exists>
		   shipping_time = :cvcOrderInfo.shippingTime,
		</#if>
	   <#if cvcOrderInfo.cancelTime ?exists>
		   cancel_time = :cvcOrderInfo.cancelTime,
		</#if>
	   <#if cvcOrderInfo.refundTime ?exists>
		   refund_time = :cvcOrderInfo.refundTime,
		</#if>
	   <#if cvcOrderInfo.packId ?exists>
		   pack_id = :cvcOrderInfo.packId,
		</#if>
	   <#if cvcOrderInfo.cardId ?exists>
		   card_id = :cvcOrderInfo.cardId,
		</#if>
	   <#if cvcOrderInfo.bonusId ?exists>
		   bonus_id = :cvcOrderInfo.bonusId,
		</#if>
	   <#if cvcOrderInfo.invoiceNo ?exists>
		   invoice_no = :cvcOrderInfo.invoiceNo,
		</#if>
	   <#if cvcOrderInfo.extensionCode ?exists>
		   extension_code = :cvcOrderInfo.extensionCode,
		</#if>
	   <#if cvcOrderInfo.extensionId ?exists>
		   extension_id = :cvcOrderInfo.extensionId,
		</#if>
	   <#if cvcOrderInfo.toBuyer ?exists>
		   to_buyer = :cvcOrderInfo.toBuyer,
		</#if>
	   <#if cvcOrderInfo.payNote ?exists>
		   pay_note = :cvcOrderInfo.payNote,
		</#if>
	   <#if cvcOrderInfo.agencyId ?exists>
		   agency_id = :cvcOrderInfo.agencyId,
		</#if>
	   <#if cvcOrderInfo.invType ?exists>
		   inv_type = :cvcOrderInfo.invType,
		</#if>
	   <#if cvcOrderInfo.tax ?exists>
		   tax = :cvcOrderInfo.tax,
		</#if>
	   <#if cvcOrderInfo.isSeparate ?exists>
		   is_separate = :cvcOrderInfo.isSeparate,
		</#if>
	   <#if cvcOrderInfo.parentId ?exists>
		   parent_id = :cvcOrderInfo.parentId,
		</#if>
	   <#if cvcOrderInfo.discount ?exists>
		   discount = :cvcOrderInfo.discount,
		</#if>
	    <#if cvcOrderInfo.preferDeliverdate ?exists>
		   prefer_deliverdate = :cvcOrderInfo.preferDeliverdate,
		</#if>
	   <#if cvcOrderInfo.enterpriseId ?exists>
		   enterprise_id = :cvcOrderInfo.enterpriseId,
		</#if>
	    <#if cvcOrderInfo.customDate ?exists>
		   custom_date = :cvcOrderInfo.customDate,
		</#if>
	   <#if cvcOrderInfo.bank ?exists>
		   bank = :cvcOrderInfo.bank,
		</#if>
	   <#if cvcOrderInfo.enterpriseDiscount ?exists>
		   enterprise_discount = :cvcOrderInfo.enterpriseDiscount,
		</#if>
	   <#if cvcOrderInfo.giftCard ?exists>
		   gift_card = :cvcOrderInfo.giftCard,
		</#if>
	   <#if cvcOrderInfo.cpsId ?exists>
		   cps_id = :cvcOrderInfo.cpsId,
		</#if>
	   <#if cvcOrderInfo.isShow ?exists>
		   is_show = :cvcOrderInfo.isShow,
		</#if>
	   <#if cvcOrderInfo.pId ?exists>
		   p_id = :cvcOrderInfo.pId,
		</#if>
	   <#if cvcOrderInfo.ordernumber ?exists>
		   orderNumber = :cvcOrderInfo.ordernumber,
		</#if>
	   <#if cvcOrderInfo.upcSuppliersId ?exists>
		   upc_suppliers_id = :cvcOrderInfo.upcSuppliersId,
		</#if>
	   <#if cvcOrderInfo.uleOrderId ?exists>
		   ule_order_id = :cvcOrderInfo.uleOrderId,
		</#if>
	   <#if cvcOrderInfo.bnOrderId ?exists>
		   bn_order_id = :cvcOrderInfo.bnOrderId,
		</#if>
	   <#if cvcOrderInfo.backOrderId ?exists>
		   back_order_id = :cvcOrderInfo.backOrderId,
		</#if>
	   <#if cvcOrderInfo.channel ?exists>
		   channel = :cvcOrderInfo.channel,
		</#if>
	   <#if cvcOrderInfo.sendType ?exists>
		   send_type = :cvcOrderInfo.sendType,
		</#if>
	   <#if cvcOrderInfo.orderType ?exists>
		   order_type = :cvcOrderInfo.orderType,
		</#if>
	   <#if cvcOrderInfo.groupNo ?exists>
		   group_no = :cvcOrderInfo.groupNo,
		</#if>
	   <#if cvcOrderInfo.channelName ?exists>
		   channel_name = :cvcOrderInfo.channelName,
		</#if>
	   <#if cvcOrderInfo.isNoneChannel ?exists>
		   is_none_channel = :cvcOrderInfo.isNoneChannel,
		</#if>
	   <#if cvcOrderInfo.idcard ?exists>
		   idcard = :cvcOrderInfo.idcard,
		</#if>
WHERE id = :cvcOrderInfo.id