package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhuo.peng
 * @date 2019/03/21
 */
@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    IMaterialService materialService;

    /**
     * 上传课程资料
     *
     * @param material
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JSONObject uploadMaterial(MultipartFile material, Integer courseId) {
        return materialService.materialUpload(material, courseId);
    }
}
