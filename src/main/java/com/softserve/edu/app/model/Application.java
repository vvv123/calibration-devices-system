package com.softserve.edu.app.model;

import com.softserve.edu.app.model.utils.Device;
import com.softserve.edu.app.model.utils.Status;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Application {
    @Id
    private Long id;
    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Device device;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status = Status.SENT;

    protected Application() {}

    public Application(Client client, Device device) {
        this.client = client;
        this.device = device;
    }

    /*
     Will serve for generating unique URL for user.
         */
    public Long getId() {
        return id == null ? Long.valueOf(client.hashCode() * UUID.randomUUID().hashCode()) : id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Application that = (Application) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .toHashCode();
    }
}
