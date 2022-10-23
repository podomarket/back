package com.podomarket.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.podomarket.user.service.KakaoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoUserService kakaoUserService;

    @GetMapping("/users/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }

//    @GetMapping("/users")
//    public String kakaoLogin22222(){
//        return "index.html";
//    }
}
