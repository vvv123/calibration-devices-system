package com.softserve.edu.app.model.directories;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Locality {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    @JoinColumn(name = "street_id")
    private Set<Street> streets;
}
