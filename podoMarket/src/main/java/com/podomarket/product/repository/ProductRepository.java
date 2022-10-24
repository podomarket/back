package com.podomarket.product.repository;

import com.podomarket.entity.product.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
    Slice<Products> findSliceBy(Pageable pageable);
}
