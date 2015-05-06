package com.softserve.edu.entity;

import javax.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "verification_id")
    private Verification verification;

}
