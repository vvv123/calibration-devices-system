package com.softserve.edu.repository;

import com.softserve.edu.entity.CalibrationTestData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalibrationTestDataRepository extends CrudRepository<CalibrationTestData, Long> {
    @Query("SELECT d FROM CalibrationTestData d WHERE d.calibrationTest.id = :testId")
    List<CalibrationTestData> findByCalibrationTestId(@Param("testId") Long testId);

}