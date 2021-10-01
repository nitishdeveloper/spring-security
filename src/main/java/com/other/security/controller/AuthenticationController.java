package com.other.security.controller;

import com.other.security.config.JwtTokens;
import com.other.security.dto.AuthenticateRequest;
import com.other.security.dto.AuthenticateResponse;
import com.other.security.entity.Credentials;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokens jwtToken;


    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokens jwtToken) {
        this.authenticationManager = authenticationManager;
        this.jwtToken = jwtToken;
    }

    @PostMapping("/request")
    ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest request){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmpCode(),request.getPassword())
            );
            Credentials user = (Credentials) authentication.getPrincipal();
            AuthenticateResponse response = AuthenticateResponse.builder()
                    .empCode(user.getEmployeeCode())
                    .password(user.getPassword())
                    .id(user.getId()).build();
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,jwtToken.generateToken(user)).body(response);
        }catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
