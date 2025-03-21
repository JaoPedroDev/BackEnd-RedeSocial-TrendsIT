package com.jaopedrodev.redesocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.jaopedrodev.redesocial.dto.UserDto;
import com.jaopedrodev.redesocial.model.UserModel;
import com.jaopedrodev.redesocial.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<UserModel> findAll() {
        return repository.findAll();
    }

    public UserDetails findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserModel currentUser = (UserModel) authentication.getPrincipal();

        return new UserDto(
                currentUser.getEmail(),
                currentUser.getName(),
                currentUser.getRole());
    }
}
