package com.example.flux.repository;

import com.example.flux.domain.document.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends ReactiveMongoRepository<Room, String> {
}
