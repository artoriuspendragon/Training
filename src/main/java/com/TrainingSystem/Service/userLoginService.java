package com.TrainingSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrainingSystem.Biz.userinfoMapper;
import com.TrainingSystem.Dto.userinfo;
import com.TrainingSystem.Dto.userlogininfo;

@Service
public class userLoginService {
@Autowired
userinfoMapper infoMapper;	

	public userlogininfo login(userinfo loginuserinfo){
		userinfo rtninfo=infoMapper.selectByLoginID(loginuserinfo.getLoginID());
		userlogininfo resultinfo = new userlogininfo();
		if(rtninfo!=null){
		    if(rtninfo.getLoginPwd().equals(loginuserinfo.getLoginPwd())){
		    	resultinfo.setLoginID(rtninfo.getLoginID());
		    	resultinfo.setLoginPwd(rtninfo.getLoginPwd());
		    	resultinfo.setName(rtninfo.getName());
		    	resultinfo.setRegistTime(rtninfo.getRegistTime());
		    	resultinfo.setUserGuid(rtninfo.getUserGuid());
		    	resultinfo.setUserID(rtninfo.getUserID());
		    	
		    }
		    else {
		    	resultinfo.setError("密码错误！");
		    }
		}
		else{
			resultinfo.setError("不存在此用户！");
		}
		
		return resultinfo;
	}
}
