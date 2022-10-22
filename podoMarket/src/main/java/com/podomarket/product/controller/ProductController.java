package com.podomarket.product.controller;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ProductListResponseDto;
import com.podomarket.dto.response.ProductResponseDto;
import com.podomarket.dto.response.TestSaveResponse;
import com.podomarket.entity.product.Product;
import com.podomarket.product.repository.ProductRepository;
import com.podomarket.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;
    @GetMapping("/product")
    public List<ProductResponseDto> allProduct() {
        return productService.getAllProduct();
    }

    @PostMapping("/product")
    public ProductResponseDto Posting(@RequestBody ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto);
        productRepository.save(product);
        return new ProductResponseDto(product);
    }


    @DeleteMapping("/product/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productRepository.deleteById(productId);
    }

    @PutMapping("/product/{productId}")
    public TestSaveResponse updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto) {
        return productService.updateTest(productId, productRequestDto);
    }

}
