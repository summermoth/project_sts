package com.co.kr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	@Description("Thymeleaf template resolver serving HTML")
	public ClassLoaderTemplateResolver templateResolver() {
		
		var templateReslover = new ClassLoaderTemplateResolver();
		templateReslover.setPrefix("templates/");
		templateReslover.setSuffix(".html");
		templateReslover.setCacheable(true);
		templateReslover.setTemplateMode("html");
		templateReslover.setCharacterEncoding("UTF-8");
		return templateReslover;
	}
	
	@Bean
	@Description("Thymeleaf template engine with Spring integration")
	public SpringTemplateEngine templateEngine() {
		var templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}
	
	@Bean
	@Description("Thymeleaf view resolver")
	public ViewResolver viewResolver() {
		var viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
	
	public void addviewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index.html");
	}
	
}
