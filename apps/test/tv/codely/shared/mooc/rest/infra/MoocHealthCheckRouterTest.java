package tv.codely.shared.mooc.rest.infra;

import tv.codely.shared.share.application.ApplicationTestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;
import tv.codely.shared.share.application.ApplicationTestCase;


class MoocHealthCheckRouterTest extends ApplicationTestCase {

    @Autowired
    private WebTestClient client;

    @Test
    void check_health_check_is_working() {

        assertRequestBody(HttpMethod.GET,
                "/mooc/health",
                "",200,
                "{'status': 'ok'}");

    }


}