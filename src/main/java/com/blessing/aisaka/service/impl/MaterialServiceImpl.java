package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.Constant;
import com.blessing.aisaka.constant.JsonConstant;
import com.blessing.aisaka.dao.IMaterialDao;
import com.blessing.aisaka.entity.Material;
import com.blessing.aisaka.service.IMaterialService;
import com.blessing.aisaka.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
        File fileDir = new File(Constant.MATERIAL_PATH);

        String path = fileDir.getAbsolutePath();

        if (!fileDir.exists()) {
            fileDir.mkdir();
        }


        StringBuilder stringBuilder = new StringBuilder();
        String fileName = material.getOriginalFilename();
        String url = stringBuilder.append(Constant.MATERIAL_URL).append(File.separator).append(fileName).toString();

        Material materialVo = new Material(courseId, fileName, url);

        try {
            material.transferTo(new File(path, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }


        materialDao.insertMaterial(materialVo);

        List<Material> materialList = materialDao.queryMaterialByCourseId(courseId);

        return JsonUtil.buildJson(JsonConstant.SUCCESS, "ok", materialList);
    }
}
