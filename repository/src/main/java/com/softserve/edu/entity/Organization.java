package com.softserve.edu.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "organizationType")
public abstract class Organization {
    @Id
    private String id;
    private String name;

    @Embedded
    private Address address;

}

