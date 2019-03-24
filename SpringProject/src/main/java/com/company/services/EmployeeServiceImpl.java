package com.company.services;

import com.company.entities.Employee;
import com.company.repositories.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRespository employeeRespository;

    @Override
    public Employee getById(Integer id) {
        return employeeRespository.getById (id);
    }

    @Override
    public List <Employee> getAllBySubsidiaryId(Integer id) {
        return employeeRespository.getAllBySubsidiaryId (id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRespository.getAllBy ( );
    }

    @Override
    public void deleteById(Integer id) {
        employeeRespository.deleteById (id);
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        employeeRespository.save (employee);
    }
}
