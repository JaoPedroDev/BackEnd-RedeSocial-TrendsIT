package com.jaopedrodev.redesocial.dto;

import com.jaopedrodev.redesocial.enums.UserRole;

public record SignUpDto(
        String email,
        String name,
        String password,
        UserRole role) {
}
