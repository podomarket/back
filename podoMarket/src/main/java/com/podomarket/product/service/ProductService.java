package com.podomarket.product.service;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ProductResponseDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.dto.response.TestSaveResponse;
import com.podomarket.entity.product.Products;
import com.podomarket.product.repository.ProductRepository;
import com.podomarket.user.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ResponseDto<?> getAllProduct(){
        List<Products> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Products product : products){
            productResponseDtoList.add(new ProductResponseDto(product));
        }
        return ResponseDto.success(productResponseDtoList);
    }

    @Transactional
    public TestSaveResponse updateTest(Long id, ProductRequestDto productRequestDto, UserDetailsImpl userDetails) {
        Products products = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("updateTest problem")
        );
        products.update(productRequestDto, userDetails);
        return new TestSaveResponse(products);
    }

    public ResponseDto<?> createProduct(ProductRequestDto productRequestDto, UserDetailsImpl userDetails) {
        Products products = new Products(productRequestDto, userDetails);
        productRepository.save(products);
        return ResponseDto.success("성공적으로 등록하셨습니다");
    }

    @Transactional
    public ResponseDto<?> deleteProduct(Long productId) {
        try {
            productRepository.deleteById(productId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("존재하지 않는 데이터입니다.");
        }
        return ResponseDto.success("성공적으로 삭제하였습니다.");
    }

    @Transactional
    public ResponseDto<?> getProduct(Long productId) {
        Products products = productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("관련 상품 글이 없습니다.")
        );
        ProductResponseDto productResponseDto = new ProductResponseDto(products);
        return ResponseDto.success(productResponseDto);
    }
}
