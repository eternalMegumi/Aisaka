package com.blessing.aisaka.service;

import com.blessing.aisaka.dao.IMaterialDao;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Material;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
public interface IMaterialService {

    Material queryMaterialById(Integer id);

    List<Material> queryMaterialByCourse(Course course);
}
