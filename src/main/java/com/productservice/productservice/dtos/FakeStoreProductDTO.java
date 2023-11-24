package com.productservice.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private Float price;
    private String category;
    private String image;
}
