package com.softserve.edu.repository.catalogue;

import com.softserve.edu.entity.catalogue.District;
import com.softserve.edu.entity.catalogue.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends CrudRepository<District, Long> {
    List<District> findByRegion(Region region);
}
