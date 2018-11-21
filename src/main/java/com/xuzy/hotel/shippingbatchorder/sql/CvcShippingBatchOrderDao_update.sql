UPDATE cvc_shipping_batch_order
SET 
	   <#if cvcShippingBatchOrder.batchNo ?exists>
		   batch_no = :cvcShippingBatchOrder.batchNo,
		</#if>
	   <#if cvcShippingBatchOrder.orderId ?exists>
		   order_id = :cvcShippingBatchOrder.orderId,
		</#if>
	   <#if cvcShippingBatchOrder.shippingName ?exists>
		   shipping_name = :cvcShippingBatchOrder.shippingName,
		</#if>
	   <#if cvcShippingBatchOrder.invoiceNo ?exists>
		   invoice_no = :cvcShippingBatchOrder.invoiceNo,
		</#if>
	   <#if cvcShippingBatchOrder.preArrivalDate ?exists>
		   pre_arrival_date = :cvcShippingBatchOrder.preArrivalDate,
		</#if>
	   <#if cvcShippingBatchOrder.addTime ?exists>
		   add_time = :cvcShippingBatchOrder.addTime,
		</#if>
	   <#if cvcShippingBatchOrder.shippingTime ?exists>
		   shipping_time = :cvcShippingBatchOrder.shippingTime,
		</#if>
	   <#if cvcShippingBatchOrder.isOffharbour ?exists>
		   is_offharbour = :cvcShippingBatchOrder.isOffharbour,
		</#if>
	   <#if cvcShippingBatchOrder.isPostorder ?exists>
		   is_postorder = :cvcShippingBatchOrder.isPostorder,
		</#if>
	   <#if cvcShippingBatchOrder.status ?exists>
		   status = :cvcShippingBatchOrder.status,
		</#if>
	   <#if cvcShippingBatchOrder.isOrderBatchNoOk ?exists>
		   is_order_batch_no_ok = :cvcShippingBatchOrder.isOrderBatchNoOk,
		</#if>
	   <#if cvcShippingBatchOrder.orderBatchNo ?exists>
		   order_batch_no = :cvcShippingBatchOrder.orderBatchNo,
		</#if>
WHERE id = :cvcShippingBatchOrder.id