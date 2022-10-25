package com.podomarket.like.repository;

import com.podomarket.entity.Likes;
import com.podomarket.entity.product.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByProductsAndUserId(Products products, Long user_id);
}
