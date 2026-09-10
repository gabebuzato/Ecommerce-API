package dev.java.ecommece.basketService.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfiguration {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                    new Info()
                    .title("Basket Service API")
                    .description("API of management for Basket of ecommerce")
                    .version("1.0")
                );
    }
}
