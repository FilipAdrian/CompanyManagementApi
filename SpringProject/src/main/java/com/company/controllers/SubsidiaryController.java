package com.company.controllers;

import com.company.entities.Employee;
import com.company.entities.ModelView;
import com.company.entities.Product;
import com.company.entities.Subsidiary;
import com.company.exceptions.NotFoundException;
import com.company.services.EmployeeServiceImpl;
import com.company.services.ProductServiceImpl;
import com.company.services.SubsidiaryServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SubsidiaryController {
    @Autowired
    SubsidiaryServiceImpl subsidiaryService;
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/subsidiaries")
    private ResponseEntity <List <Subsidiary>> displayAll() {
        List <Subsidiary> subsidiaries = subsidiaryService.getAll ( );
        return new ResponseEntity <> (subsidiaries, HttpStatus.OK);
    }

    @PostMapping("/subsidiaries")
    private ResponseEntity <Subsidiary> save(@Valid @RequestBody Subsidiary subsidiary) {
        subsidiaryService.saveOrUpdate (subsidiary);
        return new ResponseEntity <> (subsidiary, HttpStatus.CREATED);
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
    private ResponseEntity <?> update(@Valid @RequestBody Subsidiary subsidiary, @PathVariable("subsidiaryId") Integer id) {
        Subsidiary currentSubsidiary = subsidiaryService.getById (id);
        if (currentSubsidiary == null) {
            throw new NotFoundException ("subsidiary", id.toString ( ));
        }
        currentSubsidiary.setName (subsidiary.getName ( ));
        currentSubsidiary.setLocation (subsidiary.getLocation ( ));
        currentSubsidiary.setPhone (subsidiary.getPhone ( ));

        subsidiaryService.saveOrUpdate (currentSubsidiary);
        return new ResponseEntity <> (currentSubsidiary, HttpStatus.OK);
    }

    @DeleteMapping("/subsidiaries/{subsidiaryId}")
    private  ResponseEntity <?> deleteById(@PathVariable("subsidiaryId") Integer id) {
        Subsidiary currentSubsidiary = subsidiaryService.getById (id);
        if (currentSubsidiary == null) {
            throw new NotFoundException ("subsidiary", id.toString ( ));
        }
        subsidiaryService.deleteByID (id);
        return new ResponseEntity <> (HttpStatus.NO_CONTENT);
    }

    @JsonView(ModelView.Summary.class)
    @GetMapping("/subsidiaries/{subsidiaryId}/employees")
    private ResponseEntity <List <Employee>> getEmployeefFromSubsidiary(@PathVariable("subsidiaryId") Integer id) {
        List <Employee> employees = employeeService.getAllBySubsidiaryId (id);

        return new ResponseEntity <> (employees, HttpStatus.OK);
    }

    @JsonView(ModelView.Summary.class)
    @GetMapping("/subsidiaries/{subsidiaryId}/products")
    private ResponseEntity <List <Product>> getProductsFromSubsidiary(@PathVariable("subsidiaryId") Integer id) {
        List <Product> products = productService.getAllBySubsidiaryId (id);
        return new ResponseEntity <> (products, HttpStatus.OK);
    }
}
