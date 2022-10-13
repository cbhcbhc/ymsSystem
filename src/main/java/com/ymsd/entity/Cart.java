package com.ymsd.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2022-06-26  10:25:20
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = 658294031182705809L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 关联用户id
     */
    private Long uid;
    /**
     * 关联产品id
     */
    private Long pid;
    /**
     * 产品数量
     */
    private Integer number;

    private Product product;

    private double tprice; //单价


    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", uid=" + uid +
                ", pid=" + pid +
                ", number=" + number +
                ", product=" + product +
                ", tprice=" + tprice +
                '}';
    }

}

