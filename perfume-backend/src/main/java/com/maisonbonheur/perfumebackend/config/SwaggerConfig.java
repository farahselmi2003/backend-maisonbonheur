package com.maisonbonheur.perfumebackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${server.servlet.context-path:/api}")
    private String contextPath;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080" + contextPath);
        devServer.setDescription("URL du serveur de développement");

        Contact contact = new Contact();
        contact.setEmail("contact@maisonbonheur.com");
        contact.setName("Maison Bonheur");
        contact.setUrl("https://www.maisonbonheur.com");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("API Maison Bonheur - Parfums")
                .version("1.0")
                .contact(contact)
                .description("API complète pour la boutique de parfums Maison Bonheur")
                .license(mitLicense);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}