package com.metajou.authserver.controller;

import com.metajou.authserver.entity.auth.CustomUser;
import com.metajou.authserver.service.AuthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthInfoService authInfoService;

    @Autowired
    public AuthController(AuthInfoService authInfoService) {
        this.authInfoService = authInfoService;
    }

    @GetMapping("/authinfo")
    public Mono<String> getUserAuthInfo(@AuthenticationPrincipal CustomUser userInfo) {
        return null;
    }

}
