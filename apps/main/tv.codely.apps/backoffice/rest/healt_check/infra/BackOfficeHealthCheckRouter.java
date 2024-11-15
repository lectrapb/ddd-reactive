package com.apps.backoffice.rest.healt_check.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Map;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Configuration
public class BackOfficeHealthCheckRouter {

    @Bean
    public RouterFunction<ServerResponse> router(@Value("${app.url.health_back_office}") String url) {
        return route(GET(url), request -> ServerResponse.status(HttpStatus.OK)
                .body(fromValue(Map.of("status", "ok"))));
    }
}
