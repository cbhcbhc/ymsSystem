package com.ymsd.service.impl;

import com.ymsd.entity.User;
import com.ymsd.dao.UserDao;
import com.ymsd.service.UserService;
import com.ymsd.util.ResponseCode;
import com.ymsd.util.ResponseData;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-06-26  10:25:32
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public ResponseData registerUtell(User user) {
        String utell = user.getUtell();   //手机号
        String upwd = user.getUpwd();     //密码
        //1.基本的非空校验
        if(utell==null||"".equals(utell)){
            return new ResponseData(ResponseCode.ERROR_1);
        }
        if(upwd==null||"".equals(upwd)){
            return new ResponseData(ResponseCode.ERROR_2);
        }

        //2.校验手机号是否已经注册  先根据手机号查询数据
        User userByUtell = userDao.queryUserByUtell(utell);
        if(userByUtell!=null){
            return new ResponseData(ResponseCode.ERROR_3);
        }

        try{
            //3.密码加密
            Md5Hash md5Hash = new Md5Hash(upwd,"itsource",10);
            String newPwd = md5Hash.toString();
            user.setUpwd(newPwd);
            //jurisdiction
            if("2".equals(user.getJurisdiction())){
                user.setJurisdiction("管理员");
            }else{
                user.setJurisdiction("普通用户");
            }
            //4.保存用户
            user.setUrole("普通会员");
            user.setUstate(1);
            user.setUintegral(0.0);
            userDao.insert(user);
        }catch (Exception e){
            System.out.println("保存用户信息失败，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
        return new ResponseData(ResponseCode.SUCCESS);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public ResponseData userLogin(User user) {
       //1.非空校验
        String upwd = user.getUpwd();
        String utell = user.getUtell();
        String token = null;
        if(utell==null||"".equals(utell)){
            return new ResponseData(ResponseCode.ERROR_1);
        }
        if(upwd==null||"".equals(upwd)){
            return new ResponseData(ResponseCode.ERROR_2);
        }
        try{
            //2.密码加密
            Md5Hash md5Hash = new Md5Hash(upwd,"itsource",10);
            String newPwd = md5Hash.toString();

            //3.通过手机号密码查询用户，如果能查询到，说明匹配
            User userByQuery = userDao.queryUserByPWD(utell, newPwd);
            if(userByQuery==null){
                return new ResponseData(ResponseCode.ERROR_4);
            }
            if(userByQuery.getUstate()==0){
                return new ResponseData(ResponseCode.ERROR_7);
            }
            //4.生成token令牌
            token = new Md5Hash(utell,"itsource",10).toString();

            //5.跟新token令牌(根据手机号，把token保存在数据表)
            userByQuery.setToken(token);
            userDao.update(userByQuery);//跟新

            //说明是管理端登录
            if (user.getJurisdiction()!=null&&!"".equals(user.getJurisdiction())&&"管理员".equals(user.getJurisdiction())){
                if(!userByQuery.getJurisdiction().equals("管理员")){   //说明查询出来的用户不是管理员
                    return new ResponseData(ResponseCode.ERROR_8);
                }
            }
        }catch (Exception e){
            System.out.println("登录功能报错，"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
        return new ResponseData(ResponseCode.SUCCESS,token);
    }

    @Override
    public ResponseData queryUserInfo(String token) {
        try{
            User user = userDao.queryUserByToken(token);
            return new ResponseData(ResponseCode.SUCCESS,user);
        }catch (Exception e){
            System.out.println("获取用户信息失败"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData queryUserInfos(int page, int limit) {
        //page  当前第几页   limit 每页多少条
        int start = (page-1)*limit;
        try {
            //1.获取用户信息
            List<User> users = userDao.queryUserByLimit(start, limit);
            System.out.println("users = "+users);
            //2.获取总共多少条数据
            Long count = userDao.queryCount();
            return new ResponseData(ResponseCode.SUCCESS,users,count);
        }catch (Exception e){
            System.out.println("分页获取用户信息失败,"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData updateUserInfo(User user) {
        try {
            userDao.update(user);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("跟新用户信息失败"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData deleteUserInfoById(Long id) {
        try {
            userDao.deleteById(id);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println("删除用户信息失败"+e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }
}
