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

import com.TrainingSystem.Dto.lessonrecord;
import com.TrainingSystem.Dto.trainingaffect;
import com.TrainingSystem.Dto.trainingclass;
import com.TrainingSystem.Service.LessonRecordService;
import com.TrainingSystem.Service.TrainingclassService;
import com.TrainingSystem.Service.trainingaffectService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

@Controller
@RequestMapping("/trainingdiary")
public class TrainingdiaryController {
	@Autowired
	LessonRecordService lrService;
	@Autowired
	TrainingclassService tcService;
	@Autowired
	trainingaffectService taService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));

	}

	@RequestMapping(method = GET)
	String webcontrol(Model model) {
		return "trainingdiary";
	}

	@RequestMapping(value = "/lessonrecord", method = GET)
	String lessonrecordcontrol(Integer classID, Model model) {
		List<HashMap<String, String>> classnames = tcService.getallnamesapproved();
		model.addAttribute("classnames", classnames);
		if (classID != null) {
			List<lessonrecord> records = lrService.findlessonsbyclassID(classID);
			model.addAttribute("lessonrecords", records);
			model.addAttribute("selectedclass", classID);
		}
		return "lessonrecord";
	}

	@RequestMapping(value = "/lessonrecord", method = POST)
	String newlessonrecord(@Validated @ModelAttribute("lessonrecord") lessonrecord record, BindingResult bindingresult,
			Model model) {
		if (bindingresult.hasErrors()) {
			String errorstring = "";
			for (FieldError error : bindingresult.getFieldErrors()) {
				errorstring += error.getDefaultMessage();
			}
			model.addAttribute("msg", errorstring);
			model.addAttribute("input", record);
			List<HashMap<String, String>> classnames = tcService.getallnamesapproved();
			model.addAttribute("classnames", classnames);
			model.addAttribute("selectedclass", record.getClassID());
			return "lessonrecord";
		} else if (!tcService.checkexist(record.getClassID())) {
			List<HashMap<String, String>> classnames = tcService.getallnamesapproved();
			model.addAttribute("classnames", classnames);
			model.addAttribute("msg", "课程不存在");
			model.addAttribute("input", record);
			return "lessonrecord";
		} else {
			lrService.save(record);
			return "redirect:/trainingdiary/lessonrecord?classID=" + record.getClassID();
		}
	}

	@RequestMapping(value = "trainingaffect", method = GET)
	String trainingaffectcontrol(Integer classID, Model model) {
		List<HashMap<String, String>> classnames = taService.findclassnamesnotfinished();
		model.addAttribute("classnames", classnames);
		if (classID != null) {
			boolean legal=false;
			for(HashMap<String,String> singleclass:classnames){
				if(classID.equals(singleclass.get("classID")))
				   legal=true;
			}
			if(legal)
			{trainingclass classinfo = tcService.findclassByid(classID);
			model.addAttribute("classinfo", classinfo);
			model.addAttribute("selectedclass", classID);}
			else{
				return "redirect:/trainingdiary/trainingaffect";
			}
		}
		return "trainingaffect";
	}

	@RequestMapping(value = "trainingaffect", method = POST)
	String trainingaffectcontrol(@Validated @ModelAttribute("trainingaffect") trainingaffect record,
			BindingResult bindingresult, Model model) {
		if (bindingresult.hasErrors()) {
			String errorstring = "";
			for (FieldError error : bindingresult.getFieldErrors()) {
				errorstring += error.getDefaultMessage();
			}
			model.addAttribute("msg", errorstring);
			model.addAttribute("input", record);
			List<HashMap<String, String>> classnames = tcService.getallnamesapproved();
			model.addAttribute("classnames", classnames);
			model.addAttribute("selectedclass", record.getClassID());
			return "trainingaffect";
		} else if (!tcService.checkexist(record.getClassID())) {
			List<HashMap<String, String>> classnames = tcService.getallnamesapproved();
			model.addAttribute("classnames", classnames);
			model.addAttribute("msg", "课程不存在");
			model.addAttribute("input", record);
			return "trainingaffect";
		} else {
			record.setWritetime(new Date());
			taService.save(record);
			return "redirect:/trainingdiary";
		}
	}
	@RequestMapping(value="attend",method=GET)
	String attendcontrol(Model model){
		return "attend";
	}
}
