package com.other.security.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthenticateRequest {
    @NotNull
    private String empCode;

    @NotNull
    private String password;
}
