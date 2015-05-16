package com.softserve.edu.repository;

import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalibratorRepository extends CrudRepository<Calibrator, Long> {
}
