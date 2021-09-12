package bek.dev.appsalessystem.serviceImpl;

import bek.dev.appsalessystem.repository.CategoryRepository;
import bek.dev.appsalessystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    //GET ALL PRODUCT CATEGORY LISTS
    @Override
    public HttpEntity<?> getCategoryList() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }


    //GET PRODUCT CATEGORY BY ID
    @Override
    public HttpEntity<?> getCategoryByProductId(Integer product_id) {
        return ResponseEntity.ok(categoryRepository.getCategoryByProductId(product_id));
    }
}
