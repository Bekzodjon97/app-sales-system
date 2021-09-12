package bek.dev.appsalessystem.repository;

import bek.dev.appsalessystem.entity.Category;
import bek.dev.appsalessystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //get customers without orders
    @Query(value = "select * from customer where id not in (select id from customer_orders)", nativeQuery = true)
    Customer getCustomersWithoutOrders();
}
