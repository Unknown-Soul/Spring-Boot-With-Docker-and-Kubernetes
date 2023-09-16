package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployerController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee){
        return  employeeService.save(employee);
    }

    //localhost:8080/employee/getEmployee?employeeId=11
    //localhost:8080/employee/getEmployee?employeeId=11&mediaType=xml
    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public List<Employee> getEmployee(@RequestParam(required = false) String employeeId){
        return  employeeService.getEmployee(employeeId);
    }
}
