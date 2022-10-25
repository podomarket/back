package com.podomarket.dto.response;


import com.podomarket.entity.product.Products;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ProductSelectOneResponseDto {

    private String title;
    private String content;
    private List<CommentResponseDto> commentList;

    public ProductSelectOneResponseDto(Products products) {
        this.title = products.getTitle();
        this.content = products.getContent();
        this.commentList = products.getCommentsList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }


}
