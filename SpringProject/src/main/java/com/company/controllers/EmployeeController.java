package com.company.controllers;

import com.company.entities.Employee;
import com.company.exceptions.DeletedSuccesfullException;
import com.company.exceptions.IdMismatchException;
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
        } else if (id != employee.getId ( )) {
            throw new IdMismatchException ( );
        }
        employeeService.saveOrUpdate (employee);

        return new ResponseEntity <> (employee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    private void deleteById(@PathVariable("employeeId") Integer id) {
        Employee employee = employeeService.getById (id);
        if (employee == null) {
            throw new NotFoundException ("employee", id.toString ( ));
        } else {
            employeeService.deleteById (id);
            throw new DeletedSuccesfullException ( );
        }

    }

}
