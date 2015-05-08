package com.softserve.edu.repository;

import com.softserve.edu.entity.UserDate;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */
public interface UserDateRepository extends CrudRepository<UserDate,Long> {
    UserDate save(UserDate userDate);
}
