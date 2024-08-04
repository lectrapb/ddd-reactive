package com.app.mooc.controller.courses.application;

import com.app.mooc.controller.courses.domain.CreateCourseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@AllArgsConstructor
public class CoursesPutController {



    public Mono<ServerResponse> handler(ServerRequest request) {

        var id = request.pathVariable("id");
        return Mono.just(request.bodyToMono(CreateCourseRequest.class))
                .then(ServerResponse.status(HttpStatus.CREATED)
                        .body(fromValue("")));

    }
}


