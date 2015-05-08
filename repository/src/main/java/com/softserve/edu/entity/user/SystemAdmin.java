package com.softserve.edu.entity.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value= "SYS_ADMIN")
public class SystemAdmin extends User {

    enum AdminRole implements Role
    {
        SYSADMIN;

        @Override
        public String roleName() {
            return name();
        }
    }

    SystemAdmin(String username, String password)
    {
        super(username, password, AdminRole.SYSADMIN);
    }

    public SystemAdmin() {
    }
}
