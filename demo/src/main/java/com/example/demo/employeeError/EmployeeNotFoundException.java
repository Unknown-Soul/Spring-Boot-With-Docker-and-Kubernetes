package com.example.demo.employeeError;

public class EmployeeNotFoundException extends  RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
