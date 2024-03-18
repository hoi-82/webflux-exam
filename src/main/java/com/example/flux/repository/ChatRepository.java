package com.example.flux.repository;

import com.example.flux.domain.document.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {
    @Tailable
    @Query("{roomId : ?0}")
    Flux<Chat> findByRoomId(String roomId);
}
