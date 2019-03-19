package com.blessing.aisaka.service.impl;

import com.blessing.aisaka.dao.IMaterialDao;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Material;
import com.blessing.aisaka.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
@Service
public class MaterialServiceImple implements IMaterialService {

    @Autowired
    IMaterialDao materialDao;

    @Override
    public Material queryMaterialById(Integer id) {
        return materialDao.queryMaterialById(id);
    }

    @Override
    public List<Material> queryMaterialByCourse(Course course) {
        return materialDao.queryMaterialByCourse(course);
    }
}
