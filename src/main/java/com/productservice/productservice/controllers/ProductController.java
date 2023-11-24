package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * Calls /products/{id} of 3rd party fakestoreapi rest api and returns product that has id
     * @param id id of the product to fetch
     * @return Product that matches the ID as GenericProductDTO
     */
    @GetMapping("/{id}")
    public GenericProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * calls 3rd party /products end-point of fakestoreapi.com to return all products in the database.
     * @return all products as a list of GenericProductDTO
     */
    @GetMapping
    public List<GenericProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }

    @PostMapping()
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO) {
        return productService.createProduct(genericProductDTO);
    }
    public void updateProductById() {

    }
}
