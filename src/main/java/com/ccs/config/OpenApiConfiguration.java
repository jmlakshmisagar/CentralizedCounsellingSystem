package com.ccs.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI centralizedCounsellingSystemApi() {

        return new OpenAPI()

                .info(new Info()

                        .title("Centralized Counselling System API")

                        .description("""
                                Enterprise REST APIs for the Centralized Counselling System.

                                Modules:
                                • Candidate Management
                                • College Management
                                • Seat Matrix Management
                                • Counselling Round Management
                                • Candidate Preferences
                                • Seat Allocation Engine
                                • Cutoff Generation
                                • Admission Report
                                """)

                        .version("1.0.0")

                        .contact(new Contact()
                                .name("Lakshmisagar JM")
                                .email("jmlakshmisagar@example.com"))

                        .license(new License()
                                .name("MIT License")))

                .externalDocs(
                        new ExternalDocumentation()
                                .description("Centralized Counselling System Documentation"));
    }
}