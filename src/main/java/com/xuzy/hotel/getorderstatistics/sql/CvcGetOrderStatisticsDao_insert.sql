INSERT  INTO
	cvc_get_order_statistics
      ( 
      unified_batch_no               
      ,batch_no                       
      ,add_time                       
      ,order_count                    
      ) 
values
      (
      :cvcGetOrderStatistics.unifiedBatchNo                
      ,:cvcGetOrderStatistics.batchNo                       
      ,:cvcGetOrderStatistics.addTime                       
      ,:cvcGetOrderStatistics.orderCount                    
      )