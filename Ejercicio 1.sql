-- Ejercicio 1
-- Obtener las ordenes de los clientes que tengan el numero 12 en su correo
select order_id
from customer
inner join orders
on customer.customer_id=orders.customer_id
where  customer.email_id like '%12%';