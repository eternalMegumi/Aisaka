package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhou.peng
 * @date 2019/03/25
 */
@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    IPaperService paperService;

    /**
     * 编辑试卷信息
     *
     * @param paper
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    public JSONObject editPaper(Paper paper) {
        return paperService.editPaper(paper);
    }

    /**
     * 上传试卷PDF
     *
     * @param file
     * @param paper
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JSONObject uploadPaper(MultipartFile file, Paper paper) {
        return paperService.paperUpload(file, paper);
    }
}
