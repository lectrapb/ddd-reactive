package com.app.backoffice.rest.infra;

import com.app.share.application.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;

import static org.junit.jupiter.api.Assertions.*;

class BackOfficeHealthCheckRouterTest extends ApplicationTestCase {

    @Test
    void router_health_check_test() {
        assertRequestBody(HttpMethod.GET,
                "/backoffice/health",
                "",200,
                "{'status': 'ok'}");
    }
}