package com.podomarket.user.controller;

import com.podomarket.dto.TokenDto;
import com.podomarket.dto.request.TokenRequestDto;
import com.podomarket.dto.request.UserInfoRequestDto;
import com.podomarket.dto.request.UserRequestDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.user.service.UserDetailsImpl;
import com.podomarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/users", consumes = {"text/plain", "application/*"})
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
    @GetMapping("/{userId}")
    public ResponseDto<?> userInfo(@PathVariable("userId") Long id){
        return userService.getUser(id);
    }

    @PostMapping("/reissue")
    public ResponseDto<?> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        TokenDto tokenDto = new TokenDto();
        return ResponseDto.success(tokenDto);
    }
    @PutMapping("/update")
    public ResponseDto<?> userInfoUpdate(@RequestBody UserInfoRequestDto userInfoRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return userService.userUpdate(userDetails, userInfoRequestDto);
    }

}
