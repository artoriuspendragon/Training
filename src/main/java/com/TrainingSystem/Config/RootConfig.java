package com.TrainingSystem.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@ComponentScan(basePackages={"com.TrainingSystem.Config","com.TrainingSystem.Service","com.TrainingSystem.ExceptionHandler"},excludeFilters={@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
@ImportResource(locations={"classpath:applicationContext.xml"})
public class RootConfig {
	@Bean(name = "messageSource")
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(10);
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setBasename("messages_zh_CN");
		return messageSource;
	}
}
