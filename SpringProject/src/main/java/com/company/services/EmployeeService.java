package com.company.services;

import com.company.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getById(Integer id);

    List<Employee> getAllBySubsidiaryId(Integer id);

    List<Employee> getAll();

    void deleteById(Integer id);

    void saveOrUpdate(Employee employee);
}
