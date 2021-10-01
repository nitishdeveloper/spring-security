package com.other.security.services;

import com.other.security.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    Employee saveEmployee(final Employee employee);
    List<Employee> findAllEmployees(final Integer pageNum , final Integer pageSize , final String sortBy);
    Employee updateEmployee(final Employee employee);
    boolean deleteEmployee(final String phoneNumber);

}
