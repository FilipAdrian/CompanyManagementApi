package com.company.repositories;

import com.company.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository <Product, String> {
    Product getById(String Id);

    List <Product> getAllBy();

    @Override
    void deleteById(String id);

    @Override
    <S extends Product> S save(S s);

    List<Product> getAllBySubsidiaryId(Integer id);
}
