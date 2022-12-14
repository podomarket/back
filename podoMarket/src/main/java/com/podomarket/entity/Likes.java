package com.podomarket.entity;

import com.podomarket.entity.product.Products;
import com.podomarket.entity.user.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Likes {

    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Products products;

    public Likes(Products products, Users user) {
        this.products = products;
        this.user = user;
    }
}
