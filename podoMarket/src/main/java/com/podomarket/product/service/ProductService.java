package com.podomarket.product.service;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ProductListResponseDto;
import com.podomarket.dto.response.ProductResponseDto;
import com.podomarket.dto.response.TestSaveResponse;
import com.podomarket.entity.product.Product;
import com.podomarket.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;


    @Transactional
    public List<ProductResponseDto> getAllProduct(){
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Product product : products){
            productResponseDtoList.add(new ProductResponseDto(product));
        }
        return productResponseDtoList;
    }
        @Transactional
    public TestSaveResponse updateTest(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("updateTest problem")
        );
        product.update(productRequestDto);
        return new TestSaveResponse(product);
    }



}
