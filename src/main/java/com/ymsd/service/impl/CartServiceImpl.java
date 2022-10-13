package com.ymsd.service.impl;

import com.ymsd.entity.Cart;
import com.ymsd.dao.CartDao;
import com.ymsd.entity.User;
import com.ymsd.service.CartService;
import com.ymsd.util.ResponseCode;
import com.ymsd.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cart)表服务实现类
 *
 * @author makejava
 * @since 2022-06-26  10:25:29
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Resource
    private CartDao cartDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cart queryById(Long id) {
        return this.cartDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cart 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Cart> queryByPage(Cart cart, PageRequest pageRequest) {
        long total = this.cartDao.count(cart);
        return new PageImpl<>(this.cartDao.queryAllByLimit(cart, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart insert(Cart cart) {
        this.cartDao.insert(cart);
        return cart;
    }

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart update(Cart cart) {
        this.cartDao.update(cart);
        return this.queryById(cart.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.cartDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData addCart(Cart cart, String token) {
        //1.根据token，查询用户id
        User user = cartDao.queryIdByToken(token);
        if(user==null){
            return new ResponseData(ResponseCode.ERROR_6);
        }
        try {
            //2.跟新cart的uid
            cart.setUid(user.getId());

            //3.校验是否已经存在与购物车  根据传入的商品id 和用户id 进行查询(购物车表)
            Long count = cartDao.queryCount(user.getId(), cart.getPid());
            System.out.println("count = "+count);
            if(count>=1){
                return new ResponseData(ResponseCode.ERROR_5);
            }
            //4.执行保存操作
            cartDao.insert(cart);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("执行购物车报错报错"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData queryCartInfo(String token) {
        try {
            //1.根据token获取用户信息
            User user = cartDao.queryIdByToken(token);
            if(user==null){
                return new ResponseData(ResponseCode.ERROR_6);
            }
            //2.根据用户id获取购物车信息   一个购物车对应多个商品，一对多
            List<Cart> carts = cartDao.queryCartByUid(user.getId());
            return new ResponseData(ResponseCode.SUCCESS,carts);
        }catch (Exception e){
            System.out.println("获取购物车信息报错，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    @Override
    public ResponseData deleteCart(String token, Long id) {
        try {
            //1.根据token获取用户信息
            User user = cartDao.queryIdByToken(token);
            if(user==null){
                return new ResponseData(ResponseCode.ERROR_6);
            }
            //2.根据用户id和cart id删除购物车信息
            cartDao.deleteCart(id,user.getId());
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("删除购物车失败"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData changeNumber(String cmd,String token, Long id) {
        try {
            //1.根据token获取用户信息
            User user = cartDao.queryIdByToken(token);
            if(user==null){
                return new ResponseData(ResponseCode.ERROR_6);
            }
            Cart cart = cartDao.queryById(id);
            if(cmd!=null&&"add".equals(cmd)){
                cart.setNumber(cart.getNumber()+1);
            }else{
                Integer number = cart.getNumber()-1;
                if(number<=0){
                    return new ResponseData(ResponseCode.SUCCESS);
                }
                cart.setNumber(number);
            }
            cartDao.update(cart);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("删除购物车失败"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }
}
