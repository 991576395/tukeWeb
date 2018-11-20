UPDATE cvc_yl_delivery_info
SET 
	   <#if cvcYlDeliveryInfo.orderId ?exists>
		   order_id = :cvcYlDeliveryInfo.orderId,
		</#if>
	   <#if cvcYlDeliveryInfo.number ?exists>
		   number = :cvcYlDeliveryInfo.number,
		</#if>
	   <#if cvcYlDeliveryInfo.context ?exists>
		   context = :cvcYlDeliveryInfo.context,
		</#if>
	   <#if cvcYlDeliveryInfo.ftime ?exists>
		   ftime = :cvcYlDeliveryInfo.ftime,
		</#if>
WHERE id = :cvcYlDeliveryInfo.id