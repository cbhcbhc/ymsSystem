package com.ymsd.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 548778541081941247L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 1：外卖    0：自取
     */
    private Integer otype;
    /**
     * 订单流水号
     */
    private String onumber;
    /**
     * 关联用户表id
     */
    private Long uid;
    /**
     * 订单价格
     */
    private String oprice;
    /**
     * 支付状态 0:未支付   1：已经支付
     */
    private Integer paystate;
    /**
     * 支付时间
     */
    private String otime;
    /**
     * 订单状态：0：正常  1：禁用
     */
    private Integer ostate;

    private List<Product> products;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> product) {
        this.products = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOtype() {
        return otype;
    }

    public void setOtype(Integer otype) {
        this.otype = otype;
    }

    public String getOnumber() {
        return onumber;
    }

    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getOprice() {
        return oprice;
    }

    public void setOprice(String oprice) {
        this.oprice = oprice;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public Integer getOstate() {
        return ostate;
    }

    public void setOstate(Integer ostate) {
        this.ostate = ostate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", otype=" + otype +
                ", onumber='" + onumber + '\'' +
                ", uid=" + uid +
                ", oprice='" + oprice + '\'' +
                ", paystate=" + paystate +
                ", otime='" + otime + '\'' +
                ", ostate=" + ostate +
                ", products=" + products +
                '}';
    }
}

