package com.productservice.productservice.services;

import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements IProductService {
    @Override
    public String getProductById(Long id) {
        return "GeProducByID from FakeStoreProductService: "+ id;
    }

    @Override
    public String getAllProducts() {
        return "getAllProducts from FakeStoreProductService";
    }

    @Override
    public String deleteProductById(Long id) {
        return "deleteProductById from FakeStoreProductService";
    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById() {

    }
}
