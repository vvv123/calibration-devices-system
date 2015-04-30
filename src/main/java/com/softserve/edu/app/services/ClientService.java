package com.softserve.edu.app.services;

import com.softserve.edu.app.dao.ClientDAO;
import com.softserve.edu.app.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientDAO clientDAO;

    public void save(Client client) {
        clientDAO.save(client);
    }
}
