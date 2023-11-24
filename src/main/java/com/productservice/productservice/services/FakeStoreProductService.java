package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDTO;
import com.productservice.productservice.dtos.GenericProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements IProductService {
    private static final String BASE_URL = "https://fakestoreapi.com/products";
    private static final String PRODUCT_BY_ID_URL = BASE_URL + "/{id}";
    private RestTemplate restTemplate;
    FakeStoreProductService() {
        this.restTemplate = new RestTemplate();
    }
    private GenericProductDTO getGenericProductDTOFromFakeProductDTO(FakeStoreProductDTO fakeStoreProductDTO) {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        return genericProductDTO;
    }

    @Override
    public GenericProductDTO getProductById(Long id) {
        FakeStoreProductDTO getByIdDTO = restTemplate.getForObject(PRODUCT_BY_ID_URL, FakeStoreProductDTO.class, id);
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(PRODUCT_BY_ID_URL, FakeStoreProductDTO.class, id);
        return getGenericProductDTOFromFakeProductDTO(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<GenericProductDTO> allProducts = new ArrayList<>();
        ResponseEntity<FakeStoreProductDTO[]> responseEntity =
                (restTemplate.getForEntity(BASE_URL, FakeStoreProductDTO[].class)); //cannot use List<FakeStoreDTO>.class due to java's type erasure
        //get all rows in the body as a list.
        List<FakeStoreProductDTO> responseBody = List.of(responseEntity.getBody());

        //convert FakeStoreDTO to Generic DTO
        for(FakeStoreProductDTO fakeStoreProductDTO : responseBody) {
            allProducts.add(getGenericProductDTOFromFakeProductDTO(fakeStoreProductDTO));
        }
        return allProducts;
    }

    @Override
    public String deleteProductById(Long id) {
        return "deleteProductById from FakeStoreProductService";
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        ResponseEntity<GenericProductDTO> responseEntity = restTemplate.postForEntity(BASE_URL, genericProductDTO, GenericProductDTO.class);
        return responseEntity.getBody();
    }

    @Override
    public void updateProductById() {

    }
}
