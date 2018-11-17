		<#if ( cvcOrderAction.orderId )?? && cvcOrderAction.orderId ?length gt 0>
		    /* order_id */
			and coa.order_id = :cvcOrderAction.orderId
		</#if>
		<#if ( cvcOrderAction.actionUser )?? && cvcOrderAction.actionUser ?length gt 0>
		    /* action_user */
			and coa.action_user = :cvcOrderAction.actionUser
		</#if>
		<#if ( cvcOrderAction.orderStatus )?? && cvcOrderAction.orderStatus ?length gt 0>
		    /* order_status */
			and coa.order_status = :cvcOrderAction.orderStatus
		</#if>
		<#if ( cvcOrderAction.shippingStatus )?? && cvcOrderAction.shippingStatus ?length gt 0>
		    /* shipping_status */
			and coa.shipping_status = :cvcOrderAction.shippingStatus
		</#if>
		<#if ( cvcOrderAction.payStatus )?? && cvcOrderAction.payStatus ?length gt 0>
		    /* pay_status */
			and coa.pay_status = :cvcOrderAction.payStatus
		</#if>
		<#if ( cvcOrderAction.actionPlace )?? && cvcOrderAction.actionPlace ?length gt 0>
		    /* action_place */
			and coa.action_place = :cvcOrderAction.actionPlace
		</#if>
		<#if ( cvcOrderAction.actionNote )?? && cvcOrderAction.actionNote ?length gt 0>
		    /* action_note */
			and coa.action_note = :cvcOrderAction.actionNote
		</#if>
		<#if ( cvcOrderAction.logTime )?? && cvcOrderAction.logTime ?length gt 0>
		    /* log_time */
			and coa.log_time = :cvcOrderAction.logTime
		</#if>
