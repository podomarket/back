package com.podomarket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","http://localhost:3001","https://acs.amazonaws.com/groups/global/AllUsers")
                .allowedMethods("GET","POST","PUT","DELETE")
                .exposedHeaders("Authorization","Refresh-Token")
                .allowCredentials(true)//make client read header("jwt-token")
        ;
    }
}