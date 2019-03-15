package com.blessing.aisaka.service;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.User;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/08
 */
public interface IUserService {
    JSONObject addStudentAccount(User student);

    List<User> queryAllStudent();
}
