package com.softserve.edu.dao.directories;

import com.softserve.edu.model.directories.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionDAO extends CrudRepository<Region, Long> {
    Region findByName(String name);
}
