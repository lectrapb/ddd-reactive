package com.app.mooc.controller.courses.application;

import com.app.mooc.controller.courses.domain.CreateCourseRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tv.codely.mooc.courses.application.create.CourseCreator;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@AllArgsConstructor
public class CoursesPutController {

    private final CourseCreator creator;

    public Mono<ServerResponse> handler(ServerRequest request) {


        var id = request.pathVariable("id");
        return  request.bodyToMono(CreateCourseRequest.class)
                .flatMap(reqDto ->creator.create(id, reqDto.getName(), reqDto.getDuration()))
                .then(ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue("")));

    }
}


