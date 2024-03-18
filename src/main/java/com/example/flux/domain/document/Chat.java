package com.example.flux.domain.document;

import com.example.flux.domain.dto.ChatRequest;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chat")
@Getter
public class Chat {
    @Id
    private final String id;
    private final String msg;
    private final String senderId;
    private final String roomId;
    @CreatedDate
    private final LocalDateTime sendDate;

    @Builder
    public Chat(String id, String msg, String senderId, String roomId, LocalDateTime sendDate) {
        this.id = id;
        this.msg = msg;
        this.senderId = senderId;
        this.roomId = roomId;
        this.sendDate = sendDate;
    }

    public static Chat toDocument(ChatRequest request) {
        return Chat.builder()
                .msg(request.msg())
                .senderId(request.senderId())
                .roomId(request.roomId())
                .build();
    }
}
