package com.ymsd.service;

import com.ymsd.entity.User;
import com.ymsd.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-06-26  10:25:32
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    /**
     * 注册用户
     * @param user
     * @return
     */
    ResponseData registerUtell(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    ResponseData userLogin(User user);

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    ResponseData queryUserInfo(String token);

    /**
     * 分页获取用户信息
     * @param page
     * @param limit
     * @return
     */
    ResponseData queryUserInfos(int page,int limit);

    /**
     * 跟新用户信息
     * @param user
     * @return
     */
    ResponseData updateUserInfo(User user);

    /**
     * 根据用户id删除用户信息
     * @param id
     * @return
     */
    ResponseData deleteUserInfoById(Long id);
}
