package com.apple.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SpringMVC")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.apple.controller"))
                .paths(regex("/.*"))
                .build();
        	
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot REST API with Swagger")
                .description("SpringBoot REST API with Swagger")
                .termsOfServiceUrl("http://apple.com")
                .contact("sa@apple.com")
                .license("Apache License Version 2.0")
                .licenseUrl("http://apple.com/LICENSE")
                .version("2.0")
                .build();
    }
}