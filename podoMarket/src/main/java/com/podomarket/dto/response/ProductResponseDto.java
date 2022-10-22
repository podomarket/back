package com.podomarket.dto.response;


import com.podomarket.entity.Status;
import com.podomarket.entity.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto {

    private String title;
    private String content;
    private Long price;
    private String imgUrl;

    private Status status;

    public ProductResponseDto(Product product){
        this.title = product.getTitle();
        this.content = product.getContent();
        this.price = product.getPrice();

        this.imgUrl = product.getImgUrl();

        this.status = product.getStatus();

    }




}
