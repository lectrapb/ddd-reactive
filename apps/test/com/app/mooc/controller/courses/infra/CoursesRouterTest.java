package com.app.mooc.controller.courses.infra;

import com.app.mooc.controller.courses.domain.CreateCourseRequest;
import com.app.share.application.ApplicationTestCase;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CoursesRouterTest extends ApplicationTestCase {

    @Test
    void router_create_course_test() throws JSONException {
        var id = UUID.randomUUID().toString();
        var url = "/courses/"+ id;
        var payload = new CreateCourseRequest("name", "Duration");
        assertRequestBody(HttpMethod.PUT,
                url,payload, HttpStatus.CREATED.value(),"");
    }
}