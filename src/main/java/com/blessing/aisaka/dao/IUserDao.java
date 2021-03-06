package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/13
 */
@Mapper
@Repository
public interface IUserDao {

    User queryUserByName(String username);

    int insertAccount(User user);

    List<User> queryAllStudent();

    User queryStudentById(Integer id);
}
