package com.blessing.aisaka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blessing.aisaka.constant.Constant;
import com.blessing.aisaka.constant.JsonConstant;
import com.blessing.aisaka.dao.IPaperDao;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.service.IPaperService;
import com.blessing.aisaka.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
@Service
public class PaperServiceImpl implements IPaperService {

    @Autowired
    IPaperDao paperDao;

    @Override
    public Paper queryPaperById(Integer id) {
        return paperDao.queryPaperById(id);
    }

    @Override
    public Paper queryPaperByCourse(Course course) {
        Paper paper = paperDao.queryPaperByCourseId(course.getId());
        return paper == null ? new Paper() : paper;
    }

    @Override
    public JSONObject paperUpload(MultipartFile file, Paper paper) {

        File fileDir = new File(Constant.PAPER_PATH);

        String path = fileDir.getAbsolutePath();

        if (!fileDir.exists()) {
            fileDir.mkdir();
        }

        StringBuilder stringBuilder = new StringBuilder();
        String fileName = file.getOriginalFilename();
        String url = stringBuilder.append(Constant.PAPER_URL).append(File.separator).append(fileName).toString();

        paper.setName(fileName);
        paper.setUrl(url);

        try {
            file.transferTo(new File(path, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (paper.getId() != null) {
            paperDao.updatePaper(paper);
        } else {
            paper.setPrepared(false);
            paperDao.insertPaper(paper);
            paper = paperDao.queryPaperByCourseId(paper.getCourseId());
        }


        return JsonUtil.buildJson(JsonConstant.SUCCESS, "ok", paper);
    }

    @Override
    public JSONObject editPaper(Paper paper) {
        if (paper.getId() != null) {
            paper.setPrepared(true);
            paperDao.updateBaseInfo(paper);
            return JsonUtil.buildJson(JsonConstant.SUCCESS, "ok");
        }
        return JsonUtil.buildJson(JsonConstant.FAIL, "请先上传试卷");
    }
}
