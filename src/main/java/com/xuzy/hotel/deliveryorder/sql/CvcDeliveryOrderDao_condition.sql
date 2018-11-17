		<#if ( cvcDeliveryOrder.deliverySn )?? && cvcDeliveryOrder.deliverySn ?length gt 0>
		    /* delivery_sn */
			and cdo.delivery_sn = :cvcDeliveryOrder.deliverySn
		</#if>
		<#if ( cvcDeliveryOrder.orderSn )?? && cvcDeliveryOrder.orderSn ?length gt 0>
		    /* order_sn */
			and cdo.order_sn = :cvcDeliveryOrder.orderSn
		</#if>
		<#if ( cvcDeliveryOrder.orderId )?? && cvcDeliveryOrder.orderId ?length gt 0>
		    /* order_id */
			and cdo.order_id = :cvcDeliveryOrder.orderId
		</#if>
		<#if ( cvcDeliveryOrder.invoiceNo )?? && cvcDeliveryOrder.invoiceNo ?length gt 0>
		    /* invoice_no */
			and cdo.invoice_no = :cvcDeliveryOrder.invoiceNo
		</#if>
		<#if ( cvcDeliveryOrder.addTime )?? && cvcDeliveryOrder.addTime ?length gt 0>
		    /* add_time */
			and cdo.add_time = :cvcDeliveryOrder.addTime
		</#if>
		<#if ( cvcDeliveryOrder.shippingId )?? && cvcDeliveryOrder.shippingId ?length gt 0>
		    /* shipping_id */
			and cdo.shipping_id = :cvcDeliveryOrder.shippingId
		</#if>
		<#if ( cvcDeliveryOrder.shippingName )?? && cvcDeliveryOrder.shippingName ?length gt 0>
		    /* shipping_name */
			and cdo.shipping_name = :cvcDeliveryOrder.shippingName
		</#if>
		<#if ( cvcDeliveryOrder.userId )?? && cvcDeliveryOrder.userId ?length gt 0>
		    /* user_id */
			and cdo.user_id = :cvcDeliveryOrder.userId
		</#if>
		<#if ( cvcDeliveryOrder.actionUser )?? && cvcDeliveryOrder.actionUser ?length gt 0>
		    /* action_user */
			and cdo.action_user = :cvcDeliveryOrder.actionUser
		</#if>
		<#if ( cvcDeliveryOrder.consignee )?? && cvcDeliveryOrder.consignee ?length gt 0>
		    /* consignee */
			and cdo.consignee = :cvcDeliveryOrder.consignee
		</#if>
		<#if ( cvcDeliveryOrder.address )?? && cvcDeliveryOrder.address ?length gt 0>
		    /* address */
			and cdo.address = :cvcDeliveryOrder.address
		</#if>
		<#if ( cvcDeliveryOrder.country )?? && cvcDeliveryOrder.country ?length gt 0>
		    /* country */
			and cdo.country = :cvcDeliveryOrder.country
		</#if>
		<#if ( cvcDeliveryOrder.province )?? && cvcDeliveryOrder.province ?length gt 0>
		    /* province */
			and cdo.province = :cvcDeliveryOrder.province
		</#if>
		<#if ( cvcDeliveryOrder.city )?? && cvcDeliveryOrder.city ?length gt 0>
		    /* city */
			and cdo.city = :cvcDeliveryOrder.city
		</#if>
		<#if ( cvcDeliveryOrder.district )?? && cvcDeliveryOrder.district ?length gt 0>
		    /* district */
			and cdo.district = :cvcDeliveryOrder.district
		</#if>
		<#if ( cvcDeliveryOrder.signBuilding )?? && cvcDeliveryOrder.signBuilding ?length gt 0>
		    /* sign_building */
			and cdo.sign_building = :cvcDeliveryOrder.signBuilding
		</#if>
		<#if ( cvcDeliveryOrder.email )?? && cvcDeliveryOrder.email ?length gt 0>
		    /* email */
			and cdo.email = :cvcDeliveryOrder.email
		</#if>
		<#if ( cvcDeliveryOrder.zipcode )?? && cvcDeliveryOrder.zipcode ?length gt 0>
		    /* zipcode */
			and cdo.zipcode = :cvcDeliveryOrder.zipcode
		</#if>
		<#if ( cvcDeliveryOrder.tel )?? && cvcDeliveryOrder.tel ?length gt 0>
		    /* tel */
			and cdo.tel = :cvcDeliveryOrder.tel
		</#if>
		<#if ( cvcDeliveryOrder.mobile )?? && cvcDeliveryOrder.mobile ?length gt 0>
		    /* mobile */
			and cdo.mobile = :cvcDeliveryOrder.mobile
		</#if>
		<#if ( cvcDeliveryOrder.bestTime )?? && cvcDeliveryOrder.bestTime ?length gt 0>
		    /* best_time */
			and cdo.best_time = :cvcDeliveryOrder.bestTime
		</#if>
		<#if ( cvcDeliveryOrder.postscript )?? && cvcDeliveryOrder.postscript ?length gt 0>
		    /* postscript */
			and cdo.postscript = :cvcDeliveryOrder.postscript
		</#if>
		<#if ( cvcDeliveryOrder.howOos )?? && cvcDeliveryOrder.howOos ?length gt 0>
		    /* how_oos */
			and cdo.how_oos = :cvcDeliveryOrder.howOos
		</#if>
		<#if ( cvcDeliveryOrder.insureFee )?? && cvcDeliveryOrder.insureFee ?length gt 0>
		    /* insure_fee */
			and cdo.insure_fee = :cvcDeliveryOrder.insureFee
		</#if>
		<#if ( cvcDeliveryOrder.shippingFee )?? && cvcDeliveryOrder.shippingFee ?length gt 0>
		    /* shipping_fee */
			and cdo.shipping_fee = :cvcDeliveryOrder.shippingFee
		</#if>
		<#if ( cvcDeliveryOrder.updateTime )?? && cvcDeliveryOrder.updateTime ?length gt 0>
		    /* update_time */
			and cdo.update_time = :cvcDeliveryOrder.updateTime
		</#if>
		<#if ( cvcDeliveryOrder.suppliersId )?? && cvcDeliveryOrder.suppliersId ?length gt 0>
		    /* suppliers_id */
			and cdo.suppliers_id = :cvcDeliveryOrder.suppliersId
		</#if>
		<#if ( cvcDeliveryOrder.status )?? && cvcDeliveryOrder.status ?length gt 0>
		    /* status */
			and cdo.status = :cvcDeliveryOrder.status
		</#if>
		<#if ( cvcDeliveryOrder.tkStatus )?? && cvcDeliveryOrder.tkStatus ?length gt 0>
		    /* tk物流状态 */
			and cdo.tk_status = :cvcDeliveryOrder.tkStatus
		</#if>
		<#if ( cvcDeliveryOrder.agencyId )?? && cvcDeliveryOrder.agencyId ?length gt 0>
		    /* agency_id */
			and cdo.agency_id = :cvcDeliveryOrder.agencyId
		</#if>
		<#if ( cvcDeliveryOrder.preArrivalDate )?? && cvcDeliveryOrder.preArrivalDate ?length gt 0>
		    /* 预计送到时间 */
			and cdo.pre_arrival_date = :cvcDeliveryOrder.preArrivalDate
		</#if>
		<#if ( cvcDeliveryOrder.signinDate )?? && cvcDeliveryOrder.signinDate ?length gt 0>
		    /* 签收时间 */
			and cdo.signin_date = :cvcDeliveryOrder.signinDate
		</#if>
