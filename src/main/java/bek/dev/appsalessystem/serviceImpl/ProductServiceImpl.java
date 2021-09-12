package bek.dev.appsalessystem.serviceImpl;

import bek.dev.appsalessystem.repository.ProductRepository;
import bek.dev.appsalessystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    //GET ALL PEODUCTS
    @Override
    public HttpEntity<?> getProductList() {
        return ResponseEntity.ok(productRepository.findAll());
    }


    //GET PRODUCT DETAILS BY ID
    @Override
    public HttpEntity<?> getProductById(Integer product_id) {
        return ResponseEntity.ok(productRepository.findById(product_id));
    }
}
