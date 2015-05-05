package com.softserve.edu.repository.catalogue;

import com.softserve.edu.entity.catalogue.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {
}
