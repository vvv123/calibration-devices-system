package com.softserve.edu.repository;

import com.softserve.edu.entity.Application;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */
public interface ApplicationRepository extends CrudRepository<Application,Long> {
}
