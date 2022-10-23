package com.podomarket.dto.response;


import com.podomarket.entity.Status;
import com.podomarket.entity.product.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto {

    private String title;
    private String content;
    private Status status;

    public ProductResponseDto(Products products){
        this.title = products.getTitle();
        this.content = products.getContent();
        this.status = products.getStatus();

    }




}
