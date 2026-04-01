package com.soares.smartbudget.infrastructure.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS para todos os endpoints sob /api/
                .allowedOrigins("http://localhost:3000", "http://192.168.12.116:3000", "http://192.168.12.107:3000") // A porta padrão do SvelteKit dev server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}