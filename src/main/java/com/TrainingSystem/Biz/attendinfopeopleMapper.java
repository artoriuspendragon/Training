package com.TrainingSystem.Biz;

import com.TrainingSystem.Dto.attendinfopeople;

public interface attendinfopeopleMapper {
    int deleteByPrimaryKey(Integer attendID);

    int insert(attendinfopeople record);

    int insertSelective(attendinfopeople record);

    attendinfopeople selectByPrimaryKey(Integer attendID);

    int updateByPrimaryKeySelective(attendinfopeople record);

    int updateByPrimaryKey(attendinfopeople record);
}