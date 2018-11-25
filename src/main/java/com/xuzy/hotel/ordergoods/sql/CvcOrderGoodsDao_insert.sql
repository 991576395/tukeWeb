INSERT  INTO
	cvc_order_goods
      ( 
      rec_id                        
      ,order_id                       
      ,goods_id                       
      ,goods_name                     
      ,goods_sn                       
      ,product_id                     
      ,goods_number                   
      ,market_price                   
      ,goods_price                    
      ,goods_attr                     
      ,send_number                    
      ,is_real                        
      ,extension_code                 
      ,parent_id                      
      ,is_gift                        
      ,goods_attr_id                  
      ,upc_id                         
      ,superior_id                    
      ,commission                     
      ,superior_some                  
      ,seller_id                      
      ,system_sku                     
      ,fav_goods_name                 
      ,project                        
      ,group_no                       
      ,center_id                      
      ) 
values
      (
      :cvcOrderGoods.recId                         
      ,:cvcOrderGoods.orderId                       
      ,:cvcOrderGoods.goodsId                       
      ,:cvcOrderGoods.goodsName                     
      ,:cvcOrderGoods.goodsSn                       
      ,:cvcOrderGoods.productId                     
      ,:cvcOrderGoods.goodsNumber                   
      ,:cvcOrderGoods.marketPrice                   
      ,:cvcOrderGoods.goodsPrice                    
      ,:cvcOrderGoods.goodsAttr                     
      ,:cvcOrderGoods.sendNumber                    
      ,:cvcOrderGoods.isReal                        
      ,:cvcOrderGoods.extensionCode                 
      ,:cvcOrderGoods.parentId                      
      ,:cvcOrderGoods.isGift                        
      ,:cvcOrderGoods.goodsAttrId                   
      ,:cvcOrderGoods.upcId                         
      ,:cvcOrderGoods.superiorId                    
      ,:cvcOrderGoods.commission                    
      ,:cvcOrderGoods.superiorSome                  
      ,:cvcOrderGoods.sellerId                      
      ,:cvcOrderGoods.systemSku                     
      ,:cvcOrderGoods.favGoodsName                  
      ,:cvcOrderGoods.project                       
      ,:cvcOrderGoods.groupNo                       
      ,:cvcOrderGoods.centerId                      
      )