package bek.dev.appsalessystem.service;

import org.springframework.http.HttpEntity;

public interface CustomerService {
    HttpEntity<?> getCustomersWithoutOrders();
}
