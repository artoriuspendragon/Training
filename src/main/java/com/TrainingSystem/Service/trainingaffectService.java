package com.TrainingSystem.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainingSystem.Biz.trainingaffectMapper;
import com.TrainingSystem.Dto.trainingaffect;

@Service
public class trainingaffectService {
	@Autowired
	trainingaffectMapper taMapper;
public void save(trainingaffect record){
	taMapper.insert(record);
}
public List<HashMap<String, String>> findclassnames(){
	return taMapper.selectclassesnames();
}
public List<HashMap<String, String>> findclassnamesnotfinished(){
	return taMapper.selectclassesnamesnotfinished();
}
}
