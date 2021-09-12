package bek.dev.appsalessystem.service;

import bek.dev.appsalessystem.payload.OrderDetailsDto;
import bek.dev.appsalessystem.payload.Result;
import org.springframework.http.HttpEntity;

public interface OrderService {
    HttpEntity<?> getNumberOfProductsInYear();

    HttpEntity<?> getBulkProducts();

    HttpEntity<?> getHighDemandProducts();

    HttpEntity<?> getOrderById(Integer order_id);

    Result makeOrder(OrderDetailsDto orderDetailsDto);

    HttpEntity<?> getOrdersWithoutDetails();

    HttpEntity<?> getCustomersLastOrders();

    HttpEntity<?> getOrdersWithoutInvoices();
}
