package com.podomarket.comment.repository;

import com.podomarket.entity.Comments;

import com.podomarket.entity.product.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository <Comments, Long>{
}
