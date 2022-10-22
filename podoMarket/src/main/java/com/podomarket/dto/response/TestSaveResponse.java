package com.podomarket.dto.response;

import com.podomarket.entity.Status;
import com.podomarket.entity.product.Product;
import lombok.Getter;

@Getter
public class TestSaveResponse {

    private String title;
    private String content;
    private Long price;

    private String imgUrl;
    private Status status;


    public TestSaveResponse(String title, String content, Long price, String imgUrl, Status status) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.imgUrl = imgUrl;
        this.status = status;
    }

    public TestSaveResponse(Product product) {
        this.title = product.getTitle();
        this.content = product.getContent();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
        this.status = product.getStatus();
    }
}
