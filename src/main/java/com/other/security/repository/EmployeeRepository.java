package com.other.security.repository;

import com.other.security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {
    @Query(name = "select e from Employee e where e.phone = ?1")
    List<Employee> findByPhone(final String phone);

    @Query(name = "select e from Employee e where e.email = ?1")
    Optional<Employee> findByEmail(final String email);

}
