package com.podomarket.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.podomarket.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId; // lcy12354
    private String username; //
    @Column(nullable = false)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    private String phoneNum;

    private Long kakaoId;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Authority authority;

    public Users(String username, String encodedPassword, String email, Authority role, Long kakaoId) {
        this.username = username;
        this.password = encodedPassword;
        this.email = email;
        this.authority = role;
        this.kakaoId = kakaoId;
    }
}
