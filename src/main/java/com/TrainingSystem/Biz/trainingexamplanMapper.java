package com.TrainingSystem.Biz;

import com.TrainingSystem.Dto.trainingexamplan;

public interface trainingexamplanMapper {
    int insert(trainingexamplan record);

    int insertSelective(trainingexamplan record);
    
    trainingexamplan selectByclassID(int classID);
    
    void updateByClassIDselective(trainingexamplan examplan);
}