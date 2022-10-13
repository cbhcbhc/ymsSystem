package com.ymsd.service.impl;

import com.ymsd.entity.Image;
import com.ymsd.dao.ImageDao;
import com.ymsd.service.ImageService;
import com.ymsd.util.ResponseCode;
import com.ymsd.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Image)表服务实现类
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageDao imageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Image queryById(Long id) {
        return this.imageDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param image 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Image> queryByPage(Image image, PageRequest pageRequest) {
        long total = this.imageDao.count(image);
        return  null;
    }

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public Image insert(Image image) {
        this.imageDao.insert(image);
        return image;
    }

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public Image update(Image image) {
        this.imageDao.update(image);
        return this.queryById(image.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.imageDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData queryImageByType(String imageType) {
        try{
            Image image = new Image();
            image.setItype(imageType);
            image.setIstate(1);
            List<Image> images = imageDao.queryAll(image);
            System.out.println("images = "+images);
            return new ResponseData(ResponseCode.SUCCESS,images);
        }catch (Exception e){
            System.out.println("根据图片类型获取图片信息报错，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData queryAllImages(int page,int limit) {

        int start = (page-1)*limit;
        try {
            List<Image> images = imageDao.queryAllByLimit(start, limit);
            //获取总条数
            Long count = imageDao.queryCount();
            return new ResponseData(ResponseCode.SUCCESS,images,count);
        }catch (Exception e){
            System.out.println("分页获取图片信息失败，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    @Override
    public ResponseData deleteImageById(Long id) {

        try {
            imageDao.deleteById(id);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("删除图片信息失败");
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData updateImageInfo(Image image) {
        try {
            imageDao.update(image);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("跟新图片信息失败，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData addImage(Image image) {
        try {
            image.setIstate(1);
            imageDao.insert(image);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            return new ResponseData(ResponseCode.FAIL);
        }
    }
}
