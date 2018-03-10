package com.TrainingSystem.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.TrainingSystem.Dto.trainingclass;
import com.TrainingSystem.Dto.trainingexamplan;
import com.TrainingSystem.Dto.trainingexamplan_examplan;
import com.TrainingSystem.Dto.trainingexamplan_trainingplan;
import com.TrainingSystem.Service.ExamplanService;
import com.TrainingSystem.Service.TrainingclassService;
import com.TrainingSystem.Service.TrainingexamplanService;
import com.TrainingSystem.Service.TrainingplanService;

@Controller
@RequestMapping("/approve")

public class approveController {
@Autowired TrainingclassService tcService; 
@Autowired TrainingexamplanService tepService;
@Autowired TrainingplanService tpService;
@Autowired ExamplanService epService;

@RequestMapping(method=GET)
String webcontrol(Integer classId,Model model){
	List<HashMap<String,String>>names=tcService.getallnamesnotapproved();
    model.addAttribute("classnames", names);
    if(classId!=null){
     trainingexamplan classinfo =tepService.findByclassID(classId);
     List<trainingexamplan_examplan>examplans=epService.findListByclassID(classId);
     List<trainingexamplan_trainingplan>trainingplans=tpService.findListByclassID(classId);
     model.addAttribute("classinfo",classinfo);
     model.addAttribute("examplans", examplans);
     model.addAttribute("trainingplans",trainingplans);
     return "approval";
    }
    else{
    	model.addAttribute("msg","请选择培训班");
    	return "approval";
    }
}
@RequestMapping(method=POST)
String approval(@RequestParam Integer classId){
	tepService.approveexam(classId);
	return "redirect:/home";
}
}
