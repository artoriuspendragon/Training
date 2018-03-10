package com.TrainingSystem.Service;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.TrainingSystem.Biz.userinfoMapper;
import com.TrainingSystem.Dto.userinfo;

public class SecurityUserService implements UserDetailsService{
    
    private final userinfoMapper uiMapper;
    public   SecurityUserService( userinfoMapper uiMapper) {
		this.uiMapper=uiMapper;
	}
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		userinfo uinfo=uiMapper.selectByLoginID(arg0);
		if(uinfo != null){
			List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			uinfo.setAuthorities(authorities);
			return uinfo;
		}
		throw new UsernameNotFoundException("user "+arg0+"not found");
	}

}
