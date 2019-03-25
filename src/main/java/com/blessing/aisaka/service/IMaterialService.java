package com.blessing.aisaka.service;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Material;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
public interface IMaterialService {

    Material queryMaterialById(Integer id);

    List<Material> queryMaterialByCourseId(Integer courseId);

    JSONObject materialUpload(MultipartFile material, Integer courseId);
}
