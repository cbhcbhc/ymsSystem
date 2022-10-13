package com.ymsd.service;

import com.ymsd.entity.Cart;
import com.ymsd.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Cart)表服务接口
 *
 * @author makejava
 * @since 2022-06-26  10:25:29
 */
public interface CartService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cart queryById(Long id);

    /**
     * 分页查询
     *
     * @param cart 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Cart> queryByPage(Cart cart, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    Cart insert(Cart cart);

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    Cart update(Cart cart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 添加购物车信息
     * @param cart
     * @param token
     * @return
     */
    ResponseData addCart(Cart cart, String token);

    /**
     * 根据用户token获取购物车信息
     * @param token
     * @return
     */
    ResponseData queryCartInfo(String token);

    /**
     * 根据用户token删除购物车信息
     * @param token
     * @param id
     * @return
     */
    ResponseData deleteCart(String token,Long id);

    /**
     * 改变数量
     * @param token
     * @param id
     * @return
     */
    ResponseData changeNumber(String cmd,String token,Long id);
}
