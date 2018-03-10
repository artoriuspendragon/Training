package com.TrainingSystem.Biz;

import java.util.HashMap;
import java.util.List;

import com.TrainingSystem.Dto.trainingaffect;

public interface trainingaffectMapper {
    int deleteByPrimaryKey(Integer trainingAffectID);

    int insert(trainingaffect record);

    int insertSelective(trainingaffect record);

    trainingaffect selectByPrimaryKey(Integer trainingAffectID);

    int updateByPrimaryKeySelective(trainingaffect record);

    int updateByPrimaryKey(trainingaffect record);
    
    List<HashMap<String, String>> selectclassesnames();
    
    List<HashMap<String, String>> selectclassesnamesnotfinished();
}