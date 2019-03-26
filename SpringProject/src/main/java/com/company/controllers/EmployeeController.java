package com.company.controllers;

import com.company.entities.Employee;
import com.company.exceptions.NotFoundException;
import com.company.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private ResponseEntity <?> displayAll() {
        List <Employee> employees = employeeService.getAll ( );

        return new ResponseEntity <> (employees, HttpStatus.OK);
    }

    @PostMapping("/employees")
    private ResponseEntity <?> save(@RequestBody Employee employee) {
        employeeService.saveOrUpdate (employee);

        return new ResponseEntity <> (employee, HttpStatus.CREATED);
    }

    @GetMapping("/employees/{employeeId}")
    private ResponseEntity <?> getById(@PathVariable("employeeId") Integer id) {
        Employee employee = employeeService.getById (id);
        if (employee == null) {
            throw new NotFoundException ("employee", id.toString ( ));
        }

        return new ResponseEntity <> (employee, HttpStatus.OK);
    }

    @PutMapping("/employees/{employeeId}")
    private ResponseEntity <?> update(@RequestBody Employee employee, @PathVariable("employeeId") Integer id) {
        Employee currentEmployee = employeeService.getById (id);
        if (currentEmployee == null) {
            throw new NotFoundException ("employee", id.toString ( ));
        }
        currentEmployee.setName (employee.getName ( ));
        currentEmployee.setSurname (employee.getSurname ( ));
        currentEmployee.setSubsidiary (employee.getSubsidiary ( ));
        currentEmployee.setRole (employee.getRole ( ));
        currentEmployee.setEmail (employee.getEmail ( ));
        currentEmployee.setAddress (employee.getAddress ( ));
        currentEmployee.setPhone (employee.getPhone ( ));
        employeeService.saveOrUpdate (currentEmployee);

        return new ResponseEntity <> (currentEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    private ResponseEntity <?> deleteById(@PathVariable("employeeId") Integer id) {
        Employee employee = employeeService.getById (id);
        if (employee == null) {
            throw new NotFoundException ("employee", id.toString ( ));
        }
        employeeService.deleteById (id);
        return new ResponseEntity <> (HttpStatus.NO_CONTENT);


    }

}
