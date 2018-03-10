package Training.test;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.TrainingSystem.Dto.userinfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class checkclasstest {
@Test
public  void checkObjFieldIsNull() throws IllegalAccessException {
   userinfo info=new userinfo();
   info.setLoginID("123");
   info.setLoginPwd("123312");
   info.setName("123312");
   info.setRegistTime("1233");
   info.setUserID(123312);
    boolean flag = false;
    for(Field f : info.getClass().getDeclaredFields()){
        f.setAccessible(true);
        if(f.get(info) == null){
        	System.out.println("name:"+f.getName()+"\n\r");
            flag = true;
            System.out.println(flag);
        }
    }
    System.out.println( flag);
}
}
