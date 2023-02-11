package com.zaurtregulov.spring.springboot.springboot_rest.controller;

import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
import com.zaurtregulov.spring.springboot.springboot_rest.exception_handling.NoSuchEmployeeException;
import com.zaurtregulov.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/api" )
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping( "/employees" )
    public List<Employee> showAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping( "/employees/{id}" )
    public Optional<Employee> getEmployee(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee.isEmpty()) {
            throw new NoSuchEmployeeException("There is not employee with ID " + id + " in database");
        }
        return employee;
    }

    @PostMapping( "/employees" )
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping( "/employees" )
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }


    @DeleteMapping( "/employees/{id}" )
    public String deleteEmployee(@PathVariable int id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee.isEmpty()) {
            throw new NoSuchEmployeeException("There is not employee with ID " + id + " in database");
        }

        employeeService.deleteEmployee(id);
        return "Employee with Id = " + id + " was deleted;  ";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }
}
