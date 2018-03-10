package com.TrainingSystem.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.TrainingSystem.Biz.userinfoMapper;
import com.TrainingSystem.Service.SecurityUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
	@Autowired
	userinfoMapper uimapper;
@Override
protected void configure(AuthenticationManagerBuilder auth)throws Exception{
	auth.userDetailsService(new SecurityUserService(uimapper));
}
@Override
protected void configure(HttpSecurity http)throws Exception{
	 CharacterEncodingFilter filter = new CharacterEncodingFilter(); 
	 filter.setEncoding("UTF-8");  
     filter.setForceEncoding(true);  
     http.addFilterBefore(filter,CsrfFilter.class); 
   http.formLogin().loginPage("/slogin").defaultSuccessUrl("/home").failureUrl("/slogin?error=true").and()
        .logout().logoutSuccessUrl("/logoutjump").logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
        .authorizeRequests().antMatchers("/resource/**","/slogin/**","/logoutjump").permitAll()
                           .anyRequest().authenticated();
                           
}
}
