package com.apps.mooc.controller.courses.application;

import com.apps.mooc.controller.courses.domain.CreateCourseHttpRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import tv.codely.mooc.courses.application.create.CourseCreator;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.domain.CreateCourseRequest;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class CoursesPutController {

    private final CourseCreator creator;

    public CoursesPutController(CourseRepository repository) {
        this.creator = new CourseCreator(repository);
    }

    public Mono<ServerResponse> handler(ServerRequest request) {


        var id = request.pathVariable("id");
        return  request.bodyToMono(CreateCourseHttpRequest.class)
                .flatMap(reqDto ->creator.create(new CreateCourseRequest(id, reqDto.getName(),
                                reqDto.getDuration())))
                .then(ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue("")));
    }
}


