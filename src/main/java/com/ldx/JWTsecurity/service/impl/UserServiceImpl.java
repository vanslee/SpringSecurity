package com.ldx.JWTsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.JWTsecurity.mapper.MenuMapper;
//import com.ldx.JWTsecurity.pojo.CustomUserDetails;
import com.ldx.JWTsecurity.pojo.CustomUserDetails;
import com.ldx.JWTsecurity.pojo.User;
import com.ldx.JWTsecurity.service.UserService;
import com.ldx.JWTsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
* @author ldx
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2022-06-15 11:59:20
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService, UserDetailsService {
    // 重写该方法是为了使用自己的数据查询登录用户信息
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    // 重写该方法就不会使用SpringSecurity提供的默认密码
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, username));
        // 未查询到用户
            if(Objects.isNull(user)){
                // 该异常会被ExceptionTranslationFilter捕获到
                throw new RuntimeException("用户名或密码错误");
        }
            // 查询到用户
        // 1.把数据封装成UserDetails返回

        // TODO 查询用户对应的权限信息
        List<String> permissions = new ArrayList<>(menuMapper.selectPermsByUserId(user.getId()));

        return new CustomUserDetails(user,permissions);
    }
}




