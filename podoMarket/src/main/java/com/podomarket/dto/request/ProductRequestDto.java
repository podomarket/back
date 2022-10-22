package com.podomarket.dto.request;

import com.podomarket.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public class ProductRequestDto {

    private String title;
    private String content;
    private Long price;
    private String imgUrl;
    private Status status;


}
