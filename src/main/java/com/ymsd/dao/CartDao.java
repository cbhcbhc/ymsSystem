package com.ymsd.dao;

import com.ymsd.entity.Cart;
import com.ymsd.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Cart)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-26  10:25:20
 */
@Mapper
public interface CartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cart queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param cart 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Cart> queryAllByLimit(Cart cart, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param cart 查询条件
     * @return 总行数
     */
    long count(Cart cart);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 影响行数
     */
    int insert(Cart cart);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cart> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Cart> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cart> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Cart> entities);

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 影响行数
     */
    int update(Cart cart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据token获取用户id
     * @return
     */
    User queryIdByToken(String token);

    Long queryCount(@Param("uid") Long uid,@Param("pid") Long pid);

    /**
     * 根据用户id获取购物车商品信息
     * @param id
     * @return
     */
    List<Cart> queryCartByUid(Long id);

    void deleteCart(@Param("id") Long id,@Param("uid") Long uid);

    /**
     * 根据用户id删除
     * @param uid
     */
    void deleteCartByUid(Long uid);
}

