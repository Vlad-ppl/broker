package com.java.broker.dto;

import com.java.broker.entity.role.Role;
import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String password;
    private Role role;
    private String email;

}
