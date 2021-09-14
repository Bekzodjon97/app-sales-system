package bek.dev.appsalessystem.repository;

import bek.dev.appsalessystem.entity.Order;
import bek.dev.appsalessystem.payload.interfaces.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    //get total number of orders placed in 2016 by customers of each country
    @Query(value = "select count(*), c.country from orders o join customer c on c.id=o.customer_id and o.date between '01-01-2016' and '31-12-2016' group by country", nativeQuery = true)
    List<NumberOfProductsInYear> getNumberOfProductsInYear();



    //get products that are usually ordered in bulk
    @Query(value = "select co.product_id as productId, p.price from orders_count co join product p on p.id=co.product_id and co.count>7", nativeQuery = true)
    List<BulkProducts> getBulkProducts();


    //get products that were ordered more than 10 times in total
    @Query(value = "select product_id as productId, count_of_orders_by_product as countOfOrdersByProduct from count_of_orders where (count_of_orders_by_product )>10", nativeQuery = true)
    List<HighDemandProducts> getHighDemandProducts();

    //get orders that do not have a detail and were placed before 6 september 2016
    @Query(value = "select * from orders  where id not in(select order_id from detail) and date<'06-09-2016'",nativeQuery = true)
    List<Order> getOrdersWithoutDetails();


    //get id and name of customers and the date of their last order
    @Query(value = "select c.id, c.name, max(o.date) as dateOfLastOrder from customer c join orders o on o.customer_id=c.id group by c.id, c.name",nativeQuery = true)
    List<CustomersLastOrders> getCustomersLastOrders();

    // for each order without invoice, get list its ID, the date it was placed and the total price of the
    //products in its detail
    @Query(value = "select d.order_id as orderId, d.product_id as productId, o.date as orderDate, (d.quantity*(select price from product where id=d.product_id)) as totalPrice from detail d join orders o on o.id=d.order_id where d.order_id in (select id from orders where id not in (select order_id from invoice)) ",nativeQuery = true)
    List<OrdersWithoutInvoices> getOrdersWithoutInvoices();
}
