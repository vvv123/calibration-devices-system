package com.softserve.edu.app.model.directories;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
public class Flat {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String number;
    @ManyToOne
    private Building building;

    protected Flat() {}

    public Flat(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Flat flat = (Flat) o;

        return new EqualsBuilder()
                .append(id, flat.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
