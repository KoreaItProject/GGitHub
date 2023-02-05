package com.ggit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// @SpringBootApplication
// public class Application {

// 	public static void main(String[] args) {
// 		SpringApplication.run(Application.class, args);
// 		// new ServerMain();

// 	}

// }

// 위에가 원래 코드 밑에는 배포를 위한 코드
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// new ServerMain();

	}

}
