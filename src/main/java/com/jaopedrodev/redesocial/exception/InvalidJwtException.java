package com.jaopedrodev.redesocial.exception;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtException extends AuthenticationException {
    public InvalidJwtException(String ex) {
        super(ex);
    }

}
