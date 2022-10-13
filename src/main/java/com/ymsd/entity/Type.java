package com.ymsd.entity;

import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author makejava
 * @since 2022-06-26 10:25:32
 */
public class Type implements Serializable {
    private static final long serialVersionUID = 123742188234799913L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 类型名称
     */
    private String typename;
    /**
     * 类型图片路径
     */
    private String timageurl;
    /**
     * 1:可用    0：禁用
     */
    private Integer tstate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTimageurl() {
        return timageurl;
    }

    public void setTimageurl(String timageurl) {
        this.timageurl = timageurl;
    }

    public Integer getTstate() {
        return tstate;
    }

    public void setTstate(Integer tstate) {
        this.tstate = tstate;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", timageurl='" + timageurl + '\'' +
                ", tstate=" + tstate +
                '}';
    }
}

