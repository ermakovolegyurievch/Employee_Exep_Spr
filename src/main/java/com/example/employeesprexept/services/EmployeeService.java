package com.example.employeesprexept.services;

import com.example.employeesprexept.exeptions.EmployeeAlreadyAddedException;
import com.example.employeesprexept.exeptions.EmployeeNotFoundException;
import com.example.employeesprexept.exeptions.EmployeeStorageIsFullException;
import com.example.employeesprexept.main.Employee;
import org.springframework.stereotype.Service;

@Service

public class EmployeeService {
    private final Employee[] employee = new Employee[employeeListSize];
    private static final int employeeListSize = 5;

    public Employee add(String firstName, String secondName) {
        Employee temp = new Employee(firstName, secondName);
        for (Employee obj : employee) {
            if (temp.equals(obj)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = temp;
                return temp;
            }

        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String firstName, String secondName) {
        Employee temp = new Employee(firstName, secondName);
        for (int i = 0; i < employee.length; i++) {
            if (temp.equals(employee[i])) {
                employee[i] = null;
                return temp;
            }
        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String secondName) {
        Employee temp = new Employee(firstName, secondName);
        for (Employee obj : employee) {
            if (temp.equals(obj)) {
                return temp;
            }
        }
        throw new EmployeeNotFoundException();
    }
}