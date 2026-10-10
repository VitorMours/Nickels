package com.nickels.core.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI SwaggerAPI() {
        return new OpenAPI()
                        .info(new Info()
                        .title("Nickels core API")
                        .version("1.0.0")
                        .description("Documentação gerada automaticamente com SpringDoc OpenAPI"));

    }
}
