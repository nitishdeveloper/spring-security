package com.other.security.services.impl;

import com.other.security.exceptions.ResourceNotFoundException;
import com.other.security.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class EmployeeServiceDetails implements UserDetailsService {


    @Autowired
    CredentialsRepository credentialsRepository;

    @Override
    public UserDetails loadUserByUsername(final String employeeCode) throws UsernameNotFoundException {
        return credentialsRepository.findByEmployeeCode(employeeCode).orElseThrow(
                () -> new ResourceNotFoundException(String.format("employee not found %s",employeeCode)));
    }


}
