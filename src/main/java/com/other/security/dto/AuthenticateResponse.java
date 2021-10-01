package com.other.security.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticateResponse {
    private Long id;
    private String empCode;
    private String password;
}
