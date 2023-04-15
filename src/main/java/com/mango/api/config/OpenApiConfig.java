package com.mango.api.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
      //  var authUrl = String.format("%s/realms/%s/protocol/openid-connect", this.authServer, this.realm);
        return new OpenAPI()
                .components(new Components()
//                        .addSecuritySchemes("spring_oauth", new SecurityScheme()
//                                .type(SecurityScheme.Type.OAUTH2)
//                                .description("Oauth2 flow")
//                                .flows(
//                                        new OAuthFlows()
//                                        .authorizationCode(new OAuthFlow()
//                                                .authorizationUrl(authUrl + "/auth")
//                                                .refreshUrl(authUrl + "/token")
//                                                .tokenUrl(authUrl + "/token")
//                                                .scopes(new Scopes())
//                                        )))
                        .addSecuritySchemes("api_key", new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .description("Api Key access")
                                .in(SecurityScheme.In.HEADER)
                                .name("API-KEY")
                        )
//                        .addParameters("Version",
//                                new Parameter()
//                                .in("header")
//                                .name("Version")
//                                .schema(new StringSchema())
//                                .required(false))
                )
                .security(Arrays.asList(
                      //  new SecurityRequirement().addList("spring_oauth"),
                        new SecurityRequirement().addList("api_key")))

                .info(new Info()
                        .title("Mango Platform API")
                        .description("This is the Mango API Server RESTful service for OpenAPI 3.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Mango")
                                .url("http://mango.com/tos")
                        //        .email("developer@example.com")
                        ));
    }


//    @Bean
//  public OpenAPI customOpenAPI() {
//      return new OpenAPI()
//        .components(new Components())
//        .info(new Info()
//            .title("Mango Platform API")
//            .description("This is the Mango API Server RESTful service for OpenAPI 3.")
//            .termsOfService("http://mango.com/tos")
//            .contact(new Contact().email("haighis@gmail.com"))
//            .license(new License().name("unknown"))
//            .version("1.0")
//        );

//      private ApiKey getApiKey() {
//          return new ApiKey("apiKey", "Authorization", "Header");
//      }
  //}
}
