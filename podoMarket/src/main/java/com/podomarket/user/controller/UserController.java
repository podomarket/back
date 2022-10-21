package com.podomarket.user.controller;

import com.podomarket.dto.TokenDto;
import com.podomarket.dto.request.TokenRequestDto;
import com.podomarket.dto.request.UserRequestDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseDto<?> signup(@RequestBody UserRequestDto userRequestDto) {
        return userService.signup(userRequestDto);
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody UserRequestDto userRequestDto, HttpServletResponse response) {
        return userService.login(userRequestDto, response);
    }

    @PostMapping("/reissue")
    public ResponseDto<?> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        TokenDto tokenDto = new TokenDto();
        return ResponseDto.success(tokenDto);
    }

}
