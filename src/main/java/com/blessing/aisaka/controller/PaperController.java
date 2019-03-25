package com.blessing.aisaka.controller;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou.peng
 * @date 2019/03/25
 */
@RestController
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    IPaperService paperService;

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    public JSONObject editPaper(Paper paper) {
        return null;
    }
}
