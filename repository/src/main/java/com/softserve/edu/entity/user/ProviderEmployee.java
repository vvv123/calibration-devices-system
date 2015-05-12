package com.softserve.edu.entity.user;

import javax.persistence.*;

import com.softserve.edu.entity.Organization;
import com.softserve.edu.entity.Provider;
import com.softserve.edu.entity.Verification;

import java.util.Set;

@Entity
@DiscriminatorValue(value = "PROVIDER_EMPLOYEE")
public class ProviderEmployee extends Employee {

    public enum ProviderEmployeeRole implements Role {
        PROVIDER_EMPLOYEE, PROVIDER_ADMIN;

        @Override
        public String roleName() {
            return name();
        }
    }

    public ProviderEmployee(String username, String password, ProviderEmployeeRole role,
             Organization organization) {
        super(username, password, role, organization);
    }

    public ProviderEmployee(String username, String password, Role role, Organization organization,
                            String firstName, String lastName, String email, String phone) {
        super(username, password, role, organization, firstName, lastName, email, phone);
    }
}
