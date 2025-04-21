package com.java.broker.dto;

import com.java.broker.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String username;
    private String password;
    private Role role;
    private String email;

}
