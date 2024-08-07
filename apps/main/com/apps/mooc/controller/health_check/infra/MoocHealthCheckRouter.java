package com.apps.mooc.controller.health_check.infra;

import com.app.mooc.controller.health_check.application.MoocHealthCheckGetController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MoocHealthCheckRouter {

    @Bean
    public RouterFunction<ServerResponse> routerBackOffice(@Value("${app.url.health_mooc}") String url,
                                                 MoocHealthCheckGetController controller) {
        return route(GET(url), controller::handler);
    }
}
