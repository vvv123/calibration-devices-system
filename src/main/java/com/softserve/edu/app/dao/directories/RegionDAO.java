package com.softserve.edu.app.dao.directories;

import com.softserve.edu.app.model.directories.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RegionDAO extends CrudRepository<Region, Long> {
    Region findByName(String name);
}
