package com.softserve.edu.service;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService {
    public int count(String str) {
        return str.length();
    }
}

