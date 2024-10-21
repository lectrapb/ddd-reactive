package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.domain.CreateCourseRequestMother;
import tv.codely.shared.domain.bus.EventBus;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CourseCreatorTest {

    private CourseCreator useCase;
    private CourseRepository repository;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        this.repository = mock(CourseRepository.class);
        this.eventBus = mock(EventBus.class);
        this.useCase = new CourseCreator(repository, eventBus);
    }

    @Test
    void create() {
        //Given
        //When
        when(repository.save(any())).thenReturn(Mono.empty());
        when(eventBus.publish(any())).thenReturn(Mono.empty());
        //Then
        useCase.create(CreateCourseRequestMother.random())
                .as(StepVerifier::create)
                .verifyComplete();
    }
}