package com.ymsd.controller;

import com.ymsd.entity.Cart;
import com.ymsd.service.CartService;
import com.ymsd.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Cart)表控制层
 *
 * @author makejava
 * @since 2022-06-26  10:25:20
 */
@Api(tags = "购物车接口")
@RestController
@RequestMapping("cart")
public class CartController {
    /**
     * 服务对象
     */
    @Resource
    private CartService cartService;


    @ApiOperation(value = "addCart",notes = "商品添加到购物车")
    @GetMapping("addCart")
    public ResponseData addCart(Cart cart,String token){
        System.out.println("cart = "+cart);
        System.out.println("token = "+token);
        return cartService.addCart(cart,token);
    }

    @GetMapping("queryCartInfo")
    @ApiOperation(value = "queryCartInfo",notes = "获取用户的购物车信息")
    public ResponseData queryCartInfo(String token){
        System.out.println("获取用户的购物车信息,"+token);
        return cartService.queryCartInfo(token);
    }

    @GetMapping("deleteCart")
    @ApiOperation(value = "deleteCart",notes = "删除用户购物车信息")
    public ResponseData deleteCart(String token,Long id){
        System.out.println("删除用户的购物车信息,"+token);
        System.out.println("删除用户的购物车信息,"+id);
        return cartService.deleteCart(token,id);
    }

    @GetMapping("changeNumber")
    @ApiOperation(value = "changeNumber",notes = "改变数量")
    public ResponseData changeNumber(String cmd,String token,Long id){
        System.out.println("改变用户的购物车信息,"+token);
        System.out.println("改变用户的购物车信息,"+id);
        return cartService.changeNumber(cmd,token,id);
    }
}

