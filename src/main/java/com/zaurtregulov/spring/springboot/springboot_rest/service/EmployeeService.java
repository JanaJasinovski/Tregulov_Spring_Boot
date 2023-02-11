package com.zaurtregulov.spring.springboot.springboot_rest.service;


import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Optional<Employee> getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> findAllByName(String name);
}
