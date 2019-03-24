package com.company.services;

import com.company.entities.Subsidiary;
import com.company.repositories.SubsidiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubsidiaryServiceImpl implements SubsidiaryService {
    @Autowired
    private SubsidiaryRepository subsidiaryRepository;

    @Override
    public Subsidiary getById(Integer id) {
        return subsidiaryRepository.getById (id);
    }

    @Override
    public List <Subsidiary> getAll() {
        return subsidiaryRepository.getAllBy ( );
    }

    @Override
    public void deleteByID(Integer id) {
        subsidiaryRepository.deleteById (id);
    }

    @Override
    public void saveOrUpdate(Subsidiary subsidiary) {
        subsidiaryRepository.save (subsidiary);
    }
}
