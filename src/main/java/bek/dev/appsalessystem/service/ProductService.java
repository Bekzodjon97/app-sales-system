package bek.dev.appsalessystem.service;

import org.springframework.http.HttpEntity;

public interface ProductService {
    HttpEntity<?> getProductList();

    HttpEntity<?> getProductById(Integer product_id);
}
