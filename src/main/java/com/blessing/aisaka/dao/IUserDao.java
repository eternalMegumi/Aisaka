package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zhou.peng
 * @date 2019/03/13
 */
@Mapper
@Repository
public interface IUserDao {

    User queryUserByName(@Param("name") String username);

    int insertAccount(User user);
}
