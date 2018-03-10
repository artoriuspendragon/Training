package com.TrainingSystem.Biz;

import com.TrainingSystem.Dto.studentattendinfo;

public interface studentattendinfoMapper {
    int insert(studentattendinfo record);

    int insertSelective(studentattendinfo record);
}