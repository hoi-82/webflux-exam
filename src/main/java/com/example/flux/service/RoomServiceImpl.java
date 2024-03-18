package com.example.flux.service;

import com.example.flux.domain.document.Room;
import com.example.flux.domain.dto.MakeRoomRequest;
import com.example.flux.domain.dto.MakeRoomResponse;
import com.example.flux.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Mono<Room> getRoom() {
        return null;
    }

    @Override
    public Flux<Room> getRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Mono<Room> makeRoom(MakeRoomRequest request) {
        log.debug("room making...");
        return roomRepository.save(Room.toDocument(request));
    }
}
