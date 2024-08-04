package tv.codely.mooc.courses.domain;

import reactor.core.publisher.Mono;

import java.util.Optional;

public interface CourseRepository {

    Mono<Void> save(Course course);
    Mono<Optional<Course>> findById(String id);
}
