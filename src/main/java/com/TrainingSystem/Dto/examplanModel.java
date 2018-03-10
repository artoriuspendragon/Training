package com.TrainingSystem.Dto;

import java.util.List;

public class examplanModel {
	private List<trainingexamplan_examplan> examplanList;

	/*examplanModel(){
		trainingplanList=new AutoPopulatingList<>(trainingexamplan_trainingplan.class);
	}*/
	public List<trainingexamplan_examplan> getExamplanList() {
		return examplanList;
	}

	public void setExamplanList(List<trainingexamplan_examplan> trainingplanList) {
		this.examplanList = trainingplanList;
	}

	@Override
	public String toString(){
		return "sets:"+examplanList;
	}
}
