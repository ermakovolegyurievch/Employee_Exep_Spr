package com.example.employeesprexept.controllers;

import com.example.employeesprexept.main.Employee;
import com.example.employeesprexept.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeesController {
    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.add(employee);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.find(firstName, secondName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String secondName) {
        return employeeService.remove(firstName, secondName);
    }

    @GetMapping("/print")
    public List<Employee> list() {
        return employeeService.list();
    }
}
