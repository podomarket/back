package com.podomarket.product.controller;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ProductListResponseDto;
import com.podomarket.dto.response.ProductResponseDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.dto.response.TestSaveResponse;
import com.podomarket.entity.product.Product;
import com.podomarket.product.repository.ProductRepository;
import com.podomarket.product.service.ProductService;
import com.podomarket.user.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;
    @GetMapping("/product")
    public ResponseDto<?> allProduct() {
        return productService.getAllProduct();
    }

    @PostMapping("/product")
    public ResponseDto<?> Posting(@RequestBody ProductRequestDto productRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.createProduct(productRequestDto, userDetails);
    }


    @DeleteMapping("/product/{productId}")
    public ResponseDto<?> deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);

    }

    @PutMapping("/product/{productId}")
    public TestSaveResponse updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.updateTest(productId, productRequestDto, userDetails);
    }

}
