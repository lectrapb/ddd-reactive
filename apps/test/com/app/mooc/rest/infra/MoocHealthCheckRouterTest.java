package com.app.mooc.rest.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;


class MoocHealthCheckRouterTest extends ApplicationTestCase {

    @Autowired
    private WebTestClient client;

    @Test
    void check_health_check_is_working() {

        assertRequestBody(HttpMethod.GET.name(),
                "/mooc/health",
                "",200,
                "{'status': 'ok'}");

    }


}