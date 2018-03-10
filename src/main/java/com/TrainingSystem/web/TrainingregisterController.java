  package com.TrainingSystem.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.security.core.context.SecurityContextHolder;

import com.TrainingSystem.Dto.trainingclass;
import com.TrainingSystem.Service.TrainingclassService;

@Controller
@RequestMapping({ "/trainingregister" })

public class TrainingregisterController {
	@Autowired
	TrainingclassService tcService;
   /* @InitBinder
    public void InitBinder(WebDataBinder binder)
    {
    	CustomNumberEditor numbereditor=new CustomNumberEditor(Integer.class, true);
    	binder.registerCustomEditor(Integer.class, numbereditor);
    }*/
	@RequestMapping(method = GET)
     String webcontrol(Model model,HttpSession session){
		 Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(userDetails!=null)
                 model.addAttribute("userinfo", userDetails);
	   return "trainingregister";
   }

	@RequestMapping( method =POST)
    String register(@Validated @ModelAttribute("trainingclass") trainingclass classinfo,BindingResult bingdingresult,Model model){
		//inventoryValidator.validate(classinfo, bingdingresult);
	   if(bingdingresult.hasErrors()){
		   String errormessage="";
		   for(FieldError error : bingdingresult.getFieldErrors()){
			   errormessage+=error.getDefaultMessage()+"<br>";
		   }
		   model.addAttribute("msg",errormessage);
		   return "trainingregister";
	   }
	   System.out.println(classinfo);
	   tcService.save(classinfo);
	   return "redirect:/home";
  }
   
     
}
