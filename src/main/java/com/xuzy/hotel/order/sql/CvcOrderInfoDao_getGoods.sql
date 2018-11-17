SELECT 
o.*, 
IF(o.product_id > 0, p.product_number, g.goods_number) AS storage, 
g.suppliers_id, 
IFNULL(b.brand_name, '') AS brand_name,
p.product_sn,
u.size_name, 
u.color_name, 
u.system_sku,
u.master_img,
u.number
            FROM cvc_order_goods AS o
                LEFT JOIN cvc_products AS p
                    ON p.product_id = o.product_id
                LEFT JOIN cvc_goods AS g
                    ON o.goods_id = g.goods_id
                LEFT JOIN cvc_brand AS b
                    ON g.brand_id = b.brand_id
                LEFT JOIN cvc_goods_upc AS u
                    ON o.upc_id = u.upc_id
            WHERE o.order_id = :orderId;