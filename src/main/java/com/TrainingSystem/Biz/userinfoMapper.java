package com.TrainingSystem.Biz;

import com.TrainingSystem.Dto.userinfo;

public interface userinfoMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(userinfo record);

    int insertSelective(userinfo record);

    userinfo selectByPrimaryKey(Integer userID);

    int updateByPrimaryKeySelective(userinfo record);

    int updateByPrimaryKey(userinfo record);
    
    userinfo selectByLoginID(String loginID);
}