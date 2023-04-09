package com.example.employeesprexept.services;

import com.example.employeesprexept.main.Employee;
import org.springframework.stereotype.Service;

import java.util.*;


@Service

public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee) {
        return employee.getFirstName() + " " + employee.getSecondName();
    }

    public void add(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void remove(Employee employee) {
        employees.remove(getKey(employee));
    }

    public Employee find(Employee employee) {
        if (employees.containsKey(getKey(employee))) {
        }
        return employee;
    }
}
