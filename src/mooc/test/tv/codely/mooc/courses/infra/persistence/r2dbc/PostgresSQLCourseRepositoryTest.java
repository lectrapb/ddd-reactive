package tv.codely.mooc.courses.infra.persistence.r2dbc;


import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import tv.codely.mooc.courses.domain.CreateCourseMother;

import java.util.Optional;
import java.util.UUID;


public class PostgresSQLCourseRepositoryTest extends CoursesModuleInfrastructureTestCase {


    @Test
    void save_a_valid_course_test() {
        //Given
        var course =  CreateCourseMother.random();
        //When
        var result = courseRepositoryPostgres.save(course);
        //then
        StepVerifier.create(result)
               .verifyComplete();

    }

    @Test
    void search_a_valid_course_test() {
        //Given
        var course =  CreateCourseMother.random();
        //When
       courseRepositoryPostgres.save(course)
               .map(Optional::of)
               .map(opt ->courseRepositoryPostgres.findById(course.getId().value())
                           .as(StepVerifier::create)
                           .expectNext(Optional.of(course))
                           .verifyComplete());
        //then

    }

    @Test
    void search_a_non_valid_course_test() {
        // Given
        var course = CreateCourseMother.random();
        var randomId = UUID.randomUUID().toString();

        // When
        var saveOperation = courseRepositoryPostgres.save(course)
                .doOnNext(savedCourse -> System.out.println("Hey, saved course: " + savedCourse))
                .then(courseRepositoryPostgres.findById(randomId));

        // Then
        StepVerifier.create(saveOperation)
                .expectNext(Optional.empty())
                .verifyComplete();

        // Verificación del curso guardado
        StepVerifier.create(courseRepositoryPostgres.findById(course.getId().value()))
                .expectNextMatches(optionalCourse -> {
                    if (optionalCourse.isPresent()) {
                        System.out.println("Hey, saved course: " + optionalCourse.get());
                        return optionalCourse.get().equals(course);
                    }
                    return false;
                })
                .verifyComplete();
    }



}
