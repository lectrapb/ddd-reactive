package tv.codely.mooc.courses_counter.application.increment;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import tv.codely.mooc.courses.domain.event.CourseCreatedDomainEvent;
import tv.codely.mooc.courses.domain.value.CourseId;

@AllArgsConstructor
public class IncrementCoursesCounterOnCourseCreatedimp {

    private final CoursesCounterIncrementer incrementer;

    @EventListener
    public void on(CourseCreatedDomainEvent event) {
        CourseId courseId = new CourseId(event.aggregateId());
        incrementer.increment(courseId);
    }
}
