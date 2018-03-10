package com.TrainingSystem.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TrainingSystem.Dto.userinfo;
import com.TrainingSystem.Dto.userlogininfo;
import com.TrainingSystem.Service.userLoginService;

@Controller
@RequestMapping({"/wlogin"})
public class LoginController {
	@Autowired
	userLoginService uService;
	@RequestMapping(method = GET)
	public String home() {
		return "login";
	}
	@RequestMapping(method = POST)
	public String login(@ModelAttribute("userinfo")userinfo info,Model model,HttpSession session){
		System.out.println(info.getName());
		userlogininfo ulinfo=uService.login(info);
		if(ulinfo.getError()==null||ulinfo.getError().equals("")){
			session.setAttribute("userinfo", ulinfo);
			return "redirect:/home";
		}
		else{
             model.addAttribute("msg",ulinfo.getError());
	         return "/login";
		}
		//System.out.println(ulinfo);
	}
}
