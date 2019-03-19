package com.blessing.aisaka.service;

import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;

public interface IPaperService {
    Paper queryPaperById(Integer id);

    Paper quertPaperByCourse(Course course);
}
