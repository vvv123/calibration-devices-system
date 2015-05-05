package com.softserve.edu.repository;

import com.softserve.edu.entity.Calibrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalibratorRepository extends CrudRepository<Calibrator, Long> {}