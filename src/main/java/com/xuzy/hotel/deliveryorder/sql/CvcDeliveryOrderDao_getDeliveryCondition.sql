SELECT 
d.delivery_sn, 
d.order_id, 
d.invoice_no, 
d.shipping_name, 
g.*, 
u.color_name,
u.size_name, 
d.pre_arrival_date,
d.signin_date  
              FROM 
                    cvc_delivery_order AS d 
                LEFT JOIN 
                    cvc_delivery_goods AS g 
                ON 
                    d.delivery_id = g.delivery_id 
                LEFT JOIN
                    cvc_goods_upc AS u 
                ON
                    g.upc_id = u.upc_id 
                WHERE 
                    d.order_id = :orderId order by d.update_time desc limit 1;