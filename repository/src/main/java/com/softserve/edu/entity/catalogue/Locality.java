package com.softserve.edu.entity.catalogue;

import javax.persistence.*;

import static com.softserve.edu.entity.catalogue.util.Checker.checkForEmptyText;
import static com.softserve.edu.entity.catalogue.util.Checker.checkForNull;

@Entity
@Table(name="`LOCALITY`")
public class Locality extends AbstractCatalogue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String designation;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    protected Locality() {}

    public Locality(District district, String designation) {
        this.district = district;
        this.designation = designation;
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

    public District getDistrict() {
        return district;
    }

    private void setDistrict(District district) {
        checkForNull(district);
        this.district = district;
    }

    @Override
    public String toString() {
        return designation;
    }
}
