package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.JsonStatus;
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
    IUserDao userDao;

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
        JSONObject result = null;
        if (student != null) {
            User user = userDao.queryUserByName(student.getUsername());
            if (user != null) {
                result = JsonUtil.buildJson(JsonStatus.FAIL, "该用户已经存在");
            } else {
                student.setAdmin(false);
                int status = userDao.insertAccount(student);
                if (status == 1) {
                    result = JsonUtil.buildJson(JsonStatus.SUCCESS, "创建成功");
                } else {
                    result = JsonUtil.buildJson(JsonStatus.FAIL, "操作失败");
                }
            }
        }
        return result;
    }

    @Override
    public List<User> queryAllStudent() {
        return userDao.queryAllStudent();
    }
}
