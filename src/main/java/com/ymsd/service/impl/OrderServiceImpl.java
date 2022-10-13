package com.ymsd.service.impl;

import com.ymsd.dao.CartDao;
import com.ymsd.dao.ProductorderDao;
import com.ymsd.dao.UserDao;
import com.ymsd.entity.Cart;
import com.ymsd.entity.Order;
import com.ymsd.dao.OrderDao;
import com.ymsd.entity.Productorder;
import com.ymsd.entity.User;
import com.ymsd.service.OrderService;
import com.ymsd.util.ResponseCode;
import com.ymsd.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private CartDao cartDao;

    @Resource
    private ProductorderDao productorderDao;

    @Resource
    private UserDao userDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Long id) {
        return this.orderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Order> queryByPage(Order order, PageRequest pageRequest) {
        long total = this.orderDao.count(order);
        return null;
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.orderDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData addOrder(String token) {
        //1.根据token获取用户信息
        User user = cartDao.queryIdByToken(token);
        if(user==null){
            return new ResponseData(ResponseCode.ERROR_6);
        }
        try{
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //2.根据用户id，获取目前购物车信息
            List<Cart> carts = cartDao.queryCartByUid(user.getId());
            //3.生成订单，准备订单信息
            double totlePrice = createOrder(carts, user.getId(), uuid);
            //4.生成产品、订单中间表   通过流水号进行关联
            createProductOrder(carts,uuid);
            //5.清除购物车数据  根据用户id删除
            cartDao.deleteCartByUid(user.getId());
            //6.修改积分
            user.setUintegral(user.getUintegral()+totlePrice);
            userDao.update(user);

            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("生成订单失败，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData queryOrder(String token, String ostate) {
        try{
            //1.根据token获取用户信息
            User user = cartDao.queryIdByToken(token);
            if(user==null){
                return new ResponseData(ResponseCode.ERROR_6);
            }
            //2.根据uid和ostate获取信息
            List<Order> orders = orderDao.queryOrderInfo(user.getId(), ostate);
            return new ResponseData(ResponseCode.SUCCESS,orders);
        }catch (Exception e){
            System.out.println("获取订单信息失败"+e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }


    @Override
    public ResponseData queryAllOrder(int page, int limit,String ostate) {
        Order order = new Order();

        int start = (page-1)*limit;
        try {

            if(ostate!=null&&!"".equals(ostate)){

            }

            //1.查询数据
            List<Order> orders = orderDao.queryAllByLimit(start, limit,ostate);
            //2.获取总条数
            long count = orderDao.count(order);
            return new ResponseData(ResponseCode.SUCCESS,orders,count);
        }catch (Exception e){
            System.out.println("分页获取订单信息失败,"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData updateOrderInfo(Order order) {
        try {
            orderDao.update(order);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("跟新订单信息失败,"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData deleteOrderInfo(Long id) {
        try {
            orderDao.deleteById(id);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("跟新订单信息失败,"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 生成产品、订单中间表
     * @param carts
     */
    public void createProductOrder(List<Cart> carts,String uuid){
        List<Productorder> list = new ArrayList<>();
        for (int i=0;i<carts.size();i++){
            Cart cart = carts.get(i);
            Productorder po = new Productorder();
            po.setNumber(cart.getNumber());
            po.setOid(uuid); //需要修改
            po.setPid(cart.getPid());
            po.setPrice(String.valueOf(cart.getTprice()));
            list.add(po);
        }
        //插入数据(批量)
        productorderDao.insertBatch(list);
    }

    /**
     * 生产订单
     * @param carts
     * @param uid
     */
    public double createOrder(List<Cart> carts,Long uid,String uuid){
        Order order = new Order();
        order.setOtype(0); //自取
        order.setUid(uid);
        order.setPaystate(1);//已支付
        order.setOstate(0);  //预定中
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOtime(sdf.format(new Date()));
        double totlePrice = 0.0;
        for (int i=0;i<carts.size();i++){
            Cart cart = carts.get(i);
            totlePrice += cart.getNumber()*cart.getTprice();
            System.out.println("总价格未："+totlePrice);
        }
        order.setOnumber(uuid);  //订单流水号
        order.setOprice(String.valueOf(totlePrice)); //该订单的总价格

        orderDao.insert(order);
        return totlePrice;
    }
}
