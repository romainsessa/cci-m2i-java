package fr.cci.gateway;

import org.springframework.cloud.gateway.server.mvc.config.RouterFunctionHolderFactory;
import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> getRoute() {

        return GatewayRouterFunctions.route()
                .GET("/api/**", HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri(
                        "http://localhost:8080"))
                .POST("/api/**", HandlerFunctions.http())
                .before(BeforeFilterFunctions.uri(
                        "http://localhost:8080"))
                .build();
    }


}
