package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonConstant;
import com.blessing.aisaka.dao.IUserDao;
import com.blessing.aisaka.entity.User;
import com.blessing.aisaka.service.IUserService;
import com.blessing.aisaka.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */
@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userDao.queryUserByName(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }
        return userDetails;
    }

    @Override
    public JSONObject addStudentAccount(User student) {
        if (student != null) {
            User user = userDao.queryUserByName(student.getUsername());
            if (user != null) {
                return JsonUtil.buildJson(JsonConstant.FAIL, "该用户已经存在");
            } else {
                student.setAdmin(false);
                if (userDao.insertAccount(student) == 1) {
                    return JsonUtil.buildJson(JsonConstant.SUCCESS, "成功");
                }
            }
        }
        return JsonUtil.buildJson(JsonConstant.FAIL, "操作失败");
    }

    @Override
    public List<User> queryAllStudent() {
        return userDao.queryAllStudent();
    }

    @Override
    public User queryStudentById(Integer id) {
        return userDao.queryStudentById(id);
    }

    @Override
    public User queryStudentByName(String username){
        return userDao.queryUserByName(username);
    }
}
