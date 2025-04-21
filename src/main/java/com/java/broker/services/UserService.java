package com.java.broker.services;

import com.java.broker.dto.UserDto;
import com.java.broker.entity.UserEntity;
import com.java.broker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity save(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new IllegalStateException("User with email " + userDto.getEmail() + " already exists");
        }
        UserEntity userEntity = UserEntity.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getUsername())
                .role(userDto.getRole())
                .build();
        return userRepository.save(userEntity);
    }
}
