package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.Constant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author zhuo.peng
 * @date 2019/03/21
 */
@RestController
@RequestMapping("/material")
public class MaterialController {


    /**
     * 上传课程资料
     *
     * @param material
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JSONObject uploadMaterial(MultipartFile material, Integer courseId) {
        JSONObject jsonObject = new JSONObject();
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = material.getOriginalFilename();
        File fileDir = new File(Constant.MATERIAL_PATH);

        String path = fileDir.getAbsolutePath();
        System.out.println(path);
        System.out.println(courseId);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
//
//        try {
//            file.transferTo(new File(path, fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        jsonObject.put("message", "ok");
        jsonObject.put("url", stringBuilder.append(path).append(File.separator).append(fileName).toString());

        return jsonObject;
    }
}
