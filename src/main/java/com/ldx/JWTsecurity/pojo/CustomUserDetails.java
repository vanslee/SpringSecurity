package com.ldx.JWTsecurity.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class CustomUserDetails implements UserDetails {
    private User user;
    // 添加权限信息
    private List<String> permissions;

    public CustomUserDetails(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }
    @JSONField(serialize = false)
    private Set<SimpleGrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null){
            return authorities;
        }
        // 实现权限认证需要重写该方法
        // 把permission中的String类型权限封装成SimpleGrantedAuthority对象

        //方法一
//        authorities = new HashSet<>();
//        for (String permission : permissions) {
//            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission);
//            authorities.add(simpleGrantedAuthority);
//        }
//        return authorities;
        //方法二
        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
        return authorities;

    }

    @Override
    public String getPassword() {
        return  user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
