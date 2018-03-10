package com.TrainingSystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import com.TrainingSystem.Dto.studentinfo;
import com.TrainingSystem.Service.StudentinfoService;

@Controller
@RequestMapping("/studentregister")

public class StudentregisterController {
   @Autowired 
   StudentinfoService siService;
   @RequestMapping(method = GET)
   String webcontrol(Model model){
	   studentinfo[] infos=siService.findallinfo();
	   model.addAttribute("stuinfo", infos);
	   return "studentregister";
   }
   @RequestMapping(method =POST)
   String register(@Validated@ModelAttribute("studentinfo")studentinfo info,BindingResult result,Model model,HttpServletRequest request) throws UnsupportedEncodingException{
	   if(result.hasErrors()){
		   String errormessage="";
		   for(FieldError error : result.getFieldErrors()){
			   errormessage+=error.getDefaultMessage()+"<br>";
		   }
		   studentinfo[] infos=siService.findallinfo();
		   model.addAttribute("stuinfo", infos);
		   model.addAttribute("input",info);
		   model.addAttribute("msg",errormessage);
		   return "studentregister";
	   }
	   else
		   {siService.save(info);
		   return "redirect:/studentregister";}
   }
   
}
