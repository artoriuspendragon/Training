package com.TrainingSystem.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TrainingSystem.Biz.lessonrecordMapper;
import com.TrainingSystem.Dto.lessonrecord;
import com.TrainingSystem.Dto.studentinfo;
import com.TrainingSystem.Dto.trainingclass;
import com.TrainingSystem.Dto.trainingexamplan;
import com.TrainingSystem.Service.LessonRecordService;
import com.TrainingSystem.Service.StudentinfoService;
import com.TrainingSystem.Service.TrainingclassService;
import com.TrainingSystem.Service.TrainingexamplanService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/ajax")
public class ajaxController {
@Autowired
TrainingclassService tcService;
@Autowired
TrainingexamplanService tepService;
@Autowired
StudentinfoService siService;
@Autowired
LessonRecordService lrService;


@RequestMapping(value="/getclassinfo",method=POST)
@ResponseBody trainingexamplan getclassinfo(HttpServletRequest httprequest ,HttpServletResponse respones){
	Integer classid=Integer.parseInt(httprequest.getParameter("classID"));
	trainingexamplan examplan=tepService.findByclassID(classid);
	return examplan;
}
@RequestMapping(value="/gettrainingclassinfo",method=POST)
@ResponseBody trainingclass gettrainingclassinfo(HttpServletRequest httprequest ,HttpServletResponse respones){
	Integer classid=Integer.parseInt(httprequest.getParameter("classID"));
	trainingclass classinfo=tcService.findclassByid(classid);
	return classinfo;
}
@RequestMapping(value="/getlessonrecords",method=POST)
@ResponseBody  List<lessonrecord> getlessonrecords(HttpServletRequest httprequest ,HttpServletResponse respones){
	
	Integer classID=Integer.parseInt(httprequest.getParameter("classID"));
	return lrService.findlessonsbyclassID(classID);
}
@RequestMapping(value = "/getstudentsinfo")
     @ResponseBody
     public Object getstudentsinfo() {
         studentinfo[] list = siService.findallinfo();
         return list;
     }
@RequestMapping(value = "/deletestudents",method=POST)
@ResponseBody
public int testajax(String infolist) throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper jsonmapper=new ObjectMapper();
	List<Integer> list=(List<Integer>)jsonmapper.readValue(infolist, List.class);
    return siService.removeinfos(list);
}
}
