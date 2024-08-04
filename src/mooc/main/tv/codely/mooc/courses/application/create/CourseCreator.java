package tv.codely.mooc.courses.application.create;


import com.app.domain.UseCase;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;


@UseCase
@AllArgsConstructor
public final class CourseCreator {

     private final CourseRepository repository;

     public Mono<Void> create(String id, String name, String description) {

         return   Mono.fromCallable(() -> new Course(id, name, description))
                 .flatMap(repository::save)
                 .then(Mono.empty());

     }

}
