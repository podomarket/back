package com.podomarket.product.repository;

import com.podomarket.dto.response.ProductResponseDto;
import com.podomarket.entity.product.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
    Page<ProductResponseDto> findSliceBy(Pageable pageable);
}
