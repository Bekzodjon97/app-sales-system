package bek.dev.appsalessystem.service;

import bek.dev.appsalessystem.entity.Category;
import org.springframework.http.HttpEntity;

import java.util.List;

public interface CategoryService {
    HttpEntity<List<Category>>  getCategoryList();

    HttpEntity<Category> getCategoryByProductId(Integer product_id);

}
