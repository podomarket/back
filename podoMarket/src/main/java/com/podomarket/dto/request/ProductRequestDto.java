package com.podomarket.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private String content;
    private Long price;
    private MultipartFile file;
}
