package tv.codely.mooc.courses.domain;

import tv.codely.mooc.courses.domain.value.CourseDuration;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.mooc.courses.domain.value.CourseName;

public record Course(CourseId id, CourseName name, CourseDuration duration) {

    public static Course of(String id, String name, String duration) {
        return new Course(new CourseId(id), new CourseName(name), new CourseDuration(duration));
    }
}
