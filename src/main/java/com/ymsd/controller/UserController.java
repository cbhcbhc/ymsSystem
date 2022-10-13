package com.ymsd.controller;

import com.ymsd.entity.User;
import com.ymsd.service.UserService;
import com.ymsd.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-06-26  10:25:32
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @ApiOperation(value = "registerUtell",notes = "注册用户接口")
    @PostMapping("registerUtell")
    public ResponseData registerUtell(User user){
        System.out.println("注册用户接口，user = "+user);
        return userService.registerUtell(user);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @ApiOperation(value = "userLogin",notes = "用户登录接口")
    @PostMapping("userLogin")
    public ResponseData userLogin(User user){
        System.out.println("登录接口，user = "+user);
        return userService.userLogin(user);
    }

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    @ApiOperation(value = "queryUserInfo",notes = "根据token获取用户信息")
    @GetMapping("queryUserInfo")
    public ResponseData queryUserInfo(String token){
        System.out.println("根据token获取用户信息,"+token);
        return userService.queryUserInfo(token);
    }

    @GetMapping("queryUserInfos")
    @ApiOperation(value = "queryUserInfos",notes = "分页获取用户信息")
    public ResponseData queryUserInfos(int page,int limit){
        System.out.println("分页获取用户信息,page="+page+"limit = "+limit);
        return userService.queryUserInfos(page,limit);
    }

    @PostMapping("updateUserInfo")
    @ApiOperation(value = "updateUserInfo",notes = "跟新用户信息")
    public ResponseData updateUserInfo(User user){
        System.out.println("跟新用户信息,user = "+user);
        return userService.updateUserInfo(user);
    }

    @GetMapping("deleteUserInfoById")
    @ApiOperation(value = "deleteUserInfoById",notes = "根据用户id删除用户")
    public ResponseData deleteUserInfoById(Long id){
        System.out.println("根据用户id删除用户,id = "+id);
        return userService.deleteUserInfoById(id);
    }

    @PostMapping("userLoginSys")
    @ApiOperation(value = "userLoginSys",notes = "管理员用户登录")
    public ResponseData userLoginSys(User user){
        System.out.println("user = "+user);
        return null;
    }
}

