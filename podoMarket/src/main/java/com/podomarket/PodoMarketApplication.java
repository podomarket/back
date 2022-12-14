package com.podomarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PodoMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(PodoMarketApplication.class, args);
    }

}
