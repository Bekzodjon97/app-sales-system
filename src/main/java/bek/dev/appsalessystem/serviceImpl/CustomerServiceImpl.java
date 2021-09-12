package bek.dev.appsalessystem.serviceImpl;

import bek.dev.appsalessystem.repository.CustomerRepository;
import bek.dev.appsalessystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    //CUSTOMERS WHO HAVE NOT PLACED ANY ORDERS IN 2016
    @Override
    public HttpEntity<?> getCustomersWithoutOrders() {
        return ResponseEntity.ok(customerRepository.getCustomersWithoutOrders());
    }
}
