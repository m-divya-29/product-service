package com.productservice.productservice.services;

public interface IProductService {
    public String getProductById(Long id);

    public String getAllProducts();

     String deleteProductById(Long id);

    public void createProduct();
    public void updateProductById();
}
