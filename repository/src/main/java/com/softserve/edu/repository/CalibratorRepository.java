package com.softserve.edu.repository;

import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.Organization;
import com.softserve.edu.entity.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalibratorRepository extends CrudRepository<Calibrator, Long> {
    public List<Calibrator> findByAddressDistrict(String designation);
}
