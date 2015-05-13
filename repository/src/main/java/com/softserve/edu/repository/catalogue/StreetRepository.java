package com.softserve.edu.repository.catalogue;

import com.softserve.edu.entity.catalogue.District;
import com.softserve.edu.entity.catalogue.Locality;
import com.softserve.edu.entity.catalogue.Street;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends CrudRepository<Street, Long> {
    List<Street> findByLocalityId(Long id);
}
