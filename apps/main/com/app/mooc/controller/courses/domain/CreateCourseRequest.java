package com.app.mooc.controller.courses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCourseRequest {

    private String name;
    private String duration;
}
