/*package com.techlabs.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(Documentation.SWAGGER_2)
				.select
				.apis(RequestHandlersSelectors.basrPackage("com.techlabs.app.controller"))
				.paths(PathSelectors.any())
				.build();
	}

}
*/