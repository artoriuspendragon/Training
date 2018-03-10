package com.TrainingSystem.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TrainingSystem.Dto.trainingclass;
import com.TrainingSystem.Dto.userinfo;
import com.TrainingSystem.Dto.userlogininfo;
import com.TrainingSystem.Service.TrainingclassService;
import com.TrainingSystem.Service.userLoginService;
import com.TrainingSystem.Biz.userinfoMapper;
@Controller
@RequestMapping({"/","/homepage","/home","/index"})
public class HomeController {
	
	@Autowired
	userLoginService uService;
	@Autowired
	TrainingclassService tcService;
	@RequestMapping(method = GET)
	public String home(Model model,HttpSession session) {
		//userlogininfo ulinfo=(userlogininfo) session.getAttribute("userinfo");
		 Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails==null)
			return "redirect:/slogin";
		model.addAttribute("userinfo", userDetails);
		List<trainingclass> classinfos=tcService.findclasses();
		model.addAttribute("classinfos", classinfos);
		return "home";
	}
   @RequestMapping("logoutjump")
   public String logoutjump(){
	   return "logoutjump";
   }
}
