UPDATE cvc_delivery_info
SET 
	   <#if cvcDeliveryInfo.number ?exists>
		   number = :cvcDeliveryInfo.number,
		</#if>
	   <#if cvcDeliveryInfo.message ?exists>
		   message = :cvcDeliveryInfo.message,
		</#if>
	   <#if cvcDeliveryInfo.data ?exists>
		   data = :cvcDeliveryInfo.data,
		</#if>
	   <#if cvcDeliveryInfo.state ?exists>
		   state = :cvcDeliveryInfo.state,
		</#if>
WHERE id = :cvcDeliveryInfo.id