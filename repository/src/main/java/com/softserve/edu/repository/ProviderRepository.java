package com.softserve.edu.repository;

import com.softserve.edu.entity.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
    public List<Provider> findByAddressDistrict(String designation);
}
