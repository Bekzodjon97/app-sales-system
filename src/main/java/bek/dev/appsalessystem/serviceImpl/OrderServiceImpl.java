package bek.dev.appsalessystem.serviceImpl;

import bek.dev.appsalessystem.entity.*;
import bek.dev.appsalessystem.entity.enums.Status;
import bek.dev.appsalessystem.payload.OrderDetailsDto;
import bek.dev.appsalessystem.payload.Result;
import bek.dev.appsalessystem.repository.*;
import bek.dev.appsalessystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DetailRepository detailRepository;
    @Autowired
    InvoiceRepository invoiceRepository;


    // GET TOTAL NUMBER OF ORDERS PLACED IN 2016 BY CUSTOMERS OF EACH COUNTRY
    @Override
    public HttpEntity<?> getNumberOfProductsInYear() {
        return ResponseEntity.ok(orderRepository.getNumberOfProductsInYear());
    }


    //GET PRODUCTS THAT ARE USUALLY ORDERED IN BULK
    @Override
    public HttpEntity<?> getBulkProducts() {
        return ResponseEntity.ok(orderRepository.getBulkProducts());
    }


    //GET PRODUCTS THAT WERE ORDERED MORE THAN 10 TIMES IN TOTAL
    @Override
    public HttpEntity<?> getHighDemandProducts() {
        return ResponseEntity.ok(orderRepository.getHighDemandProducts());
    }


    //GET ORDER DETAILS BY ID
    @Override
    public HttpEntity<Order> getOrderById(Integer order_id) {
        Optional<Order> optionalOrder = orderRepository.findById(order_id);
        return optionalOrder.<HttpEntity<Order>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok(new Order()));
    }


    //MAKE ORDER AND CREATE INVOICE WHILE CREATING NEW ORDER
    @Override
    public Result makeOrder(OrderDetailsDto orderDetailsDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(orderDetailsDto.getCustomerId());
        if (!optionalCustomer.isPresent())
            return new Result(Status.FAILED, 0);
        Optional<Product> optionalProduct = productRepository.findById(orderDetailsDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result(Status.FAILED, 0);
        Order order=new Order();
        order.setCustomer(optionalCustomer.get());
        order.setDate(new Date(System.currentTimeMillis()));
        Order savedOrder = orderRepository.save(order);

        Detail detail=new Detail();
        detail.setOrder(savedOrder);
        detail.setProduct(optionalProduct.get());
        detail.setQuantity(orderDetailsDto.getQuantity());
        detailRepository.save(detail);

        Invoice invoice=new Invoice();
        invoice.setOrder(savedOrder);
        invoice.setIssued(new Date());
        invoice.setDue(new Date(System.currentTimeMillis()+60480000));
        invoice.setAmount(optionalProduct.get().getPrice()*orderDetailsDto.getQuantity());
        Invoice savedInvoice = invoiceRepository.save(invoice);

        return new Result(Status.SUCCESS, savedInvoice.getId());
    }


    //GET ORDERS THAT DO NOT HAVE A DETAIL AND WERE PLACED BEFORE 6 SEPTEMBER 2016
    @Override
    public HttpEntity<?> getOrdersWithoutDetails() {
        return ResponseEntity.ok(orderRepository.getOrdersWithoutDetails());
    }


    //GET ID AND NAME OF CUSTOMERS AND THE DATE OF THEIR LAST ORDER
    @Override
    public HttpEntity<?> getCustomersLastOrders() {
        return ResponseEntity.ok(orderRepository.getCustomersLastOrders());
    }


    @Override
    public HttpEntity<?> getOrdersWithoutInvoices() {
        return ResponseEntity.ok(orderRepository.getOrdersWithoutInvoices());
    }
}
