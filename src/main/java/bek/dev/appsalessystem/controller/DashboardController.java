package bek.dev.appsalessystem.controller;

import bek.dev.appsalessystem.entity.Invoice;
import bek.dev.appsalessystem.service.CustomerService;
import bek.dev.appsalessystem.service.InvoiceService;
import bek.dev.appsalessystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    OrderService orderService;
    @Autowired
    CustomerService customerService;


    /**
     * Invoices issued after their due date
     * @return all attributes
     */
    @GetMapping("/expired_invoices")
    public HttpEntity<List<Invoice>> getExpiredInvoices(){
        return invoiceService.getExpiredInvoices();
    }



    /**
     * Invoices that were issued before the date in which the order they refer to was placed
     * @return invoiceId,orderId,issuedDate,orderDate
     */
    @GetMapping("/wrong_date_invoices")
    public HttpEntity<?> getWrongDateInvoices(){
    return invoiceService.getWrongDateInvoices();
    }



    /**
     * Orders that do not have a detail and were placed before 6 September 2016
     * @return all attributes
     */
    @GetMapping("/orders_without_details")
    public HttpEntity<?> getOrdersWithoutDetails(){
        return orderService.getOrdersWithoutDetails();
    }



    /**
     * Customers who have not placed any orders in 2016
     * @return all attributes
     */
    @GetMapping("/customers_without_orders")
    public HttpEntity<?> getCustomersWithoutOrders(){
        return customerService.getCustomersWithoutOrders();
    }



    /**
     *  Get id and name of customers and the date of their last order
     * @return customer.id, customer.name, order.date
     */
    @GetMapping("/customers_last_orders")
    public HttpEntity<?> getCustomersLastOrders(){
        return orderService.getCustomersLastOrders();
    }



    /**
     * Invoices that have been overpaid
     * @return invoiceId, overpayment----
     */
    @GetMapping("/overpaid_invoices")
    public HttpEntity<?> getOverpaidInvoices(){
        return invoiceService.getOverpaidInvoices();
    }



    /**
     * Products that were ordered more than 10 times in total
     * @return productId, countOfTimes-----
     */
    @GetMapping("/high_demand_products")
    public HttpEntity<?> getHighDemandProducts(){
        return orderService.getHighDemandProducts();
    }



    /**
     * Products that are usually ordered in bulk: whenever one of these products is ordered, it
     * is ordered in a quantity that on average is equal to or greater than 8.
     * @return product code and price
     */
    @GetMapping("/bulk_products")
    public HttpEntity<?> getBulkProducts(){
        return orderService.getBulkProducts();
    }


    /**
     * Total number of orders placed in 2016 by customers of each country
     * @return countOf-----
     */
    @GetMapping("/number_of_products_in_year")
    public HttpEntity<?> getNumberOfProductsInYear(){
        return orderService.getNumberOfProductsInYear();
    }


    /**
     * For each order without invoice, list its ID, the date it was placed and the total price of the
     * products in its detail
     * @return orderId, orderDate, TotalPrice
     */
    @GetMapping("/orders_without_invoices")
    public HttpEntity<?> getOrdersWithoutInvoices(){
        return orderService.getOrdersWithoutInvoices();
    }
}

