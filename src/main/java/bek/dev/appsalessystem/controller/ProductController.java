package bek.dev.appsalessystem.controller;

import bek.dev.appsalessystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping("/list")
    public HttpEntity<?> getProductList(){
        return productService.getProductList();
    }


    @GetMapping("/{product_id}")
    public HttpEntity<?> getProductById(@PathVariable Integer product_id){
        return productService.getProductById(product_id);
    }
}
