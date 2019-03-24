package com.company.controllers;

import com.company.entities.Employee;
import com.company.entities.Subsidiary;
import com.company.exceptions.IdMismatchException;
import com.company.exceptions.NotFoundException;
import com.company.services.EmployeeServiceImpl;
import com.company.services.SubsidiaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubsidiaryController {
    @Autowired
    SubsidiaryServiceImpl subsidiaryService;
    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/subsidiaries")
    private ResponseEntity <List <Subsidiary>> displayAll() {
        List <Subsidiary> subsidiaries = subsidiaryService.getAll ( );
        return new ResponseEntity <> (subsidiaries, HttpStatus.OK);
    }

    @PostMapping("/subsidiaries")
    private ResponseEntity <Subsidiary> addNew(@RequestBody Subsidiary subsidiary) {
        subsidiaryService.saveOrUpdate (subsidiary);
        return new ResponseEntity <> (subsidiary, HttpStatus.OK);
    }

    @GetMapping("/subsidiaries/{subsidiaryId}")
    private ResponseEntity <?> getById(@PathVariable("subsidiaryId") Integer id) {
        Subsidiary subsidiary = subsidiaryService.getById (id);
        if (subsidiary == null) {
            throw new NotFoundException ("subsidiary", id.toString ( ));
        }
        return new ResponseEntity <> (subsidiary, HttpStatus.OK);
    }

    @PutMapping("/subsidiaries/{subsidiaryId}")
    private ResponseEntity <?> update(@RequestBody Subsidiary subsidiary, @PathVariable("subsidiaryId") Integer id) {
        Subsidiary currentSubsidiary = subsidiaryService.getById (id);
        if (currentSubsidiary == null) {
            throw new NotFoundException ("subsidiary", id.toString ( ));
        } else if (id != subsidiary.getId ( )) {
            throw new IdMismatchException ( );
        }
        subsidiaryService.saveOrUpdate (subsidiary);
        return new ResponseEntity <> (subsidiary, HttpStatus.OK);
    }

    @DeleteMapping("/subsidiaries/{subsidiaryId}")
    private ResponseEntity <?> deleteById(@PathVariable("subsidiaryId") Integer id) {
        Subsidiary currentSubsidiary = subsidiaryService.getById (id);
        if (currentSubsidiary == null) {
            throw new NotFoundException ("subsidiary", id.toString ( ));
        }
        subsidiaryService.deleteByID (id);
        return new ResponseEntity <> ("The subsidiary was deleted", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/subsidiaries/{subsidiaryId}/employees")
    private ResponseEntity <List <Employee>> getEmployeefFromSubsidiary(@PathVariable("subsidiaryId") Integer id) {
        List<Employee> employees = employeeService.getAllBySubsidiaryId (id);
        for (Employee item : employees) {
        }
        return new ResponseEntity <> (employees,HttpStatus.OK);
    }
}
