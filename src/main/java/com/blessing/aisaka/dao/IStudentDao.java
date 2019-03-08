package com.blessing.aisaka.dao;

import com.blessing.aisaka.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */

@Mapper
public interface IStudentDao {
    Student queryStudentById(@Param("id") String id);
}
