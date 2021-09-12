create view orders_count as select count(o.id), d.product_id from orders o join detail d on d.order_id=o.id group by d.product_id;
create view customer_orders as select count(o.*), c.* from orders o join customer c on o.customer_id=c.id and o.date between '01-01-2016' and '31-12-2016' group by c.id;