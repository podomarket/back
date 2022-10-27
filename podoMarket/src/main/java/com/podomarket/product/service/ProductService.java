package com.podomarket.product.service;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ProductResponseDto;
import com.podomarket.dto.response.ProductSelectOneResponseDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.entity.product.Products;
import com.podomarket.product.repository.ProductRepository;
import com.podomarket.user.service.UserDetailsImpl;
import com.podomarket.util.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final S3Uploader s3Uploader;

    public ResponseDto<?> getAllProduct(){
        List<Products> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Products product : products){
            productResponseDtoList.add(new ProductResponseDto(product));
        }
        return ResponseDto.success(productResponseDtoList);
    }

    @Transactional
    public ResponseDto<?> update(Long id, ProductRequestDto productRequestDto, UserDetailsImpl userDetails) throws IOException {
        Products product = productRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 데이터입니다.")
        );
        Date date = new Date();

        Products products = Products.builder()
                .id(product.getId())
                .title(productRequestDto.getTitle())
                .content(productRequestDto.getContent())
                .imgUrl(s3Uploader.upload(productRequestDto.getFile(), "product"))
                .user(userDetails.getUser())
                .price(productRequestDto.getPrice())
                .createdAt(product.getCreatedAt())
                .modifiedAt(date)
                .build();

        productRepository.save(products);

        return ResponseDto.success("업데이트 성공");
    }

    public ResponseDto<?> createProduct(ProductRequestDto productRequestDto, UserDetailsImpl userDetails) throws IOException {

        Date date = new Date();
        Products products = Products.builder()
                .title(productRequestDto.getTitle())
                .content(productRequestDto.getContent())
                .imgUrl(s3Uploader.upload(productRequestDto.getFile(), "product"))
                .user(userDetails.getUser())
                .price(productRequestDto.getPrice())
                .createdAt(date)
                .modifiedAt(date)
                .build();

        productRepository.save(products);
        return ResponseDto.success("성공적으로 등록하셨습니다");
    }

    @Transactional
    public ResponseDto<?> deleteProduct(Long productId, UserDetailsImpl userDetails) {
        Products findProduct = productRepository.findById(productId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 데이터입니다.")
        );

        if(userDetails.getUser().getUserId().equals(findProduct.getUser().getUserId())) {
            productRepository.deleteById(productId);
            return ResponseDto.success("성공적으로 삭제하였습니다.");
        } else {
            return ResponseDto.fail("권한없음","권한이 없어요.");
        }
    }

    @Transactional
    public ResponseDto<?> getProduct(Long productId) {
        Products products = productRepository.findById(productId).orElseThrow(
                () -> new IllegalArgumentException("관련 상품 글이 없습니다.")
        );
        ProductSelectOneResponseDto productResponseDto = new ProductSelectOneResponseDto(products);
        return ResponseDto.success(productResponseDto);
    }
}
