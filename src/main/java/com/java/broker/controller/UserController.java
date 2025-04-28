package com.java.broker.controller;

import com.java.broker.dto.UserDto;
import com.java.broker.entity.UserEntity;
import com.java.broker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}")
    public Optional<UserEntity> findById(@PathVariable Long id) {
        return Optional.ofNullable(userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }

    @GetMapping()
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping()
    public Optional<UserEntity> findByEmail(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    @PostMapping()
    public UserEntity save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

}
