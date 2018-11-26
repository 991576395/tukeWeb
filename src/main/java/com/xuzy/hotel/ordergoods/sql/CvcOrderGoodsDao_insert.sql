INSERT  INTO
	cvc_order_goods
      ( 
      order_id                       
      ,goods_id                       
      ,goods_sn                       
      ,goods_number                   
      ) 
values
      (
      :cvcOrderGoods.orderId                       
      ,:cvcOrderGoods.goodsId                       
      ,:cvcOrderGoods.goodsSn                       
      ,:cvcOrderGoods.goodsNumber                   
      )