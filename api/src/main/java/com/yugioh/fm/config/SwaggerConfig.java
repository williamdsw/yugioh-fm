package com.yugioh.fm.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private final ResponseMessage notFound = new ResponseMessageBuilder().code(404).message("Not Found").build();
	
	@Bean
	public Docket buildApiDoc() {
		String basePackage = "com.yugioh.fm.config";
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
				   .globalResponseMessage(RequestMethod.GET, Arrays.asList(notFound)).select()
				   .apis(RequestHandlerSelectors.basePackage(basePackage)).paths(PathSelectors.any()).build()
				   .apiInfo(buildApiInfo());
	}
	
	private ApiInfo buildApiInfo() { // TODO
		String title = "Yugioh FM";
		String description = "Backend project for Yugioh Forbidden Memories API";
		String version = "1.0";
		String authors = "William Santos";
		String links = "https://github.com/williamdsw";
		String emails = "williamdsw@outlook.com";
		Contact contact = new Contact(authors, links, emails);
		String license = "GPL-3.0-only";
		String licenseUrl = "https://www.gnu.org/licenses/gpl-3.0.en.html";
		return new ApiInfo(title, description, version, null, contact, license, licenseUrl, Collections.emptyList());
		
	}

}
