		<#if ( cvcGetOrderStatistics.unifiedBatchNo )?? && cvcGetOrderStatistics.unifiedBatchNo ?length gt 0>
		    /* 抓单统一批次号 */
			and cgos.unified_batch_no = :cvcGetOrderStatistics.unifiedBatchNo
		</#if>
		<#if ( cvcGetOrderStatistics.batchNo )?? && cvcGetOrderStatistics.batchNo ?length gt 0>
		    /* 抓单批次号 */
			and cgos.batch_no = :cvcGetOrderStatistics.batchNo
		</#if>
		<#if ( cvcGetOrderStatistics.addTime )?? && cvcGetOrderStatistics.addTime ?length gt 0>
		    /* 抓单时间 */
			and cgos.add_time = :cvcGetOrderStatistics.addTime
		</#if>
		<#if ( cvcGetOrderStatistics.waitDeliveryCount )?? && cvcGetOrderStatistics.waitDeliveryCount ?length gt 0>
		    /* 订单数量 */
			and cgos.wait_delivery_count = :cvcGetOrderStatistics.waitDeliveryCount
		</#if>
		<#if ( cvcGetOrderStatistics.deliveryCount )?? && cvcGetOrderStatistics.deliveryCount ?length gt 0>
		    /* 订单数量 */
			and cgos.delivery_count = :cvcGetOrderStatistics.deliveryCount
		</#if>
		<#if ( cvcGetOrderStatistics.offharbourCount )?? && cvcGetOrderStatistics.offharbourCount ?length gt 0>
		    /* 订单数量 */
			and cgos.offharbour_count = :cvcGetOrderStatistics.offharbourCount
		</#if>
		<#if ( cvcGetOrderStatistics.sendCount )?? && cvcGetOrderStatistics.sendCount ?length gt 0>
		    /* 订单数量 */
			and cgos.send_count = :cvcGetOrderStatistics.sendCount
		</#if>
		<#if ( cvcGetOrderStatistics.signinCount )?? && cvcGetOrderStatistics.signinCount ?length gt 0>
		    /* 订单数量 */
			and cgos.signin_count = :cvcGetOrderStatistics.signinCount
		</#if>
		<#if ( cvcGetOrderStatistics.exceptionCount )?? && cvcGetOrderStatistics.exceptionCount ?length gt 0>
		    /* 订单数量 */
			and cgos.exception_count = :cvcGetOrderStatistics.exceptionCount
		</#if>
		<#if ( cvcGetOrderStatistics.signinFailCount )?? && cvcGetOrderStatistics.signinFailCount ?length gt 0>
		    /* 订单数量 */
			and cgos.signin_fail_count = :cvcGetOrderStatistics.signinFailCount
		</#if>
		<#if ( cvcGetOrderStatistics.backCount )?? && cvcGetOrderStatistics.backCount ?length gt 0>
		    /* 订单数量 */
			and cgos.back_count = :cvcGetOrderStatistics.backCount
		</#if>
		<#if ( cvcGetOrderStatistics.orderCount )?? && cvcGetOrderStatistics.orderCount ?length gt 0>
		    /* 订单数量 */
			and cgos.order_count = :cvcGetOrderStatistics.orderCount
		</#if>
