package com.softserve.edu;

import com.softserve.edu.app.dao.RegionDAO;
import com.softserve.edu.app.model.directories.District;
import com.softserve.edu.app.model.directories.Region;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Test.class);
        RegionDAO regionDAO = applicationContext.getBean(RegionDAO.class);
        regionDAO.save(new Region("Lviv region",
                new HashSet<District>(Arrays.asList(new District("Lviv district"),
                        new District("Frankivskyi")))));
        System.out.println(regionDAO.findByName("Lviv region"));
    }
}
