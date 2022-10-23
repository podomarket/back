package com.podomarket.dto.response;

import com.podomarket.entity.Status;
import com.podomarket.entity.product.Products;
import lombok.Getter;

@Getter
public class TestSaveResponse {

    private String title;
    private String content;
    private Long price;

    private String imgUrl;
    private Status status;


    public TestSaveResponse(String title, String content,Status status) {
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public TestSaveResponse(Products products) {
        this.title = products.getTitle();
        this.content = products.getContent();
        this.status = products.getStatus();
    }
}
