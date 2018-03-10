package com.TrainingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainingSystem.Biz.trainingexamplan_examplanMapper;
import com.TrainingSystem.Dto.examplanModel;
import com.TrainingSystem.Dto.trainingexamplan_examplan;

@Service
public class ExamplanService {
	@Autowired
	trainingexamplan_examplanMapper tpeMapper;
	public void save(trainingexamplan_examplan examplan){
		tpeMapper.insert(examplan);
	}
	public void savelist(examplanModel examplans){
		for(trainingexamplan_examplan singleplan : examplans.getExamplanList()){
			   tpeMapper.insert(singleplan);
		}
	}
	public List<trainingexamplan_examplan> findListByclassID(int classID){
		return tpeMapper.selectByclassID(classID);
	}
}
