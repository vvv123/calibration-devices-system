package com.softserve.edu.app.model.directories;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Building {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String number;
    @OneToMany
    @JoinColumn(name = "flat_id")
    private Set<Flat> flats;
}
