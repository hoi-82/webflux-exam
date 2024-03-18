package com.example.flux.config;

import com.example.flux.handler.ChattingHandler;
import com.example.flux.handler.RoomHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * RouterConfig
 * 기능적 종점 (Functional Endpoint)를 구현하기 위한 클래스
 *
 * @author hoi-82
 */
@Configuration
@RequiredArgsConstructor
public class RouterConfig {

    private final ChattingHandler chattingHandler;
    private final RoomHandler roomHandler;

    /**
     * chat end point
     */
    @Bean
    public RouterFunction<ServerResponse> chatEndPoint() {
        return RouterFunctions.route()
                .path("/api/v1/chat", builder -> builder
                        .nest(accept(MediaType.TEXT_EVENT_STREAM), builder2 -> builder2
                                .GET("/room/{roomId}", chattingHandler::getChatsByRoomId)
                        )
                        .POST(chattingHandler::regChat)
                )
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> roomEndPoint() {
        return RouterFunctions.route()
                .path("/api/v1/room", builder -> builder
                        .POST(roomHandler::makeRoom)
                        .GET(roomHandler::findRooms)
                )
                .build();
    }
}
