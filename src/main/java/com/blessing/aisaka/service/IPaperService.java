package com.blessing.aisaka.service;

import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
public interface IPaperService {
    Paper queryPaperById(Integer id);

    Paper quertPaperByCourse(Course course);
}
