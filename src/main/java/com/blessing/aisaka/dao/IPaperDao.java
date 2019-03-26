package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.Course;
import com.blessing.aisaka.entity.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
@Mapper
@Repository
public interface IPaperDao {

    Paper queryPaperById(Integer id);

    Paper queryPaperByCourseId(Integer courseId);

    int insertPaper(Paper paper);

    /**
     * 更新答案分值时间等信息
     *
     * @param paper
     * @return
     */
    int updateBaseInfo(Paper paper);

    /**
     * 更新试卷
     *
     * @param paper
     * @return
     */
    int updatePaper(Paper paper);
}
