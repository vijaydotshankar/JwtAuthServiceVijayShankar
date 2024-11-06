package com.vijay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupDTO {

    @NotBlank(message = "name is required")
    private String name;

    @Email(message = "must be email")
    @NotBlank(message = "can't be blank")
    private String email;

    @NotBlank(message = "password can't be blank")
    private String password;

    private String mobileNumber;

    private List<String> roles=new ArrayList<>();

    private String createdBy;

    private String updatedBy;


}
