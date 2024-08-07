package tv.codely.mooc.courses.domain;

import java.util.UUID;

public class CreateCourseRequestMother {

    private static final String COURSE_NAME = "java-ddd";
    private static final String DURATION_COURSE = "1000";

    public static CreateCourseRequest createCourseRequest(String id, String name, String duration){

        return new CreateCourseRequest(id, name, duration);
    }

    public static CreateCourseRequest random() {
        return new CreateCourseRequest(UUID.randomUUID().toString(), COURSE_NAME, DURATION_COURSE);
    }
}
