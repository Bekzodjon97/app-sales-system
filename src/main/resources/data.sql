create view customer_orders as select count(o.*), c.* from orders o join customer c on o.customer_id=c.id and o.date between '01-01-2016' and '31-12-2016' group by c.id;
create view count_of_orders as select  d.product_id, count(o.*) as count_of_orders_by_product from orders o join detail d on d.order_id=o.id  group by d.product_id;
create view sum_of_paymentAamount_by_invoiceId as select invoice_id, sum(amount) from payment group by invoice_id;
