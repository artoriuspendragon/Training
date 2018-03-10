package Training.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.TrainingSystem.Biz.studentinfoMapper;
import com.TrainingSystem.Biz.trainingaffectMapper;
import com.TrainingSystem.Biz.trainingclassMapper;
import com.TrainingSystem.Biz.trainingexamplanMapper;
import com.TrainingSystem.Biz.trainingexamplan_examplanMapper;
import com.TrainingSystem.Biz.trainingexamplan_trainingplanMapper;
import com.TrainingSystem.Biz.userinfoMapper;
import com.TrainingSystem.Dto.lessonrecord;
import com.TrainingSystem.Dto.trainingclass;
import com.TrainingSystem.Dto.trainingexamplan;
import com.TrainingSystem.Dto.trainingexamplan_examplan;
import com.TrainingSystem.Dto.trainingexamplan_trainingplan;
import com.TrainingSystem.Dto.userinfo;
import com.TrainingSystem.Service.LessonRecordService;
import com.TrainingSystem.Service.TrainingclassService;
import com.TrainingSystem.Service.trainingaffectService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations="applicationContext.xml")
@ComponentScan("com.TrainingSystem.Service")
public class Mappertest {

@Autowired
userinfoMapper uiMapper;
@Autowired
TrainingclassService tcService;

@Autowired
LessonRecordService lrService;
@Autowired
trainingaffectMapper taService;
@Autowired
studentinfoMapper siMapper;
public void teststart(){
//userinfo tinfo=uiMapper.selectByLoginID("1234545");
//System.out.println(tinfo==null);
}

@Test
public void mapresulttest(){
	//trainingexamplan aa=tepMapper.selectByclassID(2);
	//System.out.println(aa);
	//userinfo uinfo=uiMapper.selectByLoginID("123456");
	//System.out.println(uinfo);
	List<Integer> param= new ArrayList<Integer>();
	param.add(7);
	param.add(9);
	int result=siMapper.deleteByPrimaryKeys(param);
	
}


public void Servicetest(){
	//List<lessonrecord>aa=lrService.findlessonsbyclassID(156);
	List<trainingclass>testresult=tcService.findclasses();
	System.out.println(testresult.get(0));
	
}
}
