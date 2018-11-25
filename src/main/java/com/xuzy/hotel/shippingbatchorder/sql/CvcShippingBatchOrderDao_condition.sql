		
		<#if ( cvcShippingBatchOrder.batchNo )?? && cvcShippingBatchOrder.batchNo ?length gt 0>
		    /* 导入批次号 */
			and csbo.batch_no = :cvcShippingBatchOrder.batchNo
		</#if>
		<#if ( cvcShippingBatchOrder.orderId )?? && cvcShippingBatchOrder.orderId ?length gt 0>
		    /* 订单号 */
			and csbo.order_id = :cvcShippingBatchOrder.orderId
		</#if>
		<#if ( cvcShippingBatchOrder.shippingName )?? && cvcShippingBatchOrder.shippingName ?length gt 0>
		    /* 快递名称 */
			and csbo.shipping_name = :cvcShippingBatchOrder.shippingName
		</#if>
		<#if ( cvcShippingBatchOrder.invoiceNo )?? && cvcShippingBatchOrder.invoiceNo ?length gt 0>
		    /* 快递单号 */
			and csbo.invoice_no = :cvcShippingBatchOrder.invoiceNo
		</#if>
		<#if ( cvcShippingBatchOrder.preArrivalDate )?? && cvcShippingBatchOrder.preArrivalDate ?length gt 0>
		    /* 预计送到时间 */
			and csbo.pre_arrival_date = :cvcShippingBatchOrder.preArrivalDate
		</#if>
		<#if ( cvcShippingBatchOrder.addTime )?? && cvcShippingBatchOrder.addTime ?length gt 0>
		    /* 导入时间 */
			and csbo.add_time = :cvcShippingBatchOrder.addTime
		</#if>
		<#if ( cvcShippingBatchOrder.shippingTime )?? && cvcShippingBatchOrder.shippingTime ?length gt 0>
		    /* 发货时间 */
			and csbo.shipping_time = :cvcShippingBatchOrder.shippingTime
		</#if>
		<#if ( cvcShippingBatchOrder.isOffharbour )?? && cvcShippingBatchOrder.isOffharbour ?length gt 0>
		    /* 是否离港（0：未离港；1：已离港） */
			and csbo.is_offharbour = :cvcShippingBatchOrder.isOffharbour
		</#if>
		<#if ( cvcShippingBatchOrder.isPostorder )?? && cvcShippingBatchOrder.isPostorder ?length gt 0>
		    /* 是否已物流订阅（0：未订阅；1：已订阅） */
			and csbo.is_postorder = :cvcShippingBatchOrder.isPostorder
		</#if>
		<#if ( cvcShippingBatchOrder.status )?? && cvcShippingBatchOrder.status ?length gt 0>
		    /* 是否已发货（0：未发货；1：已发货） */
			and csbo.status = :cvcShippingBatchOrder.status
		</#if>
		<#if ( cvcShippingBatchOrder.isOrderBatchNoOk )?? && cvcShippingBatchOrder.isOrderBatchNoOk ?length gt 0>
		    /* 是否为本批次订单(0:否；1:是) */
			and csbo.is_order_batch_no_ok = :cvcShippingBatchOrder.isOrderBatchNoOk
		</#if>
		<#if ( cvcShippingBatchOrder.orderBatchNo )?? && cvcShippingBatchOrder.orderBatchNo ?length gt 0>
		    /* 抓单批次号 */
			and csbo.order_batch_no = :cvcShippingBatchOrder.orderBatchNo
		</#if>
