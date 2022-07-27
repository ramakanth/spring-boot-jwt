package com.example.jwt.dto;

import lombok.Data;

@Data
public class RoleToUserRequest {
    private String username;
    private String roleName;
}
