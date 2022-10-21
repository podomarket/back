package com.podomarket.entity.product;

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

    @ManyToOne
    @JoinColumn()
    private Users user;

    private String imgUrl;

    @Column(nullable = false)
    private Long price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ActiveRegion region;
}
