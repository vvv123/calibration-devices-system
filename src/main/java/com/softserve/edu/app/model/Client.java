package com.softserve.edu.app.model;

import com.softserve.edu.app.model.utils.Gender;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondName;
    @Column(nullable = false)
    private String middleName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    @OneToMany(mappedBy = "client")
    private Set<Application> applications;

    protected Client() {}

    public Client(String firstName, String secondName, String middleName, String telephone, String email,
            Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id == null ? (id = hashCode()) : id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Client client = (Client) o;

        return new EqualsBuilder()
                .append(email, client.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return Math.abs(new HashCodeBuilder(17, 37)
                .append(email)
                .toHashCode());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
