UPDATE cvc_shipping_batch
SET 
	   <#if cvcShippingBatch.batchNo ?exists>
		   batch_no = :cvcShippingBatch.batchNo,
		</#if>
	   <#if cvcShippingBatch.shippingCount ?exists>
		   shipping_count = :cvcShippingBatch.shippingCount,
		</#if>
	   <#if cvcShippingBatch.shippingCountOk ?exists>
		   shipping_count_ok = :cvcShippingBatch.shippingCountOk,
		</#if>
	   <#if cvcShippingBatch.addTime ?exists>
		   add_time = :cvcShippingBatch.addTime,
		</#if>
	   <#if cvcShippingBatch.orderBatchNo ?exists>
		   order_batch_no = :cvcShippingBatch.orderBatchNo,
		</#if>
	   <#if cvcShippingBatch.msgStatus ?exists>
		   msg_status = :cvcShippingBatch.msgStatus,
		</#if>
WHERE id = :cvcShippingBatch.id