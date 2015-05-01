package com.softserve.edu.app.services;

import com.softserve.edu.app.dao.ClientDAO;
import com.softserve.edu.app.model.old.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientDAO clientDAO;

    public void save(Client client) {
        clientDAO.save(client);
    }

    public void delete(Client client) {
        clientDAO.delete(client);
    }

    public Client findByName(String name) {
        return clientDAO.findByFirstName(name);
    }
}
