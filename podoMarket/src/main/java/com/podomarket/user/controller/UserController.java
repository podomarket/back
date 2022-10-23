package com.podomarket.user.controller;

import com.podomarket.dto.TokenDto;
import com.podomarket.dto.request.TokenRequestDto;
import com.podomarket.dto.request.UserRequestDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/user", consumes = {"text/plain", "application/*"})
public class UserController {

    private final UserService userService;


    @PostMapping(value = "/signup", consumes = {"text/plain", "application/*"})
    public ResponseDto<?> signup(@RequestBody UserRequestDto userRequestDto) {
        return userService.signup(userRequestDto);
    }

    @PostMapping(value = "/login", consumes = {"text/plain", "application/*"})
    public ResponseDto<?> login(@RequestBody UserRequestDto userRequestDto, HttpServletResponse response) {
        return userService.login(userRequestDto, response);
    }

    @PostMapping("/reissue")
    public ResponseDto<?> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        TokenDto tokenDto = new TokenDto();
        return ResponseDto.success(tokenDto);
    }

}
