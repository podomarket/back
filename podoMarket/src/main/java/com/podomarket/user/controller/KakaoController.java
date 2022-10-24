package com.podomarket.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.podomarket.user.service.KakaoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KakaoController {

    private final KakaoUserService kakaoUserService;

    @GetMapping(value = "/users/kakao/callback", produces = {"text/plain", "application/*"})
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }
}
