package com.example.flux.handler;


import com.example.flux.domain.document.Room;
import com.example.flux.domain.dto.MakeRoomRequest;
import com.example.flux.domain.dto.MakeRoomResponse;
import com.example.flux.service.RoomServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@Slf4j
@RequiredArgsConstructor
public class RoomHandler {

    private final RoomServiceImpl roomService;

    public Mono<ServerResponse> makeRoom(ServerRequest request) {
        return request.bodyToMono(MakeRoomRequest.class)
                .single()
                .flatMap(makeRoomRequest -> {
                    log.debug("make room name : {}", makeRoomRequest.name());
                    log.debug("make room owner : {}", makeRoomRequest.ownerId());
                    return ok().body(roomService.makeRoom(makeRoomRequest).map(Room::toResponse), MakeRoomResponse.class);
                });
    }

    public Mono<ServerResponse> findRooms(ServerRequest request) {
        return ok().body(roomService.getRooms(), Room.class);
    }
}
