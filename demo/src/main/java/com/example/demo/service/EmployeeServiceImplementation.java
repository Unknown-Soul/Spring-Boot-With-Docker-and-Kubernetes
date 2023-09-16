package com.example.demo.service;

import com.example.demo.employeeError.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImplementation implements EmployeeService {


    List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if (Objects.isNull(employee.getEmployerId()) || employee.getEmployerId().isEmpty()) {
            employee.setEmployerId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployee(String employeeId) {
        if (!Objects.isNull(employeeId)) {
            return Arrays.asList(
                    employeeList.stream().
                            filter(it -> it.getEmployerId().equals(employeeId)).findFirst().orElseThrow(() -> new EmployeeNotFoundException("error")));
        }
        return employeeList;
    }
}
