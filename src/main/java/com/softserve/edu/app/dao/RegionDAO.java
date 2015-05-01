package com.softserve.edu.app.dao;

import com.softserve.edu.app.model.directories.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegionDAO extends CrudRepository<Region, Long> {
    Region findByName(String name);
}
