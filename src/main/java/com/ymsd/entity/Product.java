package com.ymsd.entity;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 728108821529074249L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 产品名称
     */
    private String pname;
    /**
     * 关联类型表id
     */
    private Long typeid;
    /**
     * 产品原价
     */
    private Object tprice;
    /**
     * 产品介绍
     */
    private String tintroduce;
    /**
     * 图片路径
     */
    private String pimageurl;
    /**
     * 1:可做热饮    0：不可做热饮
     */
    private Integer photstate;
    /**
     * 折扣：0-1之间的小数
     */
    private Object pdiscount;
    /**
     * 1:可用    0：禁用
     */
    private Integer pstate;

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public Object getTprice() {
        return tprice;
    }

    public void setTprice(Object tprice) {
        this.tprice = tprice;
    }

    public String getTintroduce() {
        return tintroduce;
    }

    public void setTintroduce(String tintroduce) {
        this.tintroduce = tintroduce;
    }

    public String getPimageurl() {
        return pimageurl;
    }

    public void setPimageurl(String pimageurl) {
        this.pimageurl = pimageurl;
    }

    public Integer getPhotstate() {
        return photstate;
    }

    public void setPhotstate(Integer photstate) {
        this.photstate = photstate;
    }

    public Object getPdiscount() {
        return pdiscount;
    }

    public void setPdiscount(Object pdiscount) {
        this.pdiscount = pdiscount;
    }

    public Integer getPstate() {
        return pstate;
    }

    public void setPstate(Integer pstate) {
        this.pstate = pstate;
    }

}

