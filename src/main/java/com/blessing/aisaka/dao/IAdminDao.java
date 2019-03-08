package com.blessing.aisaka.dao;

import com.blessing.aisaka.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    @Select("SELECT id,name,password FROM admin")
    List<Admin> queryAllAdmins();

    @Select("SELECT id,name,password FROM admin WHERE id=#{id} LIMIT 1")
    Admin queryAdminById(@Param("id") String id);

    @Select("SELECT id,name,password FROM admin WHERE name=#{name} LIMIT 1")
    Admin quertAdminByName(@Param("name") String name);
}
