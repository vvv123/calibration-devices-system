package com.softserve.edu.repository;

import com.softserve.edu.entity.CalibrationTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalibrationTestRepository  extends CrudRepository<CalibrationTest, Long> {
    List<CalibrationTest> findByName(String name);
}