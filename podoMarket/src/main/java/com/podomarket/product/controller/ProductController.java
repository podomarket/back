package com.podomarket.product.controller;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.dto.response.TestSaveResponse;
import com.podomarket.product.service.ProductService;
import com.podomarket.user.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping
    public ResponseDto<?> allProduct() {
        return productService.getAllProduct();
    }

    @PostMapping
    public ResponseDto<?> Posting(@RequestBody ProductRequestDto productRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.createProduct(productRequestDto, userDetails);
    }


    @DeleteMapping("/{productId}")
    public ResponseDto<?> deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);

    }

    @PutMapping("/{productId}")
    public TestSaveResponse updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.updateTest(productId, productRequestDto, userDetails);
    }

}
