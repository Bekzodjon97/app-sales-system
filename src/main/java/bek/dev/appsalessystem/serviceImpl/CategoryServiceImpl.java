package bek.dev.appsalessystem.serviceImpl;

import bek.dev.appsalessystem.entity.Category;
import bek.dev.appsalessystem.repository.CategoryRepository;
import bek.dev.appsalessystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    //GET ALL PRODUCT CATEGORY LISTS
    @Override
    public HttpEntity<List<Category>> getCategoryList() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }


    //GET PRODUCT CATEGORY BY ID
    @Override
    public HttpEntity<Category> getCategoryByProductId(Integer product_id) {
        return ResponseEntity.ok(categoryRepository.getCategoryByProductId(product_id));
    }
}
