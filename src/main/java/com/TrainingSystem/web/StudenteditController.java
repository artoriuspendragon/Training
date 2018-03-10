package com.TrainingSystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TrainingSystem.Dto.studentinfo;
import com.TrainingSystem.Service.StudentinfoService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/studentedit")
class StudenteditController {
@Autowired
StudentinfoService siService;
@RequestMapping(method=GET)
public String webcontrol(int studentID,Model model){
	studentinfo stuinfo=siService.findinfobyID(studentID);
	model.addAttribute("input", stuinfo);
	return "studentedit";
}
@RequestMapping(value="/ajax",method=POST)
@ResponseBody
public Integer ajaxupdatestudentcontrol(@ModelAttribute("studentinfo")studentinfo stuinfo){
	int result =siService.changeinfo(stuinfo);
	return result;
}
@RequestMapping(method=POST)
public String updatestudentcontrol(@ModelAttribute("studentinfo")studentinfo stuinfo){
	System.out.println(stuinfo);
	int result =siService.changeinfo(stuinfo);
	return "redirect:/studentregister";
}
}
