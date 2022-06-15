package com.ldx.JWTsecurity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
public class Menu implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 菜单状态(0正常,1禁用)
     */
    private String visible;

    /**
     * 菜单状态(0正常,1停用)
     */
    private String status;

    /**
     * 权限标识
     */
    private String perms;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}