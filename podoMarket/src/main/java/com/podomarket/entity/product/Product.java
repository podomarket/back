package com.podomarket.entity.product;

import com.podomarket.dto.request.ProductRequestDto;
//import com.podomarket.entity.ProductCategory;
import com.podomarket.entity.Status;
import com.podomarket.entity.user.Users;
import com.podomarket.user.service.UserDetailsImpl;
import com.podomarket.util.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.podomarket.entity.Status.CONTINUE;

@Entity
@Getter
@NoArgsConstructor
public class Product extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    private String imgUrl;

    @Column(nullable = false)
    private Long price;

    @Enumerated(EnumType.STRING)
    private Status status;

    // a b c

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private ProductCategory productCategory;


    public Product(ProductRequestDto productRequestDto, UserDetailsImpl userDetails) {
        this.title = productRequestDto.getTitle();
        this.content = productRequestDto.getContent();
        this.user = userDetails.getUser();
        this.price = productRequestDto.getPrice();
        this.imgUrl = productRequestDto.getImgUrl();
        this.status = CONTINUE;
    }

    public void update(ProductRequestDto productRequestDto, UserDetailsImpl userDetails) {
        this.title = productRequestDto.getTitle();
        this.imgUrl = productRequestDto.getImgUrl();
        this.content = productRequestDto.getContent();
        this.user = userDetails.getUser();
        this.price = productRequestDto.getPrice();
        this.status = CONTINUE;
    }
}
