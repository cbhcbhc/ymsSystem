package com.ymsd.controller;

import com.ymsd.entity.Order;
import com.ymsd.service.OrderService;
import com.ymsd.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @ApiOperation(value = "addOrder",notes = "根据用户token信息生成订单")
    @GetMapping("addOrder")
    public ResponseData addOrder(String token){
        System.out.println("根据用户token信息生成订单，"+token);
        return orderService.addOrder(token);
    }

    @ApiOperation(value = "queryOrder",notes = "根据订单状态获取该用户对应的订单信息")
    @GetMapping("queryOrder")
    public ResponseData queryOrder(String token,String ostate){
        System.out.println("token = "+token);
        System.out.println("ostate = "+ostate);
        return orderService.queryOrder(token,ostate);
    }

    @GetMapping("queryAllOrder")
    @ApiOperation(value = "queryAllOrder",notes = "分页获取订单信息")
    public ResponseData queryAllOrder(int page,int limit,String ostate){
        System.out.println("分页获取所有用户订单信息page = "+page+",limit"+limit+",ostate = "+ostate);
        return orderService.queryAllOrder(page,limit,ostate);
    }

    @PostMapping("updateOrderInfo")
    @ApiOperation(value = "updateOrderInfo",notes = "跟新订单信息")
    public ResponseData updateOrderInfo(Order order){
        System.out.println("跟新订单信息,"+order);
        return orderService.updateOrderInfo(order);
    }

    @GetMapping("deleteOrderInfo")
    @ApiOperation(value = "deleteOrderInfo",notes = "根据id删除订单信息")
    public ResponseData deleteOrderInfo(Long id){
        System.out.println("根据id删除订单信息,"+id);
        return orderService.deleteOrderInfo(id);
    }
}

