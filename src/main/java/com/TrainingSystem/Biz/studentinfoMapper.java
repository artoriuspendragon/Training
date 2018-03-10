package com.TrainingSystem.Biz;

import java.util.List;

import com.TrainingSystem.Dto.studentinfo;

public interface studentinfoMapper {
    int deleteByPrimaryKey(Integer studentID);

    int insert(studentinfo record);

    int insertSelective(studentinfo record);

    studentinfo selectByPrimaryKey(Integer studentID);

    int updateByPrimaryKeySelective(studentinfo record);

    int updateByPrimaryKey(studentinfo record);
    
    studentinfo[] selectAll();
    
    int deleteByPrimaryKeys(List<Integer> studentIDlist);
    
}