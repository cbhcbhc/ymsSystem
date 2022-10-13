package com.ymsd.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-06-26  10:25:32
 */
public class User implements Serializable {
    private static final long serialVersionUID = 567233065766736565L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 用户名
     */
    private String uname;
    /**
     * 加密之后的密码
     */
    private String upwd;
    /**
     * 手机号
     */
    private String utell;
    /**
     * 1:可用    0：禁用
     */
    private Integer ustate;
    /**
     * 会员积分
     */
    private Double uintegral;
    /**
     * 用户角色：普通会员、黄金会员、铂金会员等
     */
    private String urole;

    private String token;

    private String jurisdiction;//用户角色

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUtell() {
        return utell;
    }

    public void setUtell(String utell) {
        this.utell = utell;
    }

    public Integer getUstate() {
        return ustate;
    }

    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }

    public Double getUintegral() {
        return uintegral;
    }

    public void setUintegral(Double uintegral) {
        this.uintegral = uintegral;
    }

    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", utell='" + utell + '\'' +
                ", ustate=" + ustate +
                ", uintegral=" + uintegral +
                ", urole='" + urole + '\'' +
                ", token='" + token + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                '}';
    }
}

