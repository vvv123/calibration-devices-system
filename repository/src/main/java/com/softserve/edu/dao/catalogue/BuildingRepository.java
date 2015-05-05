package com.softserve.edu.dao.catalogue;

import com.softserve.edu.entity.catalogue.Building;
import com.softserve.edu.entity.catalogue.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {
}
