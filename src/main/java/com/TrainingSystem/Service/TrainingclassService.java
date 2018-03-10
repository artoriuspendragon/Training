package com.TrainingSystem.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainingSystem.Biz.trainingclassMapper;
import com.TrainingSystem.Dto.trainingclass;

@Service
public class TrainingclassService {
@Autowired
trainingclassMapper tcMapper;
public void save(trainingclass tclass){
	tclass.setClassGuid(UUID.randomUUID().toString());
	tcMapper.insert(tclass);
}
public boolean checkexist(int classID){
	return tcMapper.selectexists(classID)>0;
}
public List<HashMap<String,String>> getallnames(){
	return tcMapper.selectclassesnames();
}
public List<HashMap<String,String>> getallnamesnotapproved(){
	 List<HashMap<String,String>> names= tcMapper.selectclassesnames();
	 for(int i=0;i<names.size();i++){
		 if (!("not").equals(names.get(i).get("Approval")))
		 { names.remove(i);
		     i--;}
	 }
	 System.out.println(names);
	 return names;
}
public List<HashMap<String,String>> getallnamesnoapprovement(){
	 List<HashMap<String,String>> names= tcMapper.selectclassesnames();
	 for(int i=0;i<names.size();i++){
		 if (null!=names.get(i).get("Approval"))
		 { names.remove(i);
		     i--;}
	 }
	 return names;
}
public List<HashMap<String,String>> getallnamesapproved(){
	List<HashMap<String,String>> names= tcMapper.selectclassesnames();

	 for(int i=0;i<names.size();i++){
		 if (!("yes").equals(names.get(i).get("Approval")))
			 {names.remove(i);
		     i--;}
	 }
	 return names;
}
public trainingclass findclassByid(Integer id){
	trainingclass classinfo =tcMapper.selectByPrimaryKey(id);
	return classinfo;
}
public List<trainingclass>findclasses(){
	return tcMapper.selectclasses();
}
}
