package com.blessing.aisaka.service.impl;

import com.blessing.aisaka.dao.IPaperDao;
import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;
import com.blessing.aisaka.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Paper paper = paperDao.queryPaperByCourse(course);
        return paper == null ? new Paper() : paper;
    }
}
