package com.ldx.JWTsecurity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.JWTsecurity.pojo.Menu;
import com.ldx.JWTsecurity.service.MenuService;
import com.ldx.JWTsecurity.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【sys_menu】的数据库操作Service实现
* @createDate 2022-06-15 20:28:16
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




