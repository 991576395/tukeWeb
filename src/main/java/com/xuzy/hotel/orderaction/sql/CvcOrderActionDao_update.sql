UPDATE cvc_order_action
SET 
	   <#if cvcOrderAction.orderId ?exists>
		   order_id = :cvcOrderAction.orderId,
		</#if>
	   <#if cvcOrderAction.actionUser ?exists>
		   action_user = :cvcOrderAction.actionUser,
		</#if>
	   <#if cvcOrderAction.orderStatus ?exists>
		   order_status = :cvcOrderAction.orderStatus,
		</#if>
	   <#if cvcOrderAction.shippingStatus ?exists>
		   shipping_status = :cvcOrderAction.shippingStatus,
		</#if>
	   <#if cvcOrderAction.payStatus ?exists>
		   pay_status = :cvcOrderAction.payStatus,
		</#if>
	   <#if cvcOrderAction.actionPlace ?exists>
		   action_place = :cvcOrderAction.actionPlace,
		</#if>
	   <#if cvcOrderAction.actionNote ?exists>
		   action_note = :cvcOrderAction.actionNote,
		</#if>
	   <#if cvcOrderAction.logTime ?exists>
		   log_time = :cvcOrderAction.logTime,
		</#if>
WHERE id = :cvcOrderAction.id