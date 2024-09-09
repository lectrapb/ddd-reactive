package tv.codely.mooc.courses.infra;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
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
        courseRepositoryPostgres.save(course)
                .map(Optional::of)
                .map(opt ->{
                    System.out.println("saved course: " + opt.get());
                    return opt;
                })
                .defaultIfEmpty(Optional.empty());

    }

    @Test
    void search_a_valid_course_test() {
        //Given
        var course =  CreateCourseMother.random();
        //When
       courseRepositoryPostgres.save(course);
        //then
       courseRepositoryPostgres.findById(course.id().value())
                .as(StepVerifier::create)
                .expectNext(Optional.of(course))
                .verifyComplete();
    }

    @Test
    void search_a_non_valid_course_test() {
        //Given
        var course =  CreateCourseMother.random();
        //When
       courseRepositoryPostgres.save(course);
        //then
       courseRepositoryPostgres.findById(UUID.randomUUID().toString())
                .as(StepVerifier::create)
                .expectNext(Optional.empty());

    }

    @Override
    public void execute(String[] args) {

    }
}
