package com.ldx.JWTsecurity.controller;

import com.ldx.JWTsecurity.pojo.User;
import com.ldx.JWTsecurity.service.LoginService;
import com.ldx.JWTsecurity.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }
}
