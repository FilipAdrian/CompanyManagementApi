package com.company.repositories;

import com.company.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRespository extends CrudRepository <Employee, Integer> {
    Employee getById(Integer id);

    List <Employee> getAllBy();

    List <Employee> getAllBySubsidiaryId(Integer id);

    @Override
    void deleteById(Integer id);

    @Override
    <S extends Employee> S save(S s);
}
