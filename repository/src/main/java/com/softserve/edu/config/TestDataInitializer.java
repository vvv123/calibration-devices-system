package com.softserve.edu.config;

import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.Provider;
import com.softserve.edu.entity.StateVerificator;
import com.softserve.edu.entity.catalogue.*;
import com.softserve.edu.entity.user.SystemAdmin;
import com.softserve.edu.repository.OrganizationRepository;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.repository.catalogue.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TestDataInitializer {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private LocalityRepository localityRepository;
    @Autowired
    private StreetRepository streetRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    public void init() throws Exception {
        userRepository.save(new SystemAdmin("admin", "$2a$10$xTq90ybFNT/W0TfNHdQ4e.0DL1WO/7vebrpDZybGRwdEk/7F8ULEi"));

        Region regionLviv = new Region("Львівська");
        Region regionTernopil = new Region("Тернопільська");
        regionRepository.save(Arrays.asList(regionLviv, regionTernopil));

        District districtLviv = new District("Львівський", regionLviv);
        District districtTernopil = new District("Тернопільський", regionTernopil);
        District district1 = new District("Кам'янко-бузький", regionLviv);
        District district2 = new District("Стрийський", regionLviv);
        District district3 = new District("Тернопільський", regionTernopil);
        District district4 = new District("Чортківський", regionTernopil);
        District district5 = new District("Зборівський", regionTernopil);
        districtRepository.save(Arrays.asList(districtLviv, districtTernopil,
                district1, district2, district3, district4, district5));

        Locality localityStriy = new Locality(district2, "м. Стрий");
        Locality localityKamanka = new Locality(district1, "м. Кам'янка-бузька");
        Locality localityTernopil = new Locality(districtTernopil, "м. Тернопіль");
        Locality localityLviv = new Locality(districtLviv, "м. Львів");
        localityRepository.save(Arrays.asList(localityStriy, localityKamanka, localityTernopil, localityLviv));

        Street streetStiy1 = new Street(localityStriy, "вул. Шевченка");
        Street streetStiy2 = new Street(localityStriy, "вул. Сагайдачного");
        Street streetStiy3 = new Street(localityStriy, "вул. Київська");
        Street streetKamanka1 = new Street(localityKamanka, "вул. Незалежності");
        Street streetKamanka2 = new Street(localityKamanka, "вул. Шевченка");
        Street streetTernopil1 = new Street(localityTernopil, "вул. Степана Бандери");
        Street streetTernopil2 = new Street(localityTernopil, "вул. Володимира Великого");
        Street streetTernopil3 = new Street(localityTernopil, "вул. Симоненка");
        Street streetLviv1 = new Street(localityLviv, "вул. Зелена");
        Street streetLviv2 = new Street(localityLviv, "вул. Личаківська");
        streetRepository.save(Arrays.asList(streetStiy1, streetStiy2, streetStiy3, streetLviv1, streetLviv2,
                streetKamanka1, streetKamanka2, streetTernopil1, streetTernopil2, streetTernopil3));

        buildingRepository.save(Arrays.asList(
                new Building(streetStiy1, "1"), new Building(streetStiy1, "2"), new Building(streetStiy1, "3"),
                new Building(streetStiy2, "1"), new Building(streetStiy2, "2"), new Building(streetStiy2, "3"),
                new Building(streetStiy3, "1"), new Building(streetStiy3, "2"), new Building(streetStiy3, "3"),
                new Building(streetKamanka1, "1"), new Building(streetKamanka1, "2"), new Building(streetKamanka1, "3"),
                new Building(streetKamanka2, "1"), new Building(streetKamanka2, "2"), new Building(streetKamanka2, "3"),
                new Building(streetTernopil1, "1"), new Building(streetTernopil1, "2"), new Building(streetTernopil1, "3"),
                new Building(streetTernopil2, "1"), new Building(streetTernopil2, "2"), new Building(streetTernopil2, "3"),
                new Building(streetTernopil3, "1"), new Building(streetTernopil3, "2"), new Building(streetTernopil3, "3"),
                new Building(streetLviv1, "1"), new Building(streetLviv1, "2"), new Building(streetLviv1, "3"),
                new Building(streetLviv2, "1"), new Building(streetLviv2, "2"), new Building(streetLviv2, "3")));

        Provider provider1 = new Provider("ТернопільВода", "water-ternopil@ukr.net", "33-235-32-1453",
                new Address("Львівськa", "Стрийський", "м. Стрий", "вул. Шевченка", "1", "45"));
        Provider provider2 = new Provider("Львівгаз", "gaz-lviv@gmail.com", "124-22-4-15453",
                new Address("Львівськa", "Львівський", "м. Львів", "вул. Личаківська", "2", "144"));

        Calibrator calibrator1 = new Calibrator("Повірка Львів", "cvalibra@lviv.ua", "24-22-24-12",
                new Address("Львівськa", "Львівський", "м. Львів", "вул. Зелена", "3", "43"));

        StateVerificator stateVerificator1 = new StateVerificator("Наш повірник", "trustable@lviv.org.ua", "124-33-33-434",
                new Address("Львівськa", "Львівський", "м. Львів", "вул. Зелена", "1", "24"));

        StateVerificator stateVerificator2 = new StateVerificator("WelcomeVerificator", "trustable@lviv.org.ua", "124-33-33-434",
                new Address("Львівськa", "Львівський", "м. Львів", "вул. Зелена", "1", "24"));

        organizationRepository.save(Arrays.asList(provider1, provider2, calibrator1, stateVerificator1, stateVerificator2));

        /* 'admin'/'password' */
        userRepository.save(new SystemAdmin("admin", "$2a$10$xTq90ybFNT/W0TfNHdQ4e.0DL1WO/7vebrpDZybGRwdEk/7F8ULEi"));
    }
}
