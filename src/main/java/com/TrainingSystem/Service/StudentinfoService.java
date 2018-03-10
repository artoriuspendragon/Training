package com.TrainingSystem.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainingSystem.Biz.studentinfoMapper;
import com.TrainingSystem.Biz.userinfoMapper;
import com.TrainingSystem.Dto.studentinfo;

@Service
public class StudentinfoService {
@Autowired
studentinfoMapper uiMapper;
public void save(studentinfo info){
	info.setStudentGuid(UUID.randomUUID().toString());
	uiMapper.insert(info);
}
public studentinfo[] findallinfo(){
	return uiMapper.selectAll();
}
public studentinfo findinfobyID(int StudentID){
	return uiMapper.selectByPrimaryKey(StudentID);
}
public int removeinfos(List<Integer> IDs){
	return uiMapper.deleteByPrimaryKeys(IDs);
}
public int changeinfo(studentinfo info){
	return uiMapper.updateByPrimaryKeySelective(info);
}
}
