package com.softserve.edu.app.model.directories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flat {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String number;
}
