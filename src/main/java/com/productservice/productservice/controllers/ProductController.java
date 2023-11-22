package com.productservice.productservice.controllers;

import com.productservice.productservice.services.IProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public String getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }

    public void createProduct() {

    }
    public void updateProductById() {

    }
}
