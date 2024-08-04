package com.app.mooc.controller.courses.domain;

import lombok.Data;

@Data
public class CreateCourseRequest {

    private String name;
    private String duration;
}
