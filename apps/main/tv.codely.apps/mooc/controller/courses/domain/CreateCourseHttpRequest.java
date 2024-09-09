package tv.codely.apps.mooc.controller.courses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCourseHttpRequest {

    private String name;
    private String duration;
}
