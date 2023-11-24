package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;

import java.util.List;

public interface IProductService {
    public GenericProductDTO getProductById(Long id);

    public List<GenericProductDTO> getAllProducts();

     String deleteProductById(Long id);

     GenericProductDTO createProduct(GenericProductDTO fakeStoreProductDTO);
     void updateProductById();
}
