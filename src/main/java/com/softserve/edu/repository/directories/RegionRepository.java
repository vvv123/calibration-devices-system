package com.softserve.edu.repository.directories;

import com.softserve.edu.entity.directories.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {
    Region findByName(String name);
}
