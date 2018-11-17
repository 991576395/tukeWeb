UPDATE cvc_delivery_order
SET 
	   <#if cvcDeliveryOrder.deliverySn ?exists>
		   delivery_sn = :cvcDeliveryOrder.deliverySn,
		</#if>
	   <#if cvcDeliveryOrder.orderSn ?exists>
		   order_sn = :cvcDeliveryOrder.orderSn,
		</#if>
	   <#if cvcDeliveryOrder.orderId ?exists>
		   order_id = :cvcDeliveryOrder.orderId,
		</#if>
	   <#if cvcDeliveryOrder.invoiceNo ?exists>
		   invoice_no = :cvcDeliveryOrder.invoiceNo,
		</#if>
	   <#if cvcDeliveryOrder.addTime ?exists>
		   add_time = :cvcDeliveryOrder.addTime,
		</#if>
	   <#if cvcDeliveryOrder.shippingId ?exists>
		   shipping_id = :cvcDeliveryOrder.shippingId,
		</#if>
	   <#if cvcDeliveryOrder.shippingName ?exists>
		   shipping_name = :cvcDeliveryOrder.shippingName,
		</#if>
	   <#if cvcDeliveryOrder.userId ?exists>
		   user_id = :cvcDeliveryOrder.userId,
		</#if>
	   <#if cvcDeliveryOrder.actionUser ?exists>
		   action_user = :cvcDeliveryOrder.actionUser,
		</#if>
	   <#if cvcDeliveryOrder.consignee ?exists>
		   consignee = :cvcDeliveryOrder.consignee,
		</#if>
	   <#if cvcDeliveryOrder.address ?exists>
		   address = :cvcDeliveryOrder.address,
		</#if>
	   <#if cvcDeliveryOrder.country ?exists>
		   country = :cvcDeliveryOrder.country,
		</#if>
	   <#if cvcDeliveryOrder.province ?exists>
		   province = :cvcDeliveryOrder.province,
		</#if>
	   <#if cvcDeliveryOrder.city ?exists>
		   city = :cvcDeliveryOrder.city,
		</#if>
	   <#if cvcDeliveryOrder.district ?exists>
		   district = :cvcDeliveryOrder.district,
		</#if>
	   <#if cvcDeliveryOrder.signBuilding ?exists>
		   sign_building = :cvcDeliveryOrder.signBuilding,
		</#if>
	   <#if cvcDeliveryOrder.email ?exists>
		   email = :cvcDeliveryOrder.email,
		</#if>
	   <#if cvcDeliveryOrder.zipcode ?exists>
		   zipcode = :cvcDeliveryOrder.zipcode,
		</#if>
	   <#if cvcDeliveryOrder.tel ?exists>
		   tel = :cvcDeliveryOrder.tel,
		</#if>
	   <#if cvcDeliveryOrder.mobile ?exists>
		   mobile = :cvcDeliveryOrder.mobile,
		</#if>
	   <#if cvcDeliveryOrder.bestTime ?exists>
		   best_time = :cvcDeliveryOrder.bestTime,
		</#if>
	   <#if cvcDeliveryOrder.postscript ?exists>
		   postscript = :cvcDeliveryOrder.postscript,
		</#if>
	   <#if cvcDeliveryOrder.howOos ?exists>
		   how_oos = :cvcDeliveryOrder.howOos,
		</#if>
	   <#if cvcDeliveryOrder.insureFee ?exists>
		   insure_fee = :cvcDeliveryOrder.insureFee,
		</#if>
	   <#if cvcDeliveryOrder.shippingFee ?exists>
		   shipping_fee = :cvcDeliveryOrder.shippingFee,
		</#if>
	   <#if cvcDeliveryOrder.updateTime ?exists>
		   update_time = :cvcDeliveryOrder.updateTime,
		</#if>
	   <#if cvcDeliveryOrder.suppliersId ?exists>
		   suppliers_id = :cvcDeliveryOrder.suppliersId,
		</#if>
	   <#if cvcDeliveryOrder.status ?exists>
		   status = :cvcDeliveryOrder.status,
		</#if>
	   <#if cvcDeliveryOrder.tkStatus ?exists>
		   tk_status = :cvcDeliveryOrder.tkStatus,
		</#if>
	   <#if cvcDeliveryOrder.agencyId ?exists>
		   agency_id = :cvcDeliveryOrder.agencyId,
		</#if>
	   <#if cvcDeliveryOrder.preArrivalDate ?exists>
		   pre_arrival_date = :cvcDeliveryOrder.preArrivalDate,
		</#if>
	   <#if cvcDeliveryOrder.signinDate ?exists>
		   signin_date = :cvcDeliveryOrder.signinDate,
		</#if>
WHERE id = :cvcDeliveryOrder.id