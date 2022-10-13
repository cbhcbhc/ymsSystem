package com.ymsd.controller;

import com.ymsd.entity.Image;
import com.ymsd.service.ImageService;
import com.ymsd.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Image)表控制层
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
@Api(tags = "图片接口")
@RestController
@RequestMapping("image")
public class ImageController {
    /**
     * 服务对象
     */
    @Resource
    private ImageService imageService;

    @ApiOperation("根据图片类型获取图片信息，如 1：欢迎界面轮播图")
    @GetMapping("queryImageByType")
    public ResponseData queryImageByType(String imageType){
        System.out.println("根据图片类型获取图片信息，图片类型 = "+imageType);
        return imageService.queryImageByType(imageType);
    }

    @GetMapping("queryAllImages")
    @ApiOperation(value = "queryAllImages",notes = "分页获取图片信息")
    public ResponseData queryAllImages(int page,int limit){
        System.out.println("获取所有的图片信息,page = "+page+",limit = "+limit);
        return imageService.queryAllImages(page,limit);
    }

    @GetMapping("deleteImageById")
    @ApiOperation(value = "deleteImageById",notes = "根据id删除图片信息")
    public ResponseData deleteImageById(Long id){
        System.out.println("根据id删除图片信息,"+id);
        return imageService.deleteImageById(id);
    }

    @PostMapping("updateImageInfo")
    @ApiOperation(value = "updateImageInfo",notes = "跟新图片信息")
    public ResponseData updateImageInfo(Image image){
        System.out.println("跟新图片信息，image = "+image);
        return imageService.updateImageInfo(image);
    }

    @PostMapping("addImage")
    @ApiOperation(value = "addImage",notes = "新增图片信息")
    public ResponseData addImage(Image image){
        System.out.println("新增图片信息，"+image);
        return imageService.addImage(image);
    }
}

