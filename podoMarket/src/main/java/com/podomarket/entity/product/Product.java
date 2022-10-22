package com.podomarket.entity.product;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.entity.ProductCategory;
import com.podomarket.entity.Status;
import com.podomarket.entity.region.ActiveRegion;
import com.podomarket.entity.user.Users;
import com.podomarket.util.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Product extends TimeStamped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

//    @ManyToOne
//    @JoinColumn()
//    private Users user;

    private String imgUrl;

    @Column(nullable = false)
    private Long price;

    @Enumerated(EnumType.STRING)
    private Status status;

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private ProductCategory productCategory;
//
//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private ActiveRegion region;


    public Product(ProductRequestDto productRequestDto) {
        this.title = productRequestDto.getTitle();
        this.content = productRequestDto.getContent();
        this.price = productRequestDto.getPrice();


        this.imgUrl = productRequestDto.getImgUrl();

        this.status = productRequestDto.getStatus();

    }

    public void update(ProductRequestDto productRequestDto) {
        this.title = productRequestDto.getTitle();
        this.imgUrl = productRequestDto.getImgUrl();
        this.content = productRequestDto.getContent();
        this.price = productRequestDto.getPrice();
        this.status = productRequestDto.getStatus();
    }
}
