package com.ymsd.dao;

import com.ymsd.entity.Productorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Productorder)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-07 11:35:36
 */
@Mapper
public interface ProductorderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Productorder queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param productorder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Productorder> queryAllByLimit(Productorder productorder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param productorder 查询条件
     * @return 总行数
     */
    long count(Productorder productorder);

    /**
     * 新增数据
     *
     * @param productorder 实例对象
     * @return 影响行数
     */
    int insert(Productorder productorder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Productorder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Productorder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Productorder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Productorder> entities);

    /**
     * 修改数据
     *
     * @param productorder 实例对象
     * @return 影响行数
     */
    int update(Productorder productorder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

