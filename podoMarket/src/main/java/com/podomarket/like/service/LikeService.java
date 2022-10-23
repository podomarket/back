package com.podomarket.like.service;

import com.podomarket.entity.Likes;
import com.podomarket.entity.product.Products;
import com.podomarket.like.repository.LikeRepository;
import com.podomarket.product.repository.ProductRepository;
import com.podomarket.user.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final ProductRepository productRepository;

    @Transactional
    public boolean addLike(Long id, UserDetailsImpl userDetails) {
        Products products = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("상품 관련 글이 없습니다.")
        );
        Optional<Likes> likes = likeRepository.findByProductsAndUserId(products, userDetails.getUser().getId());
        if(likes.isPresent()){
            likeRepository.delete(likes.get());
            return false;
        }
        else{
            Likes likes1 = new Likes(products,userDetails.getUser());
            likeRepository.save(likes1);
            return true;
        }
    }
}
