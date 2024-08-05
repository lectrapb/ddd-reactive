package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.domain.CreateCourseRequest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CourseCreatorTest {

    private CourseCreator useCase;
    private CourseRepository repository;

    @BeforeEach
    void setUp() {
        this.repository = mock(CourseRepository.class);
        this.useCase = new CourseCreator(repository);
    }

    @Test
    void create() {
        //Given
        //When
        when(repository.save(any())).thenReturn(Mono.empty());
        //Then
        useCase.create(new CreateCourseRequest(UUID.randomUUID().toString(), "name", "1000"))
                .as(StepVerifier::create)
                .verifyComplete();
    }
}