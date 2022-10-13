package com.ymsd.service.impl;

import com.ymsd.entity.Product;
import com.ymsd.dao.ProductDao;
import com.ymsd.service.ProductService;
import com.ymsd.util.ResponseCode;
import com.ymsd.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Product)表服务实现类
 *
 * @author makejava
 * @since 2022-06-26  10:25:32
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Long id) {
        return this.productDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param product 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Product> queryByPage(Product product, PageRequest pageRequest) {
        long total = this.productDao.count(product);
        return new PageImpl<>(this.productDao.queryAllByLimit(product, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insert(Product product) {
        this.productDao.insert(product);
        return product;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product update(Product product) {
        this.productDao.update(product);
        return this.queryById(product.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.productDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData queryProductByType(Long id) {
        try{
            List<Product> products = productDao.queryProductByType(id);
            return new ResponseData(ResponseCode.SUCCESS,products);
        }catch (Exception e){
            System.out.println("根据类型id，获取产品信息失败,"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData queryProductByLimit(int page, int limit) {

        try {
            int start = (page-1)*limit;
            //分页获取数据
            List<Product> products = productDao.queryProductByLimit(start, limit);
            //获取总条数
            Long count = productDao.queryCount();
            return new ResponseData(ResponseCode.SUCCESS,products,count);
        }catch (Exception e){
            System.out.println("分页获取产品信息失败"+e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    @Override
    public ResponseData updateProductInfo(Product product) {
        try{
            productDao.update(product);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("跟新产品信息失败，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData deleteProductInfoById(Long id) {
        try {
            productDao.deleteById(id);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("根据产品id删除产品信息失败，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData addProduct(Product product) {

        try {
            product.setPstate(1);
            product.setPstate(1);
            productDao.insert(product);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("新增商品失败，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }


    }
}
