package com.podomarket.dto.request;

import lombok.Getter;
import java.io.File;

@Getter
public class ProductRequestDto {
    private String title;
    private String content;
    private File imgUrl;
}
