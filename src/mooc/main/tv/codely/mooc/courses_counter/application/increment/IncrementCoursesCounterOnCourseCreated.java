package tv.codely.mooc.courses_counter.application.increment;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import tv.codely.mooc.courses.domain.event.CourseCreatedDomainEvent;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.shared.domain.event.DomainEvent;
import tv.codely.shared.infra.bus.event.spring.ReactiveEventBus;


@Component
public class IncrementCoursesCounterOnCourseCreated {

    private final ReactiveEventBus eventBus;
    private final CoursesCounterIncrementer incrementer;

    public IncrementCoursesCounterOnCourseCreated(ReactiveEventBus eventBus, CoursesCounterIncrementer incrementer) {
        this.eventBus = eventBus;
        this.incrementer = incrementer;
    }

    @PostConstruct
    public void init() {
        Flux<DomainEvent<?>> eventFlux = eventBus.getSink().asFlux();
        Disposable subscription = eventFlux
                .filter(event -> event instanceof CourseCreatedDomainEvent)
                .cast(CourseCreatedDomainEvent.class)
                .subscribe(this::onCourseCreated);
    }

    private void onCourseCreated(CourseCreatedDomainEvent event) {
        CourseId courseId = new CourseId(event.aggregateId());
        incrementer.increment(courseId);
    }
}
