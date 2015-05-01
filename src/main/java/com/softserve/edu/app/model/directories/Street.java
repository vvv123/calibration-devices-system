package com.softserve.edu.app.model.directories;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Street {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    @JoinColumn(name = "buildings_id")
    private Set<Building> buildings;
}
