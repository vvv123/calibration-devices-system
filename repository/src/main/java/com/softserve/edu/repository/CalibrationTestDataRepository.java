package com.softserve.edu.repository;

import com.softserve.edu.entity.CalibrationTestData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalibrationTestDataRepository extends CrudRepository<CalibrationTestData, Long> {}