package com.java.broker.controller;

import com.java.broker.dto.UserDto;
import com.java.broker.entity.UserEntity;
import com.java.broker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/{id}")
    public Optional<UserEntity> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping("/email")
    public Optional<UserEntity> findByEmail(@RequestParam("email") String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/save")
    public UserEntity save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

}
