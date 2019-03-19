package com.blessing.aisaka.dao;

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

}
