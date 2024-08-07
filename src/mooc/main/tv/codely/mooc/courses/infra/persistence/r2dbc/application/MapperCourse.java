package tv.codely.mooc.courses.infra.persistence.r2dbc.application;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.infra.persistence.r2dbc.domain.CourseModel;

public class MapperCourse {
    public static CourseModel toModel(Course course) {
        return CourseModel.builder()
                .id(course.id().value())
                .name(course.name().value())
                .duration(course.duration().value())
                .build();
    }


    public static Course toEntity(CourseModel courseModel) {

        return Course.of(courseModel.getId(), courseModel.getName(), courseModel.getDuration());
    }
}
