package com.TrainingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.TrainingSystem.Biz.trainingexamplanMapper;
import com.TrainingSystem.Dto.trainingexamplan;

@Service
public class TrainingexamplanService {
@Autowired
trainingexamplanMapper tepMapper;
public void save(trainingexamplan info){
	tepMapper.insert(info);
/*	catch(DuplicateKeyException dke){
		
	}*/
}
public trainingexamplan findByclassID(int ClassID){
	return tepMapper.selectByclassID(ClassID);
}
public void approveexam(int classID){
	trainingexamplan examplan=new trainingexamplan();
	examplan.setClassID(classID);
	examplan.setApproval("yes");
	tepMapper.updateByClassIDselective(examplan);
}
}
