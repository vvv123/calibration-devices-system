package com.softserve.edu.repository.catalogue;

import com.softserve.edu.entity.catalogue.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {
    List<Building> findByStreetId(Long id);
}