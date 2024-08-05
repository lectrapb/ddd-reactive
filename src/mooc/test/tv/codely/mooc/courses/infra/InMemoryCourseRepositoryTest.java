package tv.codely.mooc.courses.infra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.domain.value.CourseDuration;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.mooc.courses.domain.value.CourseName;

import java.util.Optional;
import java.util.UUID;

class InMemoryCourseRepositoryTest {

    private CourseRepository repository;

    @BeforeEach
    void setUp() {
        this.repository = new InMemoryCourseRepository();
    }

    @Test
    void save_a_valid_course_test() {
        //Given
        var course =  new Course(new CourseId(UUID.randomUUID().toString()), new CourseName("java"), new CourseDuration("1000"));
        //When
        repository.save(course);
        //Then
    }

    @Test
    void search_a_valid_course_test() {
        //Given
        var course =  new Course(new CourseId(UUID.randomUUID().toString()), new CourseName("java"), new CourseDuration("1000"));
        //When
        repository.save(course);
        //then
         repository.findById(course.id().value())
                 .as(StepVerifier::create)
                 .expectNext(Optional.of(course))
                 .verifyComplete();
    }

    @Test
    void search_a_non_valid_course_test() {
        //Given
        var course =  new Course(new CourseId(UUID.randomUUID().toString()), new CourseName("java"), new CourseDuration("1000"));
        //When
        repository.save(course);
        //then
        repository.findById(UUID.randomUUID().toString())
                .as(StepVerifier::create)
                .expectNext(Optional.empty());

    }


}