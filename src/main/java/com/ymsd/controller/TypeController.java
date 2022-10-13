package com.ymsd.controller;

import com.ymsd.entity.Type;
import com.ymsd.service.TypeService;
import com.ymsd.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Type)表控制层
 *
 * @author makejava
 * @since 2022-06-26  10:25:32
 */
@Api(tags = "类型接口")
@RestController
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;


    @ApiOperation(value = "getTypes",notes = "获取所有的分类信息")
    @GetMapping("getTypes")
    public ResponseData getTypes(String state){
        System.out.println("获取所有的分类信息");
        return typeService.queryAll(state);
    }

    @GetMapping("deleteTypeById")
    @ApiOperation(value = "deleteTypeById",notes = "根据id删除分类信息")
    public ResponseData deleteTypeById(Long id){
        System.out.println("根据id删除分类信息，"+id);
        return typeService.deleteTypeById(id);
    }

    @PostMapping("updateTypeInfo")
    @ApiOperation(value = "updateTypeInfo",notes = "跟新商品分类信息")
    public ResponseData updateTypeInfo(Type type){
        System.out.println("跟新商品分类信息,"+type);
        return typeService.updateTypeInfo(type);
    }

    @PostMapping("addType")
    @ApiOperation(value = "addType",notes = "新增商品分类信息")
    public ResponseData addType(Type type){
        System.out.println("新增商品分类信息,"+type);
        return typeService.addType(type);
    }
}

