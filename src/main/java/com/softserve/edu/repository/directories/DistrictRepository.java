package com.softserve.edu.repository.directories;

import com.softserve.edu.entity.directories.District;
import com.softserve.edu.entity.directories.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends CrudRepository<District, Long> {
    Region findByName(String name);
}
