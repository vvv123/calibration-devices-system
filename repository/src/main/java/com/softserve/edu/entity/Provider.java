package com.softserve.edu.entity;

import com.softserve.edu.entity.user.ProviderEmployee;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "PROVIDER")
public class Provider extends Organization {
    
}
