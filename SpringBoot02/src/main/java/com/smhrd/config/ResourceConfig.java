package com.smhrd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
	
	@Value("${save.path}")
	private String savePath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// http://localhost:8088/boot/save/~~
		registry.addResourceHandler("/save/**") // 사용할 URLMapping
		        .addResourceLocations("file:///"+savePath); // 어떤 폴더
	}
	
}
