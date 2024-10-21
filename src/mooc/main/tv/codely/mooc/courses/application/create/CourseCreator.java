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
import tv.codely.shared.domain.bus.EventBus;


@UseCase
@AllArgsConstructor
public final class CourseCreator {

     private final CourseRepository repository;
     private final EventBus eventBus;

     public Mono<Void> create(CreateCourseRequest request) {
         var course = Course.of(request.id(), request.name(), request.duration());

         return   Mono.fromCallable(() -> course)
                 .flatMap(repository::save)
                 .then(eventBus.publish(course.pullDomainEvents()))
                 .then(Mono.empty());

     }

}
