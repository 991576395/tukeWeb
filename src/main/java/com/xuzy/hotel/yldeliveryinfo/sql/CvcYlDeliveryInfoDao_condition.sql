		<#if ( cvcYlDeliveryInfo.orderId )?? && cvcYlDeliveryInfo.orderId ?length gt 0>
		    /* 订单号 */
			and cydi.order_id = :cvcYlDeliveryInfo.orderId
		</#if>
		<#if ( cvcYlDeliveryInfo.number )?? && cvcYlDeliveryInfo.number ?length gt 0>
		    /* 快递单号 */
			and cydi.number = :cvcYlDeliveryInfo.number
		</#if>
		<#if ( cvcYlDeliveryInfo.context )?? && cvcYlDeliveryInfo.context ?length gt 0>
		    /* 物流信息描述 */
			and cydi.context = :cvcYlDeliveryInfo.context
		</#if>
		<#if ( cvcYlDeliveryInfo.ftime )?? && cvcYlDeliveryInfo.ftime ?length gt 0>
		    /* 处理时间 */
			and cydi.ftime = :cvcYlDeliveryInfo.ftime
		</#if>
