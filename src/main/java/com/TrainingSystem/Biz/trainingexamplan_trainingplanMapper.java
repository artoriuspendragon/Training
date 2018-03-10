package com.TrainingSystem.Biz;

import java.util.List;

import com.TrainingSystem.Dto.trainingexamplan_trainingplan;

public interface trainingexamplan_trainingplanMapper {
    int insert(trainingexamplan_trainingplan record);

    int insertSelective(trainingexamplan_trainingplan record);
    
    List<trainingexamplan_trainingplan> selectByclassID(int classID);
}