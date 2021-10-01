package com.other.security.controller;


import com.other.security.entity.Credentials;
import com.other.security.entity.Role;
import com.other.security.repository.CredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(path = "api/admin/")
@RolesAllowed(Role.USER_ADMIN)
@RequiredArgsConstructor
public class EmployeeAdmin {

    CredentialsRepository credentialsRepository;

    @PostMapping("add")
    @RolesAllowed(Role.AUTHOR_ADMIN)
    private ResponseEntity<Credentials> saveEmployee(@RequestBody Credentials credentials){
        return new ResponseEntity<>(credentialsRepository.save(credentials), HttpStatus.OK);
    }
}
