package com.softserve.edu.dao;

import com.softserve.edu.entity.ClientApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientApplicationRepository extends CrudRepository<ClientApplication, Long> {}