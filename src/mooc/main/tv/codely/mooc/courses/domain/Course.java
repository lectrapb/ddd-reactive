package tv.codely.mooc.courses.domain;

import lombok.Data;
import tv.codely.mooc.courses.domain.event.CourseCreatedDomainEvent;
import tv.codely.mooc.courses.domain.value.CourseDuration;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.mooc.courses.domain.value.CourseName;
import tv.codely.shared.domain.AggregateRoot;

import java.util.Objects;

@Data
public class Course extends AggregateRoot {

    private CourseId id;
    private CourseName name;
    private CourseDuration duration;

    public Course(CourseId id, CourseName courseName, CourseDuration courseDuration) {
        this.id = id;
        this.name = courseName;
        this.duration = courseDuration;
    }

    public static Course of(String id, String name, String duration) {

        var course = new Course(new CourseId(id), new CourseName(name), new CourseDuration(duration));
        course.record(new CourseCreatedDomainEvent(course.id.value(), course.name.value(), course.duration.value()));
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name.value(), course.name.value()) && Objects.equals(duration.value(), course.duration.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id.value(), name.value(), duration.value());
    }
}
