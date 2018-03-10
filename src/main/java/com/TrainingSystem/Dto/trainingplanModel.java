package com.TrainingSystem.Dto;

import java.util.List;

import org.springframework.util.AutoPopulatingList;

public class trainingplanModel {
private List<trainingexamplan_trainingplan> trainingplanList;

/*examplanModel(){
	trainingplanList=new AutoPopulatingList<>(trainingexamplan_trainingplan.class);
}*/
public List<trainingexamplan_trainingplan> getTrainingplanList() {
	return trainingplanList;
}

public void setTrainingplanList(List<trainingexamplan_trainingplan> trainingplanList) {
	this.trainingplanList = trainingplanList;
}

@Override
public String toString(){
	return "sets:"+trainingplanList;
}
}
