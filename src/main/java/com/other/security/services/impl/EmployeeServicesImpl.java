package com.other.security.services.impl;

import com.other.security.entity.Employee;
import com.other.security.exceptions.ResourceFoundException;
import com.other.security.repository.EmployeeRepository;
import com.other.security.services.EmployeeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        List<Employee> employeeList = employeeRepository.findByPhone(employee.getPhone());
        log.info("Employee phone number : {}",employee.getPhone());
        if(employeeList.size() != 0){
            throw new ResourceFoundException(String.format("Employee is already registered with this %s mobile number",employee.getPhone()));
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees(Integer pageNum, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy).descending());
        Page<Employee> pageResult = employeeRepository.findAll(pageable);
        return pageResult.hasContent() ? pageResult.getContent() : new ArrayList<>();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployee(String phoneNumber) {
        return false;
    }


}
