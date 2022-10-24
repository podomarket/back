package com.podomarket.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String userId;
    private String username;
    private String email;
    private String password;
    private String passwordConfirm;


    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(userId, password);
    }
}
