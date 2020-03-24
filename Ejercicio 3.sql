-- Ejercicio 3
-- Obtener el nombre del menu y el precio de las ordenes que fueron pagados con cash 'CASH_ON_DELIVERY'.
select distinct menu_name,price
from menu
inner join orders on orders.menu_id=menu.menu_id
left join payment on payment.order_id= orders.order_id
where payment.payment_type = 'CASH_ON_DELIVERY' ;