package com.blessing.aisaka.service.impl;

import com.blessing.aisaka.dao.IAdminDao;
import com.blessing.aisaka.dao.IUserDao;
import com.blessing.aisaka.entity.Admin;
import com.blessing.aisaka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019.03.08
 */
@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    IAdminDao adminDao;
    @Autowired
    IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        UserDetails userDetails = userDao.queryUserByName(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }

        System.out.println();
        return userDetails;
    }

    @Override
    public List<Admin> queryAllAdmins() {
        return adminDao.queryAllAdmins();
    }

    @Override
    public Admin queryAdminById(String id) {
        return adminDao.queryAdminById(id);
    }

}
