package com.podomarket.dto.response;

import com.podomarket.entity.user.Users;
import lombok.Getter;

@Getter
public class UserInfoResponseDto {

    private String username;
    private String email;
    private Long id;
    public UserInfoResponseDto(Users user){
        this.username = user.getUsername();
        this.email = user.getEmail();
//        this.id =user.getId();

    }
}
