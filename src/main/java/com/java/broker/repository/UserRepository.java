package com.java.broker.repository;

import com.java.broker.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long username);

    @EntityGraph(attributePaths = "binanceAccounts")
    Optional<UserEntity> findByEmail(String email);
}
