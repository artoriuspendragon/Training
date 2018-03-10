package com.TrainingSystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TrainingSystem.Dto.trainingplanModel;
import com.TrainingSystem.Dto.examplanModel;
import com.TrainingSystem.Dto.trainingexamplan;
import com.TrainingSystem.Dto.trainingexamplan_examplan;
import com.TrainingSystem.Dto.trainingexamplan_trainingplan;
import com.TrainingSystem.Service.ExamplanService;
import com.TrainingSystem.Service.TrainingclassService;
import com.TrainingSystem.Service.TrainingexamplanService;
import com.TrainingSystem.Service.TrainingplanService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.beans.PropertyEditor;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

@Controller
@RequestMapping("/trainingexamplan")
public class TrainingexamplanController {
	@Autowired
	TrainingclassService tcService;
	@Autowired
	TrainingexamplanService tepService;
	@Autowired
	TrainingplanService tpService;
	@Autowired
	ExamplanService epService;

	@RequestMapping(method = GET)
	String webcontrol(Model model) {
		List<HashMap<String, String>> classnames = tcService.getallnamesnoapprovement();
		model.addAttribute("classnames", classnames);
		return "trainingexamplan";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));

	}

	@RequestMapping(method = POST)
	String register(@Validated @ModelAttribute("trainingexamplan") trainingexamplan examinfo,
			BindingResult bindingresult, @ModelAttribute trainingplanModel trainingplan,
			@ModelAttribute examplanModel examplan, Model model) {

		if (bindingresult.hasErrors()) {
			String errormessages = "";
			for (FieldError error : bindingresult.getFieldErrors()) {
				errormessages += error.getDefaultMessage() + "<br>";
			}
			model.addAttribute("msg", errormessages);
			List<HashMap<String, String>> classnames = tcService.getallnames();
			model.addAttribute("classnames", classnames);
			return "trainingexamplan";
		} else {
			examinfo.setApproval("not");
			tepService.save(examinfo);
			for (trainingexamplan_trainingplan singleplan : trainingplan.getTrainingplanList()) {
				singleplan.setClassID(examinfo.getClassID());
			}
			for (trainingexamplan_examplan singleplan : examplan.getExamplanList()) {
				singleplan.setClassID(examinfo.getClassID());
			}
			tpService.savelist(trainingplan);
			epService.savelist(examplan);
			return "redirect:/home";
		}
	}
}
