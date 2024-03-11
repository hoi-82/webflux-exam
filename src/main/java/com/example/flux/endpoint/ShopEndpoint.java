package com.example.flux.endpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Component
public class ShopEndpoint {
    @Bean
    RouterFunction<ServerResponse> shopEndPoint() throws Exception {
        return RouterFunctions.route(RequestPredicates.GET("/")
        , request -> ServerResponse.ok().body(Mono.just(""), String.class));
    }
}
