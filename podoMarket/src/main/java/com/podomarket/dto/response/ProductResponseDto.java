package com.podomarket.dto.response;

import com.podomarket.entity.product.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;
    private String userId;
    private String title;
    private String content;
    private Long commentsNum;
    private String imgUrl;
    private Long price;

    private Long createdAt;
    private Long modifiedAt;

    public ProductResponseDto(Products products) {
        this.id = products.getId();
        this.title = products.getTitle();
        this.content = products.getContent();
        this.commentsNum = Long.valueOf(products.getCommentsList().stream().map(CommentResponseDto::new).collect(Collectors.toList()).size());
        this.imgUrl = products.getImgUrl();
        this.price = products.getPrice();
        this.createdAt = products.getCreatedAt().getTime();
        this.modifiedAt = products.getModifiedAt().getTime();
        this.userId = products.getUser().getUserId();
    }
}
