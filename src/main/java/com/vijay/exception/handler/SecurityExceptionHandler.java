package com.vijay.exception.handler;

import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class SecurityExceptionHandler {

    @ExceptionHandler(value = MalformedJwtException.class)
    public ResponseEntity<Map<String, String>> malformedJwtException(SignatureException exception) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("token malformed ", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(errorMap);
    }


    @ExceptionHandler(value = SignatureException.class)
    public ResponseEntity<Map<String, String>> signatureException(SignatureException exception) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("signature changed ", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(errorMap);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> usernameNotFoundEx(UsernameNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("invalid credentials  ", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> badCredentialsException(BadCredentialsException exception) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("bad  credentials  ", exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMap);
    }
}
