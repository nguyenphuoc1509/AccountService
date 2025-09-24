package mss301.fa.s1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My API")
                        .version("1.0")
                        .description("API documentation with multiple servers"))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local environment"),
                        new Server().url("https://accountservice-production.up.railway.app").description("Staging environment"),
                        new Server().url("https://api.myapp.com").description("Production environment")
                ));
    }
}
