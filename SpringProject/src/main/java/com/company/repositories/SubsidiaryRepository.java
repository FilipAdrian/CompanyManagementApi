package com.company.repositories;

import com.company.entities.Subsidiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubsidiaryRepository extends CrudRepository <Subsidiary, Integer> {

    Subsidiary getById(Integer id);

    List <Subsidiary> getAllBy();

    @Override
    void deleteById(Integer id);

    @Override
    <S extends Subsidiary> S save(S s);

}
