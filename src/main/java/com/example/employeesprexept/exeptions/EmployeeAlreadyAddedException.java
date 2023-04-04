package com.example.employeesprexept.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
    }
}
