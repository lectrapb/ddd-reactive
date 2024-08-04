package com.app.mooc.controller.courses.infra;

import com.app.share.application.ApplicationTestCase;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CoursesRouterTest extends ApplicationTestCase {

    @Test
    void router_create_course_test() throws JSONException {
        var id = UUID.randomUUID().toString();
        var url = "/courses/"+ id;
        var jsonObject = new JSONObject();
        jsonObject.put("name", "java-testing");
        jsonObject.put("duration", "1000");
        var payload = jsonObject.toString();
        assertRequestBody(HttpMethod.PUT,
                url,payload, HttpStatus.CREATED.value(),"");
    }
}