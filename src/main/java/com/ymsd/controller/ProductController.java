package com.ymsd.controller;

import com.ymsd.entity.Product;
import com.ymsd.service.ProductService;
import com.ymsd.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
@Api(tags = "产品接口")
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    @ApiOperation(value = "productData",notes = "根据类型id获取产品信息")
    @GetMapping("queryProductByType")
    public ResponseData queryProductByType(Long id){
        System.out.println("根据类型id获取产品信息"+id);
        return productService.queryProductByType(id);
    }

    @ApiOperation(value = "queryProductByLimit",notes = "分页获取商品信息")
    @GetMapping("queryProductByLimit")
    public ResponseData queryProductByLimit(int page,int limit){
        System.out.println("分页获取用户信息,page="+page+"limit = "+limit);
        return productService.queryProductByLimit(page,limit);
    }

    @PostMapping("updateProductInfo")
    @ApiOperation(value = "updateProductInfo",notes = "跟新产品信息")
    public ResponseData updateProductInfo(Product product){
        System.out.println("跟新产品信息，"+product);
        return productService.updateProductInfo(product);
    }

    @GetMapping("deleteProductInfoById")
    @ApiOperation(value = "deleteProductInfoById",notes = "根据产品id删除产品信息")
    public ResponseData deleteProductInfoById(Long id){
        System.out.println("根据产品id删除产品信息，id = "+id);
        return productService.deleteProductInfoById(id);
    }

    @PostMapping("addProduct")
    @ApiOperation(value = "addProduct",notes = "添加产品信息")
    public ResponseData addProduct(Product product){
        System.out.println("添加产品信息，"+product);
        return productService.addProduct(product);
    }
}

