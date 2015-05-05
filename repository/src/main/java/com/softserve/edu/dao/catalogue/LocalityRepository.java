package com.softserve.edu.dao.catalogue;

import com.softserve.edu.entity.catalogue.Locality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends CrudRepository<Locality, Long> {
    Locality findByName(String name);
}
