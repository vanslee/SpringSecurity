package com.ldx.JWTsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
//@PreAuthorize("hasAuthority('system:dept:test ')")
//@PreAuthorize("hasAnyAuthority('admin','test','system:dept:list')")
//@PreAuthorize("hasRole('ceo')")
//@PreAuthorize("hasAnyRole('ceo','cfo')")
@PreAuthorize("@CustomExpressionRoot.hasAuthority('system:dept:list')")
public class HelloController {
    @RequestMapping("/1")
    public String hello() {
        return "你好";
    }
}
