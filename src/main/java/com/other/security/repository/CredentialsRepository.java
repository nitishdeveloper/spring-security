package com.other.security.repository;

import com.other.security.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credentials , Long> {

    @Query(name = "select c from Credentials c where c.employeeCode = ?1")
    Optional<Credentials> findByEmployeeCode(final String employeeCode);
}
