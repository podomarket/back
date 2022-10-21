package com.podomarket.dto.response;

import com.podomarket.entity.Users;

public class UserResponseDto {
    private Long id;
    private String userId;
    private String password;

    public UserResponseDto(Users user) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.password = user.getPassword();
    }
}