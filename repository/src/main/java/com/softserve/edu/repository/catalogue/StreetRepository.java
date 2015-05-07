package com.softserve.edu.repository.catalogue;

import com.softserve.edu.entity.catalogue.Street;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends CrudRepository<Street, Long> {
    Street findByName(String name);
}
