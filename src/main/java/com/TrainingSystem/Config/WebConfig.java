package com.TrainingSystem.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan("com.TrainingSystem.web")
public class WebConfig extends WebMvcConfigurerAdapter{
@Bean
public ViewResolver viewResolver(){
	InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	resolver.setExposeContextBeansAsAttributes(true);
	return resolver;
}
@Override
public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configuer){
	configuer.enable();
}
@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
	//registry.addResourceHandler("/resource/**").addResourceLocations("classpath:/WEB-INF/resources/");
	registry.addResourceHandler("/scripts/**").addResourceLocations("classpath:/WEB-INF/resources/scripts/");
		super.addResourceHandlers(registry);
	}

/*@Bean(name="validator")
public LocalValidatorFactoryBean getLocalValidatorFactoryBean() {
    LocalValidatorFactoryBean factoryBean =new LocalValidatorFactoryBean();
    factoryBean.setValidationMessageSource(messageSource());
    return factoryBean;
}*/
}
