package com.softserve.edu.repository;

import com.softserve.edu.entity.ProviderApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderApplicationRepository extends CrudRepository<ProviderApplication, Long> {}