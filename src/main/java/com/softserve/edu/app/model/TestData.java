package com.softserve.edu.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class TestData {
    @Id
    private Integer id;
    @Column
    private Date date;
    @Column(name = "test_name")
    private String testName;
    @Column
    private String deviceId;

}
