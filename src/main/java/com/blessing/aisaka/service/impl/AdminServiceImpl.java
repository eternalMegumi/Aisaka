package com.blessing.aisaka.service.impl;

import com.blessing.aisaka.dao.IAdminDao;
import com.blessing.aisaka.domain.Admin;
import com.blessing.aisaka.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author zhou.peng
 * @date 2019.03.08
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    IAdminDao iAdminDao;

    @Override
    public List<Admin> queryAll() {
        return iAdminDao.queryAll();
    }
}
