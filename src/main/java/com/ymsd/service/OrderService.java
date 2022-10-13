package com.ymsd.service;

import com.ymsd.entity.Order;
import com.ymsd.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(Long id);

    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Order> queryByPage(Order order, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据用户token生成订单
     * @param token
     * @return
     */
    ResponseData addOrder(String token);

    /**
     * 根据token和订单状态获取用户订单信息
     * @param token
     * @param ostate
     * @return
     */
    ResponseData queryOrder(String token,String ostate);

    ResponseData queryAllOrder(int page,int limit,String ostate);

    /**
     * 跟新订单信息
     * @param order
     * @return
     */
    ResponseData updateOrderInfo(Order order);

    /**
     * 根据id删除订单信息
     * @param id
     * @return
     */
    ResponseData deleteOrderInfo(Long id);
}
