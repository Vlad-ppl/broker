package com.java.broker.repository;

import com.java.broker.entity.BinanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinanceRepository extends JpaRepository<BinanceEntity, Long> {
}
