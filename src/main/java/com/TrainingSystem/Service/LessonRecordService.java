package com.TrainingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainingSystem.Biz.lessonrecordMapper;
import com.TrainingSystem.Dto.lessonrecord;

@Service
public class LessonRecordService {
@Autowired
lessonrecordMapper lrMapper;
public void save(lessonrecord record){
	lrMapper.insert(record);
}
public List<lessonrecord>findlessonsbyclassID(Integer classID){
	return lrMapper.selectByClassID(classID);
}
}
