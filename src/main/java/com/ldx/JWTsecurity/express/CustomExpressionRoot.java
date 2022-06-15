package com.ldx.JWTsecurity.express;

import com.ldx.JWTsecurity.pojo.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "CustomExpressionRoot")
public class CustomExpressionRoot {
   public boolean hasAuthority(String authority) {
        // 获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        List<String> permissions = userDetails.getPermissions();
        // 判断用户权限集合中是否存在authority
        return  permissions.contains(authority);
    }
}
