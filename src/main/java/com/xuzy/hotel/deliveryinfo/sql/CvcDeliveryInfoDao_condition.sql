		<#if ( cvcDeliveryInfo.number )?? && cvcDeliveryInfo.number ?length gt 0>
		    /* 快递单号 */
			and cdi.number = :cvcDeliveryInfo.number
		</#if>
		<#if ( cvcDeliveryInfo.message )?? && cvcDeliveryInfo.message ?length gt 0>
		    /* 快递信息 */
			and cdi.message = :cvcDeliveryInfo.message
		</#if>
		<#if ( cvcDeliveryInfo.data )?? && cvcDeliveryInfo.data ?length gt 0>
		    /* 快递详情 */
			and cdi.data = :cvcDeliveryInfo.data
		</#if>
		<#if ( cvcDeliveryInfo.state )?? && cvcDeliveryInfo.state ?length gt 0>
		    /* 快递状态（0：在途；1：揽件；2：疑难；3：签收；4：退签；5：派件；6：退回） */
			and cdi.state = :cvcDeliveryInfo.state
		</#if>
