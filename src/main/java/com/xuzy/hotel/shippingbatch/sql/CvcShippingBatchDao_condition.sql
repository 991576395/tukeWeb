		<#if ( cvcShippingBatch.batchNo )?? && cvcShippingBatch.batchNo ?length gt 0>
		    /* 上传批次号 */
			and csb.batch_no = :cvcShippingBatch.batchNo
		</#if>
		<#if ( cvcShippingBatch.shippingCount )?? && cvcShippingBatch.shippingCount ?length gt 0>
		    /* 发货总量 */
			and csb.shipping_count = :cvcShippingBatch.shippingCount
		</#if>
		<#if ( cvcShippingBatch.shippingCountOk )?? && cvcShippingBatch.shippingCountOk ?length gt 0>
		    /* 发货成功数 */
			and csb.shipping_count_ok = :cvcShippingBatch.shippingCountOk
		</#if>
		<#if ( cvcShippingBatch.addTime )?? && cvcShippingBatch.addTime ?length gt 0>
		    /* 上传时间 */
			and csb.add_time = :cvcShippingBatch.addTime
		</#if>
		<#if ( cvcShippingBatch.orderBatchNo )?? && cvcShippingBatch.orderBatchNo ?length gt 0>
		    /* 订单批次号（抓单批次号） */
			and csb.order_batch_no = :cvcShippingBatch.orderBatchNo
		</#if>
		<#if ( cvcShippingBatch.msgStatus )?? && cvcShippingBatch.msgStatus ?length gt 0>
		    /* 是否存在非本订单批次号的订单（0:否；1:是） */
			and csb.msg_status = :cvcShippingBatch.msgStatus
		</#if>
