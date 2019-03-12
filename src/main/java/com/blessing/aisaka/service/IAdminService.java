package com.blessing.aisaka.service;

import com.blessing.aisaka.entity.Admin;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019.03.08
 */
public interface IAdminService {
    List<Admin> queryAllAdmins();

    Admin queryAdminById(String id);
}
