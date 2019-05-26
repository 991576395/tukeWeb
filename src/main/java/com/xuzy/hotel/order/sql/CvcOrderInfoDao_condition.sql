		<#if ( cvcOrderInfo.id )?? && cvcOrderInfo.id ?length gt 0>
		    /* order_id */
			and coi.order_id = :cvcOrderInfo.id
		</#if>
		<#if ( cvcOrderInfo.orderSn )?? && cvcOrderInfo.orderSn ?length gt 0>
		    /* order_sn */
			and coi.order_sn = :cvcOrderInfo.orderSn
		</#if>		
		<#if (cvcOrderInfo.userName)?? && cvcOrderInfo.userName ?length gt 0>
		    /* 积分账户 */
			and coi.user_name = :cvcOrderInfo.userName
		</#if>
		
		<#if ( cvcOrderInfo.isBalance )?? && cvcOrderInfo.isBalance ?length gt 0>
		    /*结算标识 */
			and coi.is_balance = :cvcOrderInfo.isBalance
		</#if>
		<#if ( cvcOrderInfo.batchNo )?? && cvcOrderInfo.batchNo ?length gt 0>
		    /*订单批次 */
			and coi.batch_no = :cvcOrderInfo.batchNo
		</#if>
		<#if (cvcOrderInfo.exceptionStatusString )?? && cvcOrderInfo.exceptionStatusString = "1">
		    /* 是否有异常 */
			and coi.exception_status > 0 
		</#if>
		<#if (cvcOrderInfo.exceptionStatusString )?? && cvcOrderInfo.exceptionStatusString ="2">
			and coi.exception_status = 0 
		</#if>
		
		<#if (cvcOrderInfo.exceptionStatus )?? && cvcOrderInfo.exceptionStatus gt 0 >
			and coi.exception_status = :cvcOrderInfo.exceptionStatus
		</#if>
		
		<#if ( cvcOrderInfo.orderStatus )?? && cvcOrderInfo.orderStatus ?length gt 0>
		    /* order_status */
			and coi.tk_order_status = :cvcOrderInfo.orderStatus
		</#if>
		<#if ( cvcOrderInfo.ylOrderStatus )?? && cvcOrderInfo.ylOrderStatus ?length gt 0>
		    /* tk订单状态 */
			and coi.yl_order_status = :cvcOrderInfo.ylOrderStatus
		</#if>
		
		<#if ( cvcOrderInfo.invoiceNo )?? && cvcOrderInfo.invoiceNo ?length gt 0>
		    /* 快递单号 */
			and d_o.invoice_no = :cvcOrderInfo.invoiceNo
		</#if>
		<#if ( cvcOrderInfo.shippingId )?? && cvcOrderInfo.shippingId ?length gt 0>
		    /* 快递公司 */
			and d_o.shipping_id = :cvcOrderInfo.shippingId
		</#if>
		<#if ( cvcOrderInfo.returnReason )?? && cvcOrderInfo.returnReason ?length gt 0>
		    /* 退货原因 */
			and coi.return_reason = :cvcOrderInfo.returnReason
		</#if>
		
		<#if ( cvcOrderInfo.addTimeBegin )?? && cvcOrderInfo.addTimeBegin ?length gt 0>
		    /* 下单时间 */
			and coi.add_time >= :cvcOrderInfo.addTimeBegin
		</#if>
		<#if ( cvcOrderInfo.addTimeEnd )?? && cvcOrderInfo.addTimeEnd ?length gt 0>
		    /* 下单时间 */
			and coi.add_time <= :cvcOrderInfo.addTimeEnd
		</#if>
		
		<#if ( cvcOrderInfo.userId )?? && cvcOrderInfo.userId ?length gt 0>
		    /* 用户id */
			and coi.user_id = :cvcOrderInfo.userId
		</#if>
		
		<#if ( cvcOrderInfo.isShow )?? && cvcOrderInfo.isShow ?length gt 0>
		    /* 用户id */
			and coi.is_show = :cvcOrderInfo.isShow
		</#if>
		
		