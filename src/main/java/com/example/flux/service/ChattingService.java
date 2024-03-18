package com.example.flux.service;

import com.example.flux.domain.document.Chat;
import com.example.flux.domain.dto.ChatRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChattingService {
    Mono<Chat> regChat(ChatRequest request);
    Mono<Chat> getChat();
    Flux<Chat> getChatsByRoomId(String roomId);
}
