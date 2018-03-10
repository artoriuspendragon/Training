package com.TrainingSystem.web;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping({"/slogin"})
public class SloginController {
@RequestMapping(method=GET)
public String sloginwebcontrol(String error,Model model,HttpSession session){
	Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
	if(!(auth instanceof AnonymousAuthenticationToken)){
		return "loginjumptohome";
	}
	if("true".equals(error))
	{
		Object excsession =session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		if(!excsession.equals(null))
	{RuntimeException exc=(RuntimeException) excsession;
	model.addAttribute("loginerror",exc.getMessage());
	}
	}
	return "s_login";
}
}
