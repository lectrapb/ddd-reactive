package tv.codely.mooc.courses.domain;

import tv.codely.mooc.courses.domain.value.CourseDuration;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.mooc.courses.domain.value.CourseName;

import java.util.UUID;

public class CreateCourseMother {

    private static  final String COURSE_NAME= "Java-ddd";
    private static final String COURSE_DURATION = "10";

    public static Course create(String id, String name, String description){
        return new Course(new CourseId(id), new CourseName(name), new CourseDuration(description));
    }

    public static Course random() {
        return new Course(new CourseId(UUID.randomUUID().toString()), new CourseName(COURSE_NAME), new CourseDuration(COURSE_DURATION));
    }
}
