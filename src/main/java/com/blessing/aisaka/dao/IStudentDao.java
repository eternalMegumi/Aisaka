package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */

@Repository
@Mapper
public interface IStudentDao {
    Student queryStudentById(@Param("id") String id);
}

