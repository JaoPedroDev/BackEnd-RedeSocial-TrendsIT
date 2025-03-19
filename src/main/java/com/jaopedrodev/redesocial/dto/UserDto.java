package com.jaopedrodev.redesocial.dto;

import com.jaopedrodev.redesocial.enums.UserRole;

public record UserDto(
        String email,
        String name,
        UserRole role) {
}
