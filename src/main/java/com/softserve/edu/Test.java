package com.softserve.edu;

import com.softserve.edu.app.dao.directories.DistrictDAO;
import com.softserve.edu.app.dao.directories.RegionDAO;
import com.softserve.edu.app.model.directories.District;
import com.softserve.edu.app.model.directories.Region;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Test.class);
        RegionDAO regionDAO = applicationContext.getBean(RegionDAO.class);
        DistrictDAO districtDAO = applicationContext.getBean(DistrictDAO.class);
        District disOne = new District("Syhivskyi");
        District disTwo = new District("Frankivskyi");
        districtDAO.save(disOne);   //for id generaton
        districtDAO.save(disTwo);   //for id generaton
        regionDAO.save(new Region("Lviv region", new HashSet<District>(Arrays.asList(disOne, disTwo))));
        System.out.println(regionDAO.findByName("Lviv region").getDistricts());
    }
}
