package tv.codely.mooc.courses.infra.persistence.in_memory;

import reactor.core.publisher.Mono;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;

import java.util.HashMap;
import java.util.Optional;


public class InMemoryCourseRepository implements CourseRepository {

    private HashMap<String, Course> courses = new HashMap<>();

    @Override
    public Mono<Void> save(Course course) {
        this.courses.put(course.id().value(), course);
        return Mono.empty();
    }

    @Override
    public Mono<Optional<Course>> findById(String id) {
        return Mono.just(Optional.ofNullable(courses.get(id)));
    }
}
