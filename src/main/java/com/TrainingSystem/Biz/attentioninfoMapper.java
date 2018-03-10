package com.TrainingSystem.Biz;

import com.TrainingSystem.Dto.attentioninfo;

public interface attentioninfoMapper {
    int deleteByPrimaryKey(String studentGuid);

    int insert(attentioninfo record);

    int insertSelective(attentioninfo record);

    attentioninfo selectByPrimaryKey(String studentGuid);

    int updateByPrimaryKeySelective(attentioninfo record);

    int updateByPrimaryKey(attentioninfo record);
}