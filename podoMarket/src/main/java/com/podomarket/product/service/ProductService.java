package com.podomarket.product.service;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ProductListResponseDto;
import com.podomarket.dto.response.ProductResponseDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.dto.response.TestSaveResponse;
import com.podomarket.entity.product.Product;
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

    @Transactional
    public ResponseDto<?> getAllProduct(){
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Product product : products){
            productResponseDtoList.add(new ProductResponseDto(product));
        }
        return ResponseDto.success(productResponseDtoList);
    }
        @Transactional
    public TestSaveResponse updateTest(Long id, ProductRequestDto productRequestDto, UserDetailsImpl userDetails) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("updateTest problem")
        );
        product.update(productRequestDto, userDetails);
        return new TestSaveResponse(product);
    }


    public ResponseDto<?> createProduct(ProductRequestDto productRequestDto, UserDetailsImpl userDetails) {
        Product product = new Product(productRequestDto, userDetails);
        productRepository.save(product);
        return ResponseDto.success("성공적으로 등록하셨습니다");
    }

    public ResponseDto<?> deleteProduct(Long productId) {
        try {
            productRepository.deleteById(productId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("존재하지 않는 데이터입니다.");
        }
        return ResponseDto.success("성공적으로 삭제하였습니다.");
    }
}
