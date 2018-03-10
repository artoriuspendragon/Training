package com.TrainingSystem.Biz;

import java.util.List;

import com.TrainingSystem.Dto.trainingexamplan_examplan;

public interface trainingexamplan_examplanMapper {
    int insert(trainingexamplan_examplan record);

    int insertSelective(trainingexamplan_examplan record);
    
    List<trainingexamplan_examplan> selectByclassID(Integer classID);
}