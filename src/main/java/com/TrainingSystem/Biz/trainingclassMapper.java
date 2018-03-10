package com.TrainingSystem.Biz;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.TrainingSystem.Dto.trainingclass;

public interface trainingclassMapper {
    int deleteByPrimaryKey(Integer classID);

    int insert(trainingclass record);

    int insertSelective(trainingclass record);

    trainingclass selectByPrimaryKey(Integer classID);

    int updateByPrimaryKeySelective(trainingclass record);

    int updateByPrimaryKey(trainingclass record);
    
    List<HashMap<String, String>> selectclassesnames();
    
    int selectexists(int classID);
    
    List<trainingclass>selectclasses();
}