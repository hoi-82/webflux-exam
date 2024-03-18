package com.example.flux.service;

import com.example.flux.domain.document.Chat;
import com.example.flux.domain.dto.ChatRequest;
import com.example.flux.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChattingServiceImpl implements ChattingService {
    private final ChatRepository chatRepository;

    @Override
    public Mono<Chat> regChat(ChatRequest request) {
        return chatRepository.save(Chat.toDocument(request));
    }

    @Override
    public Mono<Chat> getChat() {
        return null;
    }

    @Override
    public Flux<Chat> getChatsByRoomId(String roomId) {
        return chatRepository.findByRoomId(roomId);
    }
}
