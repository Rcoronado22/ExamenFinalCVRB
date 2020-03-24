-- Ejercicio 2
-- obtener el nombre del cliente y el numero de tarjeta de las tarjetas de credito que expiran el 2022.
select distinct first_name,last_name,card_number
from customer
inner join payment_details
on customer.customer_id=payment_details.customer_id
where  payment_details.exp_year = '22';