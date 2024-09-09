package com.apps.mooc.controller.courses.infra;

import com.apps.mooc.controller.courses.application.CoursesPutController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CoursesRouter {

    @Bean
    public RouterFunction<ServerResponse> routeCourseCreation(@Value("/courses/{id}") String url,
                                                              CoursesPutController controller) {

        return route(PUT(url), controller::handler);
    }
}
