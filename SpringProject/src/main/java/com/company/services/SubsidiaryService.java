package com.company.services;

import com.company.entities.Subsidiary;

import java.util.List;

public interface SubsidiaryService {

    Subsidiary getById(Integer id);

    List <Subsidiary> getAll();

    void deleteByID(Integer id);

    void saveOrUpdate(Subsidiary subsidiary);
}
