package com.apple.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = { "com.apple" })
public class Boot_SpringRest_JaxRSJersey_SwaggerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Boot_SpringRest_JaxRSJersey_SwaggerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
		return builder.sources(Boot_SpringRest_JaxRSJersey_SwaggerApplication.class);
	}

}
