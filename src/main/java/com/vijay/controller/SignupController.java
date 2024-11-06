package com.vijay.controller;

import com.vijay.dto.SignupDTO;
import com.vijay.entity.User;
import com.vijay.service.SignupService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/signup")
public class SignupController {
    private final SignupService signupService;

    private final PasswordEncoder passwordEncoder;

    public SignupController(SignupService signupService, PasswordEncoder passwordEncoder) {
        this.signupService = signupService;
        this.passwordEncoder = passwordEncoder;
    }

    @Operation(summary = "perform signup here..")
    @PostMapping
    public ResponseEntity<String> signup(@Valid @RequestBody SignupDTO signupDTO) {


        signupService.saveCredetials(User.builder()
                .id(UUID.randomUUID().toString())
                        .name(signupDTO.getName())
                .email(signupDTO.getEmail())
                .password(passwordEncoder.encode(signupDTO.getPassword()))
                        .mobileNumber(signupDTO.getMobileNumber())
                        .createdBy(signupDTO.getCreatedBy())
                        .updatedBy(signupDTO.getUpdatedBy())
                .roles(signupDTO.getRoles())
                .build());

        return ResponseEntity.status(HttpStatus.CREATED).body("signup successfully done !!");

    }
}
