package com.yskj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.yskj.dao.UseCaseMapper,com.yskj.dao.ApiMapper")
//public class TestPlatformApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(TestPlatformApplication.class, args);
//	}
//}
public class TestPlatformApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(TestPlatformApplication.class);
	}

	public static void main(String[] args) throws Exception {
	    SpringApplication.run(TestPlatformApplication.class, args);
	}

	//全局配置跨域
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/#/*").allowedOrigins("http://localhost:8080");
				registry.addMapping("/*").allowedOrigins("http://localhost:8080");
			}
		};
	}

}