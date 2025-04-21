package com.java.broker.repository;

import com.java.broker.entity.BinanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BinanceRepository extends JpaRepository<BinanceEntity, Long> {
    Optional<BinanceEntity> findById(Long username);
   // Optional<BinanceEntity> findByEmail(String email);
}
