package com.softserve.edu.app.dao;

import com.softserve.edu.app.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends CrudRepository<Client, Integer> {
    Client findByFirstName(String name);
}
