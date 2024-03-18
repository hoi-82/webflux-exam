package com.example.flux.handler;

import com.example.flux.domain.document.Chat;
import com.example.flux.domain.dto.ChatRequest;
import com.example.flux.service.ChattingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChattingHandler {

    private final ChattingServiceImpl chattingService;

    public Mono<ServerResponse> getChatsByRoomId(ServerRequest request) {
        String roomId = request.pathVariable("roomId");
        log.debug("room id : {}", roomId);
        return ok().body(chattingService.getChatsByRoomId(roomId), Chat.class)
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<ServerResponse> regChat(ServerRequest request) {
        return request.bodyToMono(ChatRequest.class)
                .single()
                .flatMap(chatRequest -> {
                    log.debug("[chat] {} : {}", chatRequest.senderId(), chatRequest.msg());
                    return ok().body(chattingService.regChat(chatRequest), Chat.class);
                });
    }

}
