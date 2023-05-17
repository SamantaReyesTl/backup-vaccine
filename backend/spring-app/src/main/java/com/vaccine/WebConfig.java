package com.vaccine;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuracion para permitir el acceso a la API desde cualquier origen.
 * Sí, esto soluciona el problema de CORS.
 */

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // esto es para que se aplique a todos los endpoints
                .allowedOriginPatterns("*") // <- Esto es lo que permite el acceso desde cualquier origen.
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600)
                .exposedHeaders("Access-Control-Allow-Origin");
    }
}
