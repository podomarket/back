package com.podomarket.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private String content;
    private String imgUrl;
}
