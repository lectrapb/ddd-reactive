package com.app.mooc.rest.infra;

import com.app.mooc.rest.application.MoocHealthCheckGetController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


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
