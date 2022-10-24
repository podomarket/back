package com.podomarket.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.podomarket.dto.request.UserInfoRequestDto;
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

    private String userId;
    private String username;
    @Column(nullable = false)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    private Long kakaoId;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Authority authority;

    //Kakao login
    public Users(String userId, String username, String encodedPassword, String email, Authority role, Long kakaoId) {
        this.userId = userId;
        this.username = username;
        this.password = encodedPassword;
        this.email = email;
        this.authority = role;
        this.kakaoId = kakaoId;
    }

    public void infoUpdate(UserInfoRequestDto userInfoRequestDto, String encodingPassword) {
        this.username = userInfoRequestDto.getUsername();
        this.email = userInfoRequestDto.getEmail();
        this.password = encodingPassword;

    }
}
