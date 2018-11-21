INSERT  INTO
	cvc_shipping_batch_order
      ( 
      id                            
      ,batch_no                       
      ,order_id                       
      ,shipping_name                  
      ,invoice_no                     
      ,pre_arrival_date               
      ,add_time                       
      ,shipping_time                  
      ,is_offharbour                  
      ,is_postorder                   
      ,status                         
      ,is_order_batch_no_ok           
      ,order_batch_no                 
      ) 
values
      (
      :cvcShippingBatchOrder.id                            
      ,:cvcShippingBatchOrder.batchNo                       
      ,:cvcShippingBatchOrder.orderId                       
      ,:cvcShippingBatchOrder.shippingName                  
      ,:cvcShippingBatchOrder.invoiceNo                     
      ,:cvcShippingBatchOrder.preArrivalDate                
      ,:cvcShippingBatchOrder.addTime                       
      ,:cvcShippingBatchOrder.shippingTime                  
      ,:cvcShippingBatchOrder.isOffharbour                  
      ,:cvcShippingBatchOrder.isPostorder                   
      ,:cvcShippingBatchOrder.status                        
      ,:cvcShippingBatchOrder.isOrderBatchNoOk              
      ,:cvcShippingBatchOrder.orderBatchNo                  
      )