package com.softserve.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */
@Entity
public class Application {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String middleName;
    private String region;
    private String locality;
    private String district;
    private String street;
    private String building;
    private String email;
    private String phone;
    // Or it will be better to add just address field and parse everything to a single string
    @OneToOne(mappedBy = "application")
    private Verification verification;

}