package com.testcase.generator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder encode()
	{
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
}
