package com.jaopedrodev.redesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.jaopedrodev.redesocial.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserDetails findByEmail(String email);
}
