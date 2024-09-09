package com.apps.shared.application;


import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

    public GlobalErrorWebExceptionHandler(ErrorAttributes errorAttributes,
                                          ApplicationContext applicationContext,
                                          ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, new WebProperties.Resources(), applicationContext);
        this.setMessageWriters(serverCodecConfigurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderException);
    }


    private Mono<ServerResponse> renderException(ServerRequest serverRequest) {

        return accessError(serverRequest)
                .flatMap(Mono::error)
                .onErrorResume(this::unknownError)
                .cast(ServerResponse.class);

    }

    public Mono<ServerResponse> unknownError(Throwable exception) {
        var error = exception.getMessage();
        return  ServerResponse
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .body(Mono.just(error), String.class);
    }

    private Mono<Throwable> accessError(ServerRequest request) {
        return Mono.just(request)
                .map(this::getError);
    }
}
