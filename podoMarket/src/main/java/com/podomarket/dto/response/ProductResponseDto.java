package com.podomarket.dto.response;


import com.podomarket.entity.Status;
import com.podomarket.entity.product.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;
    private String title;
    private String content;
    private Long commentsNum;

    public ProductResponseDto(Products products) {
        this.id = products.getId();
        this.title = products.getTitle();
        this.content = products.getContent();
        this.commentsNum = Long.valueOf(products.getCommentsList().stream().map(CommentResponseDto::new).collect(Collectors.toList()).size());
    }

}
