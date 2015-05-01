package com.softserve.edu.app.model.directories;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Building {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String number;
    @ManyToOne
    private Street street;
    @OneToMany
    @JoinColumn(name = "building_id")
    private Set<Flat> flats;

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Building building = (Building) o;

        return new EqualsBuilder()
                .append(id, building.id)
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
        return "Building{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
