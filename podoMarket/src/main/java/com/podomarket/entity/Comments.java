package com.podomarket.entity;

import com.podomarket.dto.request.CommentRequsetDto;
import com.podomarket.entity.product.Products;
import com.podomarket.entity.user.Users;
import com.podomarket.user.service.UserDetailsImpl;
import com.podomarket.util.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Comments extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn
    private Users user;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Products products;

    @Column(nullable = false)
    private String content;

    public Comments(CommentRequsetDto commentRequsetDto, Users user, Products products) {
        this.content = commentRequsetDto.getContent();
        this.user = user;
        this.products = products;
    }

    public void update(CommentRequsetDto commentRequsetDto, UserDetailsImpl userDetails) {
        this.content = commentRequsetDto.getContent();
        this.user = userDetails.getUser();

    }
}

