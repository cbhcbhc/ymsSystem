package com.ymsd.entity;

import java.io.Serializable;

/**
 * (Sysuser)实体类
 *
 * @author makejava
 * @since 2022-03-09 11:52:25
 */
public class Sysuser implements Serializable {
    private static final long serialVersionUID = 189241405352145853L;
    /**
     * ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 加密密码
     */
    private String password;
    /**
     * 用户状态
     */
    private Integer state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}

