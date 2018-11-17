UPDATE cvc_get_order_statistics
SET 
	   <#if cvcGetOrderStatistics.unifiedBatchNo ?exists>
		   unified_batch_no = :cvcGetOrderStatistics.unifiedBatchNo,
		</#if>
	   <#if cvcGetOrderStatistics.addTime ?exists>
		   add_time = :cvcGetOrderStatistics.addTime,
		</#if>
	   <#if cvcGetOrderStatistics.waitDeliveryCount ?exists>
		   wait_delivery_count = :cvcGetOrderStatistics.waitDeliveryCount,
		</#if>
	   <#if cvcGetOrderStatistics.deliveryCount ?exists>
		   delivery_count = :cvcGetOrderStatistics.deliveryCount,
		</#if>
	   <#if cvcGetOrderStatistics.offharbourCount ?exists>
		   offharbour_count = :cvcGetOrderStatistics.offharbourCount,
		</#if>
	   <#if cvcGetOrderStatistics.sendCount ?exists>
		   send_count = :cvcGetOrderStatistics.sendCount,
		</#if>
	   <#if cvcGetOrderStatistics.signinCount ?exists>
		   signin_count = :cvcGetOrderStatistics.signinCount,
		</#if>
	   <#if cvcGetOrderStatistics.exceptionCount ?exists>
		   exception_count = :cvcGetOrderStatistics.exceptionCount,
		</#if>
	   <#if cvcGetOrderStatistics.signinFailCount ?exists>
		   signin_fail_count = :cvcGetOrderStatistics.signinFailCount,
		</#if>
	   <#if cvcGetOrderStatistics.backCount ?exists>
		   back_count = :cvcGetOrderStatistics.backCount,
		</#if>
	   <#if cvcGetOrderStatistics.orderCount ?exists>
		   order_count = :cvcGetOrderStatistics.orderCount,
		</#if>
WHERE batch_no = :cvcGetOrderStatistics.batchNo