package com.ldx.JWTsecurity.mapper;

import com.ldx.JWTsecurity.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ldx
 * @description 针对表【sys_menu】的数据库操作Mapper
 * @createDate 2022-06-15 20:28:16
 * @Entity com.ldx.JWTsecurity.pojo.Menu
 */
public interface MenuMapper extends BaseMapper<Menu> {
    @Select("SELECT DISTINCT m.perms" +
            " FROM sys_user_role  ur" +
            " left JOIN sys_role r ON" +
            " ur.role_id = r.id" +
            " LEFT JOIN sys_role_menu rm ON ur.role_id = rm.role_id" +
            " LEFT JOIN sys_menu m on m.id = rm.menu_id" +
            " WHERE " +
            " user_id = #{id}" +
            " and r.`status` = 0" +
            " and m.`status` = 0")
    List<String> selectPermsByUserId(Long id);
}




