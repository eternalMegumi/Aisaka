package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Material;
import com.blessing.aisaka.entity.User;
import com.blessing.aisaka.service.IMaterialService;
import com.blessing.aisaka.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * @author zhuo.peng
 * @date 2019/03/21
 */
@RestController
public class MaterialController {

    @Autowired
    IMaterialService materialService;
    @Autowired
    IUserService userService;

    /**
     * 上传课程资料
     *
     * @param material
     * @return
     */
    @RequestMapping(value = "/admin/material/upload", method = RequestMethod.POST)
    public JSONObject uploadMaterial(MultipartFile material, Integer courseId) {
        return materialService.materialUpload(material, courseId);
    }

    /**
     * 学生开始学习界面，列出该课程的学习资料列表
     *
     * @param principal
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/user/course/{courseId}", method = RequestMethod.GET)
    public ModelAndView listMaterial(Principal principal, @PathVariable Integer courseId) {
        ModelAndView mav = new ModelAndView("user/listMaterial");
        List<Material> materialList = materialService.queryMaterialByCourseId(courseId);
        User student = userService.queryStudentByName(principal.getName());
        mav.addObject("materialList", materialList);
        mav.addObject("student", student);
        return mav;
    }

    /**
     * 学习界面，展示学习资料PDF
     *
     * @param principal
     * @param materialId
     * @return
     */
    @RequestMapping(value = "/user/material/{materialId}", method = RequestMethod.GET)
    public ModelAndView showMaterial(Principal principal, @PathVariable Integer materialId) {
        ModelAndView mav = new ModelAndView("user/showMaterial");
        Material material = materialService.queryMaterialById(materialId);
        mav.addObject("material", material);
        return mav;
    }
}
