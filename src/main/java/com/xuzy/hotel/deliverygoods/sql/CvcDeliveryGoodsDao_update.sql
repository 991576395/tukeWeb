UPDATE cvc_delivery_goods
SET 
	   <#if cvcDeliveryGoods.deliveryId ?exists>
		   delivery_id = :cvcDeliveryGoods.deliveryId,
		</#if>
	   <#if cvcDeliveryGoods.goodsId ?exists>
		   goods_id = :cvcDeliveryGoods.goodsId,
		</#if>
	   <#if cvcDeliveryGoods.productId ?exists>
		   product_id = :cvcDeliveryGoods.productId,
		</#if>
	   <#if cvcDeliveryGoods.productSn ?exists>
		   product_sn = :cvcDeliveryGoods.productSn,
		</#if>
	   <#if cvcDeliveryGoods.goodsName ?exists>
		   goods_name = :cvcDeliveryGoods.goodsName,
		</#if>
	   <#if cvcDeliveryGoods.brandName ?exists>
		   brand_name = :cvcDeliveryGoods.brandName,
		</#if>
	   <#if cvcDeliveryGoods.goodsSn ?exists>
		   goods_sn = :cvcDeliveryGoods.goodsSn,
		</#if>
	   <#if cvcDeliveryGoods.isReal ?exists>
		   is_real = :cvcDeliveryGoods.isReal,
		</#if>
	   <#if cvcDeliveryGoods.extensionCode ?exists>
		   extension_code = :cvcDeliveryGoods.extensionCode,
		</#if>
	   <#if cvcDeliveryGoods.parentId ?exists>
		   parent_id = :cvcDeliveryGoods.parentId,
		</#if>
	   <#if cvcDeliveryGoods.sendNumber ?exists>
		   send_number = :cvcDeliveryGoods.sendNumber,
		</#if>
	   <#if cvcDeliveryGoods.goodsAttr ?exists>
		   goods_attr = :cvcDeliveryGoods.goodsAttr,
		</#if>
	   <#if cvcDeliveryGoods.systemSku ?exists>
		   system_sku = :cvcDeliveryGoods.systemSku,
		</#if>
	   <#if cvcDeliveryGoods.goodsPrice ?exists>
		   goods_price = :cvcDeliveryGoods.goodsPrice,
		</#if>
	   <#if cvcDeliveryGoods.upcId ?exists>
		   upc_id = :cvcDeliveryGoods.upcId,
		</#if>
WHERE id = :cvcDeliveryGoods.id