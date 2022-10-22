package com.podomarket.dto.response;


import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
public class ProductListResponseDto {

    List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

    public void addProduct(ProductResponseDto productResponseDto){
        productResponseDtoList.add(productResponseDto);

    }

}
