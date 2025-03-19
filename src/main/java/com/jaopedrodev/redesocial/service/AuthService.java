package com.jaopedrodev.redesocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jaopedrodev.redesocial.dto.SignUpDto;
import com.jaopedrodev.redesocial.exception.InvalidJwtException;
import com.jaopedrodev.redesocial.model.UserModel;
import com.jaopedrodev.redesocial.repository.UserRepository;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByEmail(username);
        return user;
    }

    public UserDetails signUp(SignUpDto data) throws InvalidJwtException {
        if (repository.findByEmail(data.email()) != null) {
            throw new InvalidJwtException("E-mail already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.email(), data.name(), encryptedPassword, data.role());
        return repository.save(newUser);
    }
}
