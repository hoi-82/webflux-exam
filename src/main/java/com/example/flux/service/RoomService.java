package com.example.flux.service;

import com.example.flux.domain.document.Room;
import com.example.flux.domain.dto.MakeRoomRequest;
import com.example.flux.domain.dto.MakeRoomResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoomService {
    Mono<Room> getRoom();
    Flux<Room> getRooms();
    Mono<Room> makeRoom(MakeRoomRequest request);
}
