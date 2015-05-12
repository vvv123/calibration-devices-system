package com.softserve.edu.entity.catalogue;

import javax.persistence.*;

import static com.softserve.edu.entity.catalogue.util.Checker.checkForEmptyText;
import static com.softserve.edu.entity.catalogue.util.Checker.checkForNull;

@Entity
public class District extends AbstractCatalogue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    protected District() {}

    public District(String name, Region region) {
        this.designation = name;
        this.region = region;
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

    public Region getRegion() {
        return region;
    }

    private void setRegion(Region region) {
        checkForNull(region);
        this.region = region;
    }

    @Override
    public String toString() {
        return designation;
    }
}
