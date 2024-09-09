package tv.codely.mooc.courses.domain;

import lombok.EqualsAndHashCode;
import tv.codely.mooc.courses.domain.value.CourseDuration;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.mooc.courses.domain.value.CourseName;

import java.util.Objects;


public record Course(CourseId id, CourseName name, CourseDuration duration) {

    public static Course of(String id, String name, String duration) {
        return new Course(new CourseId(id), new CourseName(name), new CourseDuration(duration));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(duration, course.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
