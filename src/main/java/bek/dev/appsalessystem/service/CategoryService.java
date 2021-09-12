package bek.dev.appsalessystem.service;

import org.springframework.http.HttpEntity;

public interface CategoryService {
    HttpEntity<?> getCategoryList();

    HttpEntity<?> getCategoryByProductId(Integer product_id);

}
