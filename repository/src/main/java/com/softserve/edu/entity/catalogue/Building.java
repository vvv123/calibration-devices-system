package com.softserve.edu.entity.catalogue;

import javax.persistence.*;

import static com.softserve.edu.entity.catalogue.util.Checker.checkForEmptyText;
import static com.softserve.edu.entity.catalogue.util.Checker.checkForNull;

@Entity
public class Building extends AbstractCatalogue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;

    protected Building() {}

    public Building(Street street, String designation) {
        setStreet(street);
        setDesignation(designation);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    private void setDesignation(String designation) {
        checkForEmptyText(designation);
        this.designation = designation;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        checkForNull(street);
        this.street = street;
    }

    @Override
    public String toString() {
        return designation;
    }
}
