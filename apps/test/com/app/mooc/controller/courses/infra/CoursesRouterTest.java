package com.app.mooc.controller.courses.infra;

import com.app.mooc.controller.courses.domain.CreateCourseHttpRequest;
import com.app.share.application.ApplicationTestCase;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.UUID;

class CoursesRouterTest extends ApplicationTestCase {

    @Test
    void router_create_course_test() throws JSONException {
        var id = UUID.randomUUID().toString();
        var url = "/courses/"+ id;
        var payload = new CreateCourseHttpRequest("name", "Duration");
        assertRequestBody(HttpMethod.PUT,
                url,payload, HttpStatus.CREATED.value(),"");
    }
}