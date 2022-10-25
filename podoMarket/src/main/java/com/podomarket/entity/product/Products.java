package com.podomarket.entity.product;

import com.podomarket.dto.request.ProductRequestDto;
import com.podomarket.entity.Comments;
import com.podomarket.entity.Likes;
import com.podomarket.entity.Status;
import com.podomarket.entity.user.Users;
import com.podomarket.user.service.UserDetailsImpl;
import com.podomarket.util.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static com.podomarket.entity.Status.CONTINUE;

@Entity
@Getter
@NoArgsConstructor
public class Products extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;


    private String content;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    @OneToMany(mappedBy = "products",cascade = CascadeType.REMOVE)
    private List<Comments> commentsList = new ArrayList<>();

    @OneToMany(mappedBy = "products",cascade = CascadeType.REMOVE)
    private List<Likes> likesList = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String imgUrl;

    public Products(ProductRequestDto productRequestDto, UserDetailsImpl userDetails) {
        this.title = productRequestDto.getTitle();
        this.content = productRequestDto.getContent();
        this.user = userDetails.getUser();
        this.status = CONTINUE;
        this.imgUrl = productRequestDto.getImgUrl();
    }


    public void update(ProductRequestDto productRequestDto, UserDetailsImpl userDetails) {
        this.title = productRequestDto.getTitle();
        this.content = productRequestDto.getContent();
        this.user = userDetails.getUser();
        this.status = CONTINUE;
    }
}
