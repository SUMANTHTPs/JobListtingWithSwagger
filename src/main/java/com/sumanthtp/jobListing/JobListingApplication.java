package com.sumanthtp.jobListing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Job Listings", version = "2.0", description = "Jobs Information"))
public class JobListingApplication {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("JobListing-public")
				.pathsToMatch("/**")
				.build();
	}

	@Bean
	public GroupedOpenApi adminApi() {
		return GroupedOpenApi.builder()
				.group("JobListing-admin")
				.pathsToMatch("/**")
				.addOpenApiMethodFilter(method -> method.isAnnotationPresent(RestController.class))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(JobListingApplication.class, args);
	}
}
