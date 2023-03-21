package com.mango.api.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .components(new Components())
        .info(new Info()
            .title("Mango API")
            .description("This is the Mango API Server RESTful service for OpenAPI 3.")
            .termsOfService("http://mango.com/tos")
            .contact(new Contact().email("haighis@gmail.com"))
            .license(new License().name("unknown"))
            .version("1.0")
        );
  }
}
