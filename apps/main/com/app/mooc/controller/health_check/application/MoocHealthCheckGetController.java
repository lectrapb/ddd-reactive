package com.app.mooc.controller.health_check.application;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class MoocHealthCheckGetController {

    public Mono<ServerResponse> handler(ServerRequest request) {
        return ServerResponse
                .status(HttpStatus.OK)
                .body(fromValue(Map.of("status", "ok")));
    }
}
