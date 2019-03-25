package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.dao.IMaterialDao;
import com.blessing.aisaka.entity.Material;
import com.blessing.aisaka.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
@Service
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    IMaterialDao materialDao;

    @Override
    public Material queryMaterialById(Integer id) {
        return materialDao.queryMaterialById(id);
    }

    @Override
    public List<Material> queryMaterialByCourseId(Integer courseId) {
        return materialDao.queryMaterialByCourseId(courseId);
    }

    @Override
    public JSONObject materialUpload(MultipartFile material, Integer courseId) {
        return null;
    }
}
