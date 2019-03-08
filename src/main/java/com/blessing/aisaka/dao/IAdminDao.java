package com.blessing.aisaka.dao;

import com.blessing.aisaka.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */
@Repository
@Mapper
public interface IAdminDao {
    @Select("SELECT * FROM admin")
    @Results(id = "admin", value = {
            @Result(property = "id", column = "id", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class)
    })
    List<Admin> queryAll();
}
