package com.app.mooc.rest.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ApplicationTestCase {

    @Autowired
    private WebTestClient client;

    public void assertRequestBody(
            String method,
            String endPoint,
            String body,
            Integer expectedStatusCode,
            String expectedBody
    ){

         client.method(HttpMethod.valueOf(method))
                 .uri(endPoint)
                 .body(fromValue(body))
                 .exchange()
                 .expectStatus().isEqualTo(expectedStatusCode)
                 .expectBody()
                 .json(expectedBody);
    }

}