package tv.codely.mooc.courses.infra.persistence.r2dbc.application;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.infra.persistence.r2dbc.domain.CourseModel;

public class MapperCourse {
    public static CourseModel toModel(Course course) {
        return CourseModel.builder()
                .id(course.getId().value())
                .name(course.getName().value())
                .duration(course.getDuration().value())
                .build();
    }


    public static Course toEntity(CourseModel courseModel) {

        return Course.of(courseModel.getId(), courseModel.getName(), courseModel.getDuration());
    }
}
