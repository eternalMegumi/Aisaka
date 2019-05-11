package com.blessing.aisaka.service;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
public interface IPaperService {
    Paper queryPaperById(Integer id);

    Paper queryPaperByCourse(Course course);

    JSONObject paperUpload(MultipartFile file, Paper paper);

    JSONObject editPaper(Paper paper);

    JSONObject queryRestTime(Integer studentId, Integer paperId);
}
