package com.TrainingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainingSystem.Biz.trainingexamplan_trainingplanMapper;
import com.TrainingSystem.Dto.trainingplanModel;
import com.TrainingSystem.Dto.trainingexamplan_trainingplan;

@Service
public class TrainingplanService {
@Autowired
trainingexamplan_trainingplanMapper tep_tpMapper;
public void save(trainingexamplan_trainingplan singleplan){
	tep_tpMapper.insert(singleplan);
}
public void savelist(trainingplanModel listmodel){
	for(trainingexamplan_trainingplan singleplan: listmodel.getTrainingplanList()){
		if(!singleplan.getTrainingContent().isEmpty())
		{
			save(singleplan);
		}
	}
}
public List<trainingexamplan_trainingplan> findListByclassID(int ID){
	return tep_tpMapper.selectByclassID(ID);
}
}
