package com.podomarket.product.repository;

import com.podomarket.entity.product.Products;
import com.podomarket.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {

    List<Products> findByUser(Users user);
}
