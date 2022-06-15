package com.ldx.JWTsecurity.service;


import com.ldx.JWTsecurity.pojo.User;
import com.ldx.JWTsecurity.utils.ResponseResult;

public interface LoginService {
    ResponseResult login(User user);
//    ResponseResult logout();

}
