package com.podomarket.product.repository;

import com.podomarket.entity.product.Products;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Products, Long> {
}
