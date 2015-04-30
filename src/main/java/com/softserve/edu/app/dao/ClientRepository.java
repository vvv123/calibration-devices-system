package com.softserve.edu.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ClientRepository {
    @Autowired
    private EntityManager entityManager;
}
