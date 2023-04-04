package com.example.employeesprexept.services;

import com.example.employeesprexept.exeptions.EmployeeAlreadyAddedException;
import com.example.employeesprexept.exeptions.EmployeeNotFoundException;
import com.example.employeesprexept.exeptions.EmployeeStorageIsFullException;
import com.example.employeesprexept.main.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class EmployeeService {
    List<Employee> employee = new ArrayList<>();
    private static final int employeeListSize = 10;

    public Employee add(String firstName, String secondName) {
        Employee temp = new Employee(firstName, secondName);

        if (employee.size() >= employeeListSize) {
            throw new EmployeeStorageIsFullException();
        }
        if (employee.contains(temp)) {
            throw new EmployeeAlreadyAddedException();
        }
        employee.add(temp);
        return temp;
    }


    public Employee remove(String firstName, String secondName) {
        Employee temp = new Employee(firstName, secondName);
        if (employee.contains(temp)) {
            employee.remove(temp);
            return temp;
        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String secondName) {
        Employee temp = new Employee(firstName, secondName);
        if (employee.contains(temp)) {
            return temp;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> list() {
        return Collections.unmodifiableList(employee);
    }
}
