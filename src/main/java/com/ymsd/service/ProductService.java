package com.ymsd.service;

import com.ymsd.entity.Product;
import com.ymsd.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Product)表服务接口
 *
 * @author makejava
 * @since 2022-06-26  10:25:32
 */
public interface ProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Long id);

    /**
     * 分页查询
     *
     * @param product 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Product> queryByPage(Product product, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product update(Product product);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据类型id获取产品信息
     * @param id
     * @return
     */
    ResponseData queryProductByType(Long id);

    /**
     * 分页获取商品信息
     * @param page
     * @param limit
     * @return
     */
    ResponseData queryProductByLimit(int page,int limit);

    /**
     * 跟新产品信息
     * @param product
     * @return
     */
    ResponseData updateProductInfo(Product product);

    /**
     * 根据产品id删除产品信息
     * @param id
     * @return
     */
    ResponseData deleteProductInfoById(Long id);

    /**
     * 新增产品信息
     * @param product
     * @return
     */
    ResponseData addProduct(Product product);
}
