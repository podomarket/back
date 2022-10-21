package com.podomarket.entity;

import com.podomarket.util.TimeStamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends TimeStamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    private String imgUrl;

    @Column(nullable = false)
    private Long price;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String region;

}
