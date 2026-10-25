package lv.bootcamp.shelter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Defines the public API metadata shown in Swagger UI.
 * Do not include secrets, internal hostnames, or sensitive data in descriptions.
 */

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI shelterOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Shelter API")
                        .version("v1")
                        .description("REST endpoints for managing shelter animals. "
                                + "The whole app needs a login, so log in at /login in the same browser "
                                + "before using Try it out.")
                        .contact(new Contact().name("Shelter bootcamp project")));
    }
}