package com.jaopedrodev.redesocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaopedrodev.redesocial.config.auth.TokenProvider;
import com.jaopedrodev.redesocial.dto.JwtDto;
import com.jaopedrodev.redesocial.dto.SignInDto;
import com.jaopedrodev.redesocial.dto.SignUpDto;
import com.jaopedrodev.redesocial.exception.InvalidJwtException;
import com.jaopedrodev.redesocial.model.UserModel;
import com.jaopedrodev.redesocial.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDto data) throws InvalidJwtException {
        authService.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtDto> signIn(@RequestBody @Valid SignInDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        var authUser = authenticationManager.authenticate(usernamePassword);

        var accessToken = tokenProvider.generateAccessToken((UserModel) authUser.getPrincipal());

        return ResponseEntity.ok(new JwtDto(accessToken));
    }
}
