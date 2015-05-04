package com.softserve.edu;

import com.softserve.edu.entity.catalogue.District;
import com.softserve.edu.entity.catalogue.Region;
import com.softserve.edu.repository.catalogue.DistrictRepository;
import com.softserve.edu.service.catalogue.RegionService;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.HashSet;

public class LazyTest {
    public static void run(ApplicationContext applicationContext) {
        RegionService regionRepository = applicationContext.getBean(RegionService.class);
        DistrictRepository districtDAO = applicationContext.getBean(DistrictRepository.class);
        District disOne = new District("Syhivskyi", new HashSet<>());
        District disTwo = new District("Frankivskyi", new HashSet<>());
        districtDAO.save(disOne);   //for id generaton
        districtDAO.save(disTwo);   //for id generaton
        regionRepository.save(new Region("Lviv region", new HashSet<District>(Arrays.asList(disOne, disTwo))));
        System.out.println(regionRepository.findByName("Lviv region").getDistricts());
    }
}
