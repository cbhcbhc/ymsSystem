package com.ymsd.service.impl;

import com.ymsd.entity.Type;
import com.ymsd.dao.TypeDao;
import com.ymsd.service.TypeService;
import com.ymsd.util.ResponseCode;
import com.ymsd.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Type)表服务实现类
 *
 * @author makejava
 * @since 2022-06-26  10:25:32
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Type queryById(Long id) {
        return this.typeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param type 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Type> queryByPage(Type type, PageRequest pageRequest) {
        long total = this.typeDao.count(type);
        return new PageImpl<>(this.typeDao.queryAllByLimit(type, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type insert(Type type) {
        this.typeDao.insert(type);
        return type;
    }

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type update(Type type) {
        this.typeDao.update(type);
        return this.queryById(type.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.typeDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData queryAll(String state) {
        try{
            Type type = new Type();
            if(state!=null&&!"".equals(state)){
                type.setTstate(Integer.valueOf(state));
            }
            List<Type> types = typeDao.queryAll(type);
            System.out.println("types = "+types);
            return new ResponseData(ResponseCode.SUCCESS,types);
        }catch (Exception e){
            System.out.println("获取分类信息报错，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData deleteTypeById(Long id) {

        try {

            typeDao.deleteById(id);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("根据id删除分类信息失败,"+e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    @Override
    public ResponseData updateTypeInfo(Type type) {
        try {

            typeDao.update(type);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("跟新商品分类信息失败,"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData addType(Type type) {
        try {
            type.setTstate(1);
            typeDao.insert(type);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("新增商品分类信息失败,"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }
}
