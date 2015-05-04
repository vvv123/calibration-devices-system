package com.softserve.edu.repository.catalogue;

import com.softserve.edu.entity.catalogue.Flat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends CrudRepository<Flat, Long> {
    Flat findByNumber(String number);
}
