package com.podomarket.product.controller;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.dto.response.TestSaveResponse;
import com.podomarket.product.service.ProductService;
import com.podomarket.user.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseDto<?> getProducts() {
        return productService.getAllProduct();
    }

    @GetMapping(value = "/products/{productId}")
    public ResponseDto<?> theProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/products")
    public ResponseDto<?> Posting(
            @ModelAttribute ProductRequestDto productRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) throws IOException {
        return productService.createProduct(productRequestDto, userDetails);
    }

    @DeleteMapping(value = "/products/{productId}", consumes = {"text/plain", "application/*"})
    public ResponseDto<?> deleteProduct(@PathVariable Long productId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.deleteProduct(productId, userDetails);
    }

    @PutMapping(value = "/products/{productId}")
    public ResponseDto<?> updateProduct(
            @PathVariable Long productId,
            @ModelAttribute ProductRequestDto productRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) throws IOException {
        return productService.update(productId, productRequestDto, userDetails);
    }
}
