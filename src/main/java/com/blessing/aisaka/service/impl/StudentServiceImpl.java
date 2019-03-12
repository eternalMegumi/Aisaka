package com.blessing.aisaka.service.impl;

import com.blessing.aisaka.dao.IStudentDao;
import com.blessing.aisaka.entity.Student;
import com.blessing.aisaka.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Override
    public Student queryStudentById(String id) {
        return studentDao.queryStudentById(id);
    }
}
