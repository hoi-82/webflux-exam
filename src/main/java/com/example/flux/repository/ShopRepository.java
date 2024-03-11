package com.example.flux.repository;

import com.example.flux.domain.document.Shop;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends ReactiveCrudRepository<Shop, String> {
}
