package com.TrainingSystem.Biz;

import java.util.List;

import com.TrainingSystem.Dto.lessonrecord;

public interface lessonrecordMapper {
    int deleteByPrimaryKey(Integer lessonrecordID);

    int insert(lessonrecord record);

    int insertSelective(lessonrecord record);

    lessonrecord selectByPrimaryKey(Integer lessonrecordID);

    int updateByPrimaryKeySelective(lessonrecord record);

    int updateByPrimaryKey(lessonrecord record);
    
    List<lessonrecord> selectByClassID(Integer classID);
}