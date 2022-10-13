package com.ymsd.service;

import com.ymsd.entity.Image;
import com.ymsd.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Image)表服务接口
 *
 * @author makejava
 * @since 2022-06-26  10:25:31
 */
public interface ImageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Image queryById(Long id);

    /**
     * 分页查询
     *
     * @param image 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Image> queryByPage(Image image, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    Image insert(Image image);

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    Image update(Image image);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    /**
     * 根据图片类型获取图片信息
     * @param imageType
     * @return
     */
    ResponseData queryImageByType(String imageType);

    /**
     * 获取所有图片信息
     * @return
     */
    ResponseData queryAllImages(int page,int limit);

    /**
     * 根据id删除图片信息
     * @param id
     * @return
     */
    ResponseData deleteImageById(Long id);

    /**
     * 跟新图片信息
     * @param image
     * @return
     */
    ResponseData updateImageInfo(Image image);

    /**
     * 新增图片信息
     * @param image
     * @return
     */
    ResponseData addImage(Image image);
}
