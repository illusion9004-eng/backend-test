package org.example.todo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Todo API",
                version = "1.0",
                description = "Todo CRUD API"
        )
)
public class TodoConfig {
}
