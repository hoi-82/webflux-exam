package com.example.flux.domain.document;

import com.example.flux.domain.dto.MakeRoomRequest;
import com.example.flux.domain.dto.MakeRoomResponse;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Document(collection = "room")
@Getter
public class Room {
    @Id
    private final String id;
    private final String name;
    private final String ownerId;
    private final List<String> participants;
    @CreatedDate
    private final LocalDateTime createdDate;

    @Builder
    public Room(String id, String name, String ownerId, List<String> participants, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.participants = participants;
        this.createdDate = createdDate;
    }

    public static Room toDocument(MakeRoomRequest request) {
        return Room.builder()
                .name(request.name())
                .ownerId(request.ownerId())
                .participants(new ArrayList<>(Collections.singletonList(request.ownerId())))
                .build();
    }

    public MakeRoomResponse toResponse() {
        return new MakeRoomResponse(this.id, this.name);
    }
}
