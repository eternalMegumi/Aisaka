package com.blessing.aisaka.dao;

import com.blessing.aisaka.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhou.peng
 * @date 2019/03/19
 */
@Mapper
@Repository
public interface IMaterialDao {
    Material queryMaterialById(Integer id);

    List<Material> queryMaterialByCourseId(Integer courseId);

    int insertMaterial(Material material);
}
