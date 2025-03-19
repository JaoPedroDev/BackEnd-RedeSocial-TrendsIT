package com.jaopedrodev.redesocial.enums;

public enum UserRole {
    ADMIN("ADMIN"),
    ALUNO("ALUNO"),
    PROFESSOR("PROFESSOR");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getValue() {
        return role;
    }
}
