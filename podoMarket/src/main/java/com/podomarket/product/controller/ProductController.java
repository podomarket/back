package com.podomarket.product.controller;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.dto.response.TestSaveResponse;
import com.podomarket.product.service.ProductService;
import com.podomarket.user.service.UserDetailsImpl;
import com.podomarket.util.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final S3Uploader s3Uploader;


    @GetMapping("/products")
    public ResponseDto<?> getProducts(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        page = page - 1;
        return productService.getAllProduct(page, size);
    }


    @GetMapping(value = "/products/{productId}")
    public ResponseDto<?> theProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

//    @PostMapping(value = "/products", consumes = {"text/plain", "application/*"})
//    public ResponseDto<?> Posting(@RequestBody ProductRequestDto productRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return productService.createProduct(productRequestDto, userDetails);
//    }

    @PostMapping("/products")
    public ResponseDto<?> Posting(
            @RequestPart(required = false) MultipartFile multipartFile,
            @RequestBody ProductRequestDto productRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) throws IOException {
        if(!multipartFile.isEmpty()) {
            String imgUrl = s3Uploader.upload(multipartFile, "products");
            productRequestDto.setImgUrl(imgUrl);
        } else {
            productRequestDto.setImgUrl(null);
        }
        return productService.createProduct(productRequestDto, userDetails);
    }

    @DeleteMapping(value = "/products/{productId}", consumes = {"text/plain", "application/*"})
    public ResponseDto<?> deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }

    @PutMapping(value = "/products/{productId}",consumes = {"text/plain", "application/*"})
    public TestSaveResponse updateProduct(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.updateTest(productId, productRequestDto, userDetails);
    }

}
