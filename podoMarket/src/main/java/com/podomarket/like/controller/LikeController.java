package com.podomarket.like.controller;


import com.podomarket.like.service.LikeService;
import com.podomarket.user.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("products/{productId}/like")
    public boolean addLike(@PathVariable Long productId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likeService.addLike(productId, userDetails);
    }
}
