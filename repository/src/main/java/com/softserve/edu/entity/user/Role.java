package com.softserve.edu.entity.user;

/**
 * Role interface for users. Should be implemented as enum in each entity
 */
public interface Role {
    /**
     * Represents role name in string
     *
     * @return role name depends on its implementation
     */
    String roleName();
}
