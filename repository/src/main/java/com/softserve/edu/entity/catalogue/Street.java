package com.softserve.edu.entity.catalogue;

import javax.persistence.*;

import static com.softserve.edu.entity.catalogue.util.Checker.checkForEmptyText;
import static com.softserve.edu.entity.catalogue.util.Checker.checkForNull;

@Entity
public class Street extends AbstractCatalogue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String designation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "locality_id", nullable = false)
    private Locality locality;

    protected Street() {}

    public Street(Locality locality, String designation) {
        setLocality(locality);
        setDesignation(designation);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getDesignation() {
        return designation;
    }

    private void setDesignation(String designation) {
        checkForEmptyText(designation);
        this.designation = designation;
    }

    public Locality getLocality() {
        return locality;
    }

    private void setLocality(Locality locality) {
        checkForNull(locality);
        this.locality = locality;
    }

    @Override
    public String toString() {
        return designation;
    }
}
