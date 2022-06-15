package com.ldx.JWTsecurity;

import com.ldx.JWTsecurity.mapper.MenuMapper;
import com.ldx.JWTsecurity.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Test
    public void test01() {
        userMapper.selectList(null).forEach(System.out::println);
    }
    @Test
    public void test02() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //$2a$10$OkIhjBHyEM.U3ncq0etwrOLWwgSlf51zzQkUCaB8W2f9Z1ga.TH6O
        String loginPassword = bCryptPasswordEncoder.encode("123");
        //$2a$10$r9zIC9VI0yqagfB65o1SWeNweegk5aAOJNbtw0POX2RYl4tLp4WUy
        String loginpassword2 = bCryptPasswordEncoder.encode("123");
        boolean matches1 = bCryptPasswordEncoder.matches( "123","$2a$10$OkIhjBHyEM.U3ncq0etwrOLWwgSlf51zzQkUCaB8W2f9Z1ga.TH6O");
        System.out.println("matches1 = " + (matches1));
        boolean matches = bCryptPasswordEncoder.matches("123","$2a$10$r9zIC9VI0yqagfB65o1SWeNweegk5aAOJNbtw0POX2RYl4tLp4WUy");
        System.out.println("matches = " + (matches));
    }
    @Test
    public void test03() {
        menuMapper.selectPermsByUserId(1L).stream().forEach(System.out::println);
    }
}
