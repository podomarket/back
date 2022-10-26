package com.podomarket.dto.response;


import com.podomarket.entity.Status;
import com.podomarket.entity.product.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
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

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;


    public ProductResponseDto(Products products) {
        this.id = products.getId();
        this.title = products.getTitle();
        this.content = products.getContent();
        this.commentsNum = Long.valueOf(products.getCommentsList().stream().map(CommentResponseDto::new).collect(Collectors.toList()).size());
        this.imgUrl = products.getImgUrl();
        this.price = products.getPrice();
        this.createdAt = products.getCreatedAt();
        this.modifiedAt = products.getModifiedAt();
        this.userId = products.getUser().getUserId();
    }

}
