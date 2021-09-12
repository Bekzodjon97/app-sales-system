package bek.dev.appsalessystem.controller;

import bek.dev.appsalessystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    /**
     * get category list
     * @return all categories
     */
    @GetMapping("/list")
    public HttpEntity<?> getCategoryList(){
        return categoryService.getCategoryList();
    }


    /**
     * get category by product id
     * @param product_id
     * @return category
     */
    @GetMapping("/{product_id}")
    public HttpEntity<?> getCategoryByProductId(@PathVariable Integer product_id){
        return categoryService.getCategoryByProductId(product_id);
    }
}
