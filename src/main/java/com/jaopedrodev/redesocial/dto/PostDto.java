package com.jaopedrodev.redesocial.dto;

import java.time.LocalDateTime;

public record PostDto(
        Long id,
        String title,
        String content,
        UserDto author,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
