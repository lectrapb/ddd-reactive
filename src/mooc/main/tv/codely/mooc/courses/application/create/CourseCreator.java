package tv.codely.mooc.courses.application.create;


import tv.codely.shared.domain.UseCase;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.domain.CreateCourseRequest;
import tv.codely.mooc.courses.domain.value.CourseDuration;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.mooc.courses.domain.value.CourseName;


@UseCase
@AllArgsConstructor
public final class CourseCreator {

     private final CourseRepository repository;

     public Mono<Void> create(CreateCourseRequest request) {

         return   Mono.fromCallable(() -> new Course(new CourseId(request.id()),
                         new CourseName(request.name()), new CourseDuration(request.duration())))
                 .flatMap(repository::save)
                 .then(Mono.empty());

     }

}
