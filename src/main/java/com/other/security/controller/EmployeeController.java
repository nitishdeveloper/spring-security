package com.other.security.controller;


import com.other.security.entity.Employee;
import com.other.security.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/api")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @PostMapping
    private ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
     return new ResponseEntity<>(employeeServices.saveEmployee(employee), HttpStatus.OK);
    }


    @GetMapping
    private ResponseEntity<List<Employee>> findAllEmployeesEmployee(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
            ){
        return new ResponseEntity<>(employeeServices.findAllEmployees(pageNum ,pageSize,sortBy), HttpStatus.OK);
    }


}
