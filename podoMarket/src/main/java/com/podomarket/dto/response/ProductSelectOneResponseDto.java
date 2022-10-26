package com.podomarket.dto.response;


import com.podomarket.entity.product.Products;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ProductSelectOneResponseDto {
    private Long id;
    private String userId;
    private String title;
    private String content;
    private String imgUrl;
    private Long price;
    private List<CommentResponseDto> commentList;

    private Date createdAt;

    private Date modifiedAt;

    public ProductSelectOneResponseDto(Products products) {
        this.id = products.getId();
        this.title = products.getTitle();
        this.content = products.getContent();
        this.commentList = products.getCommentsList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
        this.imgUrl = products.getImgUrl();
        this.createdAt = products.getCreatedAt();
        this.modifiedAt = products.getModifiedAt();
        this.userId = products.getUser().getUserId();
        this.price = products.getPrice();
    }
}
