UPDATE cvc_shipping
SET 
	   <#if cvcShipping.shippingCode ?exists>
		   shipping_code = :cvcShipping.shippingCode,
		</#if>
	   <#if cvcShipping.shippingName ?exists>
		   shipping_name = :cvcShipping.shippingName,
		</#if>
	   <#if cvcShipping.shippingDesc ?exists>
		   shipping_desc = :cvcShipping.shippingDesc,
		</#if>
	   <#if cvcShipping.insure ?exists>
		   insure = :cvcShipping.insure,
		</#if>
	   <#if cvcShipping.supportCod ?exists>
		   support_cod = :cvcShipping.supportCod,
		</#if>
	   <#if cvcShipping.enabled ?exists>
		   enabled = :cvcShipping.enabled,
		</#if>
	   <#if cvcShipping.shippingPrint ?exists>
		   shipping_print = :cvcShipping.shippingPrint,
		</#if>
	   <#if cvcShipping.printBg ?exists>
		   print_bg = :cvcShipping.printBg,
		</#if>
	   <#if cvcShipping.configLable ?exists>
		   config_lable = :cvcShipping.configLable,
		</#if>
	   <#if cvcShipping.printModel ?exists>
		   print_model = :cvcShipping.printModel,
		</#if>
	   <#if cvcShipping.shippingOrder ?exists>
		   shipping_order = :cvcShipping.shippingOrder,
		</#if>
	   <#if cvcShipping.suppliersId ?exists>
		   suppliers_id = :cvcShipping.suppliersId,
		</#if>
	   <#if cvcShipping.isDefault ?exists>
		   is_default = :cvcShipping.isDefault,
		</#if>
WHERE id = :cvcShipping.id