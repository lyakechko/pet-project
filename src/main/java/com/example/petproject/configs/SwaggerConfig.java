package com.example.petproject.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${server.url-1}")
    private String url1;
    @Value("${server.url-2}")
    private String url2;
    @Value("${server.servlet.context-path}")
    private String path;

    private static final String SECURITY_SCHEME_NAME = "Bearer Token";
    private static final String SECURITY_SCHEME = "bearer";
    private static final String BEARER_FORMAT = "JWT";
    private static final String VERSION = "version 1.0";
    private static final String DESCRIPTION = "Pet project service";
    private static final String TERMS_OF_SERVICE = "health";
    private static final String PATH_CONTEXT = "server.servlet.context-path";

    @Bean
    public OpenAPI openApiConfiguration() {
        Server server1 = new Server();
        server1.setUrl(url1.concat(path));
        Server server2 = new Server();
        server2.setUrl(url2.concat(path));

        return new OpenAPI()
                .addServersItem(server1)
                .addServersItem(server2)
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(
                        new Components().addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme(SECURITY_SCHEME)
                                        .bearerFormat(BEARER_FORMAT)))
                .info(new Info()
                        .version(VERSION)
                        .description(DESCRIPTION)
                        .termsOfService(TERMS_OF_SERVICE)
                );
    }
}
